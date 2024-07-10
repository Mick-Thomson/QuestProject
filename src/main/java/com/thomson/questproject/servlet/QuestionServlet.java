package com.thomson.questproject.servlet;

import com.thomson.questproject.model.Answer;
import com.thomson.questproject.model.Data;
import com.thomson.questproject.model.Question;
import com.thomson.questproject.service.QuestionService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.List;

import static com.thomson.questproject.consts.WebConsts.*;

@WebServlet(name = "questionServlet", value = "/question")
public class QuestionServlet extends HttpServlet implements DefaultServlet {

    private QuestionService questionService;
    private Data data;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();

        questionService = (QuestionService) servletContext.getAttribute(QUESTION_SERVICE);

        data = questionService.readFromFile();
    }

    @SneakyThrows
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter(ANSWER) == null) {
            var firstQuestion = data.questions.get(0);
            sendRequest(request, response, firstQuestion);
        } else {
            var currentAnswer = getParametrAsInteger(request, ANSWER);
            var questionToRender = questionService.getQuestionByAnswerId(currentAnswer);
            sendRequest(request, response, questionToRender);
        }
    }

    /**
     *
     *
     * @param request
     * @param response
     * @param firstQuestion
     */
    @SneakyThrows
    private void sendRequest(HttpServletRequest request,
                             HttpServletResponse response,
                             Question firstQuestion) throws ServletException, IOException {
        request.setAttribute(QUESTION, firstQuestion);

        List<Answer> answers = questionService.answersByQuestionId(firstQuestion.getId());

        if (firstQuestion.isFailed()) {
            getServletContext().getRequestDispatcher(GAME_OVER_JSP).forward(request, response);
            request.setAttribute(ANSWER_1, answers.get(0));
            request.setAttribute(ANSWER_2, answers.get(1));
        }
        if (firstQuestion.isSuccess()) {
            getServletContext().getRequestDispatcher(GAME_OVER_JSP).forward(request, response);
            request.setAttribute(ANSWER_1, answers.get(0));
            request.setAttribute(ANSWER_2, answers.get(1));
        }

        request.setAttribute(ANSWER_1, answers.get(0));
        request.setAttribute(ANSWER_2, answers.get(1));

        getServletContext().getRequestDispatcher(QUESTION_JSP).forward(request, response);
    }
}

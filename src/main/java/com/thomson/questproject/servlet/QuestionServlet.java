package com.thomson.questproject.servlet;

import com.thomson.questproject.model.Data;
import com.thomson.questproject.model.Question;
import com.thomson.questproject.service.QuestionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet(name = "questionServlet", value = "/question")
public class QuestionServlet extends HttpServlet implements DefaultServlet {

    private final QuestionService questionService = new QuestionService();

    @SneakyThrows
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Data data = questionService.readFromFile();
        if (request.getParameter("answer") == null) {
            var firstQuestion = data.questions.get(0);
            sendRequest(request, response, firstQuestion);
        } else {
            //this logic for correct work with next success question. Request like:
            //http://localhost:8080/Gradle___com_thomson___QuestProject_1_0_war/question?answer=1

            var currentAnswer = getParametrAsInteger(request, "answer");
            var questionToRender = questionService.getQuestionByAnswerId(currentAnswer);

            sendRequest(request, response, questionToRender);
        }
    }


    private void sendRequest(HttpServletRequest request,
                             HttpServletResponse response,
                             Question firstQuestion) throws ServletException, IOException {
        request.setAttribute("question", firstQuestion);

        var answers = questionService.answersByQuestionId(firstQuestion.getId());
        request.setAttribute("answer_1", answers.get(0));
        request.setAttribute("answer_2", answers.get(1));
        getServletContext().getRequestDispatcher("/question.jsp").forward(request, response);
    }
}

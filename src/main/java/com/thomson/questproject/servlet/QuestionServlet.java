package com.thomson.questproject.servlet;

import com.thomson.questproject.HelloServlet;
import com.thomson.questproject.model.Answer;
import com.thomson.questproject.model.Data;
import com.thomson.questproject.service.QuestionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet(name = "questionServlet", value = "/question")
public class QuestionServlet extends HelloServlet {

    private final QuestionService questionService = new QuestionService();
    @SneakyThrows
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            Data data = questionService.readFromFile();
            if (request.getAttribute("question") == null) {
                request.setAttribute("question", data.questions.get(0).getMessage());
                request.setAttribute("answer_1", data.questions.get(0).getAnswers().get(0));
                request.setAttribute("answer_2", data.answers.get(1).getChoice());
                getServletContext().getRequestDispatcher("/question.jsp").forward(request, response);
            }
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}

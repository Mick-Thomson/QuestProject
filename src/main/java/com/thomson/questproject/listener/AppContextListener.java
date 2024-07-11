package com.thomson.questproject.listener;

import com.thomson.questproject.service.QuestionService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import lombok.SneakyThrows;

import static com.thomson.questproject.consts.WebConsts.QUESTION_SERVICE;

/**
 * Класс-лисенер для QuestionService
 */
@WebListener
public class AppContextListener implements ServletContextListener {
    @SneakyThrows
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();

        QuestionService questionService = new QuestionService();

        ctx.setAttribute(QUESTION_SERVICE, questionService);

        ServletContextListener.super.contextInitialized(sce);
    }
}
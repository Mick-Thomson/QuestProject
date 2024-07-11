package com.thomson.questproject.servlet;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Интерфейс, представляющий цифровые параметры из параметров реквеста
 * передаются запрос и имя параметра
 */
public interface DefaultServlet {
    default Integer getParameterAsInteger(HttpServletRequest request, String parameterName) {
        return Integer.valueOf(request.getParameter(parameterName).toString());
    }
}

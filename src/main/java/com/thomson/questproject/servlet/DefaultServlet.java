package com.thomson.questproject.servlet;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Интерфейс, представляющий цифровые параметры из параметров реквеста
 * передаются ...
 */
public interface DefaultServlet {
    default Integer getParametrAsInteger(HttpServletRequest request, String parameterName) {
        return Integer.valueOf(request.getParameter(parameterName).toString());
    }
}

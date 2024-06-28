<jsp:useBean id="question" scope="request" type="com.thomson.questproject.model.Question"/>
<jsp:useBean id="answer_1" scope="request" type="com.thomson.questproject.model.Answer"/>
<jsp:useBean id="answer_2" scope="request" type="com.thomson.questproject.model.Answer"/>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<a href="question">Quest</a>

<h1>Question: ${question.message}</h1>
<form action="${pageContext.request.contextPath}/question" method="get">
    <button name="answer" value="${answer_1.id}">${answer_1.choice}</button>
</form>

<form action="${pageContext.request.contextPath}/question" method="get">
    <button name="answer" value="${answer_2.id}">${answer_2.choice}</button>
</form>
</body>
</html>
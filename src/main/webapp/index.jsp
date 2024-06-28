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

<h1>Question: ${questions}</h1>
<form action="/question" method="get">
  <button name="${answer_1}" value="${answer_1}">${answer_1}</button>
</form>

<form action="/question" method="get">
  <button name="${answer_2}" value="${answer_2}">${answer_2}</button>
</form>
</body>
</html>
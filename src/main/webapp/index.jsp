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
<button><p>${answer_1}</p></button>
<button><p>${answer_2}</p></button>

</body>
</html>
<jsp:useBean id="question" scope="request" type="com.thomson.questproject.model.Question"/>
<jsp:useBean id="answer_1" scope="request" type="com.thomson.questproject.model.Answer"/>
<jsp:useBean id="answer_2" scope="request" type="com.thomson.questproject.model.Answer"/>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="main.css">
    <link rel="shortcut icon" href="alien.ico" type="image/x-icon">
    <title>Game</title>
</head>

<body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>

    <header>
        <div class="container">
            <div class="row p-5">
                <div class="col-12 text-center">
                    <h1>${question.message}</h1>
                    <div class="d-grid gap-2 col-6 mx-auto p-5">
                        <form action="${pageContext.request.contextPath}/question" method="get">
                            <button name="answer" class="btn btn-outline-primary btn-lb"
                                    value="${answer_1.id}">${answer_1.choice}</button>
                            <button name="answer" class="btn btn-outline-primary btn-lb"
                                    value="${answer_2.id}">${answer_2.choice}</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </header>
</body>
</html>

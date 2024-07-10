<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
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
                            <button class="btn btn-outline-secondary">Начать игру заново</button>
                        </form>
                        <form action="${pageContext.request.contextPath}/" method="get">
                            <button class="btn btn-outline-dark">Вернуться в начало</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </header>
</body>
</html>

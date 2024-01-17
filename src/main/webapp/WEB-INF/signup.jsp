<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Rejestracja - TweetWave</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/forms.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/2d69f1a690.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <nav class="navbar">
        <a href="#" class="logo">
            <i class="fa-solid fa-dove fa-lg"></i>
            TweetWave
        </a>
        <a href="#" class="login-button">Zaloguj</a>
    </nav>
    <main>
        <form action="${pageContext.request.contextPath}/signup" method="post" class="form" autocomplete="on">
            <h2 class="form-title">Zarejestruj się - TweetWave</h2>
            <div class="form-icon" aria-hidden="true"></div>
            <div class="input-container">
                <input type="text" class="input-field" name="username" placeholder="Nazwa użytkownika">
            </div>
            <div class="input-container">
                <input type="email" class="input-field" name="email" placeholder="email">
            </div>
            <div class="input-container">
                <input type="password" class="input-field" name="password" placeholder="hasło">
            </div>
            <div class="button-container">
                <button class="form-button">Zarejetruj się</button>
            </div>
        </form>
    </main>
    <footer>TweetWave &#174 || &#169 BartekK 2024</footer>
</div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Logowanie - TweetWave</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/forms.css">
    <%@include file="../segments/stylesheet.jspf"%>
</head>
<body>
<div class="container">
    <%@include file="../segments/header.jspf"%>
    <main>
        <form action="j_security_check" method="post" class="form" autocomplete="on">
            <h2 class="form-title">Zaloguj się - TweetWave</h2>
            <div class="form-icon" aria-hidden="true"></div>
            <div class="input-container">
                <input type="text" class="input-field" name="j_username" placeholder="Nazwa użytkownika">
            </div>
            <div class="input-container">
                <input type="password" class="input-field" name="j_password" placeholder="hasło">
            </div>
            <div class="button-container">
                <button class="form-button">Zaloguj się</button>
            </div>
            <p>Nie masz konta? <a href="${pageContext.request.contextPath}/signup">Zarejestruj się!</a></p>
        </form>
    </main>
    <%@include file="../segments/footer.jspf"%>
</div>
</body>
</html>
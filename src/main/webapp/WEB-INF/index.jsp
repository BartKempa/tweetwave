<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>TweetWave</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
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
            <c:choose>
                <c:when test="${empty pageContext.request.userPrincipal}">
                    <a href="${pageContext.request.contextPath}/login" class="login-button">Zaloguj</a></c:when>
                <c:when test="${not empty pageContext.request.userPrincipal}">
                    <a href="${pageContext.request.contextPath}/logout" class="login-button">Wyloguj</a>
                </c:when>
            </c:choose>
        </nav>
        <main>
            <c:forEach var="tweet" items="${requestScope.tweets}">
                <article class="tweet">
                    <h2>Dodane przez ${tweet.tweetAuthor}, ${tweet.dateAdded.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))} </h2>
                    <p class="tweet-content"><c:out value="${tweet.description}"/>
                    <p>Dodajemy foto, </p>
                    <a href="<c:out value="${tweet.url}"/>" class="tweet-link"><c:out value="${tweet.url}"/></a>

                    <section class="tweet-bar">
                        <a href="#" class="comment">
                            <i class="fa-regular fa-comment"></i>
                            <p class="tweet-comments">12</p>
                        </a>
                        <a href="#" class="tweet-like">
                            <i class="fa-regular fa-thumbs-up"></i>
                            <p class="tweet-likes">15</p>
                        </a>
                        <a href="#" class="tweet-dislike">
                            <i class="fa-regular fa-thumbs-down"></i>
                            <p class="tweet-dislikes">15</p>
                        </a>
                    </section>
                </article>
            </c:forEach>
        </main>
        <footer>TweetWave &#174 || &#169 BartekK 2024</footer>
    </div>
</body>
</html>
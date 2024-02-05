<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Pojedynczy tweet - TweetWave</title>
    <%@include file="../segments/stylesheet.jspf"%>
</head>
<body>
<div class="container">
    <%@include file="../segments/header.jspf"%>
    <main>
        <article class="tweet">
            <h2>Dodane przez ${tweet.tweetAuthor}, ${tweet.dateAdded.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))} </h2>
            <p class="tweet-content"><c:out value="${tweet.description}"/>
                <c:if test="${fn:length(tweet.filePart)> 0}">
            <p><img src="${pageContext.request.contextPath}/photo/${tweet.id}" alt="Brak / nie działa foto" width="200" height="200"> </p>
            </c:if>

            <a href="<c:out value="${tweet.url}"/>" class="tweet-link"><c:out value="${tweet.url}"/></a>

            <section class="tweet-bar">
                <a href="#" class="comment">
                    <i class="fa-regular fa-comment"></i>
                    <p class="tweet-comments">12</p>
                </a>

                <a href="${pageContext.request.contextPath.concat('/tweet/rate?id=').concat(tweet.id).concat('&type=LIKE')}" class="tweet-like">
                    <i class="fa-regular fa-thumbs-up"></i>
                    <p class="tweet-likes">${tweet.likeRate}</p>
                </a>
                <a href="${pageContext.request.contextPath.concat('/tweet/rate?id=').concat(tweet.id).concat('&type=DISLIKE')}" class="tweet-dislike">
                    <i class="fa-regular fa-thumbs-down"></i>
                    <p class="tweet-dislikes">${tweet.dislikeRate}</p>
                </a>
            </section>
        </article>
    </main>
    <%@include file="../segments/footer.jspf"%>
</div>
</body>
</html>
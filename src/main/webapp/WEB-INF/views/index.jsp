<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>TweetWave</title>
    <%@include file="../segments/stylesheet.jspf"%>
</head>
<body>
    <div class="container">
        <%@include file="../segments/header.jspf"%>
        <main>
            <%@include file="../segments/tweets.jspf"%>
        </main>
        <%@include file="../segments/footer.jspf"%>
        <a href="#" class="user-profile-button">
            <i class="fa-solid fa-user"></i>
        </a>
    </div>
</body>
</html>
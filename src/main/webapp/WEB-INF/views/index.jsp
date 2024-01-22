<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    </div>
</body>
</html>
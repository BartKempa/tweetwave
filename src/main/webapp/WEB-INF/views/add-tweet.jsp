<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Dodaj nowy tweet - TweetWave</title>
    <%@include file="../segments/stylesheet.jspf"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/add-tweet-form.css">
</head>
<body>
<div class="container">
    <%@include file="../segments/header.jspf"%>
    <main>
        <form action="${pageContext.request.contextPath}/tweet/add" method="post" class="add-tweet-form" autocomplete="off" enctype="multipart/form-data">
            <h2 class="tweet-form-title">Dodaj nowego tweeta</h2>

            <div class="input-container">
                <input type="url" class="input-field" name="url" placeholder="URL">
            </div>
            <div class="input-container">
                <input type="file" class="add-photo-button" name="photo" >
            </div>
            <div class="input-container">
                <textarea name="description" class="text-field" placeholder="Opis"></textarea>
            </div>
            <div class="button-container">
                <button class="tweet-form-button">Dodaj tweet</button>
            </div>
        </form>
    </main>
    <%@include file="../segments/footer.jspf"%>
</div>
</body>
</html>
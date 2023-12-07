<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup - MiniTwitter</title>
    <link rel="stylesheet" href="style/styles.css">
    <script src="style/signUp.js"></script>
</head>
<body>

<!-- Top Bar -->
<div id="top-bar">
    <div id="buttons">
        <button><a style="text-decoration: none; color: white" href="index.jsp">Home</a></button>
    </div>
</div>

<!-- Signup Section -->
<div id="signup-section">
    <h2>Signup</h2>
    <h1 style="color: red;font-size: larger" th:text="${message}"></h1>
    <form action="sign-up" method="post">
        <label for="username">Username:</label>
        <!--pattern="[a-zA-Z][a-zA-Z0-9]{4,}"-->
        <input type="text" id="username" name="username" required onblur="validateUsername()" >
        <span id="username-error" class="error-message"></span>

        <label for="password">Password:</label>

        <!--pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[^\da-zA-Z]).{8,}$"-->
        <input type="password" id="password" name="password" required onblur="validatePassword()" >
        <span id="password-error" class="error-message"></span>

        <label for="nickname">Nickname:</label>
        <input type="text" id="nickname" name="nickname" required>

        <button type="submit">Continue</button>
    </form>
</div>

</body>
</html>

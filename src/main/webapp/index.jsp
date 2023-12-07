<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MiniTwitter</title>
    <link rel="stylesheet" href="style/styles.css">
</head>
<body>

<!-- Top Bar -->
<div id="top-bar">
    <div id="buttons">
        <button onclick="showPosts()">Posts</button>
        <button onclick="showAds()">Advertising</button>
        <button onclick="showJobs()">Job</button>
    </div>
</div>

<!-- Bottom Section -->
<div id="bottom-section">
    <!-- Left Section for Login -->
    <div id="left-section">

        <div><h1>MiniTwitter - N</h1></div>
        <c:if test="${empty sessionScope.user}">
        <div>
            <h2>Login</h2><br>
            <h1 style="color: red;font-size: larger">${requestScope.message}</h1>
            <form action="signin" method="post">
                <table>
                    <tr>
                        <td><label for="username">Username:</label></td>
                        <td><input type="text" id="username" name="username" required></td>
                    </tr>
                    <tr>
                        <td><label for="password">Password:</label></td>
                        <td><input type="password" id="password" name="password" required></td>
                    </tr>
                    <tr>
                        <td colspan="2"><button type="submit">Sign in</button></td>
                    </tr>
                </table>
            </form>
            <p>Don't have an account? <a href="signup.jsp">Sign up</a></p>
        </div></c:if>

        <c:if test="${not empty sessionScope.user}">
        <div class="user-profile">
            <form action="logOut" method="post">
                <table>
                    <tr>
                        <th colspan="6" class="user-name">Welcome ${sessionScope.user.nickname}</th>
                    </tr>
                    <tr>
                        <td>posts:</td> <td>0</td>
                        <td>followers:</td><td>19</td>
                        <td>following:</td><td>13</td>
                    </tr>
                    <tr>
                        <td colspan="3" class="user-balance">Balance: </td>
                        <td colspan="3">$100.00</td>
                    </tr>
                    <tr>
                        <td colspan="6"><button type="submit">Log Out</button></td>
                    </tr>
                </table>
            </form>
        </div></c:if>
    </div>

    <!-- Right Section for Posts -->
    <div id="right-section">
        <div id="posts">
            <h2>Posts</h2>
            <!-- Your regular posts content goes here -->
        </div>
        <div id="trendy-posts">
            <h2>Trendy Posts</h2>
            <!-- Your trendy posts content goes here -->
        </div>
    </div>
</div>

<script src="style/script.js"></script>
</body>
</html>

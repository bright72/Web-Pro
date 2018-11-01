<%-- 
    Document   : Login
    Created on : Oct 26, 2018, 12:26:22 AM
    Author     : brightotech
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <table>
            <form action="Login" method="post">
                <tr>
                    <td>AccountID : <input type="number" name="id" required></td>
                </tr> 
                <tr>
                    <td>PIN : <input type="number" name="pin" required></td>
                </tr>
                <tr>
                    <td>${message}</td>
                </tr>
                <tr>
                    <td><input type="submit"></td>
                </tr>
            </form> 
        </table>

    </body>
</html>

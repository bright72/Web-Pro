<%-- 
    Document   : Deposit
    Created on : Oct 26, 2018, 1:57:11 AM
    Author     : brightotech
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deposit Page</title>
    </head>
    <body>
        <h1>Deposit Page</h1>
        ${account.name}<br>
        ${account.balance}<br>
        <form action="Deposit" method="post">
            <input type="number" name="deposit" required> <br>
            <input type="submit"><br>
        </form>
        ${message}<br>
        <a href="MyAccount.jsp">Back</a>
    </body>
</html>

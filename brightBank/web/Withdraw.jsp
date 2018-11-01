<%-- 
    Document   : Withdraw
    Created on : Oct 26, 2018, 2:03:41 AM
    Author     : brightotech
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Withdraw Page</title>
    </head>
    <body>
        <h1>Withdraw Page</h1>
        ${account.name}<br>
        ${account.balance}<br>
        <form action="Withdraw" method="post">
            <input type="number" name="withdraw" required> <br>
            <input type="submit"><br>
        </form>
        ${message}<br>
        <a href="MyAccount.jsp">Back</a>
    </body>
</html>

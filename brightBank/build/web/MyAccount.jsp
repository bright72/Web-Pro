<%-- 
    Document   : MyAccount
    Created on : Oct 26, 2018, 12:36:45 AM
    Author     : brightotech
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MyAccount Page</title>
    </head>
    <body>
        <h1>MyAccount Page</h1>
        ${status}<br>
        ${account.name}<br>      
        <h4>balance : ${account.balance}</h4>
        <a href="Deposit">Deposit</a><br>
        <a href="Withdraw">Withdraw</a><br>
        <a href="History">History</a><br><br><br>
        <a href="Logout">Logout</a>
    </body>
</html>

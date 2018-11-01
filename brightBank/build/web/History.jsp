<%-- 
    Document   : History
    Created on : Oct 26, 2018, 1:14:31 AM
    Author     : brightotech
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Page</title>
    </head>
    <body>
        <h1>History Page</h1>
        <br>
        <table>
            <tr>
                <td>#</td>
                <td>TimeStamp</td>
                <td>Method</td>
                <td>Amount</td>
                <td>Balance</td>  
            </tr>
            <c:forEach items="${history}" var="h" varStatus="n">
            <tr>
                <td>${n.count}</td>
                <td>${h.time}</td>
                <td>${h.method}</td>
                <td>${h.amount}</td>
                <td>${h.balance}</td> 
            </tr>
</c:forEach>
        </table>
        <a href="MyAccountPage">Back</a>
    </body>
</html>

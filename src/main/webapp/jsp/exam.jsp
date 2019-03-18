<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%--
            宣告先後順序 
        對 jsp 點右鍵 View Servlet 觀看編譯後的宣告順序 
        --%>
        <h1>
        <%
            out.print(x);
        %>
        <%
            int x = 100;
        %>
        <%
            out.print(x);
        %>
        <%! 
            int x = 200;
        %>
        <%
            out.print(x);
        %>
        
    </body>
</html>

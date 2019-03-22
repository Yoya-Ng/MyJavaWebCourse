
<%@page import="mvc.model.HelloModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
        <title>Hello MVC</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%
        HelloModel hm = (HelloModel)request.getAttribute("hello");
        
        %>
    </head>
    body style="padding: 10px">
        <form class="pure-form" method="post" action="/JavaWebCourse/mvc/HelloController">
            <fieldset>
                <legend>Hello MVC</legend>
                <%=hm.getUsername() %><p>
                <button type="submit" class="pure-button pure-button-primary" onclick="window.history.back()">back</button>
            </fieldset>
        </form>
    </body>
</html>

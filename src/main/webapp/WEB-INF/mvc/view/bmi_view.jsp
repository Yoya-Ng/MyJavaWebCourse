<%@page import="mvc.model.BMIModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    BMIModel bmi = (BMIModel)request.getAttribute("bmi");
%>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
        <title>BMI MVC</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body style="padding: 10px">
        <form class="pure-form">
            <fieldset>
                <legend>BMI MVC</legend>
                BMI = <%=bmi.getBmi()%><p>
                <button type="button" class="pure-button pure-button-primary" onclick="window.history.back()">Back</button>
            </fieldset>
        </form>
    </body>
</html>

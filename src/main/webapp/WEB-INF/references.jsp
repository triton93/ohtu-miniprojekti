<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
        <h2>Add Reference</h2>
        <div class="form">
            
            <form>
                Author: <input type="text" name="author"><br>
                Title: <input type="text" name="title"><br>
                Publisher: <input type="text" name="publisher"><br>
                Year: <input type="text" name="year">
            </form>
            
            
            <form:form commandName="reference" action="/api/references" method="PUT">
                <label>Author: </label><form:input id="author" path="author" /> <form:errors path="author" /><br>
                <label>Title: </label><form:input id="title" path="title" /> <form:errors path="title" /><br>
                <label>Publisher: </label><form:input id="publisher" path="publisher" /> <form:errors path="publisher" /><br>
                <label>Year: </label><form:input id="year" path="year" /> <form:errors path="year" /><br>
            </form:form>
            
            
        </div>
        
        <div class="listing">
            <h2>Saved References</h2>
            <ul>
                <c:forEach var="reference" items="${references}">
                    <li>${reference.author} ${reference.title}</li>
                </c:forEach>
            </ul>
        </div>
    </body>
</html>

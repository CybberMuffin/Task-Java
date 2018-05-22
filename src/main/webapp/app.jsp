<%@ page import="ua.kpi.tef.model.entity.Plane" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ua.kpi.tef.model.manager.FinalText" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aviation</title>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
          crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
            integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <c:forEach var="plane" items="${requestScope.planes}">
                <div class = "border border-light border-top border-bottom" style="margin: 50px;">
                    <h5>Model: <c:out value="${plane.getModel()}"/></h5>
                    <ul class="nav navbar-nav">
                        <li>Passenger capacity: <c:out value="${plane.getCapacity()}"/> man</li>
                        <li>Carrying capacity: <c:out value="${plane.getCarryingCapacity()}"/> kilograms</li>
                        <li>Fuel consumption: <c:out value="${plane.getFuelConsumption()}"/> kg per hour</li>
                        <li>Flying range: <c:out value="${plane.getRange()}"/> km</li>
                    </ul>
                </div>
            </c:forEach>
        </div>
        <div class="col-md-6">
            <form id="filter" method="POST" action="<%request.setAttribute("SERVLET_COMMAND_NAME", "sorter");%>">
                <div class="input-wrapper">
                    <div class="input-info">Fuel consumption range:</div>
                    <input type="text" name="lower" value='<%=request.getAttribute("lower")%>'>
                    <div class="dash">-</div>
                    <input type="text" name="upper" value='<%=request.getAttribute("upper")%>'>
                    <button type="submit">Submit</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
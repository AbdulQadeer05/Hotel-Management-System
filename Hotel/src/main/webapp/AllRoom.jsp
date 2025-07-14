<%@page import="com.model.Room"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.RoomType" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Room</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #121212;
            color: white;
        }
        .abc {
            background-color: rgba(0, 0, 0, 0.7);
            padding: 20px;
            border-radius: 15px;
            margin-top: 50px;
        }
        th, td {
            color: white;
        }
    </style>
</head>
<body>
<div class="container abc">
    <h2 class="text-center mb-4">All Room</h2>
    <table class="table table-bordered table-hover table-dark">
        <thead>
            <tr>
                <th>Reservation Id</th>
                <th>Hotel</th>
                <th>Room Type</th>
                <th>Floor</th>
                <th>Room No</th>
                <th>Rate Per Night</th>
                <th>Status</th>
                <th>Description</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Room> list = (List<Room>) request.getAttribute("AllRoom");
                if (list != null) {
                    for (Room r : list) {
            %>
            <tr>
                <td><%=r.getRoomId()  %></td>
                <td><%= r.getHotelId().getHotelName() %></td>
                <td><%= r.getRoomTypeId().getTypeName() %></td>
                <td><%= r.getFloor() %></td>
                <td><%= r.getRoomNo() %></td>
                <td><%= r.getRatePerNight() %></td>
                <td><%= r.getStatus() %></td>
                <td><%= r.getDescription() %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="8" class="text-center">No Room Found</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</div>
</body>
</html>

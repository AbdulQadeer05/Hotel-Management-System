<%@page import="com.model.RoomBooking"%>
<%@page import="com.model.Room"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.RoomType" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Room Booked</title>
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
    <h2 class="text-center mb-4">All Room Booked</h2>
    <table class="table table-bordered table-hover table-dark">
        <thead>
            <tr>
            	<th>Reservation Id</th>
                <th>Room ID</th>
                <th>Guest Name</th>
                <th>issue date</th>
                <th>return date</th>
                <th>number of guest</th>
                <th>special request</th>
                
            </tr>
        </thead>
        <tbody>
            <%
                List<RoomBooking> list = (List<RoomBooking>) request.getAttribute("AllRoomBooking");
                if (list != null) {
                    for (RoomBooking rb : list) {
            %>
            <tr>
                <td><%=rb.getReservationId()  %></td>
                <td><%= rb.getRoom().getRoomId() %></td>
                <td><%= rb.getGuest().getLastName() %></td>
                <td><%=rb.getIssue_date()  %></td>
                <td><%= rb.getReturn_date() %></td>
                <td><%= rb.getNumber_of_guest() %></td>
                <td><%= rb.getSpecial_request() %></td>
               
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

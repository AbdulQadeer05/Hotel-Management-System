<%@ page import="java.util.List" %>
<%@ page import="com.model.Hotel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Hotels</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: url('https://images.unsplash.com/photo-1566073771259-6a8506099945') no-repeat center center fixed;
            background-size: cover;
        }
        
            .two {
      background-image: url('RoomDB1.jpg');
      background-size: cover;
      background-repeat: no-repeat;
      background-position: center;
      background-attachment: fixed;
      min-height: 100vh;
      padding: 60px 0;
    }
        

        .container {
            margin-top: 50px;
            background-color: rgba(0,0,0,0.7);
            padding: 30px;
            border-radius: 20px;
            color: white;
        }

        h2 {
            text-align: center;
            color: #00d0ff;
            margin-bottom: 30px;
            font-weight: bold;
        }

        table {
            background-color: white;
            color: black;
        }

        th {
            background-color: #00d0ff;
            color: white;
        }

        .btn-action {
            margin-right: 5px;
        }
    </style>
</head>
<body class = "two">
<div class="container">
    <h2>All Registered Hotels</h2>

    <table class="table table-bordered table-striped table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Address</th>
            <th>City</th>
            <th>State</th>
            <th>Country</th>
            <th>Email</th>
            
        </tr>
        </thead>
        <tbody>
        <%
            List<Hotel> hotels = (List<Hotel>) request.getAttribute("hotels");
            if (hotels != null && !hotels.isEmpty()) {
                for (Hotel h : hotels) {
        %>
        <tr>
            <td><%= h.getHotelId() %></td>
            <td><%= h.getHotelName() %></td>
            <td><%= h.getPhoneNo() %></td>
            <td><%= h.getFullAddress() %></td>
            <td><%= h.getCity() %></td>
            <td><%= h.getState() %></td>
            <td><%= h.getCountry() %></td>
            <td><%= h.getEmail() %></td>
            
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="9" class="text-center text-danger">No Hotels Found</td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>

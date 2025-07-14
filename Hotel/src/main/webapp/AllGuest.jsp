<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Guest" %>
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
    <h2 class="text-center mb-4">All Guest</h2>
    <table class="table table-bordered table-hover table-dark">
        <thead>
            <tr>
                <th>Guest ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Phone No</th>
                <th>Address</th>
                <th>Nationality</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Guest> list = (List<Guest>) request.getAttribute("AllGuest");
                if (list != null) {
                    for (Guest g : list) {
            %>
            <tr>
                <td><%= g.getGuestId() %></td>
                <td><%= g.getFirstName() %></td>
                <td><%= g.getLastName() %></td>
                <td><%= g.getEmail() %></td>
                <td><%= g.getPhoneNo() %></td>
                <td><%= g.getAddress() %></td>
                <td><%= g.getNationality() %></td>
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

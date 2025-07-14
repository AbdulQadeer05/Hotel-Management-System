<%@page import="com.model.Housekeeping"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
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
    <h2 class="text-center mb-4">All House Keeping</h2>
    <table class="table table-bordered table-hover table-dark">
        <thead>
            <tr>
                <th>House Keeping Id</th>
                <th>Room Id</th>
                <th>Staff Id</th>
                <th>Date Cleaned</th>
                <th>Status</th>
                <th>Note</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Housekeeping> list = (List<Housekeeping>) request.getAttribute("AllHK");
                if (list != null) {
                    for (Housekeeping hk : list) {
            %>
            <tr>
                <td><%= hk.getHousekeepingId()  %></td>
                <td><%= hk.getRoom().getRoomId() %></td>
                <td><%= hk.getStaff().getLastName() %></td>
                <td><%= hk.getDateCleaned() %></td>
                <td><%= hk.getStatus() %></td>
                <td><%= hk.getNotes() %></td>
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

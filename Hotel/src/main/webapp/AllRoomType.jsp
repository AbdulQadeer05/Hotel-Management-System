<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.RoomType" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Room Types</title>
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
    <h2 class="text-center mb-4">All Room Types</h2>
    <table class="table table-bordered table-hover table-dark">
        <thead>
            <tr>
                <th>ID</th>
                <th>Type Name</th>
                <th>Description</th>
                <th>Max Occupancy</th>
                <th>Rate Per Day</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<RoomType> list = (List<RoomType>) request.getAttribute("roomTypes");
                if (list != null) {
                    for (RoomType rt : list) {
            %>
            <tr>
                <td><%= rt.getRoomTypeId() %></td>
                <td><%= rt.getTypeName() %></td>
                <td><%= rt.getDescription() %></td>
                <td><%= rt.getMaxOccupancy() %></td>
                <td><%= rt.getNight() %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="4" class="text-center">No Room Types Found</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</div>
</body>
</html>

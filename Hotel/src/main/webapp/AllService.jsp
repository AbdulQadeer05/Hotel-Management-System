
<%@page import="com.model.Servicess"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Services</title>
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
    <h2 class="text-center mb-4">All Services</h2>
    <table class="table table-bordered table-hover table-dark">
        <thead>
            <tr>
                <th>Service Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Servicess> list = (List<Servicess>) request.getAttribute("AllServicess");
                if (list != null) {
                    for (Servicess s : list) {
            %>
            <tr>
                <td><%= s.getServiceId()  %></td>
                <td><%= s.getName() %></td>
                <td><%= s.getDescription() %></td>
                <td><%= s.getPrice() %></td>
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

<%@page import="com.model.Staff"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Staff</title>
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
    <h2 class="text-center mb-4">All Staff</h2>
    <table class="table table-bordered table-hover table-dark">
        <thead>
            <tr>
                <th>Staff Id</th>
                <th>Hotel</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>CNIC</th>
                <th>Phone No</th>
                <th>Position</th>
                <th>Hire Date</th>
                <th>Salary</th>
                <th>Shift</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Staff> list = (List<Staff>) request.getAttribute("AllStaff");
                if (list != null) {
                    for (Staff s : list) {
            %>
            <tr>
                <td><%= s.getStaffId() %></td>
                <td><%= s.getHotel().getHotelName() %></td>
                <td><%= s.getFirstName() %></td>
                <td><%= s.getLastName() %></td>
                <td><%= s.getCnic() %></td>
                <td><%= s.getPhone() %></td>
                <td><%= s.getPosition() %></td>
                <td><%= s.getHireDate() %></td>
                <td><%= s.getSalary() %></td>
                <td><%= s.getShift() %></td>
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

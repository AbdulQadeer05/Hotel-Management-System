<%@page import="com.model.Payment"%>
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
    <h2 class="text-center mb-4">All Payment Record</h2>
    <table class="table table-bordered table-hover table-dark">
        <thead>
            <tr>
                <th>Payment Id</th>
                <th>Room Boking</th>
                <th>Payment Date</th>
                <th>Amount</th>
                <th>Payment Method</th>
                <th>Payment Status</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Payment> list = (List<Payment>) request.getAttribute("AllPayment");
                if (list != null) {
                    for (Payment p : list) {
            %>
            <tr>
                <td><%=	p.getPaymentId()  %></td>
                <td><%= p.getRoomBoking().getReservationId() %></td>
                <td><%= p.getPaymentDate() %></td>
                <td><%= p.getAmount() %></td>
                <td><%= p.getPaymentMethod() %></td>
                <td><%= p.getPaymentStatus() %></td>
            
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

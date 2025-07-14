<%@page import="com.model.RoomBooking"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Payment</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body, html {
            margin: 0;
            padding: 0;
            height: 100%;
            font-family: 'Segoe UI', sans-serif;
        }
        .hero-section {
            background-image: url('Payment.jpg');
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .abc {
            background-color: rgba(0, 0, 0, 0.85);
            padding: 30px;
            border-radius: 15px;
            width: 100%;
            max-width: 500px;
            color: white;
        }
        .form-control, .form-select {
            background-color: #1f1f1f;
            color: white;
            border: 1px solid #444;
        }
        .form-control:focus, .form-select:focus {
            border-color: #00d1ff;
            box-shadow: 0 0 0 0.2rem rgba(0, 209, 255, 0.3);
        }
        .btn-primary {
            background-color: #00d1ff;
            border: none;
            font-weight: bold;
        }
        .btn-primary:hover {
            background-color: #00b8e6;
        }
    </style>
</head>
<body>
<div class="hero-section">
    <form action="AddPayment" method="post" class="abc">
        <h3 class="text-center mb-4">Add Payment</h3>

        <div class="mb-3">
            <label class="form-label">Select Reservation ID</label>
            <select name="reservationId" class="form-select" required>
                <option value="">-- Select Reservation --</option>
                <%
                    List<RoomBooking> bookings = (List<RoomBooking>) request.getAttribute("bookings");
                    if (bookings != null) {
                        for (RoomBooking rb : bookings) {
                %>
                <option value="<%= rb.getReservationId() %>">
                    <%= rb.getReservationId() %> - <%= rb.getGuest().getFirstName() %> <%= rb.getGuest().getLastName() %>
                </option>
                <%
                        }
                    }
                %>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Payment Date</label>
            <input type="date" name="paymentDate" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Amount</label>
            <input type="text" name="amount" class="form-control" placeholder="Enter Amount" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Payment Method</label>
            <select name="paymentMethod" class="form-select" required>
                <option value="">-- Select Method --</option>
                <option value="Cash">Cash</option>
                <option value="Credit Card">Credit Card</option>
                <option value="Debit Card">Debit Card</option>
                <option value="Bank Transfer">Bank Transfer</option>
                <option value="Online">Online</option>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Payment Status</label>
            <select name="paymentStatus" class="form-select" required>
                <option value="">-- Select Status --</option>
                <option value="Paid">Paid</option>
                <option value="Pending">Pending</option>
                <option value="Failed">Failed</option>
            </select>
        </div>

       <div class="d-flex justify-content-between">
    <button type="submit" class="btn btn-primary w-25">Add Payment</button>
    <a href="AllPayment" class="btn btn-primary w-25">View All</a>
</div>
       
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

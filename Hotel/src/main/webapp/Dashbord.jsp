<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hotel Management Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
             background-image: url('hotel1.avif');
    background-size: cover;
    background-repeat: no-repeat;
    background-position: center;
    font-family: 'Segoe UI', sans-serif;
        }

        .overlay {
            background-color: rgba(0, 0, 0, 0.7);
            min-height: 100vh;
            padding-top: 50px;
            padding-bottom: 50px;
        }

        .dashboard-title {
            color: #00d0ff;
            text-shadow: 2px 2px 5px black;
            font-weight: bold;
            margin-bottom: 40px;
            text-align: center;
        }

        .card {
            border: none;
            border-radius: 20px;
            box-shadow: 0 6px 18px rgba(0, 0, 0, 0.3);
            transition: transform 0.3s ease;
            background-color: rgba(255, 255, 255, 0.9);
        }

        .card:hover {
            transform: translateY(-5px);
        }

        .card-title {
            font-weight: 600;
            font-size: 1.2rem;
        }

        .card i {
            font-size: 38px;
            color: #0d6efd;
        }

        .btn-primary {
            background-color: #0d6efd;
            border: none;
        }

        .btn-primary:hover {
            background-color: #084298;
        }

        .btn-danger:hover {
            background-color: #b02a37;
        }
    </style>
</head>
<body>
    <div class="overlay">
        <div class="container">
            <h2 class="dashboard-title">Welcome to Hotel Management Dashboard</h2>
            <div class="row g-4 justify-content-center">

                <!-- Hotels card -->
                <div class="col-md-3">
                    <div class="card text-center p-4">
                        <i class="bi bi-building"></i>
                        <h5 class="card-title mt-3">Hotels</h5>
                        <a href="hotel.jsp" class="btn btn-primary mt-2">Manage Hotels</a>
                    </div>
                </div>

                <!-- Rooms -->
                <div class="col-md-3">
                    <div class="card text-center p-4">
                        <i class="bi bi-door-open-fill"></i>
                        <h5 class="card-title mt-3">Rooms</h5>
                        <a href="RoomDashboard.jsp" class="btn btn-primary mt-2">Manage Rooms</a>
                    </div>
                </div>

                <!-- Guests -->
                <div class="col-md-3">
                    <div class="card text-center p-4">
                        <i class="bi bi-person-plus-fill"></i>
                        <h5 class="card-title mt-3">Guests</h5>
                        <a href="Guest.jsp" class="btn btn-primary mt-2">Manage Guests</a>
                    </div>
                </div>

                <!-- Reservations -->
                <div class="col-md-3">
                    <div class="card text-center p-4">
                        <i class="bi bi-calendar-check-fill"></i>
                        <h5 class="card-title mt-3">Reservations</h5>
                        <a href="RoomBookingDashbord.jsp" class="btn btn-primary mt-2">Bookings</a>
                    </div>
                </div>

                
                <div class="col-md-3">
                    <div class="card text-center p-4">
                        <i class="bi bi-currency-dollar"></i>
                        <h5 class="card-title mt-3">Payments</h5>
                        <a href="AddPayment" class="btn btn-primary mt-2">View Payments</a>
                    </div>
                </div>

                <!-- Staff -->
                <div class="col-md-3">
                    <div class="card text-center p-4">
                        <i class="bi bi-people-fill"></i>
                        <h5 class="card-title mt-3">Staff</h5>
                        <a href="StaffDashbord.jsp" class="btn btn-primary mt-2">Manage Staff</a>
                    </div>
                </div>

                <!-- Services -->
                <div class="col-md-3">
                    <div class="card text-center p-4">
                        <i class="bi bi-tools"></i>
                        <h5 class="card-title mt-3">Services</h5>
                        <a href="ServiceDashbord.jsp" class="btn btn-primary mt-2">Hotel Services</a>
                    </div>
                </div>


                <!-- Housekeeping -->
                <div class="col-md-3">
                    <div class="card text-center p-4">
                        <i class="bi bi-bucket-fill"></i>
                        <h5 class="card-title mt-3">Housekeeping</h5>
                        <a href="HKDashboard.jsp" class="btn btn-primary mt-2">Cleaning</a>
                    </div>
                </div>

                <!-- Logout -->
                <div class="col-md-3">
                    <div class="card text-center p-4">
                        <i class="bi bi-box-arrow-right"></i>
                        <h5 class="card-title mt-3">Logout</h5>
                        <a href="index.jsp" class="btn btn-danger mt-2">Logout</a>
                    </div>
                </div>

            </div>
        </div>
    </div>
</body>
</html>

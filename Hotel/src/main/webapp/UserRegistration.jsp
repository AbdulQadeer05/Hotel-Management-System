<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Guest Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-image: url('images/hotel-bg.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            height: 100vh;
        }
        .abc {
            background-color: rgba(0, 0, 0, 0.7);
            padding: 30px;
            border-radius: 15px;
            color: white;
        }
        .form-control {
            background-color: #f8f9fa;
        }
    </style>
</head>
<body>
    <div class="container d-flex justify-content-center align-items-center" style="height: 100vh;">
        <div class="col-md-6 abc">
            <h2 class="text-center mb-4">Guest Registration</h2>
            <form action="UserRegistration" method="post">
                <div class="mb-3">
                    <label>First Name</label>
                    <input type="text" name="firstname" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label>Last Name</label>
                    <input type="text" name="lastname" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label>Email</label>
                    <input type="email" name="email" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label>Phone Number</label>
                    <input type="number" name="phoneno" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label>Password</label>
                    <input type="password" name="password" class="form-control" required>
                </div>
                <button type="submit" class="btn btn-success w-100">Register Guest</button>
            </form>
        </div>
    </div>
</body>
</html>

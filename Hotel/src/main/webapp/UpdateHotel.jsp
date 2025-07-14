<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register Hotel</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: url('https://images.unsplash.com/photo-1501117716987-c8e1ecb2100e') no-repeat center center fixed;
            background-size: cover;
            font-family: 'Segoe UI', sans-serif;
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
		
        .form-container {
            background: rgba(0, 0, 0, 0.7);
            color: #fff;
            border-radius: 20px;
            padding: 30px;
            margin-top: 50px;
            box-shadow: 0 0 20px rgba(0,0,0,0.5);
        }

        .form-container input,
        .form-container textarea,
        .form-container select {
            background: rgba(255, 255, 255, 0.1);
            color: #fff;
            border: 1px solid #ccc;
        }

        .form-container input::placeholder,
        .form-container textarea::placeholder {
            color: #ddd;
        }

        .form-container h2 {
            text-align: center;
            margin-bottom: 30px;
            font-weight: bold;
            color: #00d0ff;
        }

        .btn-custom {
            background-color: #00d0ff;
            border: none;
            font-weight: bold;
        }

        .btn-custom:hover {
            background-color: #009ecf;
        }

        label {
            font-weight: 500;
        }
    </style>
</head>
<body class="two">
    <div class="container col-md-8">
        <div class="form-container">
            <h2>Update Hotel</h2>
            <form action="Updatehotel" method="post">

              <div class="row mb-3">
                <div class="col-md-4">
                        <label>Enter the ID Number which you want to Update hotel</label>
                        <input type="number" name="no" class="form-control" placeholder="Id Number" required>
                    </div>
              </div>

                <div class="row mb-3">
                    <div class="col-md-6">
                        <label>Hotel Name</label>
                        <input type="text" name="name" class="form-control" placeholder="New Name" required>
                    </div>
                    <div class="col-md-6">
                        <label>Phone Number</label>
                        <input type="text" name="phone" class="form-control" placeholder="(New) +92 300 0000000" required>
                    </div>
                </div>

                <div class="mb-3">
                    <label>Full Address</label>
                    <input type="text" name="address" class="form-control" placeholder="New Address" required>
                </div>

                <div class="row mb-3">
                    <div class="col-md-4">
                        <label>City</label>
                        <input type="text" name="city" class="form-control" placeholder="Karachi" required>
                    </div>
                    <div class="col-md-4">
                        <label>State</label>
                        <input type="text" name="state" class="form-control" placeholder="Sindh" required>
                    </div>
                    <div class="col-md-4">
                        <label>Country</label>
                        <input type="text" name="country" class="form-control" placeholder="Pakistan" required>
                    </div>
                </div>

                <div class="mb-3">
                    <label>Email</label>
                    <input type="email" name="email" class="form-control" placeholder="hotel@example.com" required>
                </div>



                <button type="submit" class="btn btn-custom w-100 mt-3">Update</button>
            </form>
        </div>
    </div>
</body>
</html>

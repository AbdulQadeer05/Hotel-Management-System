<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Guest</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: url(Lahore.jpg) no-repeat center center fixed;
            background-size: cover;
            font-family: 'Segoe UI', sans-serif;
        }
        
            .two {
      background-image: url('Lahore.jpg');
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
    <div class="container col-md-8" >
        <div class="form-container">
            <h2>Update Guest</h2>
            <form action="UpdateGuest" method="post">
    
            	<div class="row mb-3">
                    <div class="col-md-4">
                        <label>Enter the Guest ID number which you want to Update Record</label>
                        <input type="number" name="id" class="form-control" required>
                    </div>
                    
                </div>
            	
                <div class="row mb-3">
                    <div class="col-md-6">
                        <input type="text" name="firstName" class="form-control" placeholder=" New First Name" required>
                    </div>
                    <div class="col-md-6">
                        <input type="text" name="lastName" class="form-control" placeholder=" New Last Name" required>
                    </div>
                </div>

                <div class="mb-3">
                    <input type="email" name="email" class="form-control" placeholder=" New Email" required>
                </div>

                <div class="row mb-3">
                    <div class="col-md-4">
                        <input type="text" name="phone" class="form-control" placeholder=" New Phone No" required>
                    </div>
                    <div class="col-md-4">
                       
                        <input type="text" name="address" class="form-control" placeholder=" New Address" required>
                    </div>
                    <div class="col-md-4">
                        
                        <input type="text" name="nationality" class="form-control" placeholder=" New nationality" required>
                    </div>
                </div>
                
                <button type="submit" class="btn btn-custom w-25">Update Guest</button>
            </form>
        </div>
    </div>
</body>
</html>

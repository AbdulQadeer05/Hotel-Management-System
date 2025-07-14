<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Delete Staff </title>
  <meta name="viewport" content="width=device-width, initial-scale=1">

  
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

  <style>
  body {
            background-color: #121212;
            color: white;
            padding-top: 50px;
        }
    
    .navbar {
      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
    }
    .navbar-brand {
      font-size: 1.8rem;
      font-weight: bold;
      color: white;
    }
    .nav-link {
      font-weight: 600;
      font-size: 1.1rem;
      transition: all 0.3s ease;
    }
    .nav-link:hover {
      color: #ffc107 !important;
    }

    
    .hero-section {
      background-size: cover;
      background-position: center;
      background-repeat: no-repeat;
      background-attachment: fixed;
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    
    .abc {
      background-color: rgba(44, 47, 51, 0.95);
      padding: 30px;
      border-radius: 15px;
      box-shadow: 0 10px 30px rgba(0, 0, 0, 0.8);
      width: 100%;
      max-width: 400px;
    }

    .form-control {
      background-color: #1f1f1f;
      color: #fff;
      border: 1px solid #444;
    }

    .form-control:focus {
      border-color: #00d1ff;
      box-shadow: 0 0 0 0.2rem rgba(0, 209, 255, 0.25);
    }

    .btn-primary {
      background-color: #00d1ff;
      border: none;
      font-weight: bold;
    }

    .btn-primary:hover {
      background-color: #00b8e6;
    }

    .form-text {
      color: #bbb;
    }

    body {
      margin: 0;
      padding: 0;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }
  </style>
</head>
<body>


<div class="hero-section">
  <form action="DeleteStaffServlet" method="post" class="abc">
    <div class="mb-3">
      <label for="exampleInputEmail1" class="form-label text-light">Enter the Staff ID which you want to Delete</label>
      <input type="number" name="id" class="form-control" aria-describedby="emailHelp">
      
    </div>
    
    
    <button type="submit" class="btn btn-dark w-50">Click Here</button>
  </form>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Staff Dashboard</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
 
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

  <style>
    .navbar {
      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
    }

    .nav-link {
      font-weight: bold;
      font-size: 1.1rem;
      transition: color 0.3s ease;
    }

    .nav-link:hover {
      color: #ffc107 !important;
    }

    .navbar-brand {
      font-size: 1.5rem;
      font-weight: bold;
      color: white;
    }

    .two {
      background-image: url('Staff.jpg');
      background-size: cover;
      background-repeat: no-repeat;
      background-position: center;
      background-attachment: fixed;
      min-height: 100vh;
      padding: 60px 0;
    }

    .card:hover {
      box-shadow: 0 6px 15px rgba(0, 0, 0, 0.2);
      transform: scale(1.02);
      transition: all 0.3s ease-in-out;
    }

    .card-title {
      font-size: 1.2rem;
      font-weight: bold;
    }

    .dashboard-heading {
      text-align: center;
      color: white;
      text-shadow: 2px 2px 5px rgba(0,0,0,0.8);
      margin-bottom: 50px;
      font-size: 2.2rem;
    }
  </style>
</head>
<body>

<div class="two">
  <div class="container">
    
    <div class="row justify-content-center g-4 mb-4">
      <!-- Card 1 -->
      <div class="col-md-5">
        <div class="card text-white bg-primary">
          <div class="card-body text-center">
            <h5 class="card-title">Add House Keeping</h5>
            <p class="card-text">Add House Keeping to the system.</p>
            <a href="AddHK" class="btn btn-light">Click Here</a>
          </div>
        </div>
      </div>

      <!-- Card 2 -->
      <div class="col-md-5">
        <div class="card text-white bg-success">
          <div class="card-body text-center">
            <h5 class="card-title">Update House Keeping</h5>
            <p class="card-text">Update House Keeping of the System.</p>
            <a href="UpdateHK" class="btn btn-light">Click Here</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Row 2 -->
    <div class="row justify-content-center g-4">
      <!-- Card 3 -->
      <div class="col-md-5">
        <div class="card text-white bg-dark">
          <div class="card-body text-center">
            <h5 class="card-title">Delete House Keeping</h5>
            <p class="card-text">Remove House Keeping from the system.</p>
            <a href="DeleteHK.jsp" class="btn btn-light">Click Here</a>
          </div>
        </div>
      </div>

      <!-- Card 4 -->
      <div class="col-md-5">
        <div class="card text-white bg-danger">
          <div class="card-body text-center">
            <h5 class="card-title">All House Keeping</h5>
            <p class="card-text">View all House Keeping in the system.</p>
            <a href="AllHK" class="btn btn-light">Click Here</a>
          </div>
        </div>
      </div>
      
      
    </div>

  </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Room Dashboard</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
 
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

  <style>
    body, html {
      margin: 0;
      padding: 0;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    .two {
      background-image: url('hotel1.avif');
      background-size: cover;
      background-position: center;
      background-attachment: fixed;
      min-height: 100vh;
      padding: 80px 0;
      background-color: rgba(0, 0, 0, 0.6);
      background-blend-mode: darken;
    }

    .dashboard-heading {
      text-align: center;
      color: #fff;
      font-size: 2.5rem;
      font-weight: bold;
      margin-bottom: 60px;
      text-shadow: 2px 2px 10px #000;
    }

    .card {
      border: none;
      border-radius: 20px;
      overflow: hidden;
      transition: transform 0.3s, box-shadow 0.3s;
    }

    .card:hover {
      transform: translateY(-10px);
      box-shadow: 0 12px 25px rgba(0, 0, 0, 0.4);
    }

    .card-title {
      font-size: 1.4rem;
      font-weight: 600;
      margin-bottom: 20px;
    }

    .btn-light {
      font-weight: bold;
      border-radius: 30px;
      padding: 10px 25px;
      transition: background 0.3s, color 0.3s;
    }

    .btn-light:hover {
      background-color: #ffc107;
      color: #000;
    }
  </style>
</head>
<body>

<div class="two">
  <div class="container">

    <h1 class="dashboard-heading">Room Management Dashboard</h1>

    <div class="row justify-content-center g-5">
      <!-- Card 1: Room Type -->
      <div class="col-md-5">
        <div class="card bg-dark text-white text-center py-4">
          <div class="card-body">
            <h5 class="card-title">Room Type</h5>
            <a href="RoomType.jsp" class="btn btn-light mt-2">Click Here</a>
          </div>
        </div>
      </div>

      <div class="col-md-5">
        <div class="card bg-danger text-white text-center py-4">
          <div class="card-body">
            <h5 class="card-title">Rooms</h5>
            <a href="Room.jsp" class="btn btn-light mt-2">Click Here</a>
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

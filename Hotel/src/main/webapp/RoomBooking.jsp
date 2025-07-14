<!DOCTYPE html>
<%@page import="com.model.Room"%>
<%@page import="com.model.Guest"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Room Booking</title>
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
    .nav-center {
      margin: 0 auto;
    }
    .two{
       background-image: url(hotel.webp);
      background-attachment:fixed;
      height: 400px;
    width: 100%;
    background-size: cover;  
    background-repeat: no-repeat;
    background-position: 100%;
    }
    .text-center {
      text-align: center;
      padding-top: 300px;
      padding-left:100px;
      color: black;
      text-shadow: 1px 1px 3px rgba(0,0,0,0.7);
    }
    
     .hero-section {
      background-image: url('hotel.webp');
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

    <div class="two" style="width:1263px; height: 500px;">
      
	<div class="hero-section">
  <form action="RoomBookingServlet" method="post" class="abc">
    
    
      <div class="mb-3">
            <label class="form-label">Select Guest Id</label>
            <select name="guestId" class="form-select" required>
                <option value="">-- Select Guest --</option>
                <%
                    List<Guest> guest = (List<Guest>) request.getAttribute("guestlist");
                    if (guest != null) {
                        for (Guest guests : guest) {
                %>
                  
                   <option value="<%= guests.getGuestId() %>"><%= guests.getLastName() %></option>
                   
                <%
                        }
                    }
                %>
            </select>
        </div>

		
        <div class="mb-3">
            <label class="form-label">Select Room Id</label>
            <select name="roomId" class="form-select" required>
                <option value="">-- Select Room --</option>
                <%
                    List<Room> room = (List<Room>) request.getAttribute("rooms");
                    if (room != null) {
                        for (Room rooms :room) {
                %>
                  
                   <option value="<%=rooms.getRoomId() %>"><%= rooms.getRoomNo() %></option>
                   
                <%
                        }
                    }
                %>
            </select>
        </div>
    
    <div class="mb-3">
  <label for="dateInput" class="form-label text-light">Enter the Issue Date </label>
  <input type="date" name="issueDate" class="form-control" id="dateInput">
</div>

 <div class="mb-3">
  <label for="dateInput" class="form-label text-light">Enter the Return Date </label>
  <input type="date" name="returnDate" class="form-control" id="dateInput">
</div>
    
    
 <div class="mb-3">
  <label for="dateInput" class="form-label text-light">Number Of Guest</label>
  <input type="number" name="gn" class="form-control" >
</div>
    
    
 <div class="mb-3">
  <label for="dateInput" class="form-label text-light">Special Request </label>
  <input type="text" name="sr" class="form-control">
</div>
    
    
    <button type="submit" class="btn btn-primary w-100">Click Here</button>
  </form>
</div>


    </div>
    
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    
</body>
</html>

<%@page import="com.model.Hotel"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Add Staff</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

  <style>
    body, html {
      margin: 0;
      padding: 0;
      height: 100%;
      font-family: 'Segoe UI', sans-serif;
    }

    .hero-section {
      background-image: url('Staff.jpg');
      background-size: cover;
      background-position: center;
      background-attachment: fixed;
      min-height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .abc {
      background-color: rgba(30, 30, 30, 0.9);
      padding: 40px;
      border-radius: 15px;
      width: 100%;
      max-width: 500px;
      color: white;
      box-shadow: 0 10px 30px rgba(0, 0, 0, 0.7);
    }

    .form-control {
      background-color: #1f1f1f;
      color: white;
      border: 1px solid #555;
    }

    .form-control:focus {
      border-color: #00d1ff;
      box-shadow: 0 0 0 0.2rem rgba(0, 209, 255, 0.3);
    }

    .btn-primary {
      background-color: #00d1ff;
      border: none;
      font-weight: bold;
    }

    .btn-primary:hover {
      background-color: #00b5e0;
    }

    .form-label {
      font-weight: bold;
    }
  </style>
</head>
<body>
<div class="hero-section">
  <form action="AddStaffServlet" method="post" class="abc">
    <h3 class="text-center mb-4">Add New Staff</h3>

    
    <div class="mb-3">
      <label class="form-label">Select Hotel</label>
      <select name="hotelId" class="form-select" required>
        <option value="">-- Select Hotel --</option>
        <%
          List<Hotel> hotels = (List<Hotel>) request.getAttribute("hotels");
          if (hotels != null) {
            for (Hotel h : hotels) {
        %>
          <option value="<%= h.getHotelId() %>"><%= h.getHotelName() %></option>
        <%
            }
          }
        %>
      </select>
    </div>

    <div class="mb-3">
      <label class="form-label">First Name</label>
      <input type="text" name="firstName" class="form-control" required>
    </div>

    <div class="mb-3">
      <label class="form-label">Last Name</label>
      <input type="text" name="lastName" class="form-control" required>
    </div>

    <div class="mb-3">
      <label class="form-label">CNIC</label>
      <input type="text" name="cnic" class="form-control" required>
    </div>

    <div class="mb-3">
      <label class="form-label">Phone</label>
      <input type="text" name="phone" class="form-control" required>
    </div>

		<div class="mb-2">
		  <label class="form-label">Position</label>
		  <select name="position" class="form-select" required>
		    <option value="">-- Select Position --</option>
		    <option value="Manager">Manager</option>
		    <option value="Receptionist">Receptionist</option>
		    <option value="Housekeeping">Housekeeping</option>
		    <option value="Chef">Chef</option>
		    <option value="Waiter">Waiter</option>
		    <option value="Security Guard">Security Guard</option>
		    <option value="Maintenance">Maintenance</option>
		    <option value="Bell Boy">Bell Boy</option>
		    <option value="Supervisor">Supervisor</option>
		    <option value="Cleaner">Cleaner</option>
		  </select>
		</div>

    <div class="mb-3">
      <label class="form-label">Hire Date</label>
      <input type="date" name="hireDate" class="form-control" required>
    </div>

    <div class="mb-3">
      <label class="form-label">Salary</label>
      <input type="text" name="salary" class="form-control" required>
    </div>

    <div class="mb-3">
      <label class="form-label">Shift</label>
      <select name="shift" class="form-select" required>
        <option value="">-- Select Shift --</option>
        <option value="Morning">Morning</option>
        <option value="Evening">Evening</option>
        <option value="Night">Night</option>
      </select>
    </div>

    <button type="submit" class="btn btn-primary w-100">Add Staff</button>
  </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

<%@ page import="java.util.List" %>
<%@ page import="com.model.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Room</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #121212;
            color: white;
            padding-top: 50px;
        }
        .form-container {
            max-width: 500px;
            margin: auto;
            background: rgba(0,0,0,0.8);
            padding: 30px;
            border-radius: 15px;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h3 class="text-center mb-4">Update Room</h3>
    <form action="UpdateRoomServlet" method="post">
    
    	 <div class="mb-3">
            <input type="number" class="form-control" name="id" placeholder="Enter the ID No which you want to Update Room" required>
        </div>
    	

        
        <div class="mb-3">
            <label class="form-label">Select Hotel</label>
            <select name="hotelId" class="form-select" required>
                <option value="">-- Select Hotel --</option>
                <%
                    List<Hotel> hotels = (List<Hotel>) request.getAttribute("hotelList");
                    if (hotels != null) {
                        for (Hotel hotel : hotels) {
                %>
                  
                   <option value="<%= hotel.getHotelId() %>"><%= hotel.getHotelName() %></option>
                   
                <%
                        }
                    }
                %>
            </select>
        </div>

		
       
        <div class="mb-3">
            <label class="form-label">Select Room Type</label>
            <select name="roomTypeId" class="form-select" required>
                <option value="">-- Room Type --</option>
                <%
                    List<RoomType> roomTypes = (List<RoomType>) request.getAttribute("roomTypes");
                    if (roomTypes != null) {
                        for (RoomType type : roomTypes) {
                %>
                  
                   <option value="<%= type.getRoomTypeId() %>"><%= type.getTypeName() %></option>
                   
                <%
                        }
                    }
                %>
            </select>
        </div>
        
        
        <div class="mb-3">
            <input type="text" class="form-control" name="roomNo" placeholder="Room No" required>
        </div>

        <div class="mb-3">
            <input type="text" class="form-control" name="floor" placeholder="Floor" required>
        </div>

        <div class="mb-3">
            <input type="number" class="form-control" name="ratePerNight" placeholder="Rate Per Night" required>
        </div>
		 <div class="mb-3">
            <input type="text" class="form-control" name="status" placeholder="status" required>
        </div>
         <div class="mb-3">
            <input type="text" class="form-control" name="desc" placeholder="desc" required>
        </div>
        

        <div class="d-grid">
            <button type="submit" class="btn btn-success">Update Room</button>
        </div>
    </form>
</div>
</body>
</html>
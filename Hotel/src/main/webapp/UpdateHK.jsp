<%@page import="com.model.Staff"%>
<%@page import="com.model.Room"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update House Keeping</title>
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
    <h3 class="text-center mb-4">Update House Keeping</h3>
    <form action="UpdateHK" method="post">
    
    
    <div class="mb-3">
    	<lable>Enter the House Keeping ID which you want to Update</lable>
            <input type="number" class="form-control" name="id" placeholder="Id" required>
        </div>
		 

          <div class="mb-3">
            <label class="form-label">Select Room</label>
            <select name="roomId" class="form-select" required>
                <option value="">-- Select Room --</option>
                <%
                    List<Room> rooms = (List<Room>) request.getAttribute("roomList");
                    if (rooms != null) {
                        for (Room r : rooms) {
                %>
                  
                   <option value="<%= r.getRoomId() %>"><%= r.getRoomNo() %></option>
                   
                <%
                        }
                    }
                %>
            </select>
        </div>

		
        <div class="mb-3">
            <label class="form-label">Select Staff</label>
            <select name="staffId" class="form-select" required>
                <option value="">-- Add Staff --</option>
                <%
                    List<Staff> staff = (List<Staff>) request.getAttribute("staff");
                    if (staff != null) {
                        for (Staff s : staff) {
                %>
                  
                   <option value="<%= s.getStaffId() %>"><%= s.getFirstName() %></option>
                   
                <%
                        }
                    }
                %>
            </select>
        </div>
        <div class="mb-3">
            <input type="date" class="form-control" name="date" placeholder="Date Cleaned" required>
        </div>
			 <div class="mb-3">

			<select name="status" class="form-select" required>
			  <option value="">-- Select Status --</option>
			  <option value="Cleaned">Cleaned</option>
			  <option value="Pending">Pending</option>
			  <option value="In Progress">In Progress</option>
			</select>
			    
			    </div>
			    
			    
        <div class="mb-3">
            <input type="text" class="form-control" name="note" placeholder="Notes" required>
        </div>
		 

        <div class="d-grid">
            <button type="submit" class="btn btn-success">Update</button>
        </div>
    </form>
</div>
</body>
</html>
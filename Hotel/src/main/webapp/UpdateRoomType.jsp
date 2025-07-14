<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Room Type</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #121212;
            color: white;
            padding-top: 50px;
        }
        .form-container {
            background-color: rgba(0, 0, 0, 0.75);
            padding: 30px;
            border-radius: 15px;
            max-width: 500px;
            margin: auto;
            margin-top: 100px;
        }
        label {
            font-weight: bold;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h3 class="text-center mb-4">Update Room Type</h3>
    <form action="UpdateRoomType" method="post">
    
    <div class="mb-3">
            <label for="typeName" class="form-label">Enter the ID which you want to Update</label>
            <input type="number" class="form-control" id="typeName" name="id" required>
        </div>
        <div class="mb-3">
            <label for="typeName" class="form-label">Type Name</label>
            <input type="text" class="form-control" id="typeName" name="Name" placeholder="New Name" required>
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <textarea class="form-control" id="description" name="description" placeholder="New Description" rows="3" required></textarea>
        </div>
        <div class="mb-3">
            <label for="maxOccupancy" class="form-label">Max Occupancy</label>
            <input type="number" class="form-control" id="maxOccupancy" placeholder="New Max Occupancy" name="maxOccupancy" required>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-success">Add Room Type</button>
        </div>
    </form>
</div>

</body>
</html>

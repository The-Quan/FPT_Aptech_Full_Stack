
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Employee</title>
</head>
<body>
    <h1>Staff Information</h1>
    <form action="xuLyNhanVien.php" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="startDate">Start Date:</label>
        <input type="date" id="startDate" name="startDate" required><br>

        <label for="totalLeaveDays">Total Leave Days:</label>
        <input type="number" id="totalLeaveDays" name="totalLeaveDays" required><br>

        <label for="workDaysInMonth">Work Days in Month:</label>
        <input type="number" id="workDaysInMonth" name="workDaysInMonth" required><br>

        <label for="exportRatio">Export Ratio:</label>
        <input type="number" id="exportRatio" name="exportRatio" required><br>

        <input type="submit" value="Add Employee">
    </form>
</body>
</html>

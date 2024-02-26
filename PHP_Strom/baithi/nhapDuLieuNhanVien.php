
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculate Performance</title>
</head>
<body>
    <h1>Calculate Employee Performance</h1>
    <form action="xuLyThongTin.php" method="post">
        <label for="name">Employee Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="vacation_days">Vacation Days Taken:</label>
        <input type="number" id="vacation_days" name="vacation_days" required><br>

        <label for="working_days">Working Days in Month:</label>
        <input type="number" id="working_days" name="working_days" required><br>

        <label for="rate_per_day">Rate per Day (in VND):</label>
        <input type="number" id="rate_per_day" name="rate_per_day" required><br>

        <button type="submit">Calculate Performance</button>
    </form>
</body>
</html>

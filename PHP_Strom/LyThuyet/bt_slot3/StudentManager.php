<?php
class StudentManager
{
    private $conn;

    public function __construct()
    {
        $host = "localhost:3306";
        $username = "root";
        $password = "";
        $dbname = "fptaptechdb";

        $this->conn = new mysqli($host, $username, $password, $dbname);
        if ($this->conn->connect_error) {
            die("Connection failed: " . $this->conn->connect_error);
        }
    }


    public function getAllStudents()
    {
        $students = [];
        $sql = "SELECT * FROM students";
        $result = $this->conn->query($sql);
        if ($result->num_rows > 0) {
            while ($row = $result->fetch_assoc()) {
                $students[] = $row;
            }
        }
        return $students;
    }

    public function addStudent($id, $name, $address)
    {
        $sql = "INSERT INTO students (id, name, address) values (?, ?, ?)";
        $stmt = $this->conn->prepare($sql);
        $stmt->bind_param("iss", $id, $name, $address);
        if ($stmt->execute()) {
            echo "Student with ID $id added successfully.\n";
        } else {
            echo "error adding student: " . $stmt->error . "\n";
        }
        $stmt->close();
    }

    public function getStudentById($id)
    {
        $sql = "SELECT * FROM students WHERE id = '$id'";
        $result = $this->conn->query($sql);

        if ($result->num_rows == 1) {
            return $result->fetch_assoc();
        }
        return null;
    }

    public function updateStudent($id, $name, $address)
    {
        $sql = "UPDATE students SET name='$name', address='$address' WHERE id='$id'";
        $this->conn->query($sql);
    }
    public function deleteStudent($id)
    {
        $sql = "DELETE FROM students WHERE id ='$id'";
        $this->conn->query($sql);
    }
    public function __destruct()
    {
        $this->conn->close();
    }
}
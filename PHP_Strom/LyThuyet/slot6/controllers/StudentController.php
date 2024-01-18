<?php
namespace controllers;
use Database;
use models\Student;

class StudentController{
    private $db;
    public function __construct(Database $db)
    {
        $this->db = $db;
    }
    public  function getAllStudents(){
        //step 2 gọi model để thực hiện các thao tac
        $sql = "SELECT * FROM students";
        $result = $this->db->query($sql);

        // return $this->db->fetchAll($result;

        $StudentData = $this->db->fectchAll($result);

        $students = [];
        foreach ($StudentData as $data){
            $student = new Student($data['id'], $data['name'], $data['address']);
        }
        return $student;
        //step 3 thông báo cho view về việc có 1 $student từ models trả về
    }

    public function getStudentById($id){

        $sql = "SELECT * FROM student WHERE id = $id";
        $result = $this->db->query($sql);
        return $this->db->fetchAll($result);
    }
    public function addStudent($id, $name, $address){
        $sql = "INSERT INTO students (id, name, address) VALUES ('$id', $name','$address')";
        $this->db->query($sql);
    }
    public function updateStudent($id, $name, $address)
    {
       $sql = "UPDATE students SET name'$name', address='$address' WHERE id=$id";
       $this->db->query();
    }
    public function deleteStudent($id){
        $sql = "DELETE FROM students WHERE id $id";
        $this->db->query($sql);
    }
}
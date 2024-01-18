<?php
class view {

    // nhận kết quả trả về từ model sau khi dã biết cần phải gọi cái gì
    public function displayStudents($students)
    {
        echo '<h2>list of student</h2>';
        echo '<table border="1">';
        echo '<tr><th>id</th><th>name</th><th>address</th>';
        foreach ($students as $student){
            echo '<tr>';
            echo '<td>' . $student->getId() . '</td>';
            echo '<td>' . $student->getName() . '</td>';
            echo '<td>' . $student->getAddress() . '</td>';
        }
        echo '</table>';
    }
    public function displaySubjects($subjects)
    {
        echo '<h2>list of subjects</h2>';
        echo '<table border="1">';
        echo '<tr><th>id</th><th>name</th>';
        foreach ($subjects as $student){
            echo '<tr>';
            echo '<td>' . $subjects->getId() . '</td>';
            echo '<td>' . $subjects->getName() . '</td>';
            echo '</tr>';
        }
        echo '</table>';
    }
    public function displayMarks($marks)
    {
        echo '<h2>list of Marks</h2>';
        echo '<table border="1">';
        echo '<tr><th>id</th><th>Student ID</th><th>Subject ID</th><th>Marks</th>';
        foreach ($marks as $student){
            echo '<tr>';
            echo '<td>' . $marks->getId() . '</td>';
            echo '<td>' . $marks->getName() . '</td>';
            echo '<td>' . $marks->getAddress() . '</td>';
        }
        echo '</table>';
    }
}
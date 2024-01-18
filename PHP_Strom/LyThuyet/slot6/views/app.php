<?php
use controllers\MarkControllerf;
use controllers\StudentController;
use controllers\SubjectController;
include 'models/Student.php';
include 'models/Subject.php';
include 'models/Mark.php';
include 'controllers/StudentController.php';
include 'controllers/SubjectController.php';
include 'controllers/MarkController.php';
include 'view/view.php';
include 'models/Database.php';

$db = new Database();

$studentController = new StudentController($db);
//    $studentController = new SubjectController\($db);
//    $studentController = new MarkController\($db);
    $view = new view();
// step 1 : b1 từ client -> controller
    //get data from controllers
    $students = $studentController->getAllStudents();
//    $subject = $subjectController->getAllSubjects();
//    $marks = $marks->getAllMarks();
    // display data using the view
    $view->displayStudents($students);
//    $view->displaySubjects($subject);
//    $view->displayMarks($marks);


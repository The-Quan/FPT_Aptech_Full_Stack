<?php
namespace controllers;
use Database;
use models\Subject;

class SubjectControllers{
    private $db;

    /**
     * @param $db
     */
    public function __construct($db)
    {
        $this->db = $db;
    }
    public function getAllSubject()
    {
        $sql = "SELECT * FROM subject";
    }

}
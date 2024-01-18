<?php
namespace controllers;
use database;
use models\mark;

class MarkController{
    private $db;

    /**
     * @param $db
     */
    public function __construct($db)
    {
        $this->db = $db;
    }

}
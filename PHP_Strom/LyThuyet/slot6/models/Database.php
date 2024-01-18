<?php

class Database
{
    private $host = 'localhost:3306';
    private $username = 'root';
    private $password = '';
    private $database = 'fptaptechdb';
    private $connection;

    public function __construct()
    {
        $this->connect();
    }
    private function connect(){
        $this->connection = new mysqli($this->host, $this->username, $this->password, $this->database);
        if($this->connection->connect_error){
            die('connection failed: '.$this->connection->connect_error);
        }
    }
    public function query($sql){
        $result = $this->connection->query($sql);
        if(!$result){
            die('Query failed: ' .$this->connection->error);
        }
        return $result;
    }
    public function fetchAll($result){
        $rows = [];
        while ($rows = $result->fetch_assoc()){
            $rows [] = $rows;
        }
        return $rows;
    }
    public  function close(){
        $this->connection->close();
    }
}
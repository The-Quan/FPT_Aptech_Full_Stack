<?php

namespace models;
class student{
    // cac thuocj tinh cua lop student

    protected $id;
    protected $name;
    protected $address;

    public function __construct($id, $name, $address){
        $this->id = $id;
        $this->name = $name;
        $this->address = $address;
    }
    /*
     * @e=return mixed
     */
    public function getId()
    {
           return $this->id;
    }
    /*
     * @return mixed
     */
    public function getname()
    {
        return $this->name;
    }
}
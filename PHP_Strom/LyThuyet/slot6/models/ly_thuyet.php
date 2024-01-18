<?php

class ly_thuyet //e<=> table
{
     private $id; // int  get:đọc set:ghi

// thuộc tính (property or field ) <=> cột(colum) trong database
//định nghĩa lên đối tương được tạo ra từ class ly_thuyet
//private: chỉ sử dụng trong class ly_thuyet
//protected: chỉ sử dụng trong cùng namespace(thư mục: modell..)
//public: có thể truy vẫn bất kỳ đâu

    private $name;// string
    private $title; // string

    //contructor là hàm khởi tạo dùng để tạo ra đối tượng trong 1 đoạn
    //class -> tạo ra đối tượng (object)
    /**
     * @param $id
     * @param $name
     * @param $title
     */
    public function __construct($id, $name, $title)
    {
        $this->id = $id;
        $this->name = $name;
        $this->title = $title;
    }

    /**
     * @return mixed
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @return mixed
     */
    public function getName()
    {
        return $this->name;
    }

    /**
     * @return mixed
     */
    public function getTitle()
    {
        return $this->title;
    }
// chuột phải gennerate

}
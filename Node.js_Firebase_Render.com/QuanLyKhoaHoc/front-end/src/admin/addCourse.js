import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import "./AddCourse.css"; // Import file CSS

const AddCourse = () => {
  const [course, setCourse] = useState({
    name: "",
    description: "",
    instructor: "",
    price: "",
    image: "" // Thêm trường image nếu cần
  });
  const [error, setError] = useState(null);
  const navigate = useNavigate();
  const token = localStorage.getItem("token");

  const handleChange = (e) => {
    setCourse({
      ...course,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post("http://localhost:5000/course", course, {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });
      navigate("/admin"); // Điều hướng về danh sách khóa học sau khi thêm mới thành công
    } catch (error) {
      setError("Có lỗi xảy ra khi thêm khóa học: " + error.message);
    }
  };

  return (
    <div className="add-course-container">
      <h1>Thêm Khóa Học Mới</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Tên khóa học:</label>
          <input
            type="text"
            name="name"
            value={course.name}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Mô tả:</label>
          <textarea
            name="description"
            value={course.description}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Giảng viên:</label>
          <input
            type="text"
            name="instructor"
            value={course.instructor}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Giá:</label>
          <input
            type="number"
            name="price"
            value={course.price}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Ảnh khóa học (URL):</label>
          <input
            type="text"
            name="image"
            value={course.image}
            onChange={handleChange}
          />
        </div>
        <button type="submit">Thêm mới</button>
      </form>
      {error && <div className="error-message">Có lỗi xảy ra: {error}</div>}
    </div>
  );
};

export default AddCourse;

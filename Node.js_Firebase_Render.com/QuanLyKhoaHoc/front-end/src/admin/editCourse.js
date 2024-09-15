import React, { useState, useEffect } from "react";
import axios from "axios";
import { useParams, useNavigate } from "react-router-dom";
import "./EditCourse.css"; // Import file CSS

const EditCourse = () => {
  const { id } = useParams();
  const [course, setCourse] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const navigate = useNavigate();
  const token = localStorage.getItem("token");

  useEffect(() => {
    const fetchCourse = async () => {
      try {
        const response = await axios.get(`http://localhost:5000/course/${id}`, {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        });
        setCourse(response.data);
        setLoading(false);
      } catch (error) {
        setError("Có lỗi xảy ra: " + error.message);
        setLoading(false);
      }
    };

    fetchCourse();
  }, [id, token]);

  const handleChange = (e) => {
    setCourse({
      ...course,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.put(`http://localhost:5000/course/${id}`, course, {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });
      navigate("/admin");
    } catch (error) {
      setError("Có lỗi xảy ra khi cập nhật khóa học: " + error.message);
    }
  };

  if (loading) return <div>Đang tải dữ liệu...</div>;
  if (error) return <div className="error-message">Có lỗi xảy ra: {error}</div>;

  return (
    <div className="edit-course-container">
      <h1>Sửa Khóa Học</h1>
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
          <label>image</label>
          <input
            type="text"
            name="image"
            value={course.image}
            onChange={handleChange}
          />
        </div>
        <button type="submit">Cập nhật</button>
      </form>
    </div>
  );
};

export default EditCourse;

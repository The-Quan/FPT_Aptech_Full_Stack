import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const Home = () => {
  const [courses, setCourses] = useState([]); // State để lưu danh sách khóa học
  const [loading, setLoading] = useState(true); // State để hiển thị loading
  const [error, setError] = useState(null); // State để lưu lỗi
  const navigate = useNavigate(); // Hook để điều hướng

  // Giả sử token được lưu trong localStorage
  const token = localStorage.getItem("token");

  // Hàm gọi API để lấy danh sách khóa học
  useEffect(() => {
    // Sử dụng axios để gọi API với header Authorization nếu có token
    axios
      .get("http://localhost:5000/course", {
        headers: {
          Authorization: `Bearer ${token}`, // Include the token if needed
        },
      })
      .then((response) => {
        setCourses(response.data.data); // Truy cập vào mảng courses từ response.data.data
        setLoading(false); // Tắt trạng thái loading
      })
      .catch((error) => {
        setError(error.message); // Nếu có lỗi, lưu lỗi vào state
        setLoading(false); // Tắt trạng thái loading
      });
  }, [token]); // Dependency array để tránh vòng lặp vô hạn

  const handleViewDetails = (id) => {
    // Điều hướng tới trang chi tiết khóa học kèm theo id
    navigate(`/course/${id}`);
  };

  // Hàm điều hướng đến trang login
  const login = () => {
    navigate("/login");
  };

  const registeredCourses = () => {
    navigate("/register-course");
  };

  // Xử lý trạng thái đang tải dữ liệu
  if (loading) {
    return <div>Đang tải dữ liệu...</div>;
  }

  // Xử lý trạng thái lỗi
  if (error) {
    return <div>Có lỗi xảy ra: {error}</div>;
  }

  return (
    <div style={{ padding: "20px" }}>
      <h1>Danh sách các khóa học</h1>
      <button onClick={login}>Login</button>
      <button onClick={registeredCourses}>Khóa học đã đăng kí</button>
      <div style={{ display: "flex", flexWrap: "wrap" }}>
        {courses.map((course) => (
          <div
            key={course.id}
            style={{
              border: "1px solid #ccc",
              borderRadius: "8px",
              margin: "10px",
              padding: "20px",
              width: "300px",
            }}
          >
            <img
              src={course.image}
              alt={course.name}
              style={{ width: "100%", height: "auto", borderRadius: "8px" }}
            />
            <h2>{course.name}</h2>
            <p>{course.description}</p>
            <p>Giảng viên: {course.instructor}</p>
            <p>Giá: {course.price} USD</p>
            <button 
              onClick={() => handleViewDetails(course.id)} // Pass course id to handleViewDetails
              style={{ padding: "10px 20px", cursor: "pointer" }}
            >
              Xem chi tiết
            </button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Home;

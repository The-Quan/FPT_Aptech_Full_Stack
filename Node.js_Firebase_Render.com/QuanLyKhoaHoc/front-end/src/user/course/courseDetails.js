import React, { useState, useEffect, useCallback } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import { jwtDecode } from 'jwt-decode';
import './courseDetails.css'; // Import CSS file

const CourseDetails = () => {
  const { id } = useParams(); // Get the course ID from the URL params
  const [course, setCourse] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(""); // State for displaying error messages
  const [userId, setUserId] = useState(""); // User ID
  const [courseId, setCourseId] = useState(""); // Selected course ID

  const token = localStorage.getItem("token");

  useEffect(() => {
    if (token) {
      try {
        const decodedToken = jwtDecode(token);
        setUserId(decodedToken.uid); // Set user ID from payload
      } catch (error) {
        console.error("Failed to decode token:", error);
      }
    }
  }, [token]);

  useEffect(() => {
    // Fetch course details using axios
    axios
      .get(`http://localhost:5000/course/${id}`, {
        headers: {
          Authorization: `Bearer ${token}`, // Include the token if needed
        },
      })
      .then((response) => {
        setCourse(response.data); // Set course data
        setCourseId(response.data.id); // Ensure courseId is set
        setLoading(false); // Turn off loading
      })
      .catch((error) => {
        setError("Có lỗi xảy ra: " + error.message); // Set error message
        setLoading(false); // Turn off loading
      });
  }, [id, token]);

  const handleSubmit = useCallback(async () => {
    if (!userId || !courseId) {
      setError("Vui lòng kiểm tra lại thông tin người dùng và khóa học.");
      return;
    }

    try {
     await axios.post("http://localhost:3000/course_registrations", {
        userId,
        courseId
      }, {
        headers: {
          Authorization: `Bearer ${token}`
        }
      });
      alert("Bạn đã đăng ký thành công!");
      setError(""); // Clear any previous errors
    } catch (error) {
      setError(error.response?.data?.message || "Bạn đã đăng ký khóa học này.");
    }
  }, [userId, courseId, token]);

  if (loading) {
    return <div>Đang tải dữ liệu...</div>;
  }

  if (!course) {
    return <div>Khóa học không tồn tại.</div>;
  }

  return (
    <div className="course-container">
      <h1 className="course-title">{course.name}</h1>
      <img
        src={course.image}
        alt={course.name}
        className="course-image"
      />
      <p className="course-description">{course.description}</p>
      <p className="course-info">Giảng viên: {course.instructor}</p>
      <p className="course-info">Giá: {course.price} USD</p>

      <button onClick={handleSubmit}>Đăng ký khóa học</button>

      {error && <div className="error-message">{error}</div>}
    </div>
  );
};

export default CourseDetails;

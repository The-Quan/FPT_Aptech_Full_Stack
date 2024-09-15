import React, { useEffect, useState } from 'react';
import axios from 'axios';
import {jwtDecode} from 'jwt-decode'; // Importing jwtDecode correctly
import './registeredCourses.css'; // Import file CSS

const RegisteredCourses = () => {
    const [courses, setCourses] = useState([]); // All registered courses with details
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [userId, setUserId] = useState(""); // User ID

    const token = localStorage.getItem("token");

    useEffect(() => {
        if (token) {
            try {
                const decodedToken = jwtDecode(token);
                setUserId(decodedToken.uid); // Set user ID from payload
            } catch (error) {
                console.error("Failed to decode token:", error);
                setError("Có lỗi xảy ra khi giải mã token.");
                setLoading(false);
            }
        }
    }, [token]);

    useEffect(() => {
        const fetchCourses = async () => {
            if (userId) {
                try {
                    // Fetch registered course data by userId
                    const response = await axios.get(`http://localhost:5000/course_registrations/${userId}`, {
                        headers: {
                            Authorization: `Bearer ${token}`,
                        },
                    });

                    // Fetch detailed course info for each registered course
                    const courseDetails = await Promise.all(response.data.data.map(async (registeredCourse) => {
                        
                        const courseDetailResponse = await axios.get(`http://localhost:5000/course/${registeredCourse.courseId}`, {
                            headers: {
                                Authorization: `Bearer ${token}`,
                            },
                        });
                        return { ...registeredCourse, details: courseDetailResponse.data }; // Combine registration and course details
                    }));

                    setCourses(courseDetails);
                } catch (err) {
                    setError(err.response?.data?.message || 'Có lỗi xảy ra khi tải dữ liệu.');
                } finally {
                    setLoading(false);
                }
            }
        };

        fetchCourses();
    }, [userId, token]);

    if (loading) {
        return <p>Đang tải dữ liệu...</p>;
    }

    if (error) {
        return <p>{error}</p>;
    }

    // Hàm chuyển đổi Unix timestamp thành định dạng ngày
    const formatDate = (seconds, nanoseconds) => {
        const date = new Date(seconds * 1000 + nanoseconds / 1000000);
        return date.toLocaleDateString() + ' ' + date.toLocaleTimeString();
    };

    return (
        <div className="registered-courses">
            <h2>Các Khóa Học Đã Đăng Ký</h2>
            {courses.length === 0 ? (
                <p className="empty-message">Bạn chưa đăng ký khóa học nào.</p>
            ) : (
                <ul className="course-list">
                    {courses.map(course => (
                        <li key={course.id} className="course-item">
                            <img src={course.details.image} alt={course.details.name} className="courses-image" />
                            <h3>{course.details.name}</h3> {/* Display course name */}
                            <p><strong>Mô tả:</strong> {course.details.description}</p>
                            <p><strong>Giảng viên:</strong> {course.details.instructor}</p>
                            <p><strong>Giá:</strong> {course.details.price} USD</p>
                            <p><strong>Ngày đăng ký:</strong> {formatDate(course.registrationDate._seconds, course.registrationDate._nanoseconds)}</p>
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
};

export default RegisteredCourses;

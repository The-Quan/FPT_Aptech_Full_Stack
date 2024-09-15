import axios from "axios";
import React, { useState } from "react";
import './register.css'; // Điều chỉnh đường dẫn nếu cần

const Register = () => {
    const [email, setEmail] = useState('');
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const [success, setSuccess] = useState('');

    const handleRegister = async (event) => {
        event.preventDefault();
        try {
            await axios.post('http://localhost:5000/signup', {
                email,
                username,
                password
            });
            
            setSuccess('Registration successful! Please check your email to verify your account.');
            window.location.href = '/login';
        } catch (error) {
            if (error.response && error.response.data) {
                setError(`Registration failed: ${error.response.data.message}`);
            } else {
                setError('Registration failed. Please try again.');
            }
        }
    }

    return (
        <div className="register-container">
            <h2 className="register-title">Register</h2>
            <form className="register-form" onSubmit={handleRegister}>
                <div className="form-group">
                    <label className="form-label" htmlFor="email">Email:</label>
                    <input
                        className="form-input"
                        type="email"
                        id="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group">
                    <label className="form-label" htmlFor="username">Username:</label>
                    <input
                        className="form-input"
                        type="text"
                        id="username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group">
                    <label className="form-label" htmlFor="password">Password:</label>
                    <input
                        className="form-input"
                        type="password"
                        id="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </div>
                {error && <p className="form-error">{error}</p>}
                {success && <p className="form-success">{success}</p>}
                <button className="register-button1" type="submit">Register</button>
            </form>
        </div>
    );
}

export default Register;

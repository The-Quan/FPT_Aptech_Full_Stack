import React, { useState } from 'react';
import axios from 'axios'; // Make sure to install axios if you haven't
import './login.css'; // Import the CSS file
import { useNavigate } from 'react-router-dom';
import { jwtDecode } from 'jwt-decode';

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const [success, setSuccess] = useState('');

  const handleLogin = async (event) => {
    event.preventDefault();


    try {
      const response = await axios.post('http://localhost:5000/login', {
        username,
        password,
      });

      const token = response.data.token;
      const decodedToken = jwtDecode(token);

      localStorage.setItem('token', token);
      setSuccess('Login successful!');  
      if(decodedToken.role === 'user'){
        window.location.href = '/';
      }else if(decodedToken.role === 'admin'){
        window.location.href = '/admin';
      }
    } catch (error) {
      setError('Login failed. Please check your credentials.');
    }
  };

  const navigate = useNavigate();
  
  const register = () =>{
    navigate('/register')
  }

  return (
    <div class="app-container">
    <div className="login-container">
      <h2>Login</h2>
      <form onSubmit={handleLogin}>
        <div>
          <label htmlFor="username">Username:</label>
          <input
            type="text"
            id="username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          />
        </div>
        <div>
          <label htmlFor="password">Password:</label>
          <input
            type="password"
            id="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        {error && <p className="error">{error}</p>}
        {success && <p className="success">{success}</p>}
        <button type="submit">Login</button>
        <button onClick={register} style={{marginTop: '20px'}}>Register</button>
      </form>
    </div>
    </div>
  );
};

export default Login;

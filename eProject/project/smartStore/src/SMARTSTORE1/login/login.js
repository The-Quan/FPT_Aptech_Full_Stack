import React, { useState } from "react";
import './login.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEye } from '@fortawesome/free-solid-svg-icons';
import { faEyeSlash } from '@fortawesome/free-solid-svg-icons';
import loginApi from '../login/api';
import { Link, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";



const Login = () => {

    const [email, setEmail] = useState("");

    const [password, setPassword] = useState("");

    const [isShowPassword, setIsShowPassword] = useState(false);



    const navigate = useNavigate();

    const handleLogin = async () => {
        if (!email || !password) {
            toast.error("Email and Password is requires!")
            return
        }
        let res = await loginApi(email, password);
        if (res && res.token) {
            localStorage.setItem("token", res.token)
            navigate("/hone")
        }
        console.log(">> check ", res)
    }

    return (
        <>
            <div className="login" >
                <div className="btn-title-2"> <h1>Login</h1></div>
                <div className="emai-password">
                    <i class="fa-regular fa-eye"></i>
                    <p>Email or Password</p>
                </div>
                <div className="submit">
                    <input className="btn-input" type='email' placeholder="Email"
                        value={email} onChange={(event) => setEmail(event.target.value)}></input>
                    <div className="btn-password">
                        <input className="btn-input1" type={isShowPassword === true ? "text" : 'password'}
                            placeholder="Password"
                            value={password} onChange={(event) => setPassword(event.target.value)}></input>
                        <FontAwesomeIcon
                            icon={isShowPassword ? faEye : faEyeSlash}
                            onClick={() => setIsShowPassword(!isShowPassword)}
                            className={isShowPassword ? "eye" : "eye2"}
                        />


                    </div>
                    <div className="btn-dk">
                        <p className="qmp">Forgot password ?</p>
                        <p className="dk">Register</p>
                    </div>



                    <button id="btn-button" className={email && password ? "btn-button" : ""} type="submit"
                        disabled={email && password ? false : true}
                        onClick={() => handleLogin()}
                    >Login</button>
                </div>

                <Link to='/home'><div className="close">Exit</div></Link>
            </div>
        </>
    )
}
export default Login;
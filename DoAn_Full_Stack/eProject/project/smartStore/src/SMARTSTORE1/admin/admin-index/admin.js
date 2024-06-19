import React from "react";
import logo from './img/logo.png';
import './admin.css';
import { Link } from "react-router-dom";
import Dashboard from "../dashboard/dashboard";
import MenuAdmin from "../menuAdmin/menuAdmin";




function Admin() {
    return (
        <div className="body-admin">
            <div className="btn-admin">
                <Dashboard />
            </div>
        </div>
    )
}
export default Admin;
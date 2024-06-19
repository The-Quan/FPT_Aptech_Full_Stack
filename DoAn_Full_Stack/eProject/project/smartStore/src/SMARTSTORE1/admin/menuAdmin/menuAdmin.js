import React from "react";
import logo from "./img/logo.png";
import { Link } from "react-router-dom";


function MenuAdmin(){
    return(
        <div className="menu-admin">
        <img className="logo-admin" src={logo} />
        <ol className="btn-admenu">
            <li className="li-ad"><Link to='/dashboard'>Dashboard</Link></li>
            <li><Link to='/user'>User</Link></li>
            <li> <Link to='/category'>Category</Link></li>
            <li><Link to='/product'>Product</Link></li>
            <li><Link to='/order'>Order</Link></li>
        </ol>
    </div>
    )
}
export default MenuAdmin;

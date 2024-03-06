import React from 'react';
import logo from './img/logo.png';
import search from './img/search.png';
import cart from './img/cart.png';
import user from './img/user.png';
import './header.css';


function Header() {

    return (
        <div className='container'>
            <div className='logo'>
            <img src={logo} alt="Logo" />
            </div>
            <div className="btn">
                <div className="search">
                    <img id="search-icon1" src={search} alt="Search Icon" />
                    <form action="" id="search-form">
                        <input type="text" name="keyword" id="keyword" placeholder="Search" />
                    </form>
                </div>
                <div className="cart">
                    <img src={cart} alt="Cart Icon"/>
                </div>
                <div className="user">
                    <img src={user} alt="User Icon" />
                </div>
            </div>
        </div>
    );
}


export default Header;

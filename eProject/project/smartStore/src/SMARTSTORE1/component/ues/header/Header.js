import React from 'react';
import logo from './img/logo.png';
import search from './img/search.png';
import cart from './img/cart.png';
import user from './img/user.png';
import './header.css';
import { Link } from 'react-router-dom';


function Header() {
    return (
        <div className='container'>
            <div className='logo' >
                <img src={logo} alt="Logo" />
            </div>
            <div className="btn">
                <div className="search">
                    <img id="search-icon1" src={search} alt="Search Icon" />
                    <form action="" id="search-form">
                        <input type="text" name="keyword" id="keyword" placeholder="Search" />
                    </form>
                </div>
                <Link to='/shoppingcart'>
                   <div className="cart">
                        <img id='cart-icon1' src={cart} alt="Cart Icon" />
                        <sup className='quatity'>5</sup>
                    </div>
                </Link>
                <div className="user">
                    <Link to="/login"> <img id='user-icon1' src={user} alt="User Icon" /></Link>
                </div>
            </div>
        </div>
    );
}


export default Header;
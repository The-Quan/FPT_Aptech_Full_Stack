import React from 'react';
import logo from './img/logo.png';
import search from './img/search.png';
import cart from './img/cart.png';
import user from './img/user.png';
import './header.css';
import { Link } from 'react-router-dom';


function Header({ quantity, setShowCart }) {

    const ShowCart = () => {
        setShowCart(true);
    }

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
                <div className="cart" onClick={ShowCart}>
                     <img id='cart-icon1'  src={cart} alt="Cart Icon" />
                        <span className='quatity'>{quantity}</span>
                </div>
                <div className="user">
                    <img id='user-icon1' src={user} alt="User Icon" />
                </div>
            </div>
        </div>
    );
}


export default Header;
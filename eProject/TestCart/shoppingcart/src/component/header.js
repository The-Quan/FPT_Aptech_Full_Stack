import React from 'react';
import logo from './img/logo.png';
import cart from './img/cart.png'
import '../App.css';

function Header(props) {
  return (
    <div className='flex shopping-cart'>
   <div onClick={() => props.handleShow(false)}><img src={logo}/></div>
   <div onClick={() => props.handleShow(true)}><img src={cart} /><sup>{props.count}</sup></div>
   </div>
  );
}

export default Header;

import React, { useState } from 'react';
import './shoppingcart.css';
import { Link } from 'react-router-dom';
import anh1 from './img/tuQuanAo.png';
import anh2 from './img/anh1.jpg';
import anh3 from './img/anh2.jpg';
import anh4 from './img/anh3.jpg';
import anh5 from './img/gt1.webp';
import Header from '../component/ues/header/Header';
import Menu from '../component/ues/menu/menu';
import Footer from '../component/ues/footer/footer';


function ShoppingCart() {

    const [quantity, setQuantity] = useState(1);

    const decreaseQuantity = () => {
        if (quantity > 1) {
            setQuantity(quantity - 1);
        }
    }

    const increaseQuantity = () => {
        setQuantity(quantity + 1);
    }
    return (
        <div className="ShoppingCart">
            <Header />
            <Menu />
            <div className="btn-cart">
                <h1 className="title">Shopping Cart</h1>
            </div>
            <div className="btn-cart2">
                <div className="btn-cart1">
                    <div className="cart-qty">
                        <p className="btn-title">Your cart</p>
                        <p className="quantity">You currently have <strong>5</strong>  product in your cart</p>
                    </div>
                </div>
            </div>
            <div className='btn-cart-product'>
                <div className='img-cart-product1'><img className='img-cart-product2' src={anh1} /></div>
                <div className='nameProduct'>
                    <p>Beautiful modern wooden wardrobe with sliding doors – TQAVP09</p>
                    <div className='price'>5.000$ x1</div>


                </div>
                <div className='quantityy'>
                    <button className='but-qty' onClick={decreaseQuantity}>-</button>
                    <input className='input-qty' type="text" value={quantity} />
                    <button className='but-qty' onClick={increaseQuantity}>+</button>
                </div>
                <button className='remove'>Remove</button>
            </div>
            <div className='btn-cart-product'>
                <div className='img-cart-product1'><img className='img-cart-product2' src={anh2} /></div>
                <div className='nameProduct'>
                    <p>High-end Built-in Glass Door Wardrobe – TQAVP37</p>
                    <div className='price'>5.000$ x1</div>


                </div>
                <div className='quantityy'>
                    <button className='but-qty' onClick={decreaseQuantity}>-</button>
                    <input className='input-qty' type="text" value={quantity} />
                    <button className='but-qty' onClick={increaseQuantity}>+</button>
                </div>
                <button className='remove'>Remove</button>
            </div>
            <div className='btn-cart-product'>
                <div className='img-cart-product1'><img className='img-cart-product2' src={anh3} /></div>
                <div className='nameProduct'>
                    <p>6-Compartment Wardrobe with Dressing Table – TQAVP18</p>
                    <div className='price'>5.000$ x1</div>


                </div>
                <div className='quantityy'>
                    <button className='but-qty' onClick={decreaseQuantity}>-</button>
                    <input className='input-qty' type="text" value={quantity} />
                    <button className='but-qty' onClick={increaseQuantity}>+</button>
                </div>
                <button className='remove'>Remove</button>
            </div>
            <div className='btn-cart-product'>
                <div className='img-cart-product1'><img className='img-cart-product2' src={anh4} /></div>
                <div className='nameProduct'>
                    <p>Square Glass Door Wardrobe – TQAVP45</p>
                    <div className='price'>5.000$ x1</div>


                </div>
                <div className='quantityy'>
                    <button className='but-qty' onClick={decreaseQuantity}>-</button>
                    <input className='input-qty' type="text" value={quantity} />
                    <button className='but-qty' onClick={increaseQuantity}>+</button>
                </div>
                <button className='remove'>Remove</button>
            </div>
            <div className='btn-cart-product'>
                <div className='img-cart-product1'><img className='img-cart-product2' src={anh5} /></div>
                <div className='nameProduct'>
                    <p>10-Door Glass Wardrobe – TQAVP36</p>
                    <div className='price'>5.000$ x1</div>


                </div>
                <div className='quantityy'>
                    <button className='but-qty' onClick={decreaseQuantity}>-</button>
                    <input className='input-qty' type="text" value={quantity} />
                    <button className='but-qty' onClick={increaseQuantity}>+</button>
                </div>
                <button className='remove'>Remove</button>
            </div>
            <div className='close-2'>
                <h2>Total money: 25.000$</h2>
                <Link to='/home'><button className='btn-close'> close Cart</button></Link>
                <Link to='/Payment'><button className='btn-Payment'>Proceed to Checkout</button> </Link>
            </div>
            <Footer />
        </div>

    )
}

export default ShoppingCart;

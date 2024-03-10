import React, { useState } from "react";
import './shoppingcart.css';
import Header from "../component/ues/header/Header";
import Menu from "../component/ues/menu/menu";
import anh1 from "./img/tuQuanAo.png";



function ShoppingCart() {
    const [quantity, setQuantity] = useState(1);

    const increaseQuantity = () => {
        setQuantity(quantity + 1);
    };

    const decreaseQuantity = () => {
        if (quantity > 1) {
            setQuantity(quantity - 1);
        }
    };


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
                        <span className="btn-title">Your cart</span>
                        <p className="quantity">You currently have 1 product in your cart</p>
                    </div>
                    <div className="cart-product">
                        <div className="img-cart"><img className="img-cart2" src={anh1} /></div>
                        <div className="name-cart1"> <p className="name-cart">Beautiful modern wooden wardrobe with sliding doors – TQAVP09</p>
                            <div className="btn-mn1"><strong className="btn-mn">5.000$</strong></div>
                        </div>
                        <div className="tanggiam">
                        <div><strong>10.000$</strong></div>
                            <button className='buttonbtn' onClick={decreaseQuantity}>-</button>
                            <span>{quantity} &nbsp; &nbsp; &nbsp;</span>
                            <button className='buttonbtn' onClick={increaseQuantity}>+</button>
                        </div>
                        <button className="delete">delete</button>
                    </div>
                </div>
                <div className="pay">
                    <div className="sum">
                        <p className="total-money">Total money:</p>
                        <strong className="btn-monny">5.000$</strong>
                    </div>
                    <div className="btn-cn">
                        <li className="libt">FREE EXCHANGE - At all stores within 15 days</li>
                        <li className="libt">You can also enter a discount code at the checkout page.</li>
                        <div className="btn-Pay"><button className="pay2" >Payments</button></div>
                    </div>
                    <div className="btn-cn2">
                        <strong>Purchase policy:</strong>
                        <p>We are currently offering nationwide delivery</p>
                    </div>
                </div>
            </div>
        </div>
    )
}
export default ShoppingCart; 
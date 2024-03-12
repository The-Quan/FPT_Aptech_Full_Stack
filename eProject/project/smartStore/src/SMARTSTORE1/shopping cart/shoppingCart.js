import React, { useEffect, useState } from 'react';
import './shoppingcart.css';


function ShoppingCart({ Cart, setShowCart, setCart }) {
    const [tongtien, settongtien] = useState(0);

    const thaydoisoluong = (sanpham, s1) => {
        //tim sp trong cart va thay doi slg
        const idx = Cart.indexOf(sanpham);
        const arr = [...Cart];
        arr[idx].amount += s1;
        if (arr[idx].amount == 0) arr[idx].amount = 1;
        setCart([...arr]);
    };

    const removeProduct = (sanpham) => {
        const arr = Cart.filter(sp => sp.id !== sanpham.id);
        setCart([...arr])
    }


    const tinhtongtien = () => {
        let tt = 0;
        Cart.map((sp) => {
            tt += sp.price * sp.amount;
        })
        settongtien(tt);
    }

    const closeCart = () => {
        setShowCart(false)
    }
    useEffect(() => {
        tinhtongtien();
    })


    return (
        <>
            <div className="ShoppingCart">
                <div className="btn-cart">
                    <h1 className="title">Shopping Cart</h1>
                </div>
                <div className="btn-cart2">
                    <div className="btn-cart1">
                        <div className="cart-qty">
                            <span className="btn-title">Your cart</span>
                            <p className="quantity">You currently have <strong>{Cart.map((product) => (product.amount))}</strong>  product in your cart</p>
                        </div>
                    </div>
                </div>

                {Cart.map((product) => (

                    <div className='ShoppingCart2'>
                        <div className='cart-img'>
                            <img className='btn-cart-img' src={product.src} width={"100%"}></img>
                        </div>
                        <div className='cart-name'>
                            <p>{product.name}. <br /><br /><strong> {product.price}</strong>$</p>
                        </div>
                        <div className='btn-qty'>
                            <button className='bton-qty' onClick={() => thaydoisoluong(product, 1)}>+</button>
                            <p className='amount'>{product.amount}</p>
                            <button className='bton-qty' onClick={() => thaydoisoluong(product, -1)}>-</button>
                        </div>
                        <div className='sum-monny'>
                            {product.price * product.amount} $
                        </div>
                        <button className='remove' onClick={() => removeProduct(product)}>Remove</button>
                    </div>
                ))}
                <div className='close'>
                    <hr />
                    <h2>Tong thanh tien: {tongtien}</h2>
                    <button className='btn-close' onClick={closeCart}> close Cart</button>
                </div>
            </div>
        </>
    )
}
export default ShoppingCart; 
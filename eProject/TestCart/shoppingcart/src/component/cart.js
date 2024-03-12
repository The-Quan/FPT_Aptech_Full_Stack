import React, { useEffect, useState } from "react";

function CartList({cart}){
      
    const [CART, setCart] = useState([])
    useEffect (() => {
        setCart(cart)
    },[cart])

    return(
        <div>
            {
                CART?.map((cartItem, cartindex) => {
                    return(
                        <div>
                        <img src={cartItem.src} width={40}></img>
                        <span>{cartItem.name}</span>
                        <button onClick={() => {
                            const _CART = CART.map((item, index) =>{
            return  cartindex === index ? { ...item, quantity : item.quantity - 1 } : item
                            }) 
                            setCart(_CART)
                        }} >-</button>
                        <span>{cartItem.quantity}</span>
                        <button onClick={() => {
                            const _CART = CART.map((item, index) =>{
            return  cartindex === index ? { ...item, quantity : item.quantity + 1 } : item
                            }) 
                            setCart(_CART)
                        }}
                        >+</button>
                        <span>Rs. {cartItem.price * cartItem.quantity}</span>
                        </div>
                    )
                })
            }
            <p>
                {
                    CART.map(item => item.price * item.quantity).reduce((total, value) => total + value, 0)
                }
            </p>
        </div>
    )
}
export default CartList;
import React, { useState } from 'react';
import './App.css';
import Header from './component/header';
import Product from './component/product';
import CartList from './component/cart';
import anh1 from "./component/img/tuQuanAo.png";
import Menu from './component/menu/menu';

function App() {

  const [product, setProduct] = useState([
    {
      src: anh1,
      name: 'name product1',
      category: 'sheos',
      seller: 'gklngkdga',
      price: 5000
    },
    {
      src: './img/tuQuanAo2.jpg',
      name: 'name product2',
      category: 'sheos',
      seller: 'gklngkdga',
      price: 5000
    },
    {
      src: './img/tuQuanAo3.jpg',
      name: 'name product3',
      category: 'sheos',
      seller: 'gklngkdga',
      price: 5000
    }
  ])
  const [cart, setCart] = useState([])
  
  const [showCart, setShowCart] = useState(false)


  const addToCart = (data) => {
  
   setCart([...cart,{ ...data, quantity : 1 }])
  }

  const handleShow = (value) => {
   setShowCart(value)
  }
  return (
   <div className='App'>
    <Header count={cart.length}
     handleShow={handleShow} />
    {
      showCart ?
      <CartList cart={cart} /> :
      <Product  product ={product} addToCart={addToCart}/>
      
    }
<Menu />
   </div>
  );
}

export default App;

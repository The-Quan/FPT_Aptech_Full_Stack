import React, { useState } from 'react';
import './App.css';

const productsData = [
  { id: 1, name: 'Product 1', price: 20.00 },
  { id: 2, name: 'Product 2', price: 30.00 },
  // Thêm các sản phẩm khác nếu cần
];

function App() {
  const [cartItems, setCartItems] = useState([]);

  const addToCart = (id, name, price) => {
    const newItem = { id, name, price };
    setCartItems([...cartItems, newItem]);
  };

  const calculateTotal = () => {
    return cartItems.reduce((total, item) => total + item.price, 0).toFixed(2);
  };

  return (
    <div className="App">
      <div id="cart">
        <h2>Shopping Cart</h2>
        <ul id="cart-items">
          {cartItems.map(item => (
            <li key={item.id}>{item.name} - ${item.price.toFixed(2)}</li>
          ))}
        </ul>
        <p id="total">Total: ${calculateTotal()}</p>
      </div>

      <div id="products">
        <h2>Products</h2>
        <ul>
          {productsData.map(product => (
            <li key={product.id}>
              {product.name} - ${product.price.toFixed(2)} 
              <button onClick={() => addToCart(product.id, product.name, product.price)}>
                Add to Cart
              </button>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default App;

// import Product from "./Product/Product";

// function App1(){
//   return(
//     <div>
//       <h2>Product</h2>
//     <div className="App">
//       <Product
//       img = "https://suno.vn/blog/wp-content/uploads/2018/05/cach-chup-anh-san-pham-co-concept-758x400.jpg"
//       name = "Product's Name"
//       desc = "description about the product1"
//       price = "$250"
//       />
  
//     </div>
//     </div>
//   );
  
//   }
//   export default App1;
  
  

import React, {Component} from "react";

import Home from "./component/home";
import About from "./component/about";
import Category from "./component/category";
import Contact from "./component/contact";
import Product from "./component/product";


import { BrowserRouter, Link, Routes, Route } from "react-router-dom";

class App extends Component {
  render(){
    return(
     
       <div>
         <BrowserRouter>
        <ul>
          <li>
            <Link to="/Home">Home</Link>
          </li>
          <li>
          <Link to="/Product">Product</Link>
          </li>
          <li>
          <Link to="/Category">Category</Link>
          </li>
          <li>
          <Link to="/About">About</Link>
          </li>
          <li>
          <Link to="/Contact">Contact</Link>
          </li>
        </ul>
         <Routes>
         <Route path='/Home' element={<Home />} /> 
         <Route path='/Product' element={<Product />} /> 
         <Route path='/Category' element={<Category />} /> 
         <Route path='/About' element={<About />} /> 
         <Route path='/Contact' element={<Contact />} /> 
         </Routes>
      </BrowserRouter>
      </div>
    );
  }
}
export default App;


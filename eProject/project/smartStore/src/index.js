import React, { StrictMode } from "react";
import ReactDOM from "react-dom";  // Fixed import statement
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Home from "./SMARTSTORE1/user/home/index.js";
import Introduce from "./SMARTSTORE1/user/introduce/introduce.js";
import Products from './SMARTSTORE1/user/product/product.js';
import Contact from "./SMARTSTORE1/user/contact/contact.js";
import ProductContent1 from "./SMARTSTORE1/component/product/content1/content1.js";
import App from "./SMARTSTORE1/App.js";
import ProductContent2 from "./SMARTSTORE1/component/product/content2/content2.js";
import ProductContent3 from "./SMARTSTORE1/component/product/content3/content3.js";
import ProductContent4 from "./SMARTSTORE1/component/product/content4/content4.js";
import Strored from "./SMARTSTORE1/component/product/Strored/strored.js";
import BuyProduct1 from "./SMARTSTORE1/component/home/content2/Buy product/buy-product1.js";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <StrictMode>
    <Router>
      <Routes>
        <Route path="/" exact Component={App}></Route>
        <Route path="/Home" exact Component={Home}></Route>
        <Route path="/Introduce" exact Component={Introduce}></Route>
        <Route path="/Products" exact Component={Products}> </Route>
        <Route path="/Contact" exact Component={Contact}></Route>
        <Route path="/content1" exact Component={ProductContent1}></Route>
        <Route path="/content2" exact Component={ProductContent2}></Route>
        <Route path="/content3" exact Component={ProductContent3}></Route>
        <Route path="/content4" exact Component={ProductContent4}></Route>
        <Route path="/Strored" exact Component={Strored}></Route>
        <Route path="/BuyProduct1" exact Component={BuyProduct1}></Route>
      </Routes>
    </Router>
  </StrictMode>
);

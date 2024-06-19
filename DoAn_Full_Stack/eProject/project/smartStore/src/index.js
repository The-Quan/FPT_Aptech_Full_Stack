import React, { StrictMode } from "react";
import ReactDOM from "react-dom";  // Fixed import statement
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Home from "./SMARTSTORE1/Pages/home/index.js";
import Introduce from "./SMARTSTORE1/Pages/introduce/introduce.js";
import Products from './SMARTSTORE1/Pages/product/product.js';
import Contact from "./SMARTSTORE1/Pages/contact/contact.js";
import ProductContent1 from "./SMARTSTORE1/component/product/content1/content1.js";
import App from "./SMARTSTORE1/App.js";
import ProductContent2 from "./SMARTSTORE1/component/product/content2/content2.js";
import ProductContent3 from "./SMARTSTORE1/component/product/content3/content3.js";
import ProductContent4 from "./SMARTSTORE1/component/product/content4/content4.js";
import Strored from "./SMARTSTORE1/component/product/Strored/strored.js";
import BuyProduct1 from "./SMARTSTORE1/component/home/content2/Buy product/buy-product1.js";
import BuyProduct2 from "./SMARTSTORE1/component/home/content2/Buy product 2/buy-product1.js";
import BuyProduct3 from "./SMARTSTORE1/component/home/content2/Buy product 3/buy-product1.js";
import BuyProduct4 from "./SMARTSTORE1/component/home/content2/Buy product 4/buy-product1.js";
import BuyProduct5 from "./SMARTSTORE1/component/home/content2/Buy product 5/buy-product1.js";
import BuyProduct6 from "./SMARTSTORE1/component/home/content2/Buy product 6/buy-product1.js";
import BuyProduct7 from "./SMARTSTORE1/component/home/content2/Buy product 7/buy-product1.js";
import BuyProduct8 from "./SMARTSTORE1/component/home/content2/Buy product 8/buy-product1.js";
import BuyProductStored1 from "./SMARTSTORE1/component/home/content3/Buy product/buy-product1.js";
import BuyProductStored2 from "./SMARTSTORE1/component/home/content3/Buy product 2/buy-product1.js";
import BuyProductStored3 from "./SMARTSTORE1/component/home/content3/Buy product 3/buy-product1.js";
import BuyProductStored4 from "./SMARTSTORE1/component/home/content3/Buy product 4/buy-product1.js";
import BuyProductStored5 from "./SMARTSTORE1/component/home/content3/Buy product 5/buy-product1.js";
import BuyProductStored6 from "./SMARTSTORE1/component/home/content3/Buy product 6/buy-product1.js";
import BuyProductStored7 from "./SMARTSTORE1/component/home/content3/Buy product 7/buy-product1.js";
import BuyProductStored8 from "./SMARTSTORE1/component/home/content3/Buy product 8/buy-product1.js";
import ShoppingCart from "./SMARTSTORE1/shopping cart/shoppingCart.js";
import Login from "./SMARTSTORE1/login/login.js";
import Payment from "./SMARTSTORE1/thanhToan/Payment.js";
import DonHang from "./SMARTSTORE1/donhang/donhang.js";
import Dashboard from "./SMARTSTORE1/admin/dashboard/dashboard.js";
import User from "./SMARTSTORE1/admin/user/user.js";
import Admin from "./SMARTSTORE1/admin/admin-index/admin.js";
import Category from "./SMARTSTORE1/admin/category/category.js";
import Product from "./SMARTSTORE1/admin/productadmin/product-admin.js";
import Order from "./SMARTSTORE1/admin/order/order.js";





const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <StrictMode>
    <Router>
      <Routes>
        <Route path="/" exact Component={App}></Route>
        <Route path="/Home" exact Component={Home}></Route>
        <Route path="/Introduce" exact Component={Introduce}></Route>
        <Route path="/Products" exact Component={Products}></Route>
        <Route path="/Contact" exact Component={Contact}></Route>
        <Route path="/content1" exact Component={ProductContent1}></Route>
        <Route path="/content2" exact Component={ProductContent2}></Route>
        <Route path="/content3" exact Component={ProductContent3}></Route>
        <Route path="/content4" exact Component={ProductContent4}></Route>
        <Route path="/Strored" exact Component={Strored}></Route>
        <Route path="/BuyProduct1" exact Component={BuyProduct1}></Route>
        <Route path="/BuyProduct2" exact Component={BuyProduct2}></Route>
        <Route path="/BuyProduct3" exact Component={BuyProduct3}></Route>
        <Route path="/BuyProduct4" exact Component={BuyProduct4}></Route>
        <Route path="/BuyProduct5" exact Component={BuyProduct5}></Route>
        <Route path="/BuyProduct6" exact Component={BuyProduct6}></Route>
        <Route path="/BuyProduct7" exact Component={BuyProduct7}></Route>
        <Route path="/BuyProduct8" exact Component={BuyProduct8}></Route>
        <Route path="/BuyProductStored1" exact Component={BuyProductStored1}></Route>
        <Route path="/BuyProductStored2" exact Component={BuyProductStored2}></Route>
        <Route path="/BuyProductStored3" exact Component={BuyProductStored3}></Route>
        <Route path="/BuyProductStored4" exact Component={BuyProductStored4}></Route>
        <Route path="/BuyProductStored5" exact Component={BuyProductStored5}></Route>
        <Route path="/BuyProductStored6" exact Component={BuyProductStored6}></Route>
        <Route path="/BuyProductStored7" exact Component={BuyProductStored7}></Route>
        <Route path="/BuyProductStored8" exact Component={BuyProductStored8}></Route>
        <Route path="/ShoppingCart" exact Component={ShoppingCart}></Route>
        <Route path="/Login" exact Component={Login}></Route>
        <Route path="/Payment" exact Component={Payment}></Route>
        <Route path="/donhang" exact Component={DonHang}></Route>
        <Route path="/admin" exact Component={Admin}></Route>
        <Route path="/dashboard" exact Component={Dashboard}></Route>
        <Route path="/user" exact Component={User}></Route>
        <Route path="/category" exact Component={Category}></Route>
        <Route path="/product" exact Component={Product}></Route>
        <Route path="/order" exact Component={Order}></Route>
      </Routes>
    </Router>
  </StrictMode>
);

import React from 'react';
import phuonghuong from './img/phuongHuong.png';
import tuQuanAo from './img/tuQuanAo.png';
import luutru from './img/luuTru.jpg';

import './content1.css';
import { Link } from 'react-router-dom';


const Content1 = () => {
    return (
        <div className='content-1'>
            <h1>I.&nbsp;PRODUCT CATEGORY</h1>
            <div class="btn-product">
                <div class="product-1">
                    <img className='img' src={tuQuanAo} alt="" />
                    <button className='btn-btn'><Link to="/Products">Wardrobe</Link></button>
                </div>
                <div class="product-2">
                    <img className='img' src={luutru} alt="" />
                    <button className='btn-btn'><Link to="/Strored">Storage products</Link></button>
                </div>
            </div>
        </div>
    )
}

export default Content1;
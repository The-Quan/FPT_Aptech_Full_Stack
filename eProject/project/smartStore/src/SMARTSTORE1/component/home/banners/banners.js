import React from 'react';
import anhContent from './img/anhSanPham.jpg';
import './banners.css';

function Banners() {
    return (
        <div className='banners'>
            <div class="productImages">
                <img src={anhContent} alt="" />
            </div>
            <div class="content">
                <div class="btn-2">
                    <h2>QUALITY</h2>
                    <em>Product quality assurance</em>
                </div>
                <div class="btn-3">
                    <h2>FREE SHIPPING</h2>
                    <em>Free shipping for orders of 2 products</em>
                </div>
                <div class="btn-4">
                    <h2>ORDER SUPPORT</h2>
                    <em>24/7 customer support staff.</em>
                </div>
            </div>
        </div>
    );
}

export default Banners;
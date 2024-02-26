import React from 'react';
import './content3.css';
import sanphamluutru1 from './img/sanphamluutru1.jpg'
import sanphamluutru2 from './img/sanphamluutru2.jpg'
import sanphamluutru3 from './img/sanphamluutru3.webp'
import sanphamluutru4 from './img/sanphamluutru4.webp'
import sanphamluutru5 from './img/sanphamluutru5.webp'
import sanphamluutru6 from './img/sanphamluutru6.png'
import sanphamluutru7 from './img/sanphamluutru7.jpg'
import sanphamluutru8 from './img/sanphamluutru8.png'


function Content3(){
    return(
        <div className='content3'>
            
        <h1> III. &nbsp;STORED PRODUCTS</h1>
        <div class="btn-Product-2">
            <div class="btn-storedProduct-1">
                <div class="stored-1">
                    <img src= {sanphamluutru1} alt=""/><br/>
                    <a href=""><span>Plastic Belt Storage Box On Wheels Throughout The Bottom Of The Bed</span></a><br/>
                    <strong>5.000$</strong><br/>
                    <div class="addtocart">
                        <button><a href="">Buy product</a></button>
                    </div>
                </div>
                <div class="stored-2">
                    <img src= {sanphamluutru2}  alt=""/><br/>
                    <a href=""><span>Medicine Box, Multi-purpose Home Medical Equipment Storage.</span></a><br/>
                    <strong>5.000$</strong><br/>
                    <div class="addtocart">
                        <button><a href="">Buy product</a></button>
                    </div>
                </div>
                <div class="stored-3">
                    <img src={sanphamluutru3}  alt="" /><br/>
                    <a href=""><span>Shoe box with transparent hard plastic lid, full black box</span></a><br/>
                    <strong>5.000$</strong><br/>
                    <div class="addtocart">
                        <button><a href="">Buy product</a></button>
                    </div>
                </div>
                <div class="stored-4">
                    <img src={sanphamluutru4}  alt=""/><br/>
                    <a href=""><span>Cosmetic or stationery storage shelf Available in two colors: pink and
                            white</span></a><br/>
                    <strong>5.000$</strong><br/>
                    <div class="addtocart">
                        <button><a href="">Buy product</a></button>
                    </div>
                </div>
            </div>
            <div class="btn-storedProduct-2">
                <div class="stored-5">
                    <img src={sanphamluutru5}  alt=""/><br/>
                    <a href=""><span>box, cloth bag, clothes box</span></a><br/><br/>
                    <strong>5.000$</strong><br/>
                    <div class="addtocart">
                        <button><a href="">Buy product</a></button>
                    </div>
                </div>
                <div class="stored-6">
                    <img src={sanphamluutru6}  alt="" /><br/>
                    <a href=""><span>Document Storage Bag - Important Family Documents</span></a><br/>
                    <strong>5.000$</strong><br/>
                    <div class="addtocart">
                        <button><a href="">Buy product</a></button>
                    </div>
                </div>
                <div class="stored-7">
                    <img src={sanphamluutru7}  alt=""/><br/>
                    <a href=""><span>Household transparent foldable double door storage box</span></a><br/>
                    <strong>5.000$</strong><br/>
                    <div class="addtocart">
                        <button><a href="">Buy product</a></button>
                    </div>
                </div>
                <div class="stored-8">
                    <img src={sanphamluutru8} alt="" /><br/>
                    <a href=""><span>Plastic Shoe Storage Cabinet With Antbox Sound Touch LED Light</span></a><br/>
                    <strong>5.000$</strong><br/>
                    <div class="addtocart">
                        <button><a href="">Buy product</a></button>
                    </div>
                </div>
            </div>
        </div>
        </div>
    )
}
export default Content3;
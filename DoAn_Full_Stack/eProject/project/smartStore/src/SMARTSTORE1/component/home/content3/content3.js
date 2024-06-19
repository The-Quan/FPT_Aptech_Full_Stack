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
import { Link } from 'react-router-dom';


function Content3(){
    return(
        <div className='content-j3'>
            
        <h1> III. &nbsp;STORED PRODUCTS</h1>
        <div class="btn-Product-2">
            <div class="btn-storedProduct-1">
                <div class="stored-1">
                    <img className='img-product' src= {sanphamluutru1} alt=""/><br/>
                    <Link to='/BuyProductStored1'><span>Plastic Belt Storage Box On Wheels Throughout The Bottom Of The Bed</span></Link><br/>
                    <div class="addtocart">
                    <strong className="strong-btn">5.000$</strong>
                    <button className="BuyProduct"><Link to='/BuyProductStored1'>Details</Link></button>
                </div>
                </div>
                <div class="stored-2">
                    <img className='img-product'  src= {sanphamluutru2}  alt=""/><br/>
                    <Link to='/BuyProductStored2'><span>Medicine Box, Multi-purpose Home Medical Equipment Storage.</span></Link><br/>
                    <div class="addtocart">
                    <strong className="strong-btn">5.000$</strong>
                    <button className="BuyProduct"><Link to='/BuyProductStored2'>Details</Link></button>
                </div>
                </div>
                <div class="stored-3">
                    <img  className='img-product' src={sanphamluutru3}  alt="" /><br/>
                    <Link to='/BuyProductStored3'><span>Shoe box with transparent hard plastic lid, full black box</span></Link><br/>
                    <div class="addtocart">
                    <strong className="strong-btn">5.000$</strong>
                    <button className="BuyProduct"><Link to='/BuyProductStored3'>Details</Link></button>
                </div>
                </div>
                <div class="stored-4">
                    <img className='img-product'  src={sanphamluutru4}  alt=""/><br/>
                    <Link to='/BuyProductStored4'><span>Cosmetic or stationery storage shelf Available in two colors: pink and
                            white</span></Link><br/>
                            <div class="addtocart">
                    <strong className="strong-btn">5.000$</strong>
                    <button className="BuyProduct"><Link to='/BuyProductStored4'>Details</Link></button>
                </div>
                </div>
            </div>
            <div class="btn-storedProduct-2">
                <div class="stored-5">
                    <img className='img-product'  src={sanphamluutru5}  alt=""/><br/>
                    <Link to='/BuyProductStored5'><span>box, cloth bag, clothes box</span></Link><br/><br/>
                    <div class="addtocart">
                    <strong className="strong-btn">5.000$</strong>
                    <button className="BuyProduct"><Link to='/BuyProductStored5'>Details</Link></button>
                </div>
                </div>
                <div class="stored-6">
                    <img className='img-product'  src={sanphamluutru6}  alt="" /><br/>
                    <Link to='/BuyProductStored6'><span>Document Storage Bag - Important Family Documents</span></Link><br/>
                    <div class="addtocart">
                    <strong className="strong-btn">5.000$</strong>
                    <button className="BuyProduct"><Link to='/BuyProductStored6'>Details</Link></button>
                </div>
                </div>
                <div class="stored-7">
                    <img className='img-product'  src={sanphamluutru7}  alt=""/><br/>
                    <Link to='/BuyProductStored7'><span>Household transparent foldable double door storage box</span></Link><br/>
                    <div class="addtocart">
                    <strong className="strong-btn">5.000$</strong>
                    <button className="BuyProduct"><Link to='/BuyProductStored7'>Details</Link></button>
                </div>
                </div>
                <div class="stored-8">
                    <img className='img-product'  src={sanphamluutru8} alt="" /><br/>
                    <Link to='/BuyProductStored8'><span>Plastic Shoe Storage Cabinet With Antbox Sound Touch LED Light</span></Link><br/>
                     <div class="addtocart">
                    <strong className="strong-btn">5.000$</strong>
                    <button className="BuyProduct"><Link to='/BuyProductStored8'>Details</Link></button>
                </div>
                </div>
            </div>
        </div>
        </div>
    )
}
export default Content3;
import React from 'react';
import './content2.css';
import Header from '../../ues/header/Header';
import Menu from '../../ues/menu/menu';
import Menudacap from '../../ues/menudacap/menudacap1';
import anh1 from './img/anh1.jpg';
import anh2 from './img/anh2.jpg';
import anh3 from './img/anh3.jpg';
import anh4 from './img/anh4.jpg';
import anh5 from './img/anh5.jpg';
import anh6 from './img/anh6.jpg';
import anh7 from './img/anh7.jpg';
import anh8 from './img/amh8.jpg';
import Footer from '../../ues/footer/footer';

function ProductContent2() {
    return(
        <div className='productcontent2'>
        <Header />
        <Menu />
        <Menudacap/>
        <div className='prd-content2'>
         <h2 className='prd-h2'>Acado Furniture</h2>
        </div>
        <div className='prd-content-anh'>
        <div className='product-anh1'>
               <img className='imgproduct1' src={anh1}></img><br />
               <span>Beautiful modern wooden wardrobe with sliding doors – TQAVP09</span><br />
               <strong>7.000$</strong>
            </div>
        <div className='product-anh1'>
               <img className='imgproduct1' src={anh2}></img><br />
               <span>Beautiful modern wooden wardrobe with sliding doors – TQAVP09</span><br />
               <strong>7.000$</strong>
            </div>
            <div className='product-anh1'>
               <img className='imgproduct1' src={anh3}></img><br />
               <span>Beautiful modern wooden wardrobe with sliding doors – TQAVP09</span><br />
               <strong>7.000$</strong>
            </div>
            <div className='product-anh1'>
               <img className='imgproduct1' src={anh4}></img><br />
               <span>Beautiful modern wooden wardrobe with sliding doors – TQAVP09</span><br />
               <strong>7.000$</strong>
            </div>
            </div>
            <div className='prd-content-anh'>
        <div className='product-anh1'>
               <img className='imgproduct1' src={anh5}></img><br />
               <span>Beautiful modern wooden wardrobe with sliding doors – TQAVP09</span><br />
               <strong>7.000$</strong>
            </div>
        <div className='product-anh1'>
               <img className='imgproduct1' src={anh6}></img><br />
               <span>Beautiful modern wooden wardrobe with sliding doors – TQAVP09</span><br />
               <strong>7.000$</strong>
            </div>
            <div className='product-anh1'>
               <img className='imgproduct1' src={anh7}></img><br />
               <span>Beautiful modern wooden wardrobe with sliding doors – TQAVP09</span><br />
               <strong>7.000$</strong>
            </div>
            <div className='product-anh1'>
               <img className='imgproduct1' src={anh8}></img><br />
               <span>Beautiful modern wooden wardrobe with sliding doors – TQAVP09</span><br />
               <strong>7.000$</strong>
            </div>
            </div>
            <Footer />
        </div>
    )
}
export default ProductContent2;
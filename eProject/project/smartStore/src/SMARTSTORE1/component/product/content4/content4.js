import React from 'react';
import './content4.css';
import Header from '../../ues/header/Header';
import Menu from '../../ues/menu/menu';
import Menudacap from '../../ues/menudacap/menudacap1';
import Foorter from '../../ues/footer/footer';
import anh1 from './img/anh1.jpg';
import anh2 from './img/anh2.jpg';
import anh3 from './img/anh3.jpg';
import anh4 from './img/anh4.jpg';
import anh5 from './img/anh5.jpg';
import anh6 from './img/anh6.jpg';
import anh7 from './img/anh7.jpg';
import anh8 from './img/anh8.jpg';


function ProductContent4() {
    return(
        <div className='productcontent4'>
        <Header />
        <Menu />
        <Menudacap/>
        <div className='prd-content4'>
         <h2 className='prd-h2'>An Hung Furniture</h2>
        </div>
        <div className='prd-content-anh'>
        <div className='product-anh1'>
               <img className='imgproduct1' src={anh1}></img><br />
               <span>Tủ quần áo gỗ MDF thiết kế sang trọng hiện đại GHS-51259</span><br />
               <strong>7.000$</strong>
            </div>
        <div className='product-anh1'>
               <img className='imgproduct1' src={anh2}></img><br />
               <span>Tủ quần áo gỗ MDF thiết kế sang trọng hiện đại GHS-51259</span><br />
               <strong>7.000$</strong>
            </div>
            <div className='product-anh1'>
               <img className='imgproduct1' src={anh3}></img><br />
               <span>Tủ quần áo gỗ MDF thiết kế sang trọng hiện đại GHS-51259</span><br />
               <strong>7.000$</strong>
            </div>
            <div className='product-anh1'>
               <img className='imgproduct1' src={anh4}></img><br />
               <span>Tủ quần áo gỗ MDF thiết kế sang trọng hiện đại GHS-51259</span><br />
               <strong>7.000$</strong>
            </div>
            </div>
            <div className='prd-content-anh'>
        <div className='product-anh1'>
               <img className='imgproduct1' src={anh5}></img><br />
               <span>Tủ quần áo gỗ MDF thiết kế sang trọng hiện đại GHS-51259</span><br />
               <strong>7.000$</strong>
            </div>
        <div className='product-anh1'>
               <img className='imgproduct1' src={anh6}></img><br />
               <span>Tủ quần áo gỗ MDF thiết kế sang trọng hiện đại GHS-51259</span><br />
               <strong>7.000$</strong>
            </div>
            <div className='product-anh1'>
               <img className='imgproduct1' src={anh7}></img><br />
               <span>Tủ quần áo gỗ MDF thiết kế sang trọng hiện đại GHS-51259</span><br />
               <strong>7.000$</strong>
            </div>
            <div className='product-anh1'>
               <img className='imgproduct1' src={anh8}></img><br />
               <span>Tủ quần áo gỗ MDF thiết kế sang trọng hiện đại GHS-51259</span><br />
               <strong>7.000$</strong>
            </div>
            </div>
            <Foorter/>
        </div>
    )
}
export default ProductContent4;
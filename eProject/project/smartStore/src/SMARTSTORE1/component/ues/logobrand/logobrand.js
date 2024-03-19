import React from 'react';
import brand1 from './img/logo-gia-khanh_logo_1318321215.jpg';
import brand2 from './img/noithatanhhungvn-logo-TPHCM-700000.jpg.webp';
import brand3 from './img/tải xuống.png';
import brand4 from './img/wood-house-vector-logo-template-260nw-324964073.webp';
import './logobrand.css';
import { Link } from 'react-router-dom';

function LogoBrand (){
    return(
        <div className='logobrand'>
        <h1>IV.&nbsp;BRAND COOPERATION</h1>
        <div class="brand">
         <Link to="/content1"><img class="brand1" src={brand1} alt="" /></Link>   
          <Link to='/content2'><img class="brand2" src={brand2} alt=""/></Link>  
          <Link to='/content3'> <img class="brand3" src={brand3} alt=""/></Link> 
          <Link to='/content4'><img class="brand4" src={brand4} alt=""/></Link> 
            </div>
        </div>
    )
}
export default LogoBrand;
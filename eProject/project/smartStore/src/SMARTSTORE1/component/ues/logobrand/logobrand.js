import React from 'react';
import brand1 from './img/logo-gia-khanh_logo_1318321215.jpg';
import brand2 from './img/noithatanhhungvn-logo-TPHCM-700000.jpg.webp';
import brand3 from './img/tải xuống.png';
import brand4 from './img/wood-house-vector-logo-template-260nw-324964073.webp';
import './logobrand.css';

function LogoBrand (){
    return(
        <div className='logobrand'>
        <h1>IV.&nbsp;BRAND COOPERATION</h1>
        <div class="brand">
            <img class="brand1" src={brand1} alt="" />
            <img class="brand2" src={brand2} alt=""/>
            <img class="brand3" src={brand3} alt=""/>
            <img class="brand4" src={brand4} alt=""/>
            </div>
        </div>
    )
}
export default LogoBrand;
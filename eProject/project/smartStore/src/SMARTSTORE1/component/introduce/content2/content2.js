import React from 'react';
import './content2.css';
import anh4 from './img/gioitheiusp4.png';
import anh5 from './img/gioitheiusp5.png';
import anh6 from './img/gioithieusp6.png';

function Content2() {
    return (
        <div class="content2">
           <a href='https://acado.vn/'><h2 className='ndh2'>2, Acado Furniture - specializing in high-end wardrobes in Hanoi</h2></a>
            <p>If you are looking for a high-end address to sell wardrobes in Hanoi, stop by Acado. This brand is more
                about field
                residential interior design and construction,
                Villa in Vietnam. With nearly 10 years of experience in the furniture field, Acado confidently
                introduces it
                the market for the most beautiful and modern wardrobe models.
                Acado always updates the newest, most beautiful wardrobe models, at the best prices for the family.
                Sutra philosophy
                Acado's business is “quality” and “right
                appointment". Bringing the most beautiful and modern wardrobe models on the market today.
            </p><br/>
            <span>+ Acado wardrobe products provide:</span>
            <li>Modern industrial wooden bed models with youthful designs</li>
            <li>Laminate industrial wood cabinet with wood grain color combined with modern, luxurious white</li>
            <li>Natural wood wardrobe: Russian oak, peach wood,... diverse designs and styles</li>
            <li>Open door wardrobe, modern sliding door wardrobe</li>
            <li>For wardrobe price, contact Acado furniture</li>
            <div class="btn1">
                <img className='gtsp1' src={anh4} alt="" />
                <img class="gtsp2" src={anh5} alt="" />
                <img class="gtsp2" src={anh6} alt="" />
            </div>
        </div>
    )
}
export default Content2;
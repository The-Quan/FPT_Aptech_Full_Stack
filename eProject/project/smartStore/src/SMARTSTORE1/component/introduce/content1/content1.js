import React from 'react';
import './content1.css';
import anh1 from './img/gt1.webp';
import anh2 from './img/gt2.jpg';
import anh3 from './img/gioithieusp3.png';


function Content1() {
    return (
        <div class="content1">
        <a href='https://noithatgiakhanh.com/?gad_source=1&gclid=CjwKCAiA0PuuBhBsEiwAS7fsNYWgxhyqO2NmMUmbj_5CagLbIyl28Cx0imJA_AuuOGjSzC9XTbX1TxoCCQYQAvD_BwE' ><h2 className='ndh2'>1, Gia Khanh Furniture - a reputable place to sell imported wardrobes in Hanoi</h2></a>
            <p>Gia Khanh has more than 24 years of experience (Since 2000), from a small furniture factory serving
                customers
                the most difficult goods. Up to now, Gia furniture
                Khanh has become stronger with a series of famous actors and models using the brand's furniture
                This.
                Gia Khanh constantly develops product lines with the increasing aesthetic needs of society. Products
                Gia Khanh's wardrobe products with leather
                style, design,... in accordance with the motto that quality is number one. Gia Khanh is committed to
                providing wooden furniture
                Beautiful, unique style and reasonable price
                most reasonable.
            </p><br />
            <span>+ Gia Khanh wardrobe products provide:</span>
            <li>Wardrobe with 2 sliding doors + 2 open doors in flowery Sampanh yellow color TU8805A</li>
            <li>Wardrobe with 2 sliding doors + 2 open doors Neoclassical pearl white TU8805H-4</li>
            <li>Noble Neoclassical curved 4-door wardrobe in pearl white TU8802H-4</li>
            <li>Classic Style 5-Door Wardrobe TU509-5</li>
            <li>The price of the wardrobe ranges from 29 million - 30 million</li><br/>
            <p>-... All are high-end imported wardrobe lines that meet the needs of demanding interior design customers
                best.
                Gia Khanh Furniture is an address that sells high-end imported wardrobes for interior "connoisseurs".
            </p>
            <div class="btn1">
                <img className='gtsp1' src={anh1} alt="" width="400px" height="400px" />
                <img class="gtsp2" src={anh2} alt="" />
                <img class="gtsp2" src={anh3} alt="" />
            </div>
        </div>
    )
}
export default Content1;
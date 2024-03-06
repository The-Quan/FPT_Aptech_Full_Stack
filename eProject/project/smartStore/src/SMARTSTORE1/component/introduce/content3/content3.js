import React from 'react';
import './content3.css';
import anh1 from './img/gioithieusp6.png';
import anh2 from './img/gioithieusp7.png';
import anh3 from './img/gioithieusp8.png';

function Content3(){
    return(

        <div class="content3">
           <a href='https://gotrangtri.vn/'> <h2 className='ndh2'>3, Decorative Wood - address for selling modern wardrobes in Hanoii</h2></a>
            <p>Decorative wood is mainly used to construct office interiors and apartment interiors in Hanoi.
                Especially, with the cabinet array
                Clothing is also invested and respected. Love
                Decorative Wood brand is not only famous in Hanoi, but also known to many people in Ho Chi Minh City.
                Decorative wood wardrobes always come in a variety of colors
                colors for you to choose from.
            </p><br/>
            <span>+ Decorative Wooden wardrobe products provide:</span>
            <li>Moisture-proof green core mdf wood wardrobe: waterproof and scratch-resistant. Damping hinges limit
                noise,
                sturdy, sure. Always diverse styles</li>
            <li>From classic to modern, the wood grain is shiny and suitable for any living space.</li>
            <li>Solid, sturdy natural wood wardrobe in laminated, mahogany brown, light yellow,... luxurious colors.</li>
            <li>The wardrobe design is multi-functional, has a youthful style, is modern, anti-warping, does not shrink.
                close,…</li>
            <li>The durability of wooden wardrobes is up to 15 years with standard wood lines</li>
            <li>The size of the wardrobe is just right, not too large or too small. Sliding door wardrobe for small bedrooms. Closet
                Open doors for medium and large bedrooms.</li>
            <li>Depending on your budget and needs, choose a beautiful wardrobe model at Decorative Wood.</li>
            <div class="btn1">
            <img className='gtsp1' src={anh1} alt="" />
            <img class="gtsp2" src={anh2} alt="" />
            <img class="gtsp2" src={anh3} alt="" />
        </div>
        </div>
        
    )
}
export default Content3;
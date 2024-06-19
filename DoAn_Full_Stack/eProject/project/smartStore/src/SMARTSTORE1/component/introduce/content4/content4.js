import React from 'react';
import './content4.css';
import anh1 from './img/tuquanao7.jpg';
import anh2 from './img/gioithieusp10.jpg';
import anh3 from './img/sanPhambanchay.jpg';

function Content4() {
    return (
        <div class="content4">
            <a href='https://noithatanhung.vn/'><h2 className='ndh2'>4, An Hung Furniture - specializes in Hanoi walnut wardrobes</h2></a>
            <p>If you are looking for a place to sell walnut wardrobes in Hanoi, stop by An Hung. This is the brand
                specializes in high-end walnut furniture.
                Besides, there are some types of modern industrial pressed wood cabinets for sale. If you are looking for a cabinet
                Walnut wood is definitely a suggestion for An Hung.
                The wardrobe at An Hung furniture has a modern, youthful design and is more versatile than before. Come here you can
                Buy a sliding wardrobe with a small design
                Compact and doesn't take up space. The inside of the cabinet has a smart design with many compartments, helping to keep things neat. Arrive at An
                Hung you will own a wardrobe
                durable and beautiful as you like.
            </p><br />
            <span>+ An Hung interior wardrobe products provide:</span>
            <li>Walnut wood wardrobe with many doors and smart compartments</li>
            <li>Wardrobe for dressing room in luxury walnut wood</li>
            <li>Unique doorless wardrobe</li>
            <li>Modern walnut veneer wardrobe</li>
            <li>Wardrobe combined with TV shelf</li>
            <li>Sliding wardrobe, open door</li>
            <div class="btn1">
                <img className='gtsp1' src={anh1} alt="" />
                <img class="gtsp2" src={anh2} alt="" />
                <img class="gtsp2" src={anh3} alt="" />
            </div>
        </div>
    )
}
export default Content4;
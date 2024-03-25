import React, { useRef } from 'react';
import anhContent1 from './img/anhsp2.jpg';
import anhContent2 from './img/ánhp3.jpg';
import anhContent3 from './img/ánhp4.avif';
import anhContent4 from './img/anhsp5.jpg';
import anhContent5 from './img/ánhp6.jpg';
import sortright from './img/sort-right.png';
import sortleft from './img/sort-left.png';
import './banners.css';
import Slider from "react-slick";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";

function Banners() {
    const slider = useRef(null);
    var settings = {
        dots: true,
        infinite: true,
        speed: 500,
        slidesToShow: 1,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 3000,
    };
    return (
        <div className='banners'>
            <div className='slider'>
                <Slider className='btn-slider' {...settings}>
                    <div>
                        <img className='img-slider' src={anhContent1} />
                    </div>
                    <div>
                        <img className='img-slider' src={anhContent2} />
                    </div>
                    <div>
                        <img className='img-slider' src={anhContent3} />
                    </div>
                    <div>
                        <img className='img-slider' src={anhContent4} />
                    </div>
                    <div>
                        <img className='img-slider' src={anhContent5} />
                    </div>
                </Slider>

            </div>


            <div class="content">
                <div class="btn-2">
                    <h2>QUALITY</h2>
                    <em>Product quality assurance</em>
                </div>
                <div class="btn-3">
                    <h2>FREE SHIPPING</h2>
                    <em>Free shipping for orders of 2 products</em>
                </div>
                <div class="btn-4">
                    <h2>ORDER SUPPORT</h2>
                    <em>24/7 customer support staff.</em>
                </div>
            </div>
        </div>
    );
}

export default Banners;
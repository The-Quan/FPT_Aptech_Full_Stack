import React from 'react'
import './footer.css';
import youtobe from "./img/icons8-youtube-50.png";
import instagram from './img/icons8-instagram-50.png';
import facebook from './img/icons8-facebook-50.png'
import tiktok from './img/icons8-tiktok-50.png';
import zalo from './img/icons8-zalo-50.png';
import logo from './img/logo.png';
import gps from './img/icons8-gps-50.png';
import phone from './img/icons8-phone-64.png'
import email from './img/icons8-email-50.png';
import time from './img/icons8-time-64.png';



function Footer() {
    return (
        <div className='footer'>
            <div class="footer-2">
                <div className='footer-3'>
                    <a href=""> <img class="link1" src={youtobe} alt="" /></a>
                    <a href=""><img class="link2" src={instagram} alt="" /></a>
                    <a href=""> <img class="link3" src={facebook} alt="" /></a>
                    <a href=""> <img class="link4" src={tiktok} alt="" /></a>
                    <a href=""><img class="link5" src={zalo} alt="" /></a>
                </div>
            </div>
            <div class="btn-contact-1">
                <div class="contact-1">
                    <div className='logofooter'><a href="" class="logo-footer"><img className='btn-logo' src={logo} alt="" /></a></div>
                    <ul>
                        <li>
                            <div class="address">
                                <img class="iconcontact" src={gps} alt="" />
                                <strong>&nbsp; Address :</strong>
                                <span className='span'> So 8A Ton That Thuyet, My Dinh, Nam Tu Liem, HN</span>

                            </div>
                        </li>
                        <li>
                            <div class="phone1">
                                <img class="iconcontact" src={phone} lt="" />
                                <strong>&nbsp; Phone :</strong>
                                <span className='span'> 09678549283</span>

                            </div>
                        </li>
                        <li>
                            <div class="email1">
                                <img class="iconcontact" src={email} alt="" />
                                <strong>&nbsp; Email :</strong>
                                <span className='span'> abchghhu@gamil.com</span>
                            </div>
                        </li>
                        <li>
                            <div class="time">
                                <img class="iconcontact" src={time} alt="" />
                                <span className='span'>&nbsp;Showroom is open every day of the week from 10 am to 6 pm</span>

                            </div>
                        </li>
                    </ul>
                </div>
                <div class="btn-contact">
                    <div class="contact-2">
                        <h3>MENU</h3>
                        <li><a href="home.html">Home</a></li>
                        <li><a href="">Products</a></li>
                        <li><a href="Introduction.html">Introduction</a></li>
                        <li><a href="">Contact</a></li>
                    </div>
                    <div class="contact3">
                        <h3>CATEGORY</h3>
                        <li><a href="">Wardrobe</a></li>
                        <li><a href="">Storage products</a></li>
                    </div>
                    <div class="contact4">
                        <h3>SERVICE</h3>
                        <li><a href="">Customer reviews</a></li>
                        <li><a href="">direction</a></li>
                        <li><a href="">Policy</a></li>
                    </div>
                </div>
            </div>
            <footer>Copyright © 2024 | SMARTTORE</footer>
        </div>

    )
}
export default Footer;
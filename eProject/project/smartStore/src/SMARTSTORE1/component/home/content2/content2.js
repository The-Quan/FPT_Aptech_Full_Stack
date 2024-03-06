import React from "react";
import './content2.css'
import tuquanao1 from "./img/tuQuanAo.png";
import tuquanao2 from "./img/tuquanao2.jpg";
import tuquanao3 from "./img/tuquanao3.jpg";
import tuquanao4 from "./img/tuquanao4.jpg";
import tuquanao5 from "./img/tuquanao5.jpg";
import tuquanao6 from "./img/tuQuanAo6.png";
import tuquanao7 from "./img/tuquanao7.jpg";
import tuquanao8 from "./img/tuquanao8.jpg";
import { Link } from "react-router-dom";



const Content2 = () => {
    
    return(
        <div className="content3">
             <h1>II.&nbsp;FAVORITE PRODUCT</h1>
            <div class="btn-sellingProduct">
            <div class="selling-1">
                <img className="img-product" src=  {tuquanao1} alt="" /><br/>
                <Link to='/BuyProduct1' onClick={onClick2}><span>Beautiful modern wooden wardrobe with sliding doors – TQAVP09</span></Link><br/>
                <strong>5.000$</strong><br/>
                <div class="addtocart">
                    <button><Link to='/BuyProduct1'>Buy product</Link></button>
                </div>
            </div>
            <div class="selling-2">
                <img className="img-product" src={tuquanao2}  alt="" /><br/>
                <a href=""><span>High-end Built-in Glass Door Wardrobe – TQAVP37</span></a><br/>
                <strong>5.000$</strong><br/>
                <div class="addtocart">
                    <button><a href="">Buy product</a></button>
                </div>
            </div>
            <div class="selling-3">
                <img className="img-product" src={tuquanao3}  /><br/>
                <a href=""><span>2-Door Wardrobe with Sliding Dressing Table – TQAVP27</span></a><br/>
                <strong>5.000$</strong><br/>
                <div class="addtocart">
                    <button><a href="">Buy product</a></button>
                </div>
            </div>
            <div class="selling-4">
                <img className="img-product" src={tuquanao4} alt="" /><br/>
                <a href=""><span>2-Door 4-Door MDF Wardrobe – TQAVP10</span></a><br/>
                <strong>5.000$</strong><br/>
                <div class="addtocart">
                    <button><a href="">Buy product</a></button>
                </div>
            </div>
         </div>

         <div class="btn-sellingProduct-2">
            <div class="selling-5">
                <img className="img-product" src={tuquanao5}  alt="" /><br/>
                <a href=""><span>10-Door Glass Wardrobe – TQAVP36</span></a><br/>
                <strong>5.000$</strong><br/>
                <div class="addtocart">
                    <button><a href="">Buy product</a></button>
                </div>
            </div>
            <div class="selling-6">
                <img className="img-product" src={tuquanao6}  alt="" /><br/>
                <a href=""><span>Square Glass Door Wardrobe – TQAVP45</span></a><br/>
                <strong>5.000$</strong><br/>
                <div class="addtocart">
                    <button><a href="">Buy product</a></button>
                    
                </div>
            </div>
            <div class="selling-7">
                <img className="img-product" src={tuquanao7}  /><br/>
                <a href=""><span>6-Compartment Wardrobe with Dressing Table – TQAVP18</span></a><br/>
                <strong>5.000$</strong><br/>
                <div class="addtocart">
                    <button><a href="">Buy product</a></button>
                </div>
            </div>
            <div class="selling-8">
                <img className="img-product" src={tuquanao8}  alt="" /><br/>
                <a href=""><span>6-Compartment Wardrobe with Dressing Table – TQAVP18</span></a><br/>
                <strong>5.000$</strong><br/>
                <div class="addtocart">
                    <button><a href="">Buy product</a></button>
                </div>
            </div>

        </div>
    </div>
    )
} 

export default Content2;
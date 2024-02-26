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



const Content2 = () => {
    return(
        <div className="content3">
             <h1>II.&nbsp;FAVORITE PRODUCT</h1>
            <div class="btn-sellingProduct">
            <div class="selling-1">
                <img src=  {tuquanao1} alt="" /><br/>
                <a href=""><span>Beautiful modern wooden wardrobe with sliding doors – TQAVP09</span></a><br/>
                <strong>5.000$</strong><br/>
                <div class="addtocart">
                    <button><a href="">Buy product</a></button>
                </div>
            </div>
            <div class="selling-2">
                <img src={tuquanao2}  alt="" /><br/>
                <a href=""><span>High-end Built-in Glass Door Wardrobe – TQAVP37</span></a><br/>
                <strong>5.000$</strong><br/>
                <div class="addtocart">
                    <button><a href="">Buy product</a></button>
                </div>
            </div>
            <div class="selling-3">
                <img src={tuquanao3}  /><br/>
                <a href=""><span>2-Door Wardrobe with Sliding Dressing Table – TQAVP27</span></a><br/>
                <strong>5.000$</strong><br/>
                <div class="addtocart">
                    <button><a href="">Buy product</a></button>
                </div>
            </div>
            <div class="selling-4">
                <img src={tuquanao4} alt="" /><br/>
                <a href=""><span>2-Door 4-Door MDF Wardrobe – TQAVP10</span></a><br/><br/>
                <strong>5.000$</strong><br/>
                <div class="addtocart">
                    <button><a href="">Buy product</a></button>
                </div>
            </div>
         </div>

         <div class="btn-sellingProduct-2">
            <div class="selling-5">
                <img src={tuquanao5}  alt="" /><br/>
                <a href=""><span>10-Door Glass Wardrobe – TQAVP36</span></a><br/><br/>
                <strong>5.000$</strong><br/>
                <div class="addtocart">
                    <button><a href="">Buy product</a></button>
                </div>
            </div>
            <div class="selling-6">
                <img src={tuquanao6}  alt="" /><br/>
                <a href=""><span>Square Glass Door Wardrobe – TQAVP45</span></a><br/><br/>
                <strong>5.000$</strong><br/>
                <div class="addtocart">
                    <button><a href="">Buy product</a></button>
                    
                </div>
            </div>
            <div class="selling-7">
                <img src={tuquanao7}  /><br/>
                <a href=""><span>6-Compartment Wardrobe with Dressing Table – TQAVP18</span></a><br/>
                <strong>5.000$</strong><br/>
                <div class="addtocart">
                    <button><a href="">Buy product</a></button>
                </div>
            </div>
            <div class="selling-8">
                <img src={tuquanao8}  alt="" /><br/>
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
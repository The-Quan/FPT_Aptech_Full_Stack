import React, { useEffect, useState } from "react";
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
    return (
        <div className="content2" >
            <h1>II.&nbsp;FAVORITE PRODUCT</h1>
            <div class="btn-sellingProduct">
                <div class="selling-1">
                    <img className="img-product" src={tuquanao1} alt="" /><br />
                    <Link to='/BuyProduct1' >Beautiful modern wooden wardrobe with sliding doors – TQAVP09</Link><br />
                    <div class="addtocart">
                        <strong className="strong-btn">5.000$</strong>
                        <button className="BuyProduct"><Link to='/BuyProduct1#btn-neo'>Buy product</Link></button>
                    </div>
                </div>
                <div class="selling-2">
                    <img className="img-product" src={tuquanao2} alt="" /><br />
                    <Link to="/BuyProduct2"><span>High-end Built-in Glass Door Wardrobe – TQAVP37</span></Link><br />
                    <div class="addtocart">
                        <strong className="strong-btn">5.000$</strong>
                        <button className="BuyProduct"><Link to='/BuyProduct2'>Buy product</Link></button>
                    </div>
                </div>
                <div class="selling-3">
                    <img className="img-product" src={tuquanao3} alt="" /><br />
                    <Link to='/BuyProduct3'><span>2-Door Wardrobe with Sliding Dressing Table – TQAVP27</span></Link><br />
                    <div class="addtocart">
                        <strong className="strong-btn">5.000$</strong>
                        <button className="BuyProduct"><Link to='/BuyProduct3'>Buy product</Link></button>
                    </div>
                </div>
                <div class="selling-4">
                    <img className="img-product" src={tuquanao4} alt="" /><br />
                    <Link to='/BuyProduct4'><span>2-Door 4-Door MDF Wardrobe – TQAVP10</span></Link><br />
                    <div class="addtocart">
                        <strong className="strong-btn">5.000$</strong>
                        <button className="BuyProduct"><Link to='/BuyProduct4'>Buy product</Link></button>
                    </div>
                </div>
            </div>

            <div class="btn-sellingProduct-2">
                <div class="selling-5">
                    <img className="img-product" src={tuquanao5} alt="" /><br />
                    <Link to='/BuyProduct5'><span>10-Door Glass Wardrobe – TQAVP36</span></Link><br />
                    <div class="addtocart">
                        <strong className="strong-btn">5.000$</strong>
                        <button className="BuyProduct"><Link to='/BuyProduct5'>Buy product</Link></button>
                    </div>
                </div>
                <div class="selling-6">
                    <img className="img-product" src={tuquanao6} alt="" /><br />
                    <Link to='/BuyProduct6'><span>Square Glass Door Wardrobe – TQAVP45</span></Link><br />
                    <div class="addtocart">
                        <strong className="strong-btn">5.000$</strong>
                        <button className="BuyProduct"><Link to='/BuyProduct6'>Buy product</Link></button>
                    </div>
                </div>
                <div class="selling-7">
                    <img className="img-product" src={tuquanao7} /><br />
                    <Link to='/BuyProduct7'><span>6-Compartment Wardrobe with Dressing Table – TQAVP18</span></Link><br />
                    <div class="addtocart">
                        <strong className="strong-btn">5.000$</strong>
                        <button className="BuyProduct"><Link to='/BuyProduct7'>Buy product</Link></button>
                    </div>
                </div>
                <div class="selling-8">
                    <img className="img-product" src={tuquanao8} alt="" /><br />
                    <Link to='/BuyProduct8'><span>6-Compartment Wardrobe with Dressing Table – TQAVP18</span></Link><br />

                    <div class="addtocart">
                        <strong className="strong-btn">5.000$</strong>
                        <button className="BuyProduct"><Link to='/BuyProduct8'>Buy product</Link></button>
                    </div>
                </div>

            </div>
        </div>
    )
}

export default Content2;
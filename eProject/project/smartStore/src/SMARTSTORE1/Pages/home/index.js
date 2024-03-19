import React, {useState}from "react";
import Header from "../../component/ues/header/Header";
import './index.css';
import Menu from "../../component/ues/menu/menu";
import Banners from "../../component/home/banners/banners";
import Content1 from "../../component/home/content1/content1";
import Content2 from "../../component/home/content2/content2";
import Content3 from "../../component/home/content3/content3";
import LogoBrand from "../../component/ues/logobrand/logobrand";
import Footer from "../../component/ues/footer/footer";


function Home(){
    const [isShowCart, setShowCart] = useState(false);
    const [Cart, setCart] = useState([]);

    return(
        <div className="container1">
            <Header quantity={Cart.length} setShowCart={setShowCart} />
            
            <Menu />

            <Banners/>

            <Content1 />

            <Content2 />

            <Content3 />

            <LogoBrand />

            <Footer />
        </div> 
    );
}
export default Home;
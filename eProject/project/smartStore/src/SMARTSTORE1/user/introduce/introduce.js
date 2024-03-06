import React from "react";
import Header from "../../component/ues/header/Header";
import Menu from "../../component/ues/menu/menu";
import './introduce.css';
import Footer from "../../component/ues/footer/footer";
import Content1 from "../../component/introduce/content1/content1";
import Content2 from "../../component/introduce/content2/content2";
import Content3 from "../../component/introduce/content3/content3";
import Content4 from "../../component/introduce/content4/content4";

function Introduce(){
    return(
        <div className="container2">
            <Header />
            
            <Menu />
             
            <Content1 />

            <Content2 />

            <Content3 />

            <Content4 />
            
            <Footer />
        </div> 
    );
}
export default Introduce;
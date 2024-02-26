import React from "react";
import Header from "../../component/home/header/Header";
import Menu from "../../component/home/menu/menu";
import Banners from "../../component/home/banners/banners";


function Introduce(){
    return(
        <div className="container1">
            <Header />
            
            <Menu />

            <Banners/>

           
        </div> 
    );
}
export default Introduce;
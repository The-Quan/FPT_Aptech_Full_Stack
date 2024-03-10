import React from 'react';
import './product.js';
import Header from '../../component/ues/header/Header';
import Menu from '../../component/ues/menu/menu';
import Menudacap from '../../component/ues/menudacap/menudacap1.js';
import Footer from '../../component/ues/footer/footer.js';
import Productcontent from '../../component/product/content/content.js';


function Products(){
    return(
        <div className='products'>
                 
        <Header />

        <Menu />

        <Menudacap />

        <Productcontent />
         
         <Footer />
        </div>
    )
}
export default Products;
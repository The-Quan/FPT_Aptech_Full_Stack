import React from 'react';
import './contact.css';
import Header from '../../component/ues/header/Header.js';
import Menu from '../../component/ues/menu/menu.js';
import Contact1 from '../../component/contact/content1/conent1.js';
import Footer from '../../component/ues/footer/footer.js';

function Contact(){
    return(
        <div className='contact'>
                 
        <Header />

        <Menu />

        <Contact1 />
        
        <Footer />
        </div>
    )
}
export default Contact;
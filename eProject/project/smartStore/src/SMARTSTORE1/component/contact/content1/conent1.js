import React from 'react';
import gps from './img/icons8-gps-50.png';
import phone from './img/icons8-phone-64.png';
import email from './img/icons8-email-50.png';
import './content1.css';


    

function Contact1() {
    const thongbao = () =>{
        alert ('Thanh cong')
    }
    return (
    <div className='contact-0'>
    <div className='contact1'>
           <div className='btn-contact1'>
           <div className='tact1'>
                <div class="btn-address">
                    <img class="iconcontact" src={gps} alt="" />
                    <strong>&nbsp; Address :</strong><br/>
                    <span> 8a Ton That Thuyet, My Dinh, Nam Tu Liem, HN</span>

                </div>
                <div class="btn-phone">
                    <img class="iconcontact" src={phone} lt="" />
                    <strong>&nbsp; Phone :</strong><br/>
                    <span> 09678549283</span>

                </div>

                <div class="btn-email">
                    <img class="iconcontact" src={email} alt="" />
                    <strong>&nbsp; Email :</strong><br/>
                    <span> abchghhu@gamil.com</span>
                </div>

            </div>
            <div className='tact2'>
            <h2 className='text'>Send us your questions</h2><br/>
            <p className='text2'>If you have any questions, you can send us a request and we will contact you as soon as possible.</p>
            <div className='name'>
            <h4 className='h4'>Your name</h4>
            <input className='inputname' type='text' placeholder='Enter your name'/>
            </div>
            <div className='emailphone'>
            <div className='email'>
            <h4 className='h4'>Your email</h4>
            <input className='inputemail' type='text' placeholder='Enter your email'/>
            </div>
            <div className='phone'>
            <h4 className='h4'>Your phone number</h4>
            <input className='inputphone' type='text' placeholder='Enter your phone number'/>
            </div>
            </div>
            <h4 className='h4'>Content</h4>
            <textarea className='noidung' placeholder='Import content'></textarea>
            <button className='button' type="submit" form="nameform" value="Submit" onClick={thongbao}>Submit</button>
        </div>
           </div>

           <div className='btn-content2'>
            <div className='bando'>
                <iframe className='bando2' src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.0951824329845!2d105.77917147596976!3d21.028877187773134!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x313454b32c1aaaab%3A0x6d93ad048c2bb0e!2zU-G7kSA4QSBUw7RuIFRo4bqldCBUaHV54bq_dCwgTeG7uSDEkMOsbmgsIE5hbSBU4burIExpw6ptLCBIw6AgTuG7mWkgMTAwMDAsIFZp4buHdCBOYW0!5e0!3m2!1svi!2s!4v1709102064534!5m2!1svi!2s" ></iframe>
            </div>
           </div>
    </div>
    </div>
    )
}
export default Contact1;
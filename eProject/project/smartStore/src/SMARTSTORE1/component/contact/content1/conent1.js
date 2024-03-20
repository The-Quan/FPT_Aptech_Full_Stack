import React, { useState } from 'react';
import gps from './img/icons8-gps-50.png';
import phone from './img/icons8-phone-64.png';
import email from './img/icons8-email-50.png';
import './content1.css';
import Validation from './validatetion';

function Contact1() {
    const [value, setValue] = useState({
        name: '',
        email: '',
        phone: '',
    });

    const [errors, setErrors] = useState({});

    const handInput = (event) => {
        const { name, value } = event.target;
        setValue((prevState) => ({
            ...prevState,
            [name]: value,
        }));
    };

    const handleValidation = (event) => {
        event.preventDefault();
        setErrors(Validation(value));
    };

    

    return (
        <div className='contact-0'>
            <div className='contact1'>
                <div className='btn-contact1'>
                    <div className='tact1'>
                        <div className="btn-address">
                            <img className="iconcontact" src={gps} alt="" />
                            <strong>&nbsp; Address :</strong><br />
                            <span> 8a Ton That Thuyet, My Dinh, Nam Tu Liem, HN</span>
                        </div>
                        <div className="btn-phone">
                            <img className="iconcontact" src={phone} alt="" />
                            <strong>&nbsp; Phone :</strong><br />
                            <span> 09678549283</span>
                        </div>
                        <div className="btn-email">
                            <img className="iconcontact" src={email} alt="" />
                            <strong>&nbsp; Email :</strong><br />
                            <span> abchghhu@gamil.com</span>
                        </div>
                    </div>
                    <div className='tact2'>
                        <h2 className='text'>Send us your questions</h2><br />
                        <p className='text2'>If you have any questions, you can send us a request and we will contact you as soon as possible.</p>
                        <form onSubmit={handleValidation}>
                            <div className='name'>
                                <label htmlFor='name'><h4 className='h4'>Your name</h4></label>
                                <input className='inputname' type='text' name='name' placeholder='Enter your name' onChange={handInput} />
                                {errors.name && <p style={{ color: "red" }}>{errors.name}</p>}
                            </div>
                            <div className='emailphone'>
                                <div className='email'>
                                    <label htmlFor='email'><h4 className='h4'>Your email</h4></label>
                                    <input className='inputemail' type='email' name='email' placeholder='Enter your email' onChange={handInput} />
                                    {errors.email && <p style={{ color: "red" }}>{errors.email}</p>}
                                </div>
                                <div className='phone'>
                                    <label htmlFor='phone'><h4 className='h4'>Your phone number</h4></label>
                                    <input className='inputphone' type='text' name='phone' placeholder='Enter your phone number' onChange={handInput} />
                                    {errors.phone && <p style={{ color: "red" }}>{errors.phone}</p>}
                                </div>
                            </div>
                            <h4 className='h4'>Content</h4>
                            <textarea className='noidung' placeholder='Import content'></textarea>
                            <button className='button' type="submit">Submit</button>
                        </form>
                    </div>
                </div>
                <div className='btn-content2'>
                    <div className='bando'>
                        <iframe className='bando2' src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.0951824329845!2d105.77917147596976!3d21.028877187773134!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x313454b32c1aaaab%3A0x6d93ad048c2bb0e!2zU-G7kSA4QSBUw7RuIFRo4bqldCBUaHV54bq_dCwgTeG7uSDEkMOsbmgsIE5hbSBU4burIExpw6ptLCBIw6AgTuG7mWkgMTAwMDAsIFZp4buHdCBOYW0!5e0!3m2!1svi!2s!4v1709102064534!5m2!1svi!2s" title="Google Maps"></iframe>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Contact1;

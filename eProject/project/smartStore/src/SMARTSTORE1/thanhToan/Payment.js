import React, { useState } from "react";
import './Payment.css';
import Footer from '../component/ues/footer/footer';
import Header from "../component/ues/header/Header";
import Menu from "../component/ues/menu/menu";
import { Link } from "react-router-dom";
import Validation from "../component/contact/content1/validatetion";

function Payment() {

    const [value, setValue] = useState({
        name: '',
        email: '',
        phone: '',
        address: '',
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
        <div className="body-pay">
            <Header />
            <Menu />
            <div className="payment">
                <div className="payment-title"><h1 className="payment-title2">Payment Check</h1></div>
                <div className="btn-pay">
                    <div className="btn-pay1">
                        <p className="title-details">Order Details</p>
                        <div className="order-details">
                            <table className="table">
                                <tr className="tr">
                                    <td className="td">STT</td>
                                    <td className="td" >Product's_name</td>
                                    <td className="td">Quantity</td>
                                    <td className="td">Price</td>
                                    <td className="td">Total</td>
                                </tr>
                                <tr>
                                    <td className="td">1</td>
                                    <td className="td">Beautiful modern wooden wardrobe with sliding doors – TQAVP09</td>
                                    <td className="td">1</td>
                                    <td className="td">5.000$</td>
                                    <td className="td">5.000$</td>
                                </tr>
                                <tr>
                                    <td className="td">2</td>
                                    <td className="td">High-end Built-in Glass Door Wardrobe – TQAVP37</td>
                                    <td className="td">1</td>
                                    <td className="td">5.000$</td>
                                    <td className="td">5.000$</td>
                                </tr>
                                <tr>
                                    <td className="td">3</td>
                                    <td className="td">6-Compartment Wardrobe with Dressing Table – TQAVP18</td>
                                    <td className="td">1</td>
                                    <td className="td">5.000$</td>
                                    <td className="td">5.000$</td>
                                </tr>
                                <tr>
                                    <td className="td">4</td>
                                    <td className="td">Square Glass Door Wardrobe – TQAVP45</td>
                                    <td className="td">1</td>
                                    <td className="td">5.000$</td>
                                    <td className="td">5.000$</td>
                                </tr>
                                <tr>
                                    <td className="td">5</td>
                                    <td className="td">10-Door Glass Wardrobe – TQAVP36</td>
                                    <td className="td">1</td>
                                    <td className="td">5.000$</td>
                                    <td className="td">5.000$</td>
                                </tr>
                            </table>
                            <div className="thanhtien">Payment Amount: <strong> 25.000$</strong></div>
                        </div>
                        <div className="info-customer">
                            <div className="customer"><p className="customer-title">Customer Information </p></div>
                            <form onSubmit={handleValidation}>
                            <div className="first-last">
                                <div className="first-name">
                                    <label for="name"> <p>First And Last Name *</p></label>
                                    <input className="input-name" type='text' name="name" onChange={handInput} />
                                    {errors.name && <p style={{ color: "red" }}>{errors.name}</p>}
                                </div>
                                <div className="last-name">
                                    <label for='phone'><p>Phone Number *</p></label>
                                    <input className="input-name" type='text' name="phone"  onChange={handInput}/>
                                    {errors.phone && <p style={{ color: "red" }}>{errors.phone}</p>}
                                </div>
                            </div>
                            <div className="std">
                                <label for='email'><p>Email *</p></label>
                                <input className="phone-number" type='email' name="email"  onChange={handInput}/>
                                {errors.email && <p style={{ color: "red" }}>{errors.email}</p>}
                            </div>
                            <div className="address-btn">
                                <label for='address'><p>Address *</p></label>
                                <input className="phone-number" type='text' name="address"  onChange={handInput} />
                                {errors.address && <p style={{ color: "red" }}>{errors.address}</p>}
                            </div>
                            <div className="nametc"><input className="tochuc" type='checkbox' />&nbsp;&nbsp;<p>Organization</p></div>
                            <p>Organization Name *</p>
                            <input className="phone-number" type='email' />

                            <div className="note"><p className="customer-title">Additional Information </p></div>
                            <p>Order Notes *</p>
                            <textarea className="btn-note" placeholder="Notes about your order, e.g. special notes for delivery." />
                            <button type='submit'></button>
                            </form>
                       </div>
                    </div>
                    <div className="btn-pay2">
                        <p className="title-details">Your order</p>
                        <div className="thanhtoansp">
                            <div className="total-1">Total : <strong>&nbsp;&nbsp;25.000$</strong></div>
                        </div>
                        <div className="dieukhoan">
                            <form>
                                <input className="radio" type="radio" id="option1" name="options" value="option1" />
                                <label for="option1">&nbsp;&nbsp;<strong>Direct Bank Transfer</strong></label><br />
                                <p className="text-btn">Make your payment directly into our bank account.
                                    Please use your Order ID as the payment reference. Your order won’t be shipped until the funds have cleared in our account.</p>
                                <input className="radio" type="radio" id="option2" name="options" value="option2" />
                                <label className="radio" for="option2">&nbsp;&nbsp;<strong>Check Payments</strong></label><br />
                                <input className="radio" type="radio" id="option3" name="options" value="option3" />
                                <label className="radio" for="option3">&nbsp;&nbsp;<strong>Cash on Delivery</strong></label><br />
                                <input className="radio" type="radio" id="option3" name="options" value="option3" />
                                <label className="radio" for="option3">&nbsp;&nbsp;<strong>PayPal</strong></label><br />
                            </form>
                            <div className="nametc-1"><input className="tochuc" type='checkbox' />&nbsp;&nbsp;<p className="dieuk-1">I’ve read and accept the terms & conditions *</p></div>
                        </div>
                        <div className="button-pay"><Link to='/donhang'><button className="button-pay2" type='submit'>Place order</button></Link></div>
                    </div>
                </div>
            </div>
            <Footer />
        </div>
    )
}
export default Payment;
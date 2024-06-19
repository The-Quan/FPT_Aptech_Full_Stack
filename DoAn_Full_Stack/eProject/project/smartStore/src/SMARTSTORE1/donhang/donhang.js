import React from "react";
import anh from './img/icons8-checkmark-500.png';
import './donhang.css';
import Footer from "../component/ues/footer/footer";
import Header from "../component/ues/header/Header";
import Menu from "../component/ues/menu/menu";

function DonHang() {
    return (
        <div className="body">
            <Header />
            <Menu />
            <div className="btn-xong">
                <img className="img-thanhcong" src={anh} />
                <h1 className="text-h1">Order Received</h1>
                <p className="text-p">Thank you. Your order has been received.</p>
            </div>
            <table className="table-2">
                <tr className="tr-2">
                    <td className="td" >ORDER NUMBER:</td>
                    <td className="td" >DATE:</td>
                    <td className="td" >TOTAL:</td>
                    <td className="td" >PAYMENT METHOD:</td>
                </tr>
                <tr className="table-3">
                    <td className="tdd" >5</td>
                    <td className="tdd" >February 3, 2024</td>
                    <td className="tdd" >25.000$</td>
                    <td className="tdd" >Direct Bank Transfer</td>
                </tr>
            </table>
            <p className="btn-p">Make your payment directly into our bank account. Please use your Order ID as the payment reference. Your order won’t be shipped until the funds have cleared in our account.</p>
            <div className="order-details">
                <h1>Order-Details</h1>
                <table className="table-4">
                    <tr className="tr4">
                        <td className="td1"  >PRODUCT</td>
                        <td className="td1" > TOTAL</td>
                    </tr>
                    <tr className="tr5">
                        <td className="td1" >Beautiful modern wooden wardrobe with sliding doors – TQAVP09. x1</td>
                        <td className="td1" >25.0000$</td>
                    </tr>
                    <tr className="tr5">
                        <td className="td1" >High-end Built-in Glass Door Wardrobe – TQAVP37. x1</td>
                        <td className="td1" ></td>
                    </tr>
                    <tr className="tr5">
                        <td className="td1" >6-Compartment Wardrobe with Dressing Table – TQAVP18. x1</td>
                        <td className="td1" ></td>
                    </tr>
                    <tr className="tr5">
                        <td className="td1" >Square Glass Door Wardrobe – TQAVP45. x1</td>
                        <td className="td1" ></td>
                    </tr>
                    <tr className="tr6">
                        <td className="td1" >10-Door Glass Wardrobe – TQAVP36. x1</td>
                        <td className="td1" ></td>
                    </tr>
                    <tr className="tr6">
                        <td className="td1" >Payment Method:</td>
                        <td className="td1" >Direct Bank Transfer</td>
                    </tr>
                    <tr className="tr6">
                        <td className="td1" >Total:</td>
                        <td className="td1" >25.000$</td>
                    </tr>
                </table>
            </div>
            <div className="tt-kh">
                <h1>Customer Details</h1>
                <table>
                    <tr>
                        <td> Email </td>
                        <td>tranthilanhuon@gmail.com</td>
                    </tr>
                    <tr>
                        <td> Phone </td>
                        <td>09908074</td>
                    </tr>
                </table>
            </div>

            <div className="dctt">
                <h1>Billing Address</h1>
                <p className="dctt2">So 8a, Ton That Thuyet, Nam Tu Liem, Ha Noi</p>
            </div>
            <Footer />
        </div>
    )
}
export default DonHang
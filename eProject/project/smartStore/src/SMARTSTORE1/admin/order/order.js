import React from "react";
import MenuAdmin from "../menuAdmin/menuAdmin";
import './order.css'

function Order() {
    return (
        <div className="menuadmin">
            <MenuAdmin />
            <div className="order">
                <div className="btn-order">
                    <table>
                        <tr className="tr">
                            <td className="td">STT</td>
                            <td className="td" >name</td>
                            <td className="td" >Email</td>
                            <td className="td">Quantity</td>
                            <td className="td">Price</td>
                            <td className="td">data</td>
                            <td className="td">Status</td>
                        </tr>
                        <tr>
                            <td className="td">1</td>
                            <td className="td">hai</td>
                            <td className="td">sdogvbsebglsje1@gmail.com</td>
                            <td className="td">1</td>
                            <td className="td">5.000$</td>
                            <td className="td">17/3/2024</td>
                            <td className="td">shipped</td>
                        </tr>
                        <tr>
                            <td className="td">2</td>
                            <td className="td">hai2</td>
                            <td className="td">sdogvbsebglsje2@gmail.com</td>
                            <td className="td">1</td>
                            <td className="td">5.000$</td>
                            <td className="td">18/2/2024</td>
                            <td className="td">completed</td>
                        </tr>
                        <tr>
                            <td className="td">3</td>
                            <td className="td">hai3</td>
                            <td className="td">sdogvbsebglsje3@gmail.com</td>
                            <td className="td">1</td>
                            <td className="td">5.000$</td>
                            <td className="td">19/2/2024</td>
                            <td className="td">processing</td>
                        </tr>
                        <tr>
                            <td className="td">4</td>
                            <td className="td">hai4</td>
                            <td className="td">sdogvbsebglsj4@gmail.com</td>
                            <td className="td">1</td>
                            <td className="td">5.000$</td>
                            <td className="td">04/03/2024</td>
                            <td className="td">processing</td>
                        </tr>
                        <tr>
                            <td className="td">5</td>
                            <td className="td">hai5</td>
                            <td className="td">sdogvbsebglsje5@gmail.com</td>
                            <td className="td">1</td>
                            <td className="td">5.000$</td>
                            <td className="td">12/4/20204</td>
                            <td className="td">shipped</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    )
}
export default Order;
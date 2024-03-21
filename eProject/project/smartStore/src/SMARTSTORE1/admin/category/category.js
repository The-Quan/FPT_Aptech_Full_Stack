import React from "react";
import MenuAdmin from "../menuAdmin/menuAdmin";
import './catagory.css';

function Category() {
    return (
        <div className="menuadmin">
            <MenuAdmin />
            <div className="catagory1">
                <table>
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
            </div>
        </div>
  )
}
  export default Category;
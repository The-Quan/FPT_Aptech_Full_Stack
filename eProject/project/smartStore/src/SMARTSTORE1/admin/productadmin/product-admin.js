import React from "react";
import MenuAdmin from "../menuAdmin/menuAdmin";
import './productadmin.css';

function Product() {
    return (
        <div className="menuadmin">
            <MenuAdmin />
            <div className="table-bhb">
                <table className="bleo">
                    <tr className="bleo2">
                        <td className="bloe3">Stt</td>
                        <td className="bloe3">Img</td>
                        <td className="bloe3">Name</td>
                        <td className="bloe3">Category</td>
                        <td className="bloe3">Price</td>
                        <td className="bloe3">Data</td>
                        <td className="bloe3">Status</td>
                        <td className="bloe3">Action</td>
                    </tr>
                </table>
                <p className="nono">No data available in table</p>
            </div>

        </div>
    )
}
export default Product;
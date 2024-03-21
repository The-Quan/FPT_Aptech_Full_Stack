import React from "react";
import MenuAdmin from "../menuAdmin/menuAdmin";
import './user.css';
import edit from './img/icons8-edit-50.png';
import delete1 from './img/icons8-delete-30.png';

function User() {
    return (
        <div className="menuadmin"><MenuAdmin />
            <div>
            <h1 className="title-user">List User</h1>
                <table className="user-bnt">
                    <tr>
                        <td>First name</td>
                        <td>Last name</td>
                        <td>Address</td>
                        <td>Email</td>
                        <td>Contact</td>
                        <td>Username</td>
                        <td>Edit</td>
                        <td>Delete</td>
                    </tr><tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>haihelocb@gmail.com</td>
                        <td></td>
                        <td>admin</td>
                        <td><img className="edit" src={edit} /></td>
                        <td><img className="edit" src={delete1} /></td>
                    </tr>
                </table>

            </div>
        </div>
    )
}
export default User;
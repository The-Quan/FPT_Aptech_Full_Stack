import React from 'react';
import './menu.css';
import { Link} from 'react-router-dom';

function Menu() {
    return (
        <div className="menu">
            <div className='menu2'>
                <li><Link to = '/Home'>Home</Link></li>
                <li><Link to = '/Products'>Products</Link></li>
                <li><Link to = '/introduce'>Introduction</Link></li>
                <li><Link to = '/Contact'>Contact</Link></li>
            </div>
        </div>
    )
}
export default Menu;
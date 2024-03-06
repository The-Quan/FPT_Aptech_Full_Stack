import React from 'react';
import './menudacap.css';
import { Link} from 'react-router-dom';

function Menudacap() {
    return (
        <div className='dropdown'>
            <div className='menumax'>
            <p className='dropdown-select'>Product Catalog</p>
            <li className='limenu2' ><Link to='/content1'>I. Noi That Gia Khanh </Link></li>
            <li className='limenu2' ><Link to='/content2'>II. Acado Furniture</Link></li>
            <li className='limenu2' ><Link to='/content3'>III. Decorative Wood</Link></li>
            <li className='limenu2' ><Link to='/content4'>IV. An Hung Furniture</Link></li>
            <li className='limenu2' ><Link to='/strored'>V. Storage Products</Link></li>
            </div>
        </div>
    )
}
export default Menudacap;



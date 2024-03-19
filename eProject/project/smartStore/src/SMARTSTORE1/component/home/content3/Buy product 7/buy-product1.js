import React, { useState } from 'react';
import Header from '../../../ues/header/Header';
import Menu from '../../../ues/menu/menu';
import Footer from '../../../ues/footer/footer'
import anh1 from './img/sanphamluutru7.jpg';





const BuyProduct1 = () => {
  const onClick = () => {

    alert('Add to cart successfully');

  }
  return (
    <div className='buyproduct1'>

      <div className='btn-neo'><Header /></div>
      <Menu />
      <div className='sp1' >
        <div><p className='text'>Beautiful modern wooden wardrobe with sliding doors – TQAVP09</p></div>
      </div>
      <div className='product-btn1'>
        <div className='sanpham-btn'><img className='anh-product-btn1' src={anh1} /></div>
        <div className='buy'>

          <h3 className='text-2'>Beautiful modern wooden wardrobe with sliding doors – TQAVP09</h3> <br />

          <div className='imgproduct'>
            <img className='imgproduct2' src={anh1} />
            <img className='imgproduct3' src={anh1} />
            <img className='imgproduct4' src={anh1} />
            <img className='imgproduct5' src={anh1} />
            <img className='imgproduct6' src={anh1} />
          </div>
          <strong className='gia'>5.000$</strong>
          <div className='btn-buy'>
            <button className='muahangbtn' onClick={onClick} >Add To Cart</button>
          </div>
          <div className='chitiet'>
            <p>Beautiful modern wooden wardrobe with sliding doors – TQAVP09 is designed in a modern style,
              youthful. The cabinet is spacious and comfortable to store items for the whole family.
              The cabinet has 4 eye-catching glass doors and makes cleaning easy. The outside is a sturdy black aluminum frame.
              The overall cabinet is extremely eye-catching and suitable for any bedroom space.</p>
          </div>
        </div>
      </div>
      <div className='mota'>
        <u className='describe'>Product Details</u><br />
        <table>
          <tr>
            <th>Material</th>
            <td>MDF industrial wood coated with melamine on both sides</td>
          </tr>
          <tr>
            <th>Size</th>
            <td>1m6 x 2m</td>
          </tr>
          <tr>
            <th>Origin</th>
            <td>Manufactured directly at That CaCo factory</td>
          </tr>
          <tr>
            <th>Guarantee</th>
            <td>Product warranty 3 years lifetime maintenance</td>
          </tr>
          <tr>
            <th>Quality</th>
            <td>High-quality melamine-coated MDF material, resistant to scratches and termites, does not warp, shrink or crack during use.</td>
          </tr>
          <tr>
            <th>Caco commits</th>
            <td>
              <li>Manufactured directly at the factory, 100% new</li>
              <li>Return products 1-1 for free if the agreed materials and drawings do not match</li>
            </td>
          </tr>
          <tr>
            <th>Production on demand</th>
            <td>You can order according to size, material and color upon request</td>
          </tr>
          <tr>
            <th>Endow</th>
            <td>
              <li>Free home measurement survey consultation</li>
              <li>Free 2D-3D design</li>
              <li>Free shipping and installation within Ho Chi Minh City</li>
            </td>
          </tr>
        </table>

        <p className='vanban'><span className='textcolor'>Beautiful modern wooden wardrobe with sliding doors – TQAVP09 </span> is a great choice for optimizing storage space in the bedroom.
          With high quality MDF material, the product is not only durable but also easy to preserve.
          The color combination of yellow and gray creates an aesthetic and modern highlight for the interior space.</p><br />
        <p>This wardrobe is designed with spacious space and flexible shelves, helping you organize clothes and accessories effectively.
          Besides, the door opens and the drawers are easy to access, bringing convenience in daily use.</p><br />
        <p>With delicate design lines, careful material details and solid structure, this MDF industrial wood wardrobe is not only an ideal place to store
          clothes but also an interesting highlight in interior decoration. bedroom .</p><br />
        <p>The wardrobe is suitable for many spaces, from the master bedroom to the children's bedroom,
          creating luxury and convenience for your living space.</p><br />
        <p>Don't miss the opportunity to own high-end industrial wood wardrobe models to bring a luxurious and sophisticated living space to your home at CaCo Furniture, which is always ready to support you quickly and professionally. Karma. </p>
      </div>
      <Footer />
    </div>

  )
}
export default (BuyProduct1); 
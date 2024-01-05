import React from 'react';
import './index.css';

import search from '../bai_thi/img/search.png';
import star from '../bai_thi/img/star.png';
import Putdown from '../bai_thi/img/Putdown.png';
import add from '../bai_thi/img/add.png';

function Content(){
    return (
         <div className='container'>
          <div className='content'>
            <div className="search">
          <div className='search0'><img src={search}/></div>
          <input className='search2' type='search' />
         </div>
         <h2>A list of books</h2>
         <div className='btn'>
           <div className='btn-1'>
                <span className='title'>Life of pi</span>
            <div className='bn1'>
            <span >Davan</span>
            </div>
           </div>
           <div className='btn-2'>
            <img className="star" src={star} />
            <span className='title'>Học code today</span>
            <div className='bn2'>
            <span>Fpt</span>
            </div>
           </div>
           <div className='btn-3'>
           <img className="star" src={star} />
            <span className='title'>Learn Angular by example</span>
            <div className='bn3'>
            <span>FPT-Aptech</span>
            </div>
           </div>
           <div className='btn-4'>
            <span className='title'>Họ nhà trai</span>
            <div className='bn4'>
            <span>Nguyễn Anh Tú</span>
            </div>
           </div>
           <div className='btn-5'>
           <img className="star" src={star} />
            <span className='title'>Đôi mắt có lửa</span>
            <div className='bn5'>
            <span>Nguyễn Hùng Sơn</span>
            </div>
           </div>
           
           </div>

           <div className='btn-6'>
            <span className='title'>Authoer Ascending</span>
            <div className='bn6'>
            <img className='Putdown' src={Putdown} />
            </div>

            
           </div>
           <h3>Add a new book</h3>
           <div className='footer'>
           <span><strong>Title</strong></span>
           <br></br>
           <input className='input' type='text'></input>
           <br></br>
           <span><strong>Author</strong></span>
           <br></br>
           <input className='input' type='text'></input>
           <br></br>
           <div className='button'>
           <p><strong>Favotite:</strong></p>
           <input className='check' type='checkbox'></input>
           <button className='button-2' type='checkbox'> <img className='add' src={add}/> Add</button>
           </div>
         </div>
         </div>
      </div>
    );

}
export default Content;
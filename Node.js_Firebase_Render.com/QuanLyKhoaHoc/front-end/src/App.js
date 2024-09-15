import './App.css';
import { Routes, Route } from 'react-router-dom';
import Login from './authentication/login';
import Register from './authentication/register';
import Home from './user/Home/home';
import CourseDetails from './user/course/courseDetails';
import RegisteredCourses from './user/course/registeredCourses';
import HomeAdmin from './admin/homeAdmin';
import EditCourse from './admin/editCourse'
import AddCourse from './admin/addCourse';


function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/course/:id" element={<CourseDetails />} />
        <Route path="/register" element={<Register />} />
        <Route path='/register-course' element={<RegisteredCourses />} />

        <Route path="/admin" element={<HomeAdmin />} />
        <Route path="/edit-course/:id" element={<EditCourse />} />
        <Route path="/add-course" element={<AddCourse />} />


      </Routes>
    </div>
  );
}

export default App;

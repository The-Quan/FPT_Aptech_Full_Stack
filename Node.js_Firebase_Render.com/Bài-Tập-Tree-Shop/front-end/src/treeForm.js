import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { LuDownload } from "react-icons/lu";import { Upload } from "antd";
import './treeForm.css';

const TreeForm = () => {
  const [trees, setTrees] = useState([]);
  const [treeName, setTreeName] = useState('');
  const [description, setDescription] = useState('');
  const [image, setImage] = useState('');
  const [editId, setEditId] = useState(null);

  // Fetch trees on initial load
  useEffect(() => {
    fetchTrees();
  }, []);

  const fetchTrees = async () => {
    try {
      const response = await axios.get('http://localhost:5000/get');
      setTrees(response.data.data);
    } catch (error) {
      console.error('Error fetching trees:', error);
    }
  };

  // Add new tree or update existing one
  const handleAdd = async (e) => {
    e.preventDefault();
    try {
      const newTree = { name: treeName, description, img: image };
      if (editId === null) {
        await axios.post('http://localhost:5000/post', newTree);
      } else {
        await axios.put(`http://localhost:5000/${editId}`, newTree);
      }
      fetchTrees();
      resetForm();
    } catch (error) {
      console.error('Error adding/updating tree:', error);
    }
  };

  // Edit tree
  const handleEdit = (tree) => {
    setTreeName(tree.name);
    setDescription(tree.description);
    setImage(tree.img);
    setEditId(tree.id);
  };

  // Delete tree
  const handleDelete = async (id) => {
    try {
      await axios.delete(`http://localhost:5000/${id}`);
      fetchTrees();
    } catch (error) {
      console.error('Error deleting tree:', error);
    }
  };

  // Handle file change and upload to Cloudinary
  const handleFileChange = async (info) => {
    const fileList = [info.fileList[info.fileList.length - 1].originFileObj]; // Get the last file only
    const cloudName = 'ddrgrnsex';
    const uploadPreset = 'url_img'; // Be careful of spaces in upload preset

    const file = fileList[0];
    const formData = new FormData();
    formData.append('file', file);
    formData.append('upload_preset', uploadPreset);

    try {
      const uploadResponse = await axios.post(
        `https://api.cloudinary.com/v1_1/${cloudName}/image/upload`,
        formData
      );
      const imageUrl = uploadResponse.data.secure_url;
      
      setImage(imageUrl); // Set uploaded image URL
    } catch (error) {
      if (error.response) {
        console.log('Response data:', error.response.data);
        console.log('Response status:', error.response.status);
      } else {
        console.log('Error message:', error.message);
      }
      console.error('Error uploading image:', error);
    }

    info.fileList = [];
  };

  const resetForm = () => {
    setTreeName('');
    setDescription('');
    setImage('');
    setEditId(null);
  };

  return (
    <div className="tree-shop-container">
      <img className='img' src='https://hoalan360.com/upload/UploadFiles/images/hinh-anh-hoa-lan-my-mieu-mong-manh.jpg' alt='tree shop' />
      <h1 className="tree-shop-title">Tree Shop</h1>

      <form onSubmit={handleAdd} className="tree-form">
        <div className="tree-form-group">
          <label className="tree-form-label">Tree Name:</label>
          <input
            type="text"
            value={treeName}
            onChange={(e) => setTreeName(e.target.value)}
            required
            className="tree-form-input"
          />
        </div>
        <div className="tree-form-group">
          <label className="tree-form-label">Description:</label>
          <textarea
            value={description}
            onChange={(e) => setDescription(e.target.value)}
            required
            className="tree-form-textarea"
          />
        </div>
        <div className="tree-form-group">
          <label className="tree-form-label">Image Upload:</label>
          <input
            type="text"
            value={image}
            onChange={(e) => setImage(e.target.value)}
            required
            className="tree-form-input-img"
          />
           <Upload
            listType="picture"
            showUploadList={false}
            beforeUpload={() => false}
            onChange={handleFileChange}
          >
            <LuDownload size={28} style={{ cursor: 'pointer', marginLeft: '20px', marginBottom: '-10px' }} />
          </Upload>
        </div>
        <div className="tree-form-buttons">
          <button type="submit" className="tree-form-button-add">
            {editId ? 'Update' : 'Add'} Tree
          </button>
          <button type="button" onClick={resetForm} className="tree-form-button-reset">
            Reset
          </button>
        </div>
      </form>

      <table className="tree-table">
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Image</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {trees.map((tree) => (
            <tr key={tree.id}>
              <td>{tree.id}</td>
              <td>{tree.name}</td>
              <td>{tree.description}</td>
              <td>
                <img src={tree.img} alt={tree.name} className="tree-table-image" />
              </td>
              <td>
                <button onClick={() => handleEdit(tree)} className="tree-table-button-edit">
                  Edit
                </button>
                <button onClick={() => handleDelete(tree.id)} className="tree-table-button-delete">
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default TreeForm;

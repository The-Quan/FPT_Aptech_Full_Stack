import React, { useState, useEffect } from 'react';
import axios from 'axios';
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
      const response = await axios.get('http://localhost:5000/get');  // Thay '/api/trees' bằng URL API thực tế của bạn
      setTrees(response.data.data); // Gán dữ liệu từ API vào state
    } catch (error) {
      console.error('Error fetching trees:', error);
    }
  };

  // Add new tree
  const handleAdd = async (e) => {
    e.preventDefault();
    try {
      const newTree = { name: treeName, description, img: image };
      if (editId === null) {
        await axios.post('http://localhost:5000/post', newTree);
      } else {
        await axios.put(`http://localhost:5000/${editId}`, newTree);
      }
      fetchTrees(); // Refresh the tree list
      resetForm();  // Reset form after adding or updating
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
      fetchTrees(); // Refresh the tree list
    } catch (error) {
      console.error('Error deleting tree:', error);
    }
  };

  const resetForm = () => {
    setTreeName('');
    setDescription('');
    setImage('');
    setEditId(null);
  };

  return (
    <div className="tree-shop-container">
       <img className='img' src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbUOVdfMjIsddmCLy0Io2WfUEfmjfndB5FkfQtvd46oyYLUBhb' />

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
          <label className="tree-form-label">Image URL:</label>
          <input
            type="text"
            value={image}
            onChange={(e) => setImage(e.target.value)}
            required
            className="tree-form-input"
          />
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
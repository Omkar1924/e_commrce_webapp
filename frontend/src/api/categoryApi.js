import axios from 'axios';
const API_BASE = 'http://localhost:8081/api/categories';

export const getAllCategories = () => axios.get(API_BASE);
export const getCategoryById = (id) => axios.get(`${API_BASE}/${id}`);
import axios from 'axios'
const API_BASE = 'http://localhost:8081/api/products'

export const getAllproducts = () => axios.get(API_BASE);
export const getProductById = (id) => axios.get(`${API_BASE}/${id}`);
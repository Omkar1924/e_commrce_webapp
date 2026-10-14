import { Routes, Route } from 'react-router-dom';
import ProductList from './components/ProductList';
import 'bootstrap/dist/css/bootstrap.min.css';
import ProductDetail from './components/ProductDetail';
import Navbar from './components/Navbar';
import CategoriesList from './components/CategoriesList';

function App() {
  return (
    <div>
      <Navbar />
      <Routes>
        <Route path='/' element={<ProductList />} />
        <Route path='/product/:id' element={<ProductDetail />} />
        <Route path='/categories' element={<CategoriesList/>} />
      </Routes>
    </div>
  );
}

export default App;
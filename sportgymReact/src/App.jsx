import './App.css';
import { Routes, Route } from 'react-router-dom';
import { Login } from './components/Login.jsx';
import { Inicio } from './components/Inicio.jsx';
import { Registro } from './components/Registro.jsx';
import { Tienda } from './components/Tienda.jsx';
import { SobreNosotros } from './components/SobreNosotros.jsx';
import { Contactenos } from './components/Contactenos.jsx';



export default function App() {

  return (
    <>
    
      <div className='App'>   

        <Routes>
          <Route path='/' element={<Login />} />
          <Route path='/inicio' element={<Inicio />} />
          <Route path='/registro' element={<Registro />} />
          <Route path='/tienda' element={<Tienda />} />
          <Route path='/sobreNosotros' element={<SobreNosotros />} />
          <Route path='/contactenos' element={<Contactenos />} />
        </Routes>

      </div>
      
    </>
  );
}



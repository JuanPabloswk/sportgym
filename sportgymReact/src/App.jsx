import './App.css';
import { Login }  from './components/Login.jsx';
import { Inicio } from './components/Inicio.jsx';
import { Route, Routes } from 'react-router-dom';

export default function App() {

  return (
    <>
      <div className='App'>   
        
        <Routes>
          <Route path='/' element={<Login />} />
          <Route path='/inicio' element={<Inicio />} />
        </Routes>
      </div>
      
    </>
  )
}



import '../stylesheets/Inicio.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { Header } from '../components/Header.jsx';
import { Tienda } from '../components/Tienda.jsx';
import { SobreNosotros } from '../components/SobreNosotros.jsx';
import { Contactenos } from '../components/Contactenos.jsx';
import { Planes } from '../components/Planes.jsx';
import { Footer } from '../components/Footer.jsx';


export function Inicio () {

    return (
        
        <div className='Inicio'>
            <Header />
            <div className='portada'>
                <div className='portadaTexto'>
                    <p>TRANSFORMA TU CUERPO</p>
                    <p> Las excusas queman 0 calorias por hora</p>
                </div>
            </div>
            <Planes />
            <Footer /> 
        </div>
    )
}
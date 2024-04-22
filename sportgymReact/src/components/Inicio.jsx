import '../stylesheets/Inicio.css';
import { Header } from '../components/Header.jsx';
import { Planes } from '../components/Planes.jsx';
import { Footer } from '../components/Footer.jsx';


export function Inicio () {

    return (          
        
        <div className='Inicio'>
            <Header />
            <div cflassName='portada'>
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
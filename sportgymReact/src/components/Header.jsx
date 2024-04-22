import '../stylesheets/Header.css';
import { FaUser } from 'react-icons/fa';
import { Link } from 'react-router-dom';


export function Header () {

    return (
    <header>
        <div className='menu'>
            <div className='logo'>
                <img src='/assets/icono.ico' width='55px' height='55px' />
            </div>

            <div className='menu-botones'>
                <ul>
                    <li><Link to='/inicio'>Home</Link></li>
                    <li><Link to='/tienda'>Tienda</Link></li>
                    <li><Link to='/sobreNosotros'>Sobre Nosotros</Link></li>
                    <li><Link to='/contactenos'>Contactenos</Link></li>
                </ul>
            </div>

            <div className='usuario'>
                <FaUser className='usuarioIcon' />
                <p className='userName'>Juan Pablo</p>
                <Link to='/'>
                    <button>Cerrar sesion</button>
                </Link> 
            </div>
        </div>
    </header>
    )
}
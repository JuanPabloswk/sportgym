import '../stylesheets/Header.css';
import { FaUser } from 'react-icons/fa';


export function Header ({user, setUser}) {

    const handleLogout = () => {
        setUser([])
    }

    return (
    <header>
        <div className='menu'>
            <div className='logo'>
                <img src='/assets/icono.ico' width='55px' height='55px' />
            </div>
            <div className='menu-botones'>
                <a>Home</a>
                <a>Tienda</a>
                <a>Sobre Nosotros</a>
                <a>Contactenos</a>
            </div>
            <div className='usuario'>
                <FaUser className='usuarioIcon' />
                <p className='userName'>Juan Pablo{user}</p>
                <button onClick={handleLogout}>Cerrar sesion</button>
            </div>
        </div>
    </header>
    )
}
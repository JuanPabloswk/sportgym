import '../stylesheets/Login.css';
import { FaUser } from 'react-icons/fa';
import { FaLock } from 'react-icons/fa';
import { Link } from 'react-router-dom';


export function Login() {

    return (

        <div className='login'>

            <section>

                <h1>Login</h1>

                <form>
                    <input type='text' placeholder='Ingresa tu nombre'  required />
                    <FaUser className='icon1' />
                    
                    <input type='password' placeholder='Ingresa tu contraseña'  required />
                    <FaLock className='icon2' />

                    <Link to='/inicio'>
                        <button className='boton'>Iniciar sesion</button>
                    </Link>
                </form>

                <div className='botonRegistro'>
                    <Link to='/registro'> 
                    ¿No tienes cuenta?
                    </Link>
                    <a href='https://developer.mozilla.org/en-US/' >¿Olvidaste tu contraseña?</a>
                </div>

            </section>

        </div>

        
        
    )
  }
  

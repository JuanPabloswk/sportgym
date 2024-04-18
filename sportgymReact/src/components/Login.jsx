import '../stylesheets/Login.css';
import { FaUser } from 'react-icons/fa';
import { FaLock } from 'react-icons/fa';


export function Login() {

    return (

        <section>

            <h1>Login</h1>

            <form>
                <input type='text' placeholder='Ingresa tu usuario' value='nombre'required />
                <FaUser className='icon1' />
                
                <input type='password' placeholder='Ingresa tu contraseña' value='contraseña'  required />
                <FaLock className='icon2' />

                <button>Iniciar Sesion</button>
            </form>

            <div className='olvidaste'>
                <a href='https://developer.mozilla.org/en-US/' target='_blank'>¿Olvidaste tu contraseña?</a>
                <a href='https://developer.mozilla.org/en-US/' target='_blank'>¿No tienes cuenta?</a>
            </div>

        </section>
        
    );
  }
  

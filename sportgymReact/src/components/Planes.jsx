import '../stylesheets/Planes.css';


export function Planes () {
    return (
        <div className='container'>
            <h2>Encuentra un plan perfecto</h2>
            <div className='planes'>
                <div className='estandar'>
                    <h3>PLAN ESTANDAR</h3>
                    <p>$200</p>
                    <select>
                        <option>1 mes</option>
                        <option>3 meses</option>
                        <option>6 meses</option>
                        <option>1 año</option>
                    </select>
                    <div className='beneficios'>
                        <h4>Beneficios</h4>
                        <p>Acceso al gimnasio</p>
                    </div>
                    <button>Comprar</button>
                </div>
                <div className='personalizado'>
                    <h3>PLAN ESTANDAR</h3>
                    <p>$300</p>
                    <select>
                        <option>1 mes</option>
                        <option>3 meses</option>
                        <option>6 meses</option>
                        <option>1 año</option>
                    </select>
                    <div className='beneficios'>
                        <h4>Beneficios</h4>
                        <p>Acceso al gimnasio</p>
                        <p>Entrenador Personal</p>
                    </div>
                    <button>Comprar</button>
                </div>
            </div>
            
        </div>
    )
}
document.addEventListener('DOMContentLoaded', function() {
    const mesesSelect = document.getElementById('duracion');
    const precioInput = document.getElementById('precio');

    const preciosPorMes = {
        1: 100,
        2: 400,
        3: 1200,
        4: 2400,
        5: 4800
    };

    function actualizarPrecio() {
        const mesSeleccionado = parseInt(mesesSelect.value);
        const precio = preciosPorMes[mesSeleccionado];
        precioInput.value = '$' + precio.toFixed(2);
    }

    mesesSelect.addEventListener('change', actualizarPrecio);

    // Establecer el precio inicial para el mes actual
    const mesActual = new Date().getMonth() + 1; // Se suma 1 porque los meses van de 0 a 11
    precioInput.value = '$' + preciosPorMes[mesActual].toFixed(2);
});
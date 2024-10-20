document.addEventListener('DOMContentLoaded', () => {
    const resultMessage = document.getElementById('resultMessage');
    const status = localStorage.getItem('creditStatus');

    if (status === 'APPROVED') {
        resultMessage.textContent = 'Solicitud Aprobada';
        resultMessage.style.color = 'green';
    } else if (status === 'REJECTED') {
        resultMessage.textContent = 'Solicitud Rechazada';
        resultMessage.style.color = 'red';  
    } else {
        resultMessage.textContent = 'No hay resultados disponibles.';
        resultMessage.style.color = 'gray';
    }
});
document.addEventListener('DOMContentLoaded', () => {
    fetch(`${config.baseUrlBackend}${config.urlGetStats}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al obtener los datos de la API');
            }
            return response.json();
        })
        .then(data => {
            const approved = data.approved;
            const rejected = data.rejected;

            const ctx = document.getElementById('creditChart').getContext('2d');
            new Chart(ctx, {
                type: 'pie',
                data: {
                    labels: ['Aprobadas', 'Rechazadas'],
                    datasets: [{
                        data: [approved, rejected],
                        backgroundColor: ['#4CAF50', '#F44336'],
                    }],
                },
                options: {
                    responsive: true,
                    plugins: {
                        legend: {
                            position: 'top',
                        },
                        title: {
                            display: true,
                            text: 'Solicitudes Aprobadas vs. Rechazadas'
                        }
                    }
                }
            });
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Ocurrió un error al cargar los indicadores.');
        });
});
document.getElementById('creditForm').addEventListener('submit', function (event) {
    event.preventDefault();
    const clientId = document.getElementById('clientId').value;
    const branchId = document.getElementById('branchId').value;
    const creditAmount = document.getElementById('creditAmount').value;

    const creditRequest = {
        clientId: parseInt(clientId),
        branchId: parseInt(branchId),
        amount: parseFloat(creditAmount),
    };

    fetch(`${config.baseUrlBackend}${config.urlPostCredit}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(creditRequest),
    })
    .then(response => response.json())
    .then(data => {
        localStorage.setItem('creditStatus', data.decision);
        window.location.href = 'result.html'; 
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Ocurrió un error. Intente nuevamente.');
    });
});



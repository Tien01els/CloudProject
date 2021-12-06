const api = 'http://localhost:8081/account/getUserid';

async function getId() {
    return await $.get(api)
        .done(function(data) {
            const idUser = data.key;
            return idUser;
        })
        .fail(function() {
            console.log('Error');
        })
}

export default getId;
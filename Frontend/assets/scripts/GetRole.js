const api = 'http://localhost:8081/account/getUserrole';

async function getRole() {
    return await $.get(api)
        .done(function(data) {
            const idUser = data.key;
            return idUser;
        })
        .fail(function() {
            console.log('Error');
        })
}

export default getRole;
const api = 'http://localhost:8081/account/getUserid';

async function getId() {
    return await $.get(api)
        .done(function(data) {
            const idUser = data.key;
            console.log(idUser);
            return idUser;
        })
        .fail(function() {
            console.log('Error');
        })
}

// .then(function(id) {
//     console.log(id);
// })

export default getId;
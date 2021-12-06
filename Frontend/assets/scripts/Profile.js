import getId from './GetIdUser.js';
import getRole from './GetRole.js';


const btnSubmit = document.querySelector('.btn-submit');
const inputs = document.querySelectorAll('.form-input');

btnSubmit.onclick = (e) => {
    e.preventDefault();
    var value = {};
    inputs.forEach(input => {
        Object.assign(value, {
            [input.getAttribute('name')]: input.value
        });
    });
    addObjects(value);
}

function addObjects(data) {
    getId()
        .then(idUser => {
            getRole()
                .then(role => {
                    const api = "http://localhost:8081/" + role.key + "/" + idUser.key;
                    $.ajax({
                            type: 'PUT',
                            url: api,
                            contentType: 'application/json',
                            data: JSON.stringify(data), // access in body
                        })
                        .done(function(data) {
                            console.log(data);
                        })
                        .fail(function() {
                            console.log("error");
                        })
                });


        });
}

getId()
    .then(idUser => {
        getRole()
            .then(role => {
                const api = "http://localhost:8081/" + role.key + "/" + idUser.key;
                $.ajax({
                        type: 'GET',
                        url: api,
                        contentType: 'application/json'
                    })
                    .done(function(data) {
                        inputs.forEach(input => {
                            input.value = data[input.getAttribute('name')]
                        });
                    })
                    .fail(function() {
                        console.log("error");
                    })
            });


    });
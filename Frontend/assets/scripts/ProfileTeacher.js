import getId from './UserGlobal.js';
const firstname = document.querySelector('#firstname');
const lastname = document.querySelector('#lastname');
const email = document.querySelector('#email');
const phone = document.querySelector('#phone');
const gender = document.querySelector('#gender');
const birth = document.querySelector('#birth');

getId()
    .then(data => {
        const api = "http://localhost:8081/teacher/" + data.key;

        $.post({
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
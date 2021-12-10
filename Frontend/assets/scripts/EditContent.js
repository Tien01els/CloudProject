import getUser from './GetUser.js';
import { URL } from './URL.js';

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
    editObjects(value);
}

function editObjects(data) {
    getUser()
        .then(user => {
            let api;
            api = URL + '/' + user.key_userrole + '/' + user.key_userid;
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

}

getUser()
    .then(user => {
        const api = URL + '/' + user.key_userrole + '/' + user.key_userid;
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
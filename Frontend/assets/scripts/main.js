import { URL } from './URL.js';

const btnMenu = document.querySelector('.btn-menu');
const btnLogout = document.querySelector('.btn-logout');
const btnProfile = document.querySelector('.btn-profile');
const main = document.querySelector('#main');
if (btnMenu)
    btnMenu.onclick = () => {
        main.classList.toggle('mini-sidebar');
    }
if (btnLogout)
    btnLogout.onclick = () => {
        console.log(URL);
        $.ajax({
            type: 'DELETE',
            url: URL + '/account/deleteGlobalId',
            dataType: 'json',
            headers: {
                "Content-Type": "application/json",
            },
            success: function(data) {
                console.log(data);
                location.href = "Login.html";
            },
            error: function() {
                console.log("The following error occured: ");
            }
        });
    }
import { URL } from './URL.js';

function checkpass() {
    if (document.getElementById("id_pass").value !== document.getElementById("id_repass").value) {
        alert("Password does not match!!!");
        return false;
    }
}

function getRole() {
    var ele = document.getElementsByName("role");
    for (let i = 0; i < ele.length; ++i) {
        if (ele[i].checked)
            return ele[i].value;
    }
}

const btnAdd = document.getElementById("btn_register");
btnAdd.addEventListener("click", (Event) => {
    Event.preventDefault();

    if (checkpass() == false)
        return;

    var Model = {
        username: document.getElementById("id_user").value,
        password: document.getElementById("id_pass").value,
        role: getRole(),
    };

    console.log("testvalue: " + Model);
    var requestJSON = JSON.stringify(Model);

    $.ajax({
        type: 'POST',
        url: URL + '/account/' + getRole(),
        dataType: 'json',
        headers: {
            "Content-Type": "application/json",
        },
        data: requestJSON,
        success: function(data) {
            location.href = "Login.html";
        },
        error: function() {
            console.log("The following error occured: ");
        }
    });
}, false);
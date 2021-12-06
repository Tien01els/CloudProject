function getRole() {
    var ele = document.getElementsByName("role");
    for (let i = 0; i < ele.length; ++i) {
        if (ele[i].checked)
            return ele[i].value;
    }
}


const btnAdd = document.getElementById("btn_login");
btnAdd.addEventListener("click", (Event) => {
    Event.preventDefault();

    var Model = {
        username: document.getElementById("id_user").value,
        password: document.getElementById("id_pass").value,
        role: getRole()
    };

    console.log(Model.username);
    var requestJSON = JSON.stringify(Model);

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8081/account/login',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json",
        },
        data: requestJSON,
        success: function(data) {
            // location.href = "Login.html";
            if (data.key == "Success") {
                window.location.href = "Dashboard.html";
            }
        },
        error: function() {
            console.log("The following error occured: ");
        }
    });
}, false);
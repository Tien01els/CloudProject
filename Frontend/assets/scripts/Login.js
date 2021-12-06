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

    console.log("testvalue: " + Model);
    var requestJSON = JSON.stringify(Model);

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8081/member/login',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json",
        },
        data: requestJSON,
        success: function(data) {
            // location.href = "Login.html";
            console.log(data);
            if (data.key == "Success")
                window.location.href = "./OldFE/HomePage.html";
        },
        error: function() {
            console.log("The following error occured: ");
        }
    });
}, false);
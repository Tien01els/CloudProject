function checkpass(){
    if(document.getElementById("id_pass").value !== document.getElementById("id_repass").value){
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

    if(checkpass() == false)
        return;

    var Model = {
        // id: "",
        username: document.getElementById("id_user").value,
        email: document.getElementById("id_email").value,
        role: getRole(),
        password: document.getElementById("id_pass").value,
    };

    console.log("testvalue: " + Model);
    var requestJSON = JSON.stringify(Model);

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8081/member',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json",
        },
        data: requestJSON,
        success: function(data) {
            location.reload();
        },
        error: function() {
            console.log("The following error occured: ");
        }
    });
}, false);
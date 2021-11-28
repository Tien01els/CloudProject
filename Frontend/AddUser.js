function getGender(){
    var ele = document.getElementsByName("gender");
    for(i = 0; i < ele.length; ++i){
        if(ele[i].checked)
            return ele[i].value;
    }
}

document.getElementById("btn_add").addEventListener("click", function InsertFunction(Event){
    Event.preventDefault();

    var Model ={
            id: "",
            fullname: document.getElementById("id_fullname").value,
            gender: getGender(),
            age: document.getElementById("id_age").value,
            email: document.getElementById("id_email").value,
            phone: document.getElementById("id_phone").value
        };

    console.log("testvalue: " + Model);
    var requestJSON = JSON.stringify(Model);

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8081/users',
        dataType: 'json',
        headers:{
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin" : "http://localhost:8081/users"
        },
        data: requestJSON,
        success: function(data) {
            console.log(data);
        },
        error: function() {
            console.log("The following error occured: ");
        }
    });
}, false);

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


function addObjects(Objects) {
    const api = "http://localhost:8081/student/";
    console.log(Objects);
    // $.post("api", Objects)
    //     .done(function(data) {
    //         console.log(data);
    //     })
    //     .fail(function() {
    //         alert("error");
    //     })
    //     .always(function() {
    //         alert("complete");
    //     });
}
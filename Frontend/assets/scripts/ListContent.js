const btnEdits = document.querySelectorAll('.btn-edit');
const formEdit = document.querySelector('#form-edit');
const btnCloseForm = document.querySelector('.form-close');

btnEdits.forEach(btnEdit => {
    btnEdit.onclick = () => {
        formEdit.classList.add('active');
    }
})
btnCloseForm.onclick = () => {
    formEdit.classList.remove('active');
}

function getObject() {
    const api = "http://localhost:8081/student/";
    // var valueObjects = Objects.map(Object => ({ Object: Object.value }));
    $.post("api")
        .done(function(data) {
            console.log(data);
        })
        .fail(function() {
            alert("error");
        })
        .always(function() {
            alert("complete");
        });
}
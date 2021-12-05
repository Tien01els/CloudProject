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
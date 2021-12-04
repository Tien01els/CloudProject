const btnMenu = document.querySelector('.btn-menu');
const headerLeft = document.querySelector('.header-left');
const main = document.querySelector('#main');
const btnEdits = document.querySelectorAll('.btn-edit');
const formEdit = document.querySelector('#form-edit');
const btnCloseForm = document.querySelector('.form-close')

btnMenu.onclick = () => {
    main.classList.toggle('mini-sidebar');
}

btnEdits.forEach(btnEdit => {
    btnEdit.onclick = () => {
        formEdit.classList.add('active');
    }
})
btnCloseForm.onclick = () => {
    formEdit.classList.remove('active');
}
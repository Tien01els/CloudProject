const btnMenu = document.querySelector('.btn-menu');
const headerLeft = document.querySelector('.header-left');
const main = document.querySelector('#main');
const btnEdit = document.querySelector('.btn-edit');
const formEdit = document.querySelector('#form-edit');
const btnCloseForm = document.querySelector('.form-close')

btnMenu.onclick = () => {
    main.classList.toggle('mini-sidebar');
}

btnEdit.onclick = () => {
    formEdit.classList.add('active');
}
btnCloseForm.onclick = () => {
    formEdit.classList.remove('active');
}
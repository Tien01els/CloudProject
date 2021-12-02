const btnMenu = document.querySelector('.btn-menu');
const headerLeft = document.querySelector('.header-left');
const sidebar = document.querySelector('#sidebar');

btnMenu.onclick = () => {
    console.log('a');
    sidebar.classList.toggle('mini-sidebar');
}
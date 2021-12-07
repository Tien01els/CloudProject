const btnMenu = document.querySelector('.btn-menu');
const main = document.querySelector('#main');

btnMenu.onclick = () => {
    main.classList.toggle('mini-sidebar');
}
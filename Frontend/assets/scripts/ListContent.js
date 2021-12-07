import { URL } from './URL.js';

const btnEdits = document.querySelectorAll('.btn-edit');
const formEdit = document.querySelector('#form-edit');
const btnCloseForm = document.querySelector('.form-close');
const type = document.querySelector('input[type="hidden"]').value;
const tableBody = document.querySelector('table tbody');

btnEdits.forEach(btnEdit => {
    btnEdit.onclick = () => {
        formEdit.classList.add('active');
    }
})
btnCloseForm.onclick = () => {
    formEdit.classList.remove('active');
}

function ObjectLength(object) {
    var length = 0;
    for (var key in object) {
        if (object.hasOwnProperty(key)) {
            ++length;
        }
    }
    return length;
};

function getContent() {
    const api = URL + "/" + type + "/";
    console.log(api);
    $.get(api)
        .done(function(contents) {
            contents.forEach(content => {
                let tr = document.createElement('tr');
                for (let key in content) {
                    if (key !== 'account_id') {
                        let td = document.createElement('td');
                        td.innerHTML = content[key];
                        tr.append(td);
                    }
                }
                let td = document.createElement('td');
                td.innerHTML = `
                        <button class="btn btn-edit">
                            <i class="ri-pencil-fill"></i>
                        </button>
                        <button class="btn btn-delete">
                            <i class="ri-delete-bin-4-fill"></i>
                       </button>
                    </td>`
                tr.append(td);
                tableBody.append(tr);
            });
        })
        .fail(function() {
            console.log("error");
        })
}

getContent();
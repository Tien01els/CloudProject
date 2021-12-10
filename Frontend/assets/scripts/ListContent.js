import { URL } from './URL.js';
import getUser from './GetUser.js';

const btnEdits = document.querySelectorAll('.btn-edit');
const formEdit = document.querySelector('#form-edit');
const btnCloseForm = document.querySelector('.form-close');
const type = document.querySelector('input[type="hidden"]').value;
const tableBody = document.querySelector('table tbody');
if (btnEdits != null) {
    btnEdits.forEach(btnEdit => {
        btnEdit.onclick = () => {
            formEdit.classList.add('active');
        }
    })
}

if (btnCloseForm != null) {
    btnCloseForm.onclick = () => {
        formEdit.classList.remove('active');
    }
}

function getContent() {
    getUser()
        .then(user => {
            let api;
            if (type === 'score') {
                api = URL + '/' + type + '/' + user.key_userid;
            } else
                api = URL + "/" + type + "/";
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
                        if (user.key_userrole == 'student' && type == 'score') {
                            td.innerHTML = `
                        <button class="btn btn-edit">
                            <i class="ri-checkbox-circle-fill"></i>
                        </button>
                        <button class="btn btn-delete">
                            <i class="ri-delete-bin-4-fill"></i>
                       </button>
                    </td>`
                        }
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
        })
}

getContent();
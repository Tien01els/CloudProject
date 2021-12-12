import { URL } from './URL.js';
import getUser from './GetUser.js';


const formEdit = document.querySelector('#form-edit');
const btnCloseForm = document.querySelector('.form-close');
const type = document.querySelector('input[type="hidden"]').value;
const registered = document.querySelector('input[type="hidden"]').get;
const tableBody = document.querySelector('table tbody');
const tableBodyModal = document.querySelector('.modal-container table tbody');


if (btnCloseForm != null) {
    btnCloseForm.onclick = () => {
        formEdit.classList.remove('active');
    }
}

function getContent() {
    getUser()
        .then(user => {
            let api;
            if (user.key_userrole == 'student' && type === 'score' || user.key_userrole == 'teacher' && type == 'course') {
                api = URL + '/' + type + '/' + user.key_userid;

            } else
                api = URL + "/" + type + "/";
            console.log(api);
            $.get(api)
                .done(function(contents) {
                    contents.forEach(content => {
                        let tr = document.createElement('tr');
                        const contentOrder = Object.keys(content).sort().reduce(
                            (obj, key) => {
                                obj[key] = content[key];
                                return obj;
                            }, {}
                        );
                        for (let key in contentOrder) {
                            if (user.key_userrole == 'teacher' && type == 'course' && 'teacher_id' == key) {
                                continue;
                            }
                            if (key !== 'account_id') {
                                let td = document.createElement('td');
                                td.innerHTML = contentOrder[key];
                                tr.append(td);
                            }
                        }
                        let td = document.createElement('td');
                        if (user.key_userrole == 'student' && type == 'score') {
                            if (content.scores == null) {
                                tableBody.append(tr);
                                return;
                            } else if (content.scores >= 5) {
                                td.innerHTML = `
                                    <td>
                                        <i class="ri-check-circle-line"></i>
                                    </td>`
                            } else if (content.scores < 5) {
                                td.innerHTML = `
                                    <td>
                                        <i class="ri-close-circle-line"></i>
                                    </td>`
                            }
                        } else if (user.key_userrole == 'teacher' && type == 'course') {
                            td.innerHTML = `
                            <td>
                                <button class="btn btn-mark" data-index=${content.course_id} data-course=${content.name}>
                                    <i class="ri-calendar-check-line"></i>
                                </button>
                                <button class="btn btn-delete" data-index=${content.course_id}>
                                    <i class="ri-delete-bin-4-fill"></i>
                                </button>
                            </td>`
                        } else {
                            td.innerHTML = `
                            <td>
                                <button class="btn btn-edit" data-index=${content.course_id}>
                                    <i class="ri-pencil-fill"></i>
                                </button>
                                <button class="btn btn-delete" data-index=${content.course_id}>
                                    <i class="ri-delete-bin-4-fill"></i>
                                </button>
                            </td>`
                        }
                        tr.append(td);
                        tableBody.append(tr);
                    });
                    const btnEdits = document.querySelectorAll('.btn-edit');
                    if (btnEdits != null) {
                        if (type === 'course' && user.key_userrole == 'student') {
                            btnEdits.forEach(btnEdit => {
                                btnEdit.onclick = () => {
                                    const courseId = btnEdit.getAttribute('data-index');
                                    let api = URL + '/score/check';
                                    let data = {
                                        'student_id': user.key_userid,
                                        'course_id': courseId,
                                        'score': '',
                                    }
                                    $.ajax({
                                            type: 'POST',
                                            url: api,
                                            contentType: 'application/json',
                                            data: JSON.stringify(data), // access in body
                                        })
                                        .done(contents => {
                                            console.log(contents);
                                            if (contents === 'Registered')
                                                alert('Registered');
                                            else {
                                                let api = URL + '/score/';
                                                $.ajax({
                                                        type: 'POST',
                                                        url: api,
                                                        contentType: 'application/json',
                                                        data: JSON.stringify(data), // access in body
                                                    })
                                                    .done(contents => {
                                                        alert('Registered Success');
                                                    })
                                            }

                                        })
                                }
                            })
                        } else {
                            btnEdits.forEach(btnEdit => {
                                btnEdit.onclick = () => {
                                    formEdit.classList.add('active');
                                }
                            })
                        }
                    }
                    const btnMarks = document.querySelectorAll('.btn-mark');
                    if (btnMarks != null) {
                        btnMarks.forEach(btnMark => {
                            console.log(btnMark);
                            const courseId = btnMark.getAttribute('data-index');
                            btnMark.onclick = () => {
                                const formModalTitleID = document.querySelector('.modal-container .form-title .course-id');
                                formModalTitleID.innerHTML = `${btnMark.getAttribute('data-index')}`;
                                const formModalTitleCourse = document.querySelector('.modal-container .form-title .course-name');
                                formModalTitleCourse.innerHTML = `${btnMark.getAttribute('data-course')}`;
                                formEdit.classList.add('active');
                                api = URL + '/score/course/' + courseId;
                                console.log(api);
                                $.get(api)
                                    .done(function(contents) {
                                        const ths = document.querySelectorAll('.modal-container th');
                                        const trs = document.querySelectorAll('.modal-container tr:not(tr:first-child)');
                                        for (let tr of trs) {
                                            tr.innerHTML = '';
                                        }
                                        contents.forEach(content => {
                                            let tr = document.createElement('tr');

                                            for (let key of ths) {
                                                if (key.classList.value != 'scores') {
                                                    let td = document.createElement('td');
                                                    td.classList.add(key.classList.value + '-td');
                                                    td.innerHTML = content[key.classList];
                                                    tr.append(td);
                                                }
                                            }
                                            let td = document.createElement('td');
                                            td.innerHTML = `
                                                <td>
                                                    <input type="number" id="quantity" class='scores-td' name="quantity" min="0" max="100" value="${content['scores']}">
                                                </td>`;
                                            tr.append(td);
                                            tableBodyModal.append(tr);
                                        })
                                    })
                                    .fail(function() {
                                        console.log("error");
                                    })
                            }
                        })
                    }
                    const btnDeletes = document.querySelectorAll('.btn-delete');
                    if (btnDeletes != null) {
                        if (type === 'course' && user.key_userrole == 'student') {
                            btnDeletes.forEach(btnDelete => {
                                btnDelete.onclick = () => {
                                    const courseId = btnDelete.getAttribute('data-index');
                                    let api = URL + '/score';
                                    let data = {
                                        'student_id': user.key_userid,
                                        'course_id': courseId,
                                        'score': '',
                                    }
                                    $.ajax({
                                            type: 'DELETE',
                                            url: api,
                                            contentType: 'application/json',
                                            data: JSON.stringify(data), // access in body
                                        })
                                        .done(contents => {
                                            console.log('oke');
                                        })
                                }
                            })
                        } else {
                            btnDeletes.forEach(btnDelete => {
                                btnDelete.onclick = () => {
                                    const courseId = btnDelete.getAttribute('data-index');
                                    let api = URL + '/' + type + '/' + courseId;
                                    $.ajax({
                                            type: 'DELETE',
                                            url: api,
                                            contentType: 'application/json',
                                        })
                                        .done(contents => {
                                            console.log('oke');
                                        })
                                }
                            })
                        }
                    }
                })
                .fail(function() {
                    console.log("error");
                })
        })
}

getContent();
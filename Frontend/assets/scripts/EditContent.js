import getUser from './GetUser.js';
import { URL } from './URL.js';

const btnSubmit = document.querySelector('.btn-submit');
const inputs = document.querySelectorAll('.form-input');
const btnSubmitScores = document.querySelector('.modal-scores .btn-submit');

if (btnSubmitScores) {
    btnSubmitScores.onclick = (e) => {
        e.preventDefault();
        const courseId = document.querySelector('.modal-scores .form-title .course-id').innerHTML;
        const studentIds = document.querySelectorAll('.modal-scores .student_id-td');
        const scores = document.querySelectorAll('.modal-scores .scores-td');
        let data = [];
        studentIds.forEach((studentId, index) => {
            data.push({
                'course_id': courseId,
                'student_id': studentId.innerHTML,
                'scores': scores[index].value,
            });
        });
        const api = URL + '/score';
        $.ajax({
                type: 'PUT',
                url: api,
                contentType: 'application/json',
                data: JSON.stringify(data), // access in body
            })
            .done(function(data) {
                console.log(data);
            })
            .fail(function() {
                console.log("error");
            })
    }
} else if (btnSubmit) {
    btnSubmit.onclick = (e) => {
        e.preventDefault();
        var value = {};
        inputs.forEach(input => {
            Object.assign(value, {
                [input.getAttribute('name')]: input.value
            });
        });
        editObjects(value);
    }
}



function editObjects(data) {
    getUser()
        .then(user => {
            let api;
            api = URL + '/' + user.key_userrole + '/' + user.key_userid;
            $.ajax({
                    type: 'PUT',
                    url: api,
                    contentType: 'application/json',
                    data: JSON.stringify(data), // access in body
                })
                .done(function(data) {
                    console.log(data);
                })
                .fail(function() {
                    console.log("error");
                })
        });

}

getUser()
    .then(user => {
        const api = URL + '/' + user.key_userrole + '/' + user.key_userid;
        $.ajax({
                type: 'GET',
                url: api,
                contentType: 'application/json'
            })
            .done(function(data) {
                inputs.forEach(input => {
                    input.value = data[input.getAttribute('name')]
                });
            })
            .fail(function() {
                console.log("error");
            })
    });
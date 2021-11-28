const tableUserList = document.querySelector('#table_userlist');
const tableBodyUserList = tableUserList.querySelector('tbody');



const table = {
    render: function() {
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8081/users',
            dataType: 'json',
            headers: {
                "Content-Type": "application/json",
                "Access-Control-Allow-Origin": "http://localhost:8081/users"
            },
            success: function(data) {
                const htmls = data.map((user) => {
                    return `
                    <tr data-index="${user.id}">
                        <td class="fullname">${user.fullname}</td>
                        <td class="gender">${user.gender}</td>
                        <td class="age">${user.age}</td>
                        <td class="email">${user.email}</td>
                        <td class="phone">${user.phone}</td>
                        <td>
                            <div class="actions">
                                <button class="btn btn-edit">
                                    <i class="ri-edit-2-line"></i>
                                </button>
                                <button class="btn btn-delete">
                                    <i class="ri-delete-bin-2-line"></i>
                                </button>
                            <div>
                        </td>
                    </tr>
                    `
                });

                function getGender() {
                    var ele = document.getElementsByName("gender");
                    for (let i = 0; i < ele.length; ++i) {
                        if (ele[i].checked)
                            return ele[i].value;
                    }
                };
                tableBodyUserList.innerHTML = htmls.join('');
                const btnEdits = document.querySelectorAll(".btn-edit");
                btnEdits.forEach((btnEdit) => {
                    btnEdit.addEventListener("click", (e) => {
                        e.preventDefault();

                        const trEdit = e.target.parentElement.parentElement.parentElement.parentElement;;

                        var Model = {
                            id: trEdit.dataset.index,
                            fullname: trEdit.querySelector(".fullname").innerText,
                            gender: trEdit.querySelector(".gender").innerText,
                            age: trEdit.querySelector(".age").innerText,
                            email: trEdit.querySelector(".email").innerText,
                            phone: trEdit.querySelector(".phone").innerText
                        };


                        document.querySelector('#mid').style.display = 'none';
                        const htmlEditProfileRender = `
                            <div id="mid">
                                <form>
                                    <div class="h1_add">
                                        <h1>Edit An Employee</h1>
                                    </div>
                                    <div class="wrapper">
                                        <div class="content">
                                            <p>Full Name:</p>
                                            <input type="text" name="fullname" id="id_fullname" placeholder="Enter full name" value="${Model.fullname}">
                                        </div>
                                        <div class="content">
                                            <div class="flex-container">
                                                <div class="flex-child">
                                                    <p>Gender:</p>
                                                </div>
                                                <div class="flex-child">
                                                    <input type="radio" name="gender" value="male" checked>
                                                    <label for="male">Male</label>
                                                    <input type="radio" name="gender" value="female">
                                                    <label for="female">Female</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="content">
                                            <p>Age:</p>
                                            <input type="text" name="age" id="id_age" placeholder="Enter age" value="${Model.age}">
                                        </div>
                                        <div class="content">
                                            <p>Email:</p>
                                            <input type="text" name="email" id="id_email" placeholder="Enter email" value="${Model.email}">
                                        </div>
                                        <div class="content">
                                            <p>Phone:</p>
                                            <input type="text" name="phone" id="id_phone" placeholder="Enter phone number" value="${Model.phone}">
                                        </div>
                                        <div class="content">
                                            <input type="submit" id="btn_edit" class="button" name="Edd" value="Edit Employee"">
                                        </div>
                                        <p id="demo"></p>
                                    </div>
                                </form>
                                <!-- <button onclick="myFunction()">Click me</button> -->
                            </div>`
                        document.querySelector('.content').innerHTML = htmlEditProfileRender;
                        const btnEdit = document.querySelector('#btn_edit');


                        btnEdit.onclick = (e) => {
                            e.preventDefault();
                            var ModelEdit = {
                                fullname: document.querySelector('#id_fullname').value,
                                gender: getGender(),
                                age: document.querySelector('#id_age').value,
                                email: document.querySelector('#id_email').value,
                                phone: document.querySelector('#id_phone').value
                            }
                            var requestJSONEdit = JSON.stringify(ModelEdit);
                            $.ajax({
                                type: 'PUT',
                                url: 'http://localhost:8081/users/' + Model.id,
                                dataType: 'json',
                                headers: {
                                    "Content-Type": "application/json",
                                    "Access-Control-Allow-Origin": "http://localhost:8081/users"
                                },
                                data: requestJSONEdit,
                                success: function(data) {
                                    console.log(data);
                                    location.href = "UserList.html";
                                },
                                error: function() {
                                    console.log("The following error occured: ");
                                }
                            });
                        }
                    })
                });

                const btnDeletes = document.querySelectorAll(".btn-delete");

                btnDeletes.forEach((btnDelete) => {
                    btnDelete.addEventListener("click", (e) => {
                        e.preventDefault();

                        const trEdit = e.target.parentElement.parentElement.parentElement.parentElement;
                        console.log(trEdit);


                        var Model = {
                            id: trEdit.dataset.index,
                            // fullname: trEdit.querySelector(".fullname").innerText,
                            // gender: trEdit.querySelector(".gender").innerText,
                            // age: trEdit.querySelector(".age").innerText,
                            // email: trEdit.querySelector(".email").innerText,
                            // phone: trEdit.querySelector(".phone").innerText
                        };

                        console.log(Model);
                        var requestJSON = JSON.stringify(Model);

                        $.ajax({
                            type: 'DELETE',
                            url: 'http://localhost:8081/users/' + Model.id,
                            dataType: 'json',
                            headers: {
                                "Content-Type": "application/json",
                                // "Access-Control-Allow-Origin": "http://localhost:8081/users"
                            },
                            data: requestJSON,
                            success: function(data) {
                                console.log(data);
                            },
                            error: function() {
                                console.log("The following error occured: ");
                            }
                        });
                    })
                });
            },
            error: function() {
                console.log("The following error occured: ");
            }
        });

    }
}

table.render();
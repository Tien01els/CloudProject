const tableUserList = document.querySelector('#table_userlist');
const tableBodyUserList = tableUserList.querySelector('tbody');

const table = {
    // users: [{
    //     id: 1,
    //     Fullname: 'Tien',
    //     Gender: 'male',
    //     Age: 18,
    //     Email: 'tien@gmail.com',
    //     Phone: '123-456',
    // }, {
    //     id: 2,
    //     Fullname: 'Tien',
    //     Gender: 'male',
    //     Age: 18,
    //     Email: 'tien@gmail.com',
    //     Phone: '123-456',
    // }],
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
                        <td class="fullname">${user.Fullname}</td>
                        <td class="gender">${user.Gender}</td>
                        <td class="age">${user.Age}</td>
                        <td class="email">${user.Email}</td>
                        <td class="phone">${user.Phone}</td>
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
                })
                tableBodyUserList.innerHTML = htmls.join('');
            },
            error: function() {
                console.log("The following error occured: ");
            }
        });

    }
}

table.render();


const btnEdits = document.querySelectorAll(".btn-edit");
btnEdits.forEach((btnEdit) => {
    btnEdit.addEventListener("click", (e) => {
        e.preventDefault();

        const trEdit = e.target.parentElement.parentElement.parentElement;

        var Model = {
            id: trEdit.dataset.index,
            fullname: trEdit.querySelector(".fullname").innerText,
            gender: trEdit.querySelector(".gender").innerText,
            age: trEdit.querySelector(".age").innerText,
            email: trEdit.querySelector(".email").innerText,
            phone: trEdit.querySelector(".phone").innerText
        };

        console.log(Model);
        var requestJSON = JSON.stringify(Model);

        $.ajax({
            type: 'PUT',
            url: 'http://localhost:8081/users' + Model.id,
            dataType: 'json',
            headers: {
                "Content-Type": "application/json",
                "Access-Control-Allow-Origin": "http://localhost:8081/users"
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

const btnDeletes = document.querySelectorAll(".btn-delete");
btnDeletes.forEach((btnDelete) => {
    btnDelete.addEventListener("click", (e) => {
        e.preventDefault();

        const trEdit = e.target.parentElement.parentElement.parentElement;

        var id = trEdit.dataset.index;

        console.log(id);
        var requestJSON = JSON.stringify(id);

        $.ajax({
            type: 'DELETE',
            url: 'http://localhost:8081/users/' + id,
            dataType: 'json',
            headers: {
                "Content-Type": "application/json",
                "Access-Control-Allow-Origin": "http://localhost:8081/users"
            },
            success: function(data) {
                console.log(data);
            },
            error: function() {
                console.log("The following error occured: ");
            }
        });
    })
});
const btnMenu = document.querySelector('.btn-menu');
const main = document.querySelector('#main');


btnMenu.onclick = () => {
    main.classList.toggle('mini-sidebar');
}



function getObject() {
    // var valueObjects = Objects.map(Object => ({ Object: Object.value }));
    $.post("api")
        .done(function(data) {
            console.log(data);
        })
        .fail(function() {
            alert("error");
        })
        .always(function() {
            alert("complete");
        });
}

function addObject(Objects) {
    var valueObjects = Objects.map(Object => ({ Object: Object.value }));
    // $.post("api", {...valueObjects })
    //     .done(function(data) {
    //         console.log(data);
    //     })
    //     .fail(function() {
    //         alert("error");
    //     })
    //     .always(function() {
    //         alert("complete");
    //     });
}
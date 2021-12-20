import { URL } from "./URL.js";
import getUser from "./GetUser.js";
import { generateUploadURL } from "./s3.js";

const imageBtn = document.querySelector(".btn-avatar");
const imageInput = document.querySelector("#image-avatar");
const avatar = document.querySelector("#avatar");

import { getStorage, ref as sRef, uploadBytesResumable, getDownloadURL } from "https://www.gstatic.com/firebasejs/9.6.1/firebase-storage.js";
console.log(imageInput);

imageInput.onchange = () => {
    console.log(imageInput.value);
    avatar.src = "https://thumbs.dreamstime.com/b/default-avatar-profile-icon-vector-social-media-user-image-182145777.jpg";
};

// imageForm.addEventListener("submit", (event) => {
//     event.preventDefault();
//     const file = imageInput.files[0];
//     uploadFileImage(file);
// });

function uploadFileImage(file) {
    const url = generateUploadURL();
    console.log(url);
}

function uploadFile(file) {
    const metadata = {
        contentType: file.type,
    };
    const storage = getStorage();
    const storageRef = sRef(storage, "Musics/" + file.name);
    const UploadTask = uploadBytesResumable(storageRef, file, metadata);
    const modal = document.querySelector(".js-modal");

    UploadTask.on(
        "state-changed",
        () => {},
        (error) => {
            console.error;
        },
        () => {
            getUser().then((user) => {
                getDownloadURL(UploadTask.snapshot.ref).then((firebaseURL) => {
                    console.log(firebaseURL);
                    // const api = URL + "/music/insert";
                    // $.post(api, { name: file.name, link: firebaseURL, userId: user.id, singer: file.singer })
                    //     .done(function (data) {
                    //         console.log(data);
                    //         mainApp.songs = [];
                    //         // mainApp.getSongs();
                    //         uploadFileImage({ link: firebaseURL, image: file.image });
                    //         mainHome.getNewMusic();
                    //         mainHome.getTopMusic(user.pageCurrent);
                    //         modal.classList.remove("open");
                    //     })
                    //     .fail(function () {
                    //         console.log("error");
                    //     });
                });
            });
        }
    );
}

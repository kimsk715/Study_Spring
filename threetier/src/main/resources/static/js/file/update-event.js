// const fileWrap = document.getElementById("file-wrap");

// input 태그 1개(multiple)
// const file = document.querySelector("input.file");
//
// file.addEventListener("change", (e) =>{
//     FileList.prototype.forEach = Array.prototype.forEach;
//     e.target.files.forEach(async (file) => {
//         const formData = new FormData();
//         formData.append("file", file);
//         await fileService.upload(formData);
//     });
// })

// input태그 여러개
// const files = document.querySelectorAll("input.file");
// files.forEach((file) => {
//     file.addEventListener("change", async (e) => {
//         const file = e.target.files[0];
//         const formData = new FormData();
//         formData.append("file", file);
//         await fileService.upload(formData);
//     });
// });

const fileWrap = document.getElementById("file-wrap");
const resetButton = document.getElementById("reset");
const updateOkButton = document.getElementById("update-ok");
let deleteFiles = [];

post.postFiles.forEach((postFile) => {
    const a = document.createElement("a");
    const img = document.createElement("img");

    a.href = postFile.id;

    img.classList.add("thumbnail_file")
    img.src = `/files/display?path=${postFile.filePath + "/t_" + postFile.fileName}`;
    img.style.width = "100px";

    a.appendChild(img)
    fileWrap.appendChild(a);
});

fileWrap.addEventListener("click", (e) => {
    e.preventDefault();
    if(e.target.classList.contains("thumbnail_file")){
        deleteFiles.push(e.target.parentElement.getAttribute("href"));
        e.target.parentElement.style.display = "none";
        console.log(deleteFiles);
    }
});

resetButton.addEventListener("click", (e) => {
    const thumbnailFiles = document.querySelectorAll("img.thumbnail_file");
    thumbnailFiles.forEach((thumbnailFile) => {
        thumbnailFile.parentElement.style.display = "inline-block";
    });
    deleteFiles = [];
})

updateOkButton.addEventListener("click", (e) => {
    const form = document["update-form"];
    deleteFiles.forEach((id) => {
        const input = document.createElement("input");
        input.type = "hidden";
        input.name = "file-id";
        input.value = id;
        form.appendChild(input);
    });

    form.submit();
})
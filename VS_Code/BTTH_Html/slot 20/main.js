let form = document.getElementById("form");
let textInput = document.getElementById("textInput");
let dateInput = document.getElementById("dateInput");
let textarea = document.getElementById("textarea");
let msg = document.getElementById("msg");
let tasks = document.getElementById("tasks");
let add = document.getElementById("add");
form.addEventListener("submit", (e) => {
    e.preventDefault();
    formValidation();
});

let formValidation = () => {
    if (textInput.value === "") {
        console.log("failure");
        msg.innerHTMl = "task cannot be blank";
    } else {
        console.log("success");
        msg.innerHTML = "";
        acceptData();
        add.setAttribute("data-bs-dismiss", "modal");
        add.click();

        (() => {
            add.setAttribute("date-bs-dismiss", "");
        })();
    }
};

let data = [{}];
let acceptData = () => {
    data.push({
        text: textInput.value,
        date: dateInput.value,
        description: textarea.value,
    });
    localStorage.setItem("data", JSON.stringify(data));
    console.log(data);
    createTasks();
};
let createTasks = () => {
    tasks.innerHTML = "";
    data.map((x, y) => {
        return (tasks.innerHTML += 
            <div id={y}>
                <span class="fw-bold">${x.text}</span>
                <span class="smail text-secondary">${x.date}</span>
                <p>${x.description}</p>
                <span class="options">
                    <i onclick="editTask(this)" data-bs-toggle="modal" data-bs-target="#from" class="fas fa-edit"></i>
                    <i onclick="deleteTask(this);createTask()" class="fas fa-trash-alt"></i>
                </span>
            </div>
       );
    });
    resetForm();
};
let deleteTask = (e) => {
    e.parentElement.parentElement.remove();
    data.splice(e.parentElement.parentElement.id, 1);
    localStorage.setItem("data", JSON.stringify(data));
    console.log(data);
}
let editTask = (e) => {
    let seclectedTask = e.parentElement.parentElement;
    textInput.value = seclectedTask.children[0].innerHTML;
    dateInput.value = seclectedTask.children[1].innerHTML;
    textarea.value = seclectedTask.children[2].innerHTML;
    deleteTasks(e);
};
let resetFrom = () => {
    textInput.value = "";
    dateInput.value = "";
    textarea.value = "";
};
(() => {
    data = JSON.parse(localStorage.getItem("data")) || []
    console.log(data);
    createTasks();
})();
function taskCreateModalOpen(){
    var modalClass = document.getElementById('taskCreateModal');
    modalClass.classList.remove("hidden");
};

function taskCreateModalClose(){
    var modalClass = document.getElementById("taskCreateModal");
    modalClass.classList.add("hidden");
};

function taskEditModalOpen(){
    var modalClass = document.getElementById('taskEditModal');
    modalClass.classList.remove("hidden");
};

function taskEditModalClose(){
    var modalClass = document.getElementById("taskEditModal");
    modalClass.classList.add("hidden");
};
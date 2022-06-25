window.onload = function() {
    var createResult = document.getElementById('createResult').value;
    if(createResult){
        userCreateResultModalOpen();
    }
};

function userCreateResultModalOpen(){
    var modalClass = document.getElementById('modal');
    modalClass.classList.remove("hidden");
};

function userCreateResultModalClose(){
    var modalClass = document.getElementById("modal");
    modal.classList.add("hidden");
};
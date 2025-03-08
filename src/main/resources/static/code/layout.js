document.addEventListener("DOMContentLoaded",()=>{

    const typeButton = document.querySelector('.type');
    const optionsList = document.querySelectorAll('.dropdown-types-list button');

    let activeOperation = null;

    optionsList.forEach( op => {
        op.addEventListener('click', event => {
            event.preventDefault();
            typeButton.textContent = op.textContent;
        })
    });

    const compButton = document.querySelector(".compress-button");
    const decompButton = document.querySelector(".decompress-button");
    compButton.addEventListener("click", function (){
        toggleDropDownList();
        toggleUploadBar();
    });

    decompButton.addEventListener("click", ()=>{
        activeOperation = "Decompression";
        toggleUploadBar();
        let visible = document.querySelector("#ListOfTypes");
        if(visible){
            visible.classList.remove("show");
            visible.classList.add("hide");
        }
        else {
            visible.classList.remove("hide");
            visible.classList.add("show");
        }
    });

    typeButton.addEventListener("click", ()=>{
        toggleUploadBar();
        optionsList.forEach( op => {
            op.addEventListener('click', event => {
                toggleUploadBar();
            })
        });
    })

    const dropdownContainer = document.querySelector("#ListOfTypes");
    const upSection = document.querySelector(".upload-section");

    dropdownContainer.addEventListener("mouseenter", () => {
        upSection.style.marginTop = "230px";
    });

    dropdownContainer.addEventListener("mouseleave", () => {
        upSection.style.marginTop = "0px";
    });
})

function toggleUploadBar() {
    let pressed = document.querySelector("#up-sec");
    if (pressed) pressed.classList.toggle("upload-section");
}

function toggleDropDownList() {
    let pressed = document.querySelector("#ListOfTypes");
    if (pressed) pressed.classList.toggle("show");
}



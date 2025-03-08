document.querySelector(".compress-button").addEventListener("click", async function(event){
    event.preventDefault();
    document.querySelector(".compress-button").classList.add("active");
    document.querySelector(".decompress-button").classList.remove("active");
})

document.querySelector(".submit").addEventListener("click", async function () {
    if (!document.querySelector(".compress-button").classList.contains("active")) {
        return;
    }

    const fileInput = document.querySelector(".upload");
    const file = fileInput.files[0];

    if (!file) {
        alert('Please select a file.');
        return;
    }

    const compressionType = document.querySelector('.type').textContent;

    const formData = new FormData();
    formData.append('file', file);
    formData.append('operation',"compression");
    formData.append('compressionType', compressionType);

    try {
        const response = await fetch('/api/generate', {
            method: 'POST',
            body: formData
        });

        if (!response.ok) {
            const errorText = await response.text();
            console.error("Server Error:", errorText);
            alert(`Failed to process the file. Server response: ${errorText}`);
            return;
        }

        const blob = await response.blob();
        const url = window.URL.createObjectURL(blob);
        const a = document.createElement('a');
        a.href = url;
        a.download = file.name + "." + compressionType;
        document.body.appendChild(a);
        a.click();
        document.body.removeChild(a);
        window.URL.revokeObjectURL(url);
    } catch (error) {
        console.error('Error:', error);
        alert('An error occurred while processing the file.');
    }
})

document.querySelectorAll(".dropdown-types-list").forEach(button => {
    button.addEventListener("click", function(event) {
        event.preventDefault();
        document.querySelector(".type").dataset.type = button.dataset.type;
    });
});
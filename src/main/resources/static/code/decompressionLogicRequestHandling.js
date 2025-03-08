document.querySelector(".decompress-button").addEventListener("click", async function(event){
    event.preventDefault();
    document.querySelector(".decompress-button").classList.add("active");
    document.querySelector(".compress-button").classList.remove("active");
});

document.querySelector(".submit").addEventListener("click", async function () {
    if (!document.querySelector(".decompress-button").classList.contains("active")) {
        return;
    }

    const inputFile = document.querySelector(".upload");
    const file = inputFile.files[0];

    if (!file){alert("Please select a file."); return;}

    const formData = new FormData();
    formData.append('file', file);
    formData.append('operation',"decompression");

    try{
        const response = await fetch('/api/generate', {
            method : 'POST',
            body: formData
        });

        if(!response.ok){
            const errorTXT = await response.text();
            console.error("Server Error:", errorTXT);
            alert(`Failed to process the file. Server response: ${errorTXT}`);
            return;
        }

        const blob = await response.blob();
        const url = window.URL.createObjectURL(blob);
        const anchorElement = document.createElement('a');
        anchorElement.href = url;
        anchorElement.download = file.name.substring(0, file.name.lastIndexOf("."));
        document.body.appendChild(anchorElement);
        anchorElement.click();
        document.body.removeChild(anchorElement);
        window.URL.revokeObjectURL(url);
    } catch(error){
        console.error('Error:', error);
        alert('An error occurred while processing the file.');
    }
})
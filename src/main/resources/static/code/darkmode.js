let darkmode = localStorage.getItem('darkmode');

const enableSwitch = () => {
    document.body.classList.add('darkmode');
    localStorage.setItem('darkmode', 'active');
}

const disableSwitch = () => {
    document.body.classList.remove('darkmode');
    localStorage.setItem('darkmode',null);
}

if ('darkmode' === 'active') enableSwitch();

let lightAndDark = document
    .getElementById('light-on-off')
    .addEventListener('click', () => {
        darkmode = localStorage.getItem('darkmode');
        darkmode !=='active' ? enableSwitch() : disableSwitch() ;
})

lightAndDark = document.addEventListener("DOMContentLoaded",()=>{
    darkmode = localStorage.getItem('darkmode');
    if (darkmode === 'active') enableSwitch();
});
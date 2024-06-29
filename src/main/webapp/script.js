document.addEventListener('DOMContentLoaded', function() {
    const helpSection = document.querySelector('.help-section');
    const mainSection = document.querySelector('.main-section');

    setTimeout(() => {
        helpSection.style.display = 'block';
        helpSection.style.transform = 'translateY(0)';
    }, 3000);
});

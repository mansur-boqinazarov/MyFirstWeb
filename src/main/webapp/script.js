document.addEventListener('DOMContentLoaded', () => {
    // Add event listeners to buttons for additional interactive effects
    const buttons = document.querySelectorAll('.animated-button');

    buttons.forEach(button => {
        button.addEventListener('mouseover', () => {
            button.style.transform = 'scale(1.2)';
            button.style.boxShadow = '0 0 20px rgba(0, 140, 186, 0.5)';
        });

        button.addEventListener('mouseout', () => {
            button.style.transform = 'scale(1)';
            button.style.boxShadow = 'none';
        });

        button.addEventListener('mousedown', () => {
            button.style.transform = 'scale(1)';
            button.style.boxShadow = 'inset 0 0 10px rgba(0, 0, 0, 0.3)';
        });

        button.addEventListener('mouseup', () => {
            button.style.transform = 'scale(1.2)';
            button.style.boxShadow = '0 0 20px rgba(0, 140, 186, 0.5)';
        });
    });

    // Add a fade-in effect to the main content on page load
    const mainSection = document.querySelector('.main-section');
    mainSection.style.opacity = 0;
    setTimeout(() => {
        mainSection.style.transition = 'opacity 1.5s';
        mainSection.style.opacity = 1;
    }, 500);

    // Add smooth scroll to the help link
    const helpLink = document.querySelector('.help-section a');
    helpLink.addEventListener('click', (e) => {
        e.preventDefault();
        const targetId = e.target.getAttribute('href');
        window.scrollTo({
            top: document.querySelector(targetId).offsetTop,
            behavior: 'smooth'
        });
    });
});

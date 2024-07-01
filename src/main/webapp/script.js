class MainMenu {
    constructor() {
        this.init();
    }

    init() {
        this.addButtonEffects();
        this.addScrollEffects();
    }

    addButtonEffects() {
        const buttons = document.querySelectorAll('.animated-button');

        buttons.forEach(button => {
            button.addEventListener('mouseenter', () => {
                button.style.transform = 'scale(1.1)';
                button.style.boxShadow = '0 0 10px #333';
            });

            button.addEventListener('mouseleave', () => {
                button.style.transform = 'scale(1)';
                button.style.boxShadow = 'none';
            });
        });
    }

    addScrollEffects() {
        window.addEventListener('scroll', () => {
            const header = document.querySelector('.header');
            const scrollY = window.scrollY;

            if (scrollY > 50) {
                header.style.background = 'rgba(0, 0, 0, 0.7)';
            } else {
                header.style.background = 'rgba(0, 0, 0, 0.5)';
            }
        });
    }
}

// Initialize the MainMenu class when the document is ready
document.addEventListener('DOMContentLoaded', () => {
    new MainMenu();
});

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main Menu</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
    <style>
        body {
            background: #141E30; /* fallback for old browsers */
            background: -webkit-linear-gradient(to right, #243B55, #141E30); /* Chrome 10-25, Safari 5.1-6 */
            background: linear-gradient(to right, #243B55, #141E30);
            font-family: 'Arial', sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        .header {
            margin-bottom: 50px;
            text-align: center;
        }

        .header h1 {
            color: #fff;
            font-size: 3em;
            margin: 0;
            text-shadow: 0 0 10px rgba(255, 255, 255, 0.7);
        }

        .main-section {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .button-container {
            display: flex;
            flex-direction: row;
            gap: 20px;
            margin-top: 20px;
        }

        .animated-button {
            background: transparent;
            border: 2px solid #00bcd4;
            color: #00bcd4;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            transition: all 0.3s ease;
            position: relative;
            overflow: hidden;
        }

        .animated-button:hover {
            background: #00bcd4;
            color: #fff;
            box-shadow: 0 0 10px #00bcd4, 0 0 20px #00bcd4, 0 0 30px #00bcd4;
        }

        .help-section {
            margin-top: 40px;
            text-align: center;
        }

        .help-section a {
            color: #8be3e3;
            font-size: 1.2em;
            text-decoration: none;
            transition: color 0.3s, transform 0.3s;
        }

        .help-section a:hover {
            color: #2e538f;
            transform: scale(1.1);
        }

    </style>
</head>
<body>
<header class="header animate__animated animate__fadeInDown">
    <h1 class="animate__animated animate__pulse animate__infinite">MAIN MENU</h1>
</header>
<section class="main-section">
    <div class="button-container">
        <a href="/loginPage">
            <button type="button" class="animated-button animate__animated animate__fadeInUp">Login</button>
        </a>
        <a href="/signupPage">
            <button type="button" class="animated-button animate__animated animate__fadeInUp">Sign Up</button>
        </a>
    </div>
</section>
<script>
    document.addEventListener('DOMContentLoaded', (event) => {
        const buttons = document.querySelectorAll('.animated-button');

        buttons.forEach(button => {
            button.addEventListener('click', () => {
                button.classList.add('animate__animated', 'animate__heartBeat');
                setTimeout(() => {
                    button.classList.remove('animate__animated', 'animate__heartBeat');
                }, 1000);
            });
        });
    });
</script>
</body>
</html>

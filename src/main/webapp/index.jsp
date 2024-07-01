<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main Menu</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
    <style>
        body {
            background-color: #f0fdfd;
            background-size: cover;
            margin: 0;
            font-family: 'Arial', sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            overflow: hidden;
            animation: backgroundFade 10s infinite alternate;
        }
        @keyframes backgroundFade {
            0% { filter: brightness(1); }
            100% { filter: brightness(0.7); }
        }
        .header {
            background: rgba(0, 0, 0, 0.5);
            width: 100%;
            padding: 20px;
            text-align: center;
            animation: slideDown 1s ease-out;
        }
        @keyframes slideDown {
            from { transform: translateY(-100%); }
            to { transform: translateY(0); }
        }
        .header h1 {
            color: #fff;
            font-size: 3em;
            margin: 0;
            animation: textGlow 2s infinite alternate;
        }
        @keyframes textGlow {
            0% { text-shadow: 0 0 10px #fff, 0 0 20px #fff, 0 0 30px #ff00ff, 0 0 40px #ff00ff, 0 0 50px #ff00ff, 0 0 60px #ff00ff, 0 0 70px #ff00ff; }
            100% { text-shadow: 0 0 20px #fff, 0 0 30px #ff00ff, 0 0 40px #ff00ff, 0 0 50px #ff00ff, 0 0 60px #ff00ff, 0 0 70px #ff00ff, 0 0 80px #ff00ff; }
        }
        .main-section {
            display: flex;
            flex-direction: column;
            align-items: center;
            animation: bounceIn 2s;
        }
        @keyframes bounceIn {
            0%, 20%, 40%, 60%, 80%, 100% { transform: translateY(0); }
            50% { transform: translateY(-20px); }
            70% { transform: translateY(10px); }
            90% { transform: translateY(-5px); }
        }
        .button-container {
            display: flex;
            gap: 20px;
            margin-top: 20px;
            animation: fadeInUp 1.5s ease-out;
        }
        @keyframes fadeInUp {
            from { transform: translateY(50px); opacity: 0; }
            to { transform: translateY(0); opacity: 1; }
        }
        .animated-button {
            background-color: #008CBA;
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            transition: transform 0.2s, box-shadow 0.2s;
            border-radius: 5px;
            cursor: pointer;
            position: relative;
            overflow: hidden;
            animation: pulseButton 2s infinite;
        }
        @keyframes pulseButton {
            0% { box-shadow: 0 0 0 0 rgba(0, 140, 186, 0.7); }
            70% { box-shadow: 0 0 10px 20px rgba(0, 140, 186, 0); }
            100% { box-shadow: 0 0 0 0 rgba(0, 140, 186, 0); }
        }
        .animated-button::before {
            content: '';
            position: absolute;
            top: 50%;
            left: 50%;
            width: 300%;
            height: 300%;
            background: rgba(255, 255, 255, 0.15);
            transition: width 0.4s, height 0.4s, top 0.4s, left 0.4s;
            border-radius: 50%;
            z-index: 0;
            transform: translate(-50%, -50%);
        }
        .animated-button:hover::before {
            width: 0;
            height: 0;
            top: 50%;
            left: 50%;
        }
        .animated-button:hover {
            transform: scale(1.1);
            box-shadow: 0 0 10px #333;
        }

        .help-section {
            margin-top: 40px;
            text-align: center;
            animation: fadeIn 2s ease-in-out;
        }
        @keyframes fadeIn {
            from { opacity: 0; }
            to { opacity: 1; }
        }
        .help-section a {
            color: #8be3e3;
            font-size: 1.2em;
            text-decoration: none;
            transition: color 0.2s, transform 0.2s;
            animation: glowText 2s infinite alternate;
        }
        @keyframes glowText {
            0% { text-shadow: 0 0 10px #8be3e3; }
            100% { text-shadow: 0 0 20px #8be3e3, 0 0 30px #8be3e3, 0 0 40px #8be3e3, 0 0 50px #8be3e3, 0 0 60px #8be3e3, 0 0 70px #8be3e3; }
        }
        .help-section a:hover {
            color: #fff;
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
            <button type="button" class="animated-button animate__animated animate__fadeInUp">SignUp</button>
        </a>
    </div>
</section>
<section class="help-section animate__animated animate__fadeIn">
    <a href="https://t.me/Mansurbek_Boqinazarov">
        <h4>Help</h4>
    </a>
</section>
<script src="script.js"></script>
</body>
</html>

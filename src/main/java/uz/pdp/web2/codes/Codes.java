package uz.pdp.web2.codes;

/**
 * @author Mansurbek Boqinazarov
 */
public interface Codes{
    String SIGN_UP = """
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup Page</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');

        @keyframes backgroundAnimation {
                    0% { background-color: rgba(255, 255, 255, 0.8); } /* Oq */
                                25% { background-color: rgba(49, 37, 37, 0.8); } /* Qora */
                                50% { background-color: rgba(55, 55, 110, 0.8); } /* Ko'k */
                                75% { background-color: rgba(97, 138, 97, 0.8); } /* Yashil */
                                100% { background-color: rgba(192, 160, 160, 0.8); } /* Oq */
        }

        body {
            background-image: url('wallpaperflare.com_wallpaper.jpg');
            font-family: 'Roboto', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-size: cover;
            background-position: center;
            animation: backgroundAnimation 20s infinite;
        }

        .container {
            background: rgba(255, 255, 255, 0.9);
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0 6px 20px rgba(0, 0, 0, 0.3);
            width: 320px; /* Kichikroq o'lcham */
            text-align: center;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .container:hover {
            transform: translateY(-5px);
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.5);
        }

        .signup-form h2 {
            margin-bottom: 20px;
            font-size: 24px; /* Kichikroq o'lcham */
            color: #333;
        }

        .signup-form label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            color: #444;
            text-align: left;
        }

        .signup-form input {
            width: 100%;
            padding: 10px; /* Kichikroq o'lcham */
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
            font-size: 14px; /* Kichikroq o'lcham */
            transition: border-color 0.3s ease;
            margin-bottom: 15px;
        }

        .signup-form input:focus {
            border-color: #4CAF50;
            outline: none;
        }

        .signup-form button {
            background-color: #4CAF50;
            color: white;
            padding: 12px; /* Kichikroq o'lcham */
            border: none;
            border-radius: 6px;
            cursor: pointer;
            width: 100%;
            font-size: 16px; /* Kichikroq o'lcham */
            transition: background-color 0.3s ease, transform 0.3s ease;
        }

        .signup-form button:hover {
            background-color: #45a049;
            transform: translateY(-2px);
        }

        .signup-form .center-link {
            color: #4CAF50;
            text-decoration: none;
            display: block;
            margin-top: 20px;
            font-size: 14px; /* Kichikroq o'lcham */
            transition: color 0.3s ease;
        }

        .signup-form .center-link:hover {
            color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="signup-form">
            <h2>Signup</h2>
            <form action="/signupPage" method="POST">
                <label for="firstName">First Name:</label>
                <input type="text" id="firstName" name="firstName" required>

                <label for="lastName">Last Name:</label>
                <input type="text" id="lastName" name="lastName" required>

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>

                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>

                <label for="phone">Phone:</label>
                <input type="tel" id="phone" name="phone" required>

                <label for="birthDate">Birth Date:</label>
                <input type="date" id="birthDate" name="birthDate" required>

                <button type="submit">Signup</button>
                <hr>
                <a href="/" class="center-link">Home</a>
            </form>
        </div>
    </div>
</body>
</html>
            """;
    String LOGIN = """
           <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');

        @keyframes backgroundAnimation {
            0% { background-color: rgba(255, 255, 255, 0.8); } /* Oq */
            25% { background-color: rgba(49, 37, 37, 0.8); } /* Qora */
            50% { background-color: rgba(55, 55, 110, 0.8); } /* Ko'k */
            75% { background-color: rgba(97, 138, 97, 0.8); } /* Yashil */
            100% { background-color: rgba(192, 160, 160, 0.8); } /* Oq */
        }

        body {
            background-image: url('wallpaperflare.com_wallpaper.jpg');
            font-family: 'Roboto', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-size: cover;
            background-position: center;
            animation: backgroundAnimation 20s infinite;
        }

        .login-container {
            background: rgba(255, 255, 255, 0.9);
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 6px 20px rgba(0, 0, 0, 0.3);
            width: 400px;
            text-align: center;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .login-container:hover {
            transform: translateY(-5px);
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.5);
        }

        .login-container h2 {
            margin-bottom: 25px;
            font-size: 28px;
            color: #333;
        }

        .input-group {
            margin-bottom: 20px;
            text-align: left;
        }

        .input-group label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            color: #444;
        }

        .input-group input {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
            font-size: 16px;
            transition: border-color 0.3s ease;
        }

        .input-group input:focus {
            border-color: #4CAF50;
            outline: none;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            width: 100%;
            font-size: 18px;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }

        button:hover {
            background-color: #45a049;
            transform: translateY(-2px);
        }

        .login-container a {
            color: #4CAF50;
            text-decoration: none;
            display: block;
            margin-top: 20px;
            font-size: 16px;
            transition: color 0.3s ease;
        }

        .login-container a:hover {
            color: #45a049;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Login</h2>
    <form action="/loginPage" method="post">
        <div class="input-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="input-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit">Login</button>
        <a href="/signupPage">Sign Up</a>
    </form>
</div>
</body>
</html>

                        """;
}

package uz.pdp.web2.codes;

/**
 * @author Mansurbek Boqinazarov
 */
public interface Codes{
    String SIGN_UP = """
                            <head>
                    <style>
                        body {
                            background-image: url('wallpaperflare.com_wallpaper.jpg');
                            font-family: Arial, sans-serif;
                            display: flex;
                            justify-content: center;
                            align-items: center;
                            height: 100vh;
                            margin: 0;
                        }
                                
                        .container {
                            background-color: #fff;
                            padding: 20px;
                            border-radius: 10px;
                            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                        }
                                
                        .signup-form {
                            max-width: 400px;
                            margin: auto;
                        }
                                
                        .signup-form h2 {
                            margin-bottom: 20px;
                            font-size: 24px;
                            text-align: center;
                        }
                                
                        .signup-form label {
                            display: block;
                            margin-bottom: 5px;
                        }
                                
                        .signup-form input {
                            width: 100%;
                            padding: 10px;
                            margin-bottom: 15px;
                            border: 1px solid #ccc;
                            border-radius: 5px;
                        }
                                
                        .signup-form button {
                            width: 100%;
                            padding: 10px;
                            border: none;
                            background-color: #28a745;
                            color: white;
                            font-size: 16px;
                            border-radius: 5px;
                            cursor: pointer;
                        }
                                
                        .signup-form button:hover {
                            background-color: #218838;
                        }
                         .center-link {
                                    display: block;
                                    text-align: center;
                                    margin: 0 auto;
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

            """;
    String LOGIN = """
                            <head>
                <style>
                body {
                    background-image: url('wallpaperflare.com_wallpaper.jpg');
                    font-family: Arial, sans-serif;
                    background-color: #f0f0f0;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    height: 100vh;
                    margin: 0;
                }
                
                .login-container {
                    background-color: white;
                    padding: 20px;
                    border-radius: 8px;
                    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                    width: 300px;
                    text-align: center;
                }
                                
                .login-container h2 {
                    margin-bottom: 20px;
                }
                                
                .input-group {
                    margin-bottom: 15px;
                    text-align: left;
                }
                                
                .input-group label {
                    display: block;
                    margin-bottom: 5px;
                }
                                
                .input-group input {
                    width: 100%;
                    padding: 8px;
                    border: 1px solid #ccc;
                    border-radius: 4px;
                    box-sizing: border-box;
                }
                                
                button {
                    background-color: #4CAF50;
                    color: white;
                    padding: 10px 15px;
                    border: none;
                    border-radius: 4px;
                    cursor: pointer;
                    width: 100%;
                }
                                
                button:hover {
                    background-color: #45a049;
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
                            <a href="/signupPage"><p>Sign Up</p></a>
                        </form>
                    </div>
                </body>

            """;
}

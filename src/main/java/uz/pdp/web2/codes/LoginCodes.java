package uz.pdp.web2.codes;

/**
 * @author Mansurbek Boqinazarov
 */
public interface LoginCodes {
    String LOGIN_ERROR = """
            <!DOCTYPE html>
                    <html lang="en">
                    <head>
                      <meta charset="UTF-8">
                      <meta name="viewport" content="width=device-width, initial-scale=1.0">
                      <title>Notification Example</title>
                      <style>
                        body {
                          font-family: Arial, sans-serif;
                          background-color: #f0f0f0; /* Light background for better contrast */
                        }
                        .notification {
                          display: none;
                          position: fixed;
                          top: 50%;
                          left: 50%;
                          transform: translate(-50%, -50%);
                          background-color: white;
                          color: red;
                          padding: 16px;
                          border-radius: 8px;
                          border: 2px solid red;
                          box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                          z-index: 1000;
                          animation: fadeInOut 4s ease-in-out;
                          text-align: center;
                        }

                        .notification-content {
                          display: flex;
                          flex-direction: column;
                          align-items: center;
                        }

                        .notification-text {
                          margin: 0;
                          font-size: 20px;
                          font-weight: bold;
                        }
                                        
                        .try-again-button {
                          margin-top: 10px;
                          padding: 10px 20px;
                          font-size: 16px;
                          color: white;
                          background-color: red;
                          border: none;
                          border-radius: 4px;
                          cursor: pointer;
                        }
                                        
                        .try-again-button:hover {
                          background-color: darkred;
                        }
                                        
                        @keyframes fadeInOut {
                          0% { opacity: 0; }
                          10% { opacity: 1; }
                          90% { opacity: 1; }
                          100% { opacity: 0; }
                        }
                      </style>
                    </head>
                    <body>
                      <div class="notification" id="notification">
                        <div class="notification-content">
                          <p class="notification-text">Wrong email or password</p>
                                <a href="/loginPage">  <button class="try-again-button">Try Again</button></a>
                        </div>
                      </div>
                     \s
                      <script>
                        document.addEventListener('DOMContentLoaded', function() {
                          const notification = document.getElementById('notification');
                          notification.style.display = 'block';
                          setTimeout(() => {
                            notification.style.display = 'none';
                          }, 100000);
                        });
                                        
                        function tryAgain() {
                          // Your function implementation here
                          alert('Try again function triggered');
                        }
                      </script>
                    </body>
                    </html>
            """;

    String LOGIN_SUCCESS  = """
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Information</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #2c3e50, #3498db);
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #fff;
        }
        .container {
            max-width: 600px;
            background: rgba(255, 255, 255, 0.9);
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0 0 30px rgba(0, 0, 0, 0.2);
            opacity: 0;
            transform: translateY(20px);
            animation: fadeIn 1s forwards;
        }
        h1 {
            margin-top: 0;
            font-size: 32px;
            text-transform: uppercase;
            letter-spacing: 2px;
            color: #2c3e50;
            border-bottom: 2px solid #3498db;
            padding-bottom: 10px;
            text-align: center;
        }
        .button-container {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }
        .custom-button, .animated-button {
            background: linear-gradient(45deg, #8e44ad, #3498db);
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            transition: all 0.3s ease;
            border-radius: 12px;
            flex: 1; /* Tugmalarni teng ravishda bo'lish uchun */
            margin: 5px; /* Tugmalar orasidagi bo'shliq */
        }
        .custom-button:hover, .animated-button:hover {
            background: linear-gradient(45deg, #3498db, #8e44ad);
            color: #fff;
            transform: scale(1.1);
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
        }
        @keyframes fadeIn {
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome %s %s</h1>
        <div class="button-container">
            <a href="/addTask"><button class="animated-button">Add Task</button></a>
            <a href="/showTask"><button class="animated-button">Show Task</button></a>
            <a href="/archiveTodo"><button class="animated-button">Archive Task</button></a>
            <a href="/"><button class="custom-button">Back to Home</button></a>
        </div>
    </div>
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            const container = document.querySelector('.container');
            container.style.opacity = '1';
            container.style.transform = 'translateY(0)';
        });
    </script>
</body>
</html>
            """;
}

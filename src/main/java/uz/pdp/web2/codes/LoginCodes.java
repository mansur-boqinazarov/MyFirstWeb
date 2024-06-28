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
}

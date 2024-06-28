package uz.pdp.web2.codes;

public interface SignUpCodes {
    String SIGN_UP_SUCCESS = """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Success Screen</title>
                <style>
                    @import url('https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700');
                        
                    body {
                        font-family: 'Quicksand', sans-serif;
                        background-color: #E4F6FA;
                        margin: 0;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        height: 100vh;
                    }
                        
                    .screen {
                        position: relative;
                        width: 330px;
                        height: 360px;
                        background-color: #fff;
                        border-radius: 15px;
                        box-shadow: 0 2px 12px 0 rgba(0,0,0,0.1);
                        text-align: center;
                        padding-top: 40px;
                        overflow: hidden;
                        cursor: pointer;
                        user-select: none;
                    }
                        
                    .screen .border-top {
                        position: absolute;
                        top: 0;
                        height: 10px;
                        width: 100%;
                        background-color: #5AE9BA;
                    }
                        
                    .screen #topIcon {
                        margin-top: 20px;
                    }
                        
                    .screen h3 {
                        font-weight: 700;
                        font-size: 24px;
                        color: #606060;
                        margin-top: 80px;
                    }
                        
                    .screen p {
                        font-weight: 400;
                        font-size: 16px;
                        color: #616161;
                        margin-top: 20px;
                        width: 90%;
                        margin-left: auto;
                        margin-right: auto;
                    }
                        
                    .screen button {
                        background: #5AE9BA;
                        border: 1px solid #34E2A9;
                        box-shadow: 0 3px 20px 0 rgba(90,233,186,0.60);
                        border-radius: 100px;
                        letter-spacing: 1.5px;
                        font-weight: 500;
                        color: #fff;
                        width: 186px;
                        height: 40px;
                        margin-top: 40px;
                        font-size: 13px;
                        cursor: pointer;
                        transition: all 0.2s ease-in;
                    }
                        
                    .screen button:focus {
                        outline: none;
                    }
                        
                    .btn-overlay {
                        background-color: #43d0f1;
                        border: 0;
                        color: #fff;
                        opacity: 0.6;
                        padding: 10px 15px;
                        border-radius: 100px;
                        font-size: 12px;
                        letter-spacing: 0.8px;
                        z-index: 999;
                        width: 100px;
                        position: fixed;
                        right: 10px;
                        transition: all 0.2s ease-in;
                    }
                        
                    .btn-overlay:hover {
                        opacity: 1;
                    }
                        
                    #restart {
                        top: 10px;
                    }
                        
                    #invert {
                        top: 55px;
                    }
                        
                    #Bubbles {
                        visibility: hidden;
                    }
                </style>
            </head>
            <body>
                <div class="screen un">
                    <div class="border-top"></div>
                   \s
                    <svg id="topIcon" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="100" height="100">
                        <circle cx="12" cy="12" r="12" fill="#5AE9BA"/>
                        <path d="M9.9 15.6l-2.7-2.7L6 12.1 9.9 16l8.3-8.3-1.4-1.4z" fill="#FFF"/>
                    </svg>
                   \s
                    <h3>SUCCESS!</h3>
                    <p>Sign Up Successfully ✔</p>
                   \s
                    <a href = "/"><button id="btnClick">CONTINUE</button></a>
                </div>
               \s
                <button type="button" id="restart" class="btn-overlay restart tr">RESTART</button>
                <button type="button" id="invert" class="btn-overlay invert tr">INVERT</button>
                        
                <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.10.4/gsap.min.js"></script>
                <script>
                    (function($) {
                        var red = "#F86969";
                        var green = "#5AE9BA";
                        var color = green;
                        var tlScreen1 = gsap.timeline();
                       \s
                        tlScreen1
                            .add("start")
                            .set("#Bubbles", {visibility: "visible"})
                            .from("#bottom-bubbles", {duration: 4, opacity: 0, y: 50, x: 40, ease: "elastic.out(1, 0.8)"})
                            .from("#top-bubbles", {duration: 4, opacity: 0, y: 50, x: 40, ease: "elastic.out(1, 0.8)"}, "start")
                            .to("#btnClick", {duration: 3.5, opacity: 1, y: -96, ease: "elastic.out(1, 1)"}, "-=3.5");
                       \s
                        $("#btnClick").mousedown(function() {
                            $(this).css("box-shadow", "unset");
                        });
                       \s
                        $("#btnClick").mouseup(function() {
                            if (color == green) {
                                $(this).css("box-shadow", "0 3px 20px 0 rgba(90,233,186,0.60)");
                            } else {
                                $(this).css("box-shadow", "0 3px 13px 0 rgba(248,105,105,0.60)");
                            }
                        });
                       \s
                        $("#restart").click(function() {
                            tlScreen1.restart();
                        });
                       \s
                        $("#invert").click(function() {
                            if (color == green) {
                                tlScreen1.stop();
                               \s
                                $(".border-top").css("background-color", red);
                                $("#topIcon circle").css("fill", red);
                                $("#topIcon path").css("fill", "#D74747");
                                $("#Bubbles ellipse").css("fill", red);
                                $(".screen button").css({
                                    'box-shadow': '0 3px 13px 0 rgba(248,105,105,0.60)',
                                    'background-color': red,
                                    'border-color': red
                                });
                                $(".screen button").html("TRY AGAIN");
                                $(".screen h3").html("FAILED!");
                                $(".screen p").html("Your file has not been transferred successfully via bluetooth.");
                                color = red;
                                tlScreen1.restart();
                            } else {
                                tlScreen1.stop();
                               \s
                                $(".border-top").css("background-color", green);
                                $("#topIcon circle").css("fill", green);
                                $("#topIcon path").css("fill", "#fff");
                                $("#Bubbles ellipse").css("fill", green);
                                $(".screen button").css({
                                    'box-shadow': '0 3px 20px 0 rgba(90,233,186,0.60)',
                                    'background-color': green,
                                    'border-color': green
                                });
                                $(".screen button").html("CONTINUE");
                                $(".screen h3").html("SUCCESS!");
                                $(".screen p").html("You have successfully transferred your file via bluetooth.");
                                color = green;
                                tlScreen1.restart();
                            }
                        });
                    })(jQuery);
                </script>
            </body>
            </html>
            """;
    String SIGN_UP_ERROR = """
            <!DOCTYPE html>
            <html lang="uz">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>User Already Exists</title>
                <style>
                    .container {
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        height: 100vh;
                        background-color: #f0f0f0;
                    }
                    .box {
                        background-color: #fff;
                        padding: 20px;
                        border-radius: 5px;
                        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                        text-align: center;
                    }
                    .message {
                        font-size: 1.2em;
                        color: #e74c3c;
                        margin-bottom: 10px;
                    }
                    .button {
                        display: inline-block;
                        padding: 10px 20px;
                        font-size: 1em;
                        color: #fff;
                        background-color: #3498db;
                        border: none;
                        border-radius: 5px;
                        cursor: pointer;
                        text-decoration: none;
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <div class="box">
                        <div class="message">User already exists!</div>
                        <a href="/signupPage" class="button" onclick="retry()">Retry</a>
                    </div>
                </div>
               
            </body>
            </html>
            """;
}

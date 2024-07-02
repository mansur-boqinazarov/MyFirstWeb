<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Task</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: linear-gradient(45deg, #000000, #ffffff, #4141ab, #000000); /* Initial background colors */
            background-size: 400% 400%;
            animation: backgroundAnimation 15s ease infinite;
        }

        @keyframes backgroundAnimation {
            0% {
                background-position: 0% 50%;
            }
            50% {
                background-position: 100% 50%;
            }
            100% {
                background-position: 0% 50%;
            }
        }

        .container {
            background-color: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 600px;
            margin: 20px;
            text-align: center;
            animation: fadeInUp 0.5s ease; /* Removed pulse effect */
        }

        @keyframes fadeInUp {
            0% {
                opacity: 0;
                transform: translateY(20px);
            }
            100% {
                opacity: 1;
                transform: translateY(0);
            }
        }

        h1 {
            margin-bottom: 20px;
            font-size: 28px;
            color: #333;
            animation: textGlow 2s ease-in-out infinite alternate;
        }

        @keyframes textGlow {
            0% {
                text-shadow: 0 0 10px #007bff;
            }
            100% {
                text-shadow: 0 0 20px #007bff;
            }
        }

        .form-group {
            margin-bottom: 20px;
            text-align: left;
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #555;
        }

        input[type="text"], textarea, input[type="datetime-local"] {
            width: calc(100% - 16px);
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 16px;
            transition: border-color 0.3s ease, box-shadow 0.3s ease;
        }

        input[type="text"]:focus, textarea:focus, input[type="datetime-local"]:focus {
            border-color: #007bff;
            box-shadow: 0 0 8px rgba(0, 123, 255, 0.5);
        }

        textarea {
            height: 120px;
            resize: vertical;
        }

        button {
            padding: 14px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 18px;
            transition: background-color 0.3s ease, transform 0.3s ease, box-shadow 0.3s ease;
            animation: buttonGlow 2s ease-in-out infinite alternate;
        }

        @keyframes buttonGlow {
            0% {
                box-shadow: 0 0 10px #007bff;
            }
            100% {
                box-shadow: 0 0 20px #007bff;
            }
        }

        button:hover {
            background-color: #0056b3;
            transform: scale(1.05);
        }

        #message {
            margin-top: 20px;
            font-size: 18px;
            color: #28a745;
            animation: fadeIn 1s ease;
        }

        @keyframes fadeIn {
            0% {
                opacity: 0;
            }
            100% {
                opacity: 1;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Create Task</h1>
    <form id="taskForm" action="addTask" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label>Task:</label>
            <input type="text" name="task" id="task" required>
        </div>
        <div class="form-group">
            <label>Description:</label>
            <textarea id="description" name="description"  required></textarea>
        </div>
        <div class="form-group">
            <label>Due Date:</label>
            <input type="datetime-local" name="due_date" id="due_date" required>
        </div>
        <div class="form-group">
            <label for="file">Choose file:</label>
            <input type="file" name="file" id="file" required><br><br>
        </div>
        <hr>
        <button type="submit">CREATE</button>
    </form>
</div>
</body>
</html>

<!DOCTYPE html>
<html lang="uz">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ToDo Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            background: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            border-radius: 8px;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
            font-size: 24px;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        input {
            margin-bottom: 10px;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        button {
            padding: 10px;
            background: #28a745;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background: #218838;
        }

        ul {
            list-style: none;
            padding: 0;
            margin-top: 20px;
        }

        li {
            background: #f9f9f9;
            margin-bottom: 10px;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        li span {
            display: block;
            margin-bottom: 5px;
        }

        li .task-title {
            font-weight: bold;
            color: #333;
        }

        li .task-desc {
            font-size: 0.9em;
            color: #666;
        }

        li .task-due {
            font-size: 0.8em;
            color: #999;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Add Task</h1>
    <form id="todo-form">
        <input type="text" id="task" placeholder="Task" required>
        <input type="text" id="description" placeholder="Description" required>
        <input type="date" id="due-date" required>
        <button type="submit">CREATE</button>
    </form>
    <ul id="todo-list">
        <li>
            <span class="task-title">Sample Task</span>
            <span class="task-desc">This is a sample description.</span>
            <span class="task-due">Due Date: 2024-12-31</span>
        </li>
    </ul>
</div>
</body>
</html>

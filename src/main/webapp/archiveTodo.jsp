<%@ page import="java.util.List" %>
<%@ page import="uz.pdp.web2.model.Todo" %>
<%@ page import="uz.pdp.web2.service.ToDoService" %>
<%@ page import="java.util.Objects" %>
<%@ page import="uz.pdp.web2.servlet.LoginServlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo List</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #2b2d42;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .todo-container {
            background-color: #333;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
            width: 400px;
        }

        .todo-button {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            margin: 5px 0;
            border: none;
            border-radius: 5px;
            text-align: left;
            font-size: 16px;
            transition: background-color 0.3s ease, transform 0.2s ease;
            cursor: pointer;
            width: 100%;
        }

        .todo-button:hover {
            background-color: #45a049;
            transform: scale(1.05);
        }

        .todo-icon {
            font-size: 20px;
        }

        .todo-details {
            display: none;
            padding: 10px;
            background-color: #444;
            border-radius: 5px;
            margin-top: 5px;
            color: white;
        }

        .button-container {
            display: flex;
            justify-content: center;
            margin-bottom: 20px;
        }

        .animated-button {
            font-size: 18px;
            padding: 10px 20px;
            border: 2px solid #00aaff;
            background-color: #333;
            color: #00aaff;
            cursor: pointer;
            outline: none;
            transition: color 0.4s, box-shadow 0.4s;
            position: relative;
            overflow: hidden;
        }

        .animated-button::before,
        .animated-button::after {
            content: "";
            position: absolute;
            width: 100%;
            height: 100%;
            top: 0;
            left: 0;
            background-color: #00aaff;
            transition: transform 0.4s;
            z-index: -1;
        }

        .animated-button::before {
            border-top: 2px solid #00aaff;
            border-bottom: 2px solid #00aaff;
            transform: scaleX(0);
        }

        .animated-button::after {
            border-left: 2px solid #00aaff;
            border-right: 2px solid #00aaff;
            transform: scaleY(0);
        }

        .animated-button:hover::before {
            transform: scaleX(1);
        }

        .animated-button:hover::after {
            transform: scaleY(1);
        }

        .animated-button:hover {
            color: #fff;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
        }
    </style>
</head>
<body>

<div class="todo-container">
    <div class="button-container">
        <a href="showTask">
            <button class="animated-button">ARCHIVE LIST</button>
        </a>
    </div>
    <%
        int userId = (int) session.getAttribute("userId");
        ToDoService toDoService = new ToDoService();
        List<Todo> list = toDoService.getAll();
        for (Todo todo : list) {
            if (Objects.equals(todo.getOwner_id(), userId) && todo.completed) {
    %>
    <div class="todo-item">
        <button class="todo-button">
            <span><%= todo.getTask() %></span>
            <i class="fas fa-angle-down todo-icon"></i>
        </button>
        <div class="todo-details">
            <p>
                <strong>Description:</strong> <i><%= todo.getDescription() %>
            </i>
            </p>
            <p>
                <strong>Create Date:</strong> <i><%= todo.getCreated_at() %>
            </i>
            </p>
            <p>
                <strong>Due Date:</strong> <i><%= todo.getDue_date() %>
            </i>
            </p>
            <p style="color: #78e81c; margin-left: 70%; ">Completed ✔</p>
        </div>
    </div>
    <%
            }
        }
    %>
</div>

<script>
    document.querySelectorAll('.todo-button').forEach(button => {
        button.addEventListener('click', () => {
            const details = button.nextElementSibling;
            details.style.display = details.style.display === 'block' ? 'none' : 'block';
        });
    });
</script>
</body>
</html>

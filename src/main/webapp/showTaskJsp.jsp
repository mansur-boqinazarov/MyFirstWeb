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
            background-color: #f4f4f4;
            padding: 20px;
        }

        .todo-container {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }

        .todo-button {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #4CAF50;
            color: white;
            padding: 15px;
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
            padding: 10px 20px;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
            margin-top: 5px;
        }

        .button-container {
            position: relative;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .animated-button {
            font-size: 24px;
            padding: 20px 40px;
            border: 2px solid black;
            background-color: white;
            color: black;
            cursor: pointer;
            outline: none;
            position: relative;
            overflow: hidden;
            transition: color 0.4s, box-shadow 0.4s;
        }

        .animated-button::before,
        .animated-button::after {
            content: "";
            position: absolute;
            width: 100%;
            height: 100%;
            top: 0;
            left: 0;
            background-color: white;
            transition: transform 0.4s;
            z-index: -1;
        }

        .animated-button::before {
            border-top: 2px solid #78e81c;
            border-bottom: 2px solid black;
            transform: scaleX(0);
        }

        .animated-button::after {
            border-left: 2px solid black;
            border-right: 2px solid black;
            transform: scaleY(0);
        }

        .animated-button:hover::before {
            transform: scaleX(1);
        }

        .animated-button:hover::after {
            transform: scaleY(1);
        }

        .animated-button:hover {
            color: #e35c5c;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
        }

        .animated-button:hover span {
            animation: text-glow 1s infinite alternate;
        }

        @keyframes text-glow {
            from {
                text-shadow: 0 0 5px white, 0 0 10px white, 0 0 15px white, 0 0 20px white;
            }
            to {
                text-shadow: 0 0 10px white, 0 0 20px white, 0 0 30px white, 0 0 40px white;
            }
        }
    </style>
</head>
<body>
<div class="todo-container">
    <div class="button-container">
        <a href="showTask">
            <button class="animated-button">TODO LIST</button>
        </a>
    </div>
    <%
        ToDoService toDoService = new ToDoService();
        List<Todo> list = toDoService.getAll();
        for (Todo todo : list) {
            if (Objects.equals(todo.getOwner_id(), LoginServlet.USER.id) && !todo.completed) {
    %>
    <div class="todo-item">
        <button class="todo-button">
            <span><%= todo.getTask() %></span>
            <i class="fas fa-angle-down todo-icon"></i>
        </button>
        <div class="todo-details">

            <p>
                <strong>Description:</strong> <i><%= todo.getDescription() %></i>
            </p>

            <p>
                <strong>Create Date:</strong> <i><%= todo.getCreated_at() %> </i>
            </p>

            <p>
                <strong>Due Date:</strong> <i><%= todo.getDue_date() %></i>
            </p>
            <a href="download?fileId=<%=todo.getFile_id()%>"> Download</a>
            <button type="button" style="color: #78e81c; margin-left: 95%; ">DELETE</button>


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
            if (details.style.display === 'none' || details.style.display === '') {
                details.style.display = 'block';
            } else {
                details.style.display = 'none';
            }
        });
        /* document.querySelector('.animated-button').addEventListener('click', function() {
             alert('Button Clicked!');
         });*/
    });
</script>
</body>
</html>
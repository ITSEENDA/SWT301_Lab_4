<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sales Commission Calculator</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: linear-gradient(to right, #6a11cb, #2575fc);
        }

        .container {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
            width: 350px;
            text-align: center;
        }

        h2 {
            margin-bottom: 20px;
        }

        input, select {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        button {
            background: #6a11cb;
            color: white;
            padding: 10px;
            border: none;
            width: 100%;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background: #2575fc;
        }

        #result {
            margin-top: 20px;
            font-size: 18px;
            font-weight: bold;
        }
    </style>
</head>
<body>
<%
    String resultMsg = (String) request.getAttribute("resultMsg");
    String errorMsg = (String) request.getAttribute("errorMsg");
%>
<div class="container">
    <h2>Commission Calculator</h2>
    <form action="${pageContext.request.contextPath}/commission" method="get">
        <input type="hidden" name="service" value="calculate">
        <label>Is Salaried?</label>
        <select id="isSalaried" name="isSalaried">
            <option value="false">No</option>
            <option value="true">Yes</option>
        </select>

        <label for="itemType">Type Of Item</label>
        <select id="itemType" name="itemType">
            <option value="GENERAL">General</option>
            <option value="BONUS">Bonus</option>
            <option value="STANDARD">Standard</option>
        </select>

        <label for="isRegularCustomer">Is Regular Customer?</label>
        <select id="isRegularCustomer" name="isRegularCustomer">
            <option value="false">No</option>
            <option value="true">Yes</option>
        </select>

        <label>Item Price</label>
        <input type="number" id="itemPrice" name="itemPrice" placeholder="Enter price" required
               onchange="priceChange()" step="any">
        <p id="error-message" style="color:red;"><%=errorMsg != null ? errorMsg : ""%></p>
        <input type="submit" id="calculateCommission" disabled value="Calculate">
    </form>
    <div id="result"><%=resultMsg != null ? resultMsg : ""%></div>
</div>

<script>
    function priceChange() {
        let price = document.getElementById("itemPrice").value;
        if (!Number.isNaN(price)) {
            document.getElementById("calculateCommission").disabled = false;
            return;
        }
        document.getElementById("calculateCommission").disabled = true;
    }
</script>
</body>
</html>
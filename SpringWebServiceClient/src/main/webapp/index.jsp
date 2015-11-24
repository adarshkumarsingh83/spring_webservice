<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript">
        function getMethodName() {
            var dropDown = document.getElementById('selectedMethod');
            document.getElementById('methodName').value = dropDown.options[dropDown.selectedIndex].text;
        }
    </script>
</head>
<body>
<form name="myForm" method="post" action="service.do">
    <center>
        <br/>
        Enter the Method Name &nbsp;
        <input type="text" name="methodName" id="methodName" value="get"/>
        &nbsp;
        <select id="selectedMethod" onchange="getMethodName()">
            <option>get</option>
            <option>post</option>
            <option>delete</option>
            <option>put</option>
            <option>head</option>
        </select>
        <br/>
        <input type="submit" value="send"/>
    </center>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Adarsh_K
  Date: 27/4/13
  Time: 12:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>REST WEB SERVICE UPLOAD PAGE</title>
</head>
<body>
<h1>File Upload with Jersey</h1>

<form action="rest/postService/fileUpload" method="post" enctype="multipart/form-data">
    <center>
        <p>
            Select a file : <input type="file" name="file" size="45"/>
        </p>
        <BR/>
        <input type="submit" value="Upload It"/>
    </center>
</form>

</body>
</html>
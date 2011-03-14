<html>
<head>
  <title>FreeMarker Example Web Application 1</title>
</head>
<body>



 <ul>
  <#list theList as being>
    <li>${being.ru} and ${being.en}</li>
  </#list>
  </ul>



</body>
</html>
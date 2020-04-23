<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
</head>
<body>

   주소<input type ="text" name ="location" value="" id ="addr">
   <input type ="button" value ="전송" onclick ="Click()">


<script type="text/javascript">

function Click() {
   var location = $("#addr").val();
   $.ajax({
      url : 'map/kakaoMap.go',
      type : 'get',
      dataType:'text',
      data: {
         "location" : location, 
      },
      success: function(data){
         console.log(data);
         data = JSON.parse(data);
         console.log(data.documents[0].x)
         console.log(data.documents[0].y)
 /*         for (var i = 0; i < data.length; i++) {
             var findX = data.indexOf("x");
             var findXEnd = data.substring(findX, data.length);
             var find = findXEnd.indexOf(",");
             var latitude = findXEnd.substring(4, find-1);              
          }
         
         console.log(latitude);
         for (var j = 0; j < data.length; j++) {
             var findY = data.indexOf("y");
             var findYEnd = data.substring(findY, data.length);
             var find = findYEnd.indexOf(",");
             var longitude = findYEnd.substring(4, find-1);              
          }
         console.log(longitude); */

      },
      error : function(xhr, status, error){
         console.log('실패?')
         console.log(xhr);
         console.log(error);
      }      
   });   
}


</script>
</body>
</html>
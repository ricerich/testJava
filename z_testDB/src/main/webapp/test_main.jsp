<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트 JSON</title>
<link rel="stylesheet" href="./css/bootstrap.css" />
<link rel="stylesheet" href="./css/bootstrap.min.css" />


<script type="text/javascript">
	
	var xhrObject; // XMLhttpRequest객체를 저장할 변수, 전역변수선언
	
	function selectData()//json 요청
	{		
// 		setTimeout("alert('111111')", 1);
		
		var form_name = "form_main";
		var user_id = document.forms[form_name].elements["txt_user_id"].value;
		
		xhrObject = new XMLHttpRequest();
		
// 		var url = "./testFile.jsp"; //요청 url 설정
		var url = "./db_select.jsp"; //요청 url 설정
		
		var reqparam = "user_id="+user_id;
		xhrObject.onreadystatechange = resSelectData; // 다되면 실행할 함수 등록(호출 아님. 역호출)
		xhrObject.open("Post", url, "true"); //서버의 요청설정 -url변수에 설정된 리소스를 요청할 준비
		xhrObject.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		xhrObject.send(reqparam);
	}

	function resSelectData()
	{
		if(xhrObject.readyState == 4)
		{
			
			if(xhrObject.status == 200)
			{
				//alert("2");
				
				var result = xhrObject.responseText;
  				//alert(result);
				
 				var objRes = eval("("+result+")");
  				//alert(objRes);
				
				var num = objRes.datas.length;
				var res = "<table class='table table-hover'>";
				var resDiv = document.getElementById("div_res");
				
				if(num<1)
				{
					res += "<tr><td width='980' height='100' align = 'center' style='font-size:50;'>검색 결과가 없습니다.</td></tr>";
				}
				else
				{
					for(var i=0; i<num; i++)
					{
						var user_id = objRes.datas[i].ID;
						var user_name = objRes.datas[i].NAME;
						var user_phone = objRes.datas[i].PHONE;
						var user_grade = objRes.datas[i].GRADE;
						var user_time = objRes.datas[i].WRITE_TIME;
						
						res +="<tr class='table-active'>";
						res +="<td >"+user_id+"</td>";
						res +="<td><br>"+user_name+"<br></td>";
						res +="<td><br>"+user_phone+"<br></td>";
						res +="<td><br>"+user_grade+"<br></td>";
						res +="<td><br>"+user_time+"<br></td>";
						res +="</tr>";
					}
				}
				res += "</table>";
				
 				//alert(res);
				resDiv.innerHTML = res;
			}
		}
	}
	
	function insertData()//json 요청
	{		
// 		setTimeout("alert('111111')", 1);
		
		var form_name = "form_main";
// 		var user_id = document.forms[form_name].elements["txt_user_id"].value;//이건 검색창에서 들고 온것

		var user_id    = document.forms[form_name].elements["user_id"].value;
		var user_name  = document.forms[form_name].elements["user_name"].value;
		var user_phone = document.forms[form_name].elements["user_phone"].value;
		var user_grade = document.forms[form_name].elements["user_grade"].value;
		
		xhrObject = new XMLHttpRequest();
		
// 		var url = "./testFile.jsp"; //요청 url 설정
		var url = "./db_insert.jsp"; //요청 url 설정
		
		var reqparam  = "user_id="+user_id;
			reqparam += "&user_name=" + user_name;
			reqparam += "&user_phone=" + user_phone;
			reqparam += "&user_grade=" + user_grade;
			
		
		xhrObject.onreadystatechange = resInsertData; // 다되면 실행할 함수 등록(호출 아님. 역호출)
		xhrObject.open("Post", url, "true"); //서버의 요청설정 -url변수에 설정된 리소스를 요청할 준비
		xhrObject.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		xhrObject.send(reqparam);
	}

	function resInsertData()
	{
		if(xhrObject.readyState == 4)
		{
			
			if(xhrObject.status == 200)
			{
				//alert("2");
				
				var result = xhrObject.responseText;
//   				alert(result);
				
 				var objRes = eval("("+result+")");
//   				alert(objRes);

				var resDiv = document.getElementById("div_res");
				var res = "";
				

				var success = objRes.SUCCESS;
				
				if(success == "1")
				{
					alert("입력 성공했어요~!");
					res = "<p>입력 성공</p>";
					
				}
				else if(success == "0")
				{
					alert("입력 실패했어요~!")
					res = "<p>입력 실패</p>";
					
				}
				
				resDiv.innerHTML = res;
				
// 				var num = objRes.datas.length;
// 				var res = "<table class='table table-hover'>";
// 				var resDiv = document.getElementById("div_res");
				
// 				if(num<1)
// 				{
// 					res += "<tr><td width='980' height='100' align = 'center' style='font-size:50;'>검색 결과가 없습니다.</td></tr>";
// 				}
// 				else
// 				{
// 					for(var i=0; i<num; i++)
// 					{
// 						var user_id = objRes.datas[i].ID;
// 						var user_name = objRes.datas[i].NAME;
// 						var user_phone = objRes.datas[i].PHONE;
// 						var user_grade = objRes.datas[i].GRADE;
// 						var user_time = objRes.datas[i].WRITE_TIME;
						
// 						res +="<tr class='table-active'>";
// 						res +="<td >"+user_id+"</td>";
// 						res +="<td><br>"+user_name+"<br></td>";
// 						res +="<td><br>"+user_phone+"<br></td>";
// 						res +="<td><br>"+user_grade+"<br></td>";
// 						res +="<td><br>"+user_time+"<br></td>";
// 						res +="</tr>";
// 					}
// 				}
// 				res += "</table>";
				
//  				//alert(res);
// 				resDiv.innerHTML = res;
			}
		}
	}
	
	function searchData()
	{
	
		//alert("111")
		var form_name = "form_main";
		var user_id = document.forms[form_name].elements["txt_user_id"].value;
		//alert("123");
		if(user_id == "")
		{			
			alert("값이 없어요!")
			document.forms[form_name].elements["txt_user_id"].focus();
			
			var resDiv = document.getElementById("div_res");
			resDiv.innerHTML = "값없음"
			
			return;
		}
		else
		{
			//alert("user_id ");
			getData();
			
// 			alert("a1")
// 			alert("a2")
// 			alert("a3")
// 			alert("a4")
// 			alert("a5")
// 			alert("a6")
// 			alert("a7")
// 			alert("a8")
		}		
	}
	
</script>


</head>
<body>
	<form name="form_main" onSubmit="javascript:return false;">
	<div class="container">
	    <div class="row">
	        <div class="col-xs-12"> -</div>
	    </div>
	    <div class="row">
	        <div class="col-xs-12">
		    	<input type="text" name='user_id' value="aa1" class="form-control" id="inputDefault">
		    	<input type="text" name='user_name' value="홍길동" class="form-control" id="inputDefault">
		    	<input type="text" name='user_phone' value="010-1234-4546" class="form-control" id="inputDefault">
		    	<input type="text" name='user_grade' value="3" class="form-control" id="inputDefault">
		    	<button class="btn btn-primary" type="button" id="button-addon2" onClick='javascript:insertData();' >Button</button>
	        </div>
	    </div>
	    <div class="row">	        
	        <div class="col-sm-6">   
	        	<div class="input-group mb-3">
		      		<input type="text" name='txt_user_id' class="form-control" placeholder="ID 입력바람!" aria-label="Recipient's username" aria-describedby="button-addon2" onkeyup='javascript:;'>
		      		<button class="btn btn-primary" type="button" id="button-addon2" onClick='javascript:searchData();' >Button</button>
		    	</div>
		    	<div id='div_res' class="input-group mb-3" >
		    	
		    	</div>
    		</div>
	        <div class="col-md-3"></div>
	    </div>
	
	</div>
 </form>
   
</body>
</html>
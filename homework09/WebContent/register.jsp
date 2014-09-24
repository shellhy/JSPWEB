<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>黄勇的用户注册</title>
<script language="javascript">
//检测全部表单元素是否为空
function checkBlank(Form){
	var v=true;
	for(i=0;i<Form.length;i++){  
		if(Form.elements[i].value == ""){         //Form的属性elements的首字e要小写
			alert(Form.elements[i].title + "不能为空!");
			Form.elements[i].focus();				//指定表单元素获取焦点
			v=false;
			return false;
		}
	}
	return v;
}
//验证用户名是否合法
function checkusername(username){
	var str=username;
	 //在JavaScript中，正则表达式只能使用"/"开头和结束，不能使用双引号
	var Expression=/^(\w){3,20}$/; 
	var objExp=new RegExp(Expression);		//创建正则表达式对象
	return objExp.test(str)			//通过正则表达式验证
}
//验证密码是否合法
function checkPWD(PWD){
	var str=PWD;
	 //在JavaScript中，正则表达式只能使用"/"开头和结束，不能使用双引号
	var Expression=/^[A-Za-z]{1}([A-Za-z0-9]|[._]){5,19}$/; 
	var objExp=new RegExp(Expression);		//创建正则表达式对象
	return objExp.test(str)		//通过正则表达式验证
}
//验证E-mail地址是否合法
function checkemail(email){
	var str=email;
	 //在JavaScript中，正则表达式只能使用"/"开头和结束，不能使用双引号
	var Expression=/\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/; 
	var objExp=new RegExp(Expression);		//创建正则表达式对象
	return objExp.test(str)			//通过正则表达式进行验证
}

	function check(Form){
		if(checkBlank(Form)){	//验证表单元素是否为空
			if(checkusername(Form.username.value)){	//验证用户名
				if(checkPWD(Form.pwd.value)){	//验证密码
					if(Form.pwd.value==Form.repwd.value){	//验证两次输入的密码是否一致
						if(checkemail(Form.email.value)){	//验证E-mail地址
							return true;
						}else{
							alert("请输入正确的E-mail地址！");
							Form.email.focus();	//让E-mail文本框获得焦点
							return false;
						}
					}else {
						alert("您两次输入的密码不一致，请重新输入！");
						return false;
					}
				}else{
					alert("您输入的密码不合法！");
					Form.pwd.focus();	//让密码文本框获得焦点
					return false;
				}
			}else {
				alert("您输入的用户名不合法！");
				Form.username.focus();	//让用户名文本框获得焦点
				return false;
			}
		}else{
			return false;
		}
	}
</script>
</head>
<body align="center">
<form name="form1" method="post" action="insertServlet" onSubmit="return check(this)">
用户名： <input	name="username" type="text" id="username" placeholder="长度控制在3-20个字符之内" title="用户名"style="width: 120px"><br><br>
密&nbsp;&nbsp;码： <input name="password" type="password" id="password" placeholder="请设定在6-20位之间" title="密码" style="width: 120px"> <br><br>
确认密码：<input type="password" name="repwd" id="repwd" title="确认密码" style="width: 120px"> <br><br>

邮&nbsp;&nbsp;箱：<input name="email" type="email" id="email" title="邮箱" style="width: 120px"> <br><br>
出生日期:<input name="birthday" type="date" id="date" title="出生日期"autocomplete="on" style="width: 120px"> <br>
学&nbsp;&nbsp;历：<select name="degree" id="degree" title="学历">
<option value="本科">bachelor</option>
<option value="硕士">graduate</option>
<option value="博士">doctor</option>
<option value="研究员" selected="selected">professor</option>
</select><br/>
是否愿意接受消息推送：
<select name="pushInfo" id="pushInfo" title="是否推送">
<option value="no">No</option>
<option value="yes" selected="selected">Yes</option>
</select><br/>
&nbsp;&nbsp;&nbsp;<input type="reset" name="reset" id="reset" value="重置">
&nbsp;&nbsp;&nbsp;<input type="submit" name="Submit" id="submit" value="提交"><br/>

</form>
</body>
</html>
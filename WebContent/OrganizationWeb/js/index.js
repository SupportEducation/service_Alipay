/*Login*/
$(document).ready(function(){
	$(".login-user").mousemove(function(){
		if($(".login-user div").is(":animated")){
			return;
		}
		$(".login-user div").slideDown("1000");
	});
	$(".login-user,.login-user div").mouseleave(function(){
		$(".login-user div").css("display","none");
	});
});
/*Login-Item*/
$(document).ready(function(){
	$("#index_login").click(function(){
    	$("#overlay_l").fadeIn();
    });
    $(".login-back").click(function(){
    	$("#overlay_l").fadeOut();
    });
    $("#index_register").click(function(){
    	$("#overlay_r").fadeIn();
    });
    $("#index_register2").click(function(){
    	$("#overlay_r").fadeIn();
    });
    $(".register-back").click(function(){
    	$("#overlay_r").fadeOut();
    });
});
/*QRCode*/   
var QRCode;
window.onload=function(){
    QRCode="";   
    var codeLength=4;//验证码的长度  
    var regCode=document.getElementById('test');
    var random=new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R',  
    'S','T','U','V','W','X','Y','Z');//随机数  
    for(var i=0;i<codeLength;i++) {//循环操作  
        var index=Math.floor(Math.random()*36);//取得随机数的索引（0~35）  
        QRCode+=random[index];//根据索引取得随机数加到code上  
    }  
    regCode.innerHTML=QRCode;//把code值赋给前端

    document.getElementById('test').onclick=function(){
        QRCode="";
        for(var i=0;i<codeLength;i++) {//循环操作  
        var index=Math.floor(Math.random()*36);//取得随机数的索引（0~35）  
        QRCode+=random[index];//根据索引取得随机数加到code上  
        }
        regCode.innerHTML=QRCode;
    }
}

var username=$("#username").attr("value");
var pwd=$("#password").attr("value");
var pwdag=$("#pwdag").attr("value");
var code=$("#code").attr("value");

function checkForm(){
	if(username==""||pwd==""||pwdag==""||code==""){
		alert("信息不能为空！");
		return false;
		}
	else if(pwd!=pwdag){
		 alert("两次密码不一致！");
		 return false;
	}
//	else if(QRCode!=code){
//		alert("验证码不一致！");
//		return false;
//	}
	else
		return true;
	    
}




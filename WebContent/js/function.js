function change(img){
	img.src="getcode?"+new Date().getTime();
}

var flag=true;//标记位


function FocusItem(obj){
	
	if($(obj).attr('name') == 'code'){
		$(obj).next().next().html('').removeClass('error');
	}else{
		$(obj).next('span').html('').removeClass('error');
	}
}
function CheckItem(obj){
	var msgBox = $(obj).next('span');
	switch($(obj).attr('name')){
	case "user_id":
	    if(obj.value == ""){
	    	msgBox.html('用户名不能为空');
	    	msgBox.addClass('error');
	    	flag=false;
	    }else{
	    	var url="useridcheck?name="+encodeURI($(obj).val())+"&"+new Date().getTime();
	    	
	    	//"false" "true"
	    	$.get(url, function(data){
	    		if(data == "false"){
	    			msgBox.html('用户名已存在');
	    			msgBox.addClass('error');
	    			flag=false;
	    		}else{
	    			msgBox.html().removeClass('error');
	    			flag=true;
	    		}
	    	});
	    }
	    break;
	case "user_password":
		if(obj.value == ""){
	    	msgBox.html('密码不能为空');
	    	msgBox.addClass('error');
	    	flag=false;
		}else{
			flag=true;
		}
	    break;
	case "repassword":
		if(obj.value == ""){
	    	msgBox.html('确认密码不能为空');
	    	msgBox.addClass('error');
	    	flag=false;
		}else if($(obj).val() !=$('input[name="user_password"]').val() ){
			msgBox.html('密码不一致');
	    	msgBox.addClass('error');
	    	flag=false;
		}else{
			flag=true;
		}
	    break;
	    
	case "code":
		var numshow  = $(obj).next().next();
		
		if(obj.value == ""){
	    	numshow.html('验证码不能为空');
	    	numshow.addClass('error');
	    	flag=false;
	    }else {
	    	
	    	var url="checkusernum?num="+encodeURI($(obj).val())+"&"+new Date().getTime();
	    	$.get(url, function(data){
	    		
	    	if(data=="flase"){
	    			
	    		numshow.html('验证码输入有误');
	    		numshow.addClass('error');
	    		flag=false;
	    	}else{
	    		numshow.html().removeClass('error');
	    		flag=true;
	    	}
	    })
	   }
		break;
	}
}



function checkForm(frm){
	var els = frm.getElementsByTagName('input');
	//onblur 这个属性才需要验证
	for(var i=0; i<els.length; i++){
		
		if(els[i] !=null ){
			
			if(els[i].getAttribute("onblur")){
				
				CheckItem(els[i]);
			}
		}
	}
	return flag;
}
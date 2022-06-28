<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Plantcare</title>
	
	<!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>
	
    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
	<script>
	function id_duplicate(form){
		
		window.open("id_duplicate_check.jsp?email="+form.Email.value, "idover","width=500px, height=300px");
	}
	
	function registValidate(form){
		
		var id_val = document.getElementById("id_validate");
	 	var p_check = document.getElementById("pass_check");
	 
	 	if(form.pass1.value == "") {
     		alert("비밀번호를 입력하세요.");
        	form.pass1.focus();
        	return false;
     	} else {
     		if(p_check.innerHTML != "사용가능합니다.") {
     			alert("비밀번호를 확인하세요.");
     			form.pass1.focus();
            	return false;
     		}
     	}
		// submit 후 비밀번호 확인 시 다르면 경고창 띄우기
		if(form.pass1.value != form.pass2.value) {
	 		alert("비밀번호를 다시 확인하세요.");
	    	form.pass2.focus();
	    	return false;
	 	} 
		if(form.name.value == "") {
     		alert("이름을 입력하세요.");
        	form.name.focus();
        	return false;
     	}
		
	}
	// 아이디 중복 확인
    function id_Duplication_Check(form) {
    	// 아이디 입력 X
    	if(form.email.value == "") {
    		alert("아이디 입력 후 중복확인하세요.");
    		form.email.focus();
    		
    		// 아이디 입력 O
    	} else {
    		// 사용가능한 아이디 일 때 팝업창
    		
    		window.open("id_duplicate_check.jsp?email=" + form.email.value, "idover", "width=500px, height=300px");
    	}
	}
    
    // 비밀번호 입력 시 유효성 검사
    function passCheck(form) {
    	if(form.pass1.value != null) {
    		var u_pass = form.pass1.value;
    		var check = document.getElementById("pass_check");
    		
    		if(u_pass.length >= 8 && u_pass.length <= 16) {
    			var num = 0;
    			var Alpha = 0;
    			var symbol = 0;
    			for(var i = 0; i < u_pass.length; i++) {
    				var ascii = u_pass.charCodeAt(i);
    				if(ascii >= 48 && ascii <= 57) num++;
    				if(ascii >= 65 && ascii <= 90 || ascii >= 97 && ascii <= 122) Alpha++;
    				if((ascii >= 33 && ascii <= 47) || (ascii >= 58 && ascii <= 64)
    						|| (ascii >= 91 && ascii <= 96)
    						|| (ascii >= 123 && ascii <= 126)) symbol++;
    			}
    			if( num > 0 && Alpha > 0 && symbol > 0 ) {
        			check.innerHTML = "사용가능합니다.";
    				check.style.color = "skyblue";
        			form.pass2.focus();
    			} else {
    				check.innerHTML = "영문/숫자/특수문자가 모두 포함되어야 합니다.";
    				check.style.color = "red";
        			/* form.pass1.focus(); */
    			}
    		} else {
    			check.innerHTML = "8~16 자리로 입력하세요.";
				check.style.color = "red";
    			/* form.pass1.focus(); */
    		}
    	}
    }
    
    
 // 비밀번호, 휴대폰 번호, 전화번호 입력시 잘못된 사항
    $(function () {
        $('#pwd1').keyup(function () {
          $('#pwd2').val('');
          $('#msg').val('');
        });

        $('#pwd2').keyup(function () {
          if ($('#pwd1').val() == $('#pwd2').val()) {
            $('#msg').html('비밀번호 일치').attr('style', 'color: skyblue');
            $('input[name=name]').focus();
          } else {
            $('#msg').html('비밀번호 불일치').attr('style', 'color: red');
            $('#pwd2').focus();
          }
        });
    });
	</script>
	
</head>

<body class="bg-gradient" style="background:transparent;">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Register</h1>
                            </div>
                            <form class="user was-validated" action="../plantcare/regist.do" method="POST" onsubmit="return registValidate(this)">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="Name"
                                            placeholder=" Name" name="name" required>
                                        <!-- <div class="invalid-feedback"> 이름을 입력해주세요.</div> -->
                                    </div>
                                </div>
                                
                                <div class="form-group" style="display: flex; flex-wrap: wrap; margin-right: -0.35rem; margin-left: -0.75rem;">
                                	<div class="col-sm-9 mb-3 me-2 mb-sm-0" style="display: flex; justify-content:space-between;">
	                                    <input type="email" class="form-control form-control-user col-sm-9" id="Email"
	                                        placeholder="Email Address" name="email" required>&nbsp;&nbsp;
	                                    <button type="button" class="btn btn-outline-info btn-user" onclick="id_Duplication_Check(this.form)">중복확인</button>
	                    				<span id="id_validate" style="color: skyblue"></span>
	                                </div>
                                </div>
                    				
	                                     
                    				
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" class="form-control form-control-user" onblur="passCheck(this.form);"
                                            id="pwd1" placeholder="Password" name="pass1" required>
                                        <span id="pass_check" style="font-size:12px"></span>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user"
                                            id="pwd2" placeholder="Repeat Password"  name="pass2" required>
                                        <span id="msg" style="font-size:12px"></span>
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-success btn-user btn-block">
                                    회원가입
                                </button>
                                <hr>
                                <a href="" class="btn btn-google btn-user btn-block">
                                    <i class="fab fa-google fa-fw"></i> Google 계정으로 회원가입
                                </a>
                                <a href="" class="btn btn-facebook btn-user btn-block">
                                    <i class="fab fa-facebook-f fa-fw"></i> Facebook 계정으로 회원가입
                                </a>
                            </form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="forgot_password.jsp">비밀번호를 잊으셨나요?</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="../plantcare/login.do">이미 계정이 있으신가요? 로그인</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    
</body>

</html>
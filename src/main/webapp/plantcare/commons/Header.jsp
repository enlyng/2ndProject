<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String popupMode = "on"; 

Cookie[] cookies = request.getCookies();
if (cookies != null) {
    for (Cookie c : cookies) {
        String cookieName = c.getName();
        String cookieValue = c.getValue();
        if (cookieName.equals("PopupClose")) {
            popupMode = cookieValue; 
        }
    }
} 
%>
<!DOCTYPE html>
<!-- saved from url=(0035)Plant_main.html/#contact -->
<html lang="ko">
  <head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <!-- Global site tag (gtag.js) - Google Analytics -->
    <script
      type="text/javascript"
      async=""
      src="./Plant_files/analytics.js.다운로드"
    ></script>
    <script src="./Plant_files/653878285453364" async=""></script>
    <script async="" src="./Plant_files/fbevents.js.다운로드"></script>
    <script async="" src="./Plant_files/js"></script>
    <script>
      window.dataLayer = window.dataLayer || [];
      function gtag() {
        dataLayer.push(arguments);
      }
      gtag("js", new Date());

      gtag("config", "UA-164229575-1");
    </script>

    <!-- Naver Analytics -->
    <meta
      name="naver-site-verification"
      content="7106a9f437dc45d25f934336c4d338f0b2a33a97"
    />

    <!-- Facebook Pixel Code -->
    <script>
      !(function (f, b, e, v, n, t, s) {
        if (f.fbq) return;
        n = f.fbq = function () {
          n.callMethod
            ? n.callMethod.apply(n, arguments)
            : n.queue.push(arguments);
        };
        if (!f._fbq) f._fbq = n;
        n.push = n;
        n.loaded = !0;
        n.version = "2.0";
        n.queue = [];
        t = b.createElement(e);
        t.async = !0;
        t.src = v;
        s = b.getElementsByTagName(e)[0];
        s.parentNode.insertBefore(t, s);
      })(
        window,
        document,
        "script",
        "https://connect.facebook.net/en_US/fbevents.js"
      );
      fbq("init", "653878285453364");
      fbq("track", "PageView");
    </script>
    <noscript
      ><img
        height="1"
        width="1"
        style="display: none"
        src="https://www.facebook.com/tr?id=653878285453364&ev=PageView&noscript=1"
    /></noscript>
    <!-- End Facebook Pixel Code -->

    <meta
      name="viewport"
      content="width=device-width, initial-scale=1.0, maximum-scale=1.0"
    />
    <meta http-equiv="Content-Style-Type" content="text/css" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="title" content="(주)체인지메이커" />
    <meta
      name="description"
      content="도심 속 자연을 선물합니다 - (주)체인지메이커 -"
    />
    <meta
      name="keywords"
      content="체인지메이커, 플랜테리어, 그린오피스, 식물케어, 식물렌탈, 식물, 인테리어, 화훼, 꽃집예약서비스, 반려식물, 분갈이, 자연친화적공간, 공간디자인, 실내녹조화"
    />
    <meta
      property="og:image"
      content="https://www.changemaker.kr/images/img_meta.jpg"
    />
    <meta
      property="og:description"
      content="도심 속 자연을 선물합니다 - (주)체인지메이커 -"
    />
    <meta property="og:title" content="(주)체인지메이커" />
    <meta
      name="naver-site-verification"
      content="61aae5394e49aa659c8bce4779df77a794608d84"
    />
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <title>Plant Care</title>

    <!-- <link rel="stylesheet" href="/2ndProject/plantcare/Plant_files/main.css" type="text/css" />
    <link rel="stylesheet" href="/2ndProject/plantcare/Plant_files/default.css" type="text/css" />
    <link rel="stylesheet" href="/2ndProject/plantcare/Plant_files/reset.css" type="text/css" />
    <link rel="stylesheet" href="/2ndProject/plantcare/Plant_files/sub.css" type="text/css" />
    <link rel="stylesheet" href="/2ndProject/plantcare/Plant_files/slick.css" type="text/css" /> -->

	<link rel="stylesheet" href="https://www.changemaker.kr/css/main.css" type="text/css" />
	<link rel="stylesheet" href="https://www.changemaker.kr/css/default.css" type="text/css" />
	<link rel="stylesheet" href="https://www.changemaker.kr/css/reset.css" type="text/css" />
	<link rel="stylesheet" href="https://www.changemaker.kr/css/sub.css" type="text/css" />
	<link rel="stylesheet" href="https://www.changemaker.kr/css/slick.css" type="text/css" />
	
	
  <!--   <link href="/2ndProject/plantcare/Plant_files/css" rel="stylesheet" />
    <link href="/2ndProject/plantcare/Plant_files/css(1)" rel="stylesheet" />

    <script
      type="text/javascript"
      src="./Plant_files/jquery-1.11.1.min.js.다운로드"
    ></script>
    <script
      type="text/javascript"
      src="./Plant_files/maps.js.다운로드"
    ></script>
    <script src="./Plant_files/postcode.v2.js.다운로드"></script>
    <script
      type="text/javascript"
      src="./Plant_files/slick.js.다운로드"
    ></script>
    <link rel="stylesheet" href="./Plant_files/swiper-bundle.min.css" />
    <script src="./Plant_files/swiper-bundle.min.js.다운로드"></script> -->
    
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700,900&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900&display=swap" rel="stylesheet">
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script type="text/javascript"
	    src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=xinvkhmb9z"></script>
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript" src="https://www.changemaker.kr/jQuery/slick.js"></script>
	
	<link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.2/font/bootstrap-icons.css"
    />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	
	
	<link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css"/>
	<script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
	
	
<style>
    div#popup{
        position: absolute; top:200px; left:100px; color:white;  
        width:400px; height:500px; background-color: white; border: 1px dotted lightgray;
    }
    div#popup>div{
        position: relative; background-color:white; top:0px;
        border:none; padding:10px;
    }
    
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" 
integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
crossorigin="anonymous"></script>
<script>
$(function() {
	//팝업창의 닫기 버튼을 클릭했을때...
    $('#closeBtn').click(function() {
    	//레이어 팝업창을 숨김처리한다.
        $('#popup').hide();
    	//하루동안 열지않음 체크박스에 체크된 경우에만 value를 얻어온다.
        var chkVal = $("input:checkbox[id=inactiveToday]:checked").val();
    	//jQuery ajax() 함수를 통해 요청한다.
        $.ajax({
        	//요청할 서버의 URL(경로)
            url : './PopupCookie.jsp',
            //전송방식
            type : 'get',
            //파라미터(요청시 전송할 값. 파라미터는 JSON형식으로 기술해야한다.)
            data : {inactiveToday : chkVal},
            //콜백 데이터의 형식 지정
            dataType : "text",
            //성공했을 때의 콜백 함수
            success : function(resData) {
            	//콜백 데이터는 매개변수 resData가 받는다.
            	if(resData){
            		console.log('있다');
            	}
            	else{
            		console.log('없다');	
            	}
            	//콜백 데이터가 있다면 화면을 새로고침한다. F5를 누른 것과 동일하다.
                if (resData != '') location.reload();
            }
        });
    });
});
</script>
  </head>
  
  <div id="popup" style="z-index: 999">
        <p align="center"><img style="padding-top:10px" id="popup" src="./Plant_files/serverout.png" alt="" /></p>
        
        <div class="form-check" align="right"><form name="popFrm">
            <input type="checkbox" id="inactiveToday" value="1" />
            <label for="inactiveToday" style="color:#276157">하루 동안 열지 않음</label>
            <input type="button" style="background-color: #276157; color:white" class=" btn" value="닫기" id="closeBtn" />
        </form></div>
    </div>

  <body cz-shortcut-listen="true">
    <div class="contwrap">
      <div class="header">
        <div class="navigation">
          <div class="nav_logo">
            <a href="/2ndProject/plantcare/Plant_main.jsp" class="home"
              ><img src="./Plant_files/logo.png" alt="체인지메이커 로고"
            /></a>
            <div class="sns">
              <a class="trackClick" id="instagram" href="#" target="_blank">
                <img
                  src="./Plant_files/sns_instargram.png"
                  alt="체인지메이커 인스타"
                />
              </a>
              <a class="trackClick" id="facebook" href="#" target="_blank">
                <img
                  src="./Plant_files/sns_facebook.png"
                  alt="체인지메이커 페이스북"
                />
              </a>
              <a class="trackClick" id="blog" href="#" target="_blank">
                <img
                  src="./Plant_files/sns_blog.png"
                  alt="체인지메이커 블로그"
                />
              </a>
            </div>
          </div>
          <ul class="menu">
            <li class="first_menu">
              <a class="about_a" href="#">About</a>
            </li>
            <li class="no_2depth">
              <a href="Design.jsp">Design</a>&nbsp;&nbsp;&nbsp;|
            </li>
            <!-- <li class="no_2depth"><a href="https://greenlab.kr/">Care</a></li>
            <li class="no_2depth">
              <a href="https://fldi.kr/" target="_blank">Platform Service</a>
            </li> -->
            <!-- <li class="no_2depth">
              <a href="Plant_main.html/portfolio">Portfolio</a> 
            </li> -->
            <%
            if (session.getAttribute("UserEmail") != null ) {
            	if(!session.getAttribute("UserEmail").equals("admin@plantcare.com")){
            %>
            <li class="no_2depth"><%= session.getAttribute("UserName") %>님</li>
            <li class="no_2depth"><a href="logout.jsp">Logout</a></li>  |&nbsp;&nbsp;&nbsp;
            <%
            	} else{
            %>
            <li class="admin_menu"><a href="#"><%= session.getAttribute("UserName") %>님</a></li>
            <li class="no_2depth"><a href="logout.jsp">Logout</a></li>  |&nbsp;&nbsp;&nbsp;
            <%
            	}
            } else{
            %>
            <li class="no_2depth"><a href="../plantcare/login.do">Login</a></li>
            <li class="no_2depth"><a href="../plantcare/regist.do">Register</a></li> |&nbsp;&nbsp;&nbsp;
            <%
            }
            %>
            <li class="last_menu"><a href="#">Customer</a></li>
            
          </ul>
          
        </div>
        <div class="menu_2depth">
          <ul>
            <li class="about">
              <ul>
                <li>
                  <a href="./About_company.jsp">Company</a>
                </li>
                <li>
                  <a href="./About_history.jsp">History</a>
                </li>
                <li class="last_menu_2depth">
                  <a href="./About_location.jsp">How to come</a>
                </li>
              </ul>
            </li>
            <li class="admin">
            <ul>
            	<li class="admin_menu_2depth" style="margin-left:800px; position:absolute;"><a href="./index.jsp">AdminPage</a></li>
            </ul>
            </li>
            <li class="customer">
              <ul>
                <li><a href="../plantcare/noticelist_customer.do">Notice</a></li>
                <li><a href="../plantcare/qnalist_customer.do">Q&amp;A</a></li>
                <li class="last_menu_2depth">
                  <a href="/2ndProject/plantcare/Plant_main.jsp#contact">Contact</a>
                </li>
              </ul>
            </li>
          </ul>
          
       
        </div>
      </div>

      <div class="m_header">
        <div class="m_navigation">
          <div class="m_nav_logo">
            <a href="#" class="m_home"
              ><img src="./Plant_files/logo(1).png" alt="체인지메이커 로고"
            /></a>
            <button class="m_menu_open">메뉴열기</button>
          </div>
          <div class="m_menu">
            <div class="m_menu_bg"></div>
            <div class="m_menu_inner">
              <button class="m_menu_close">메뉴닫기</button>
              <ul class="m_menu_1depth">
                <li>
                  <a>About</a>
                  <ul class="m_menu_2depth">
                    <li>
                      <a href="./About_company.jsp">- Company</a>
                    </li>
                    <li>
                      <a href="./About_history.jsp">- History</a>
                    </li>
                    <li>
                      <a href="<%= request.getContextPath() %>/plantcare/About_location.jsp"
                        >- How to come</a
                      >
                    </li>
                  </ul>
                </li>
                <li>
                  <a href="./Design.jsp"> Design</a>
                </li>
                <!-- <li>
                  <a href="Plant_main.jsp/portfolio"> Portfolio</a>
                </li> -->
                <li>
                  <a>Customer</a>
                  <ul class="m_menu_2depth">
                    <li>
                      <a href="../plantcare/noticelist_customer.do">- Notice</a>
                    </li>
                    <li>
                      <a href="../plantcare/qnalist_customer.do">- Q&amp;A</a>
                    </li>
                    <li>
                      <a href="/2ndProject/plantcare/Plant_main.jsp#contact"
                        >- Contact</a
                      >
                    </li>
                  </ul>
                </li>
                <br />
                <%
                if (session.getAttribute("UserEmail") != null ) {
                	if(!session.getAttribute("UserEmail").equals("admin@plantcare.com")){
                %>
                <li style="color:#87C5BA;">
                  <%= session.getAttribute("UserName") %>님
                </li>
                <li>
                  <a href="logout.jsp" style="color:#87C5BA;"> Logout</a>
                </li>
                <%
                	} else{
                %>
                <li>
                <ul class="m_menu_2depth">
                  <p style="color:#87C5BA; font-size: 25px; font-weight:bold;"><%= session.getAttribute("UserName") %>님</p>
                    <li>
                      <a href="index.jsp" style="color:#87C5BA;">- AdminPage</a>
                    </li>
                    <li>
                		<a href="logout.jsp" style="color:#87C5BA;">- Logout</a>
                	</li>
                 </ul>
                </li>
                
                <%
                	}
                } else{
                %>
                <li>
                  <a href="../plantcare/login.do" style="color:#87C5BA;"> Login</a>
                </li>
                <li>
                  <a href="../plantcare/regist.do" style="color:#87C5BA;"> Register</a>
                </li>
                <%
                }
                %>
              </ul>
              
              <!-- <div class="m_sns">
                <a
                  href="#"
                  target="_blank"
                  ><img
                    src="/Plant_files/sns_instargram(1).png"
                    alt="체인지메이커 인스타"
                /></a>
                <a
                  href="#"
                  target="_blank"
                  ><img src="/Plant_files/sns_facebook(1).png" alt="체인지메이커 페이스북"
                /></a>
                <a href="#" target="_blank"
                  ><img
                    src="./Plant_files/sns_blog(1).png"
                    alt="체인지메이커 블로그"
                /></a>
              </div> -->
            </div>
          </div>
        </div>
        
      </div>
	
      <script>
        $("#file_input").on("change", (e) => {
          $(".text").text(e.target.files[0].name);
          $(".text").css("color", "black");
          $(".add").hide();
        });

        $(".modal").show();
      </script>
      
      <script>
        $(".first_menu").mouseenter(function () {
          $(".menu_2depth").slideDown(300);
          $(".customer").hide();
          $(".admin").hide();
          $(".about").show();
          $(".first_menu").addClass("hover_a");
        });

        $(".admin_menu").mouseenter(function () {
            $(".menu_2depth").slideDown(300);
            $(".about").hide();
            $(".customer").hide();
            $(".admin").show();
            $(".admin_menu").addClass("hover_a");
          });
        
        $(".last_menu").mouseenter(function () {
          $(".menu_2depth").slideDown(300);
          $(".about").hide();
          $(".admin").hide();
          $(".customer").show();
          $(".last_menu").addClass("hover_a");
        });

        $(".header").mouseleave(function () {
          $(".menu_2depth").slideUp(200);
          $(".first_menu").removeClass("hover_a");
          $(".admin_menu").removeClass("hover_a");
          $(".last_menu").removeClass("hover_a");
        });

        $(".no_2depth").mouseenter(function () {
          $(".menu_2depth").slideUp(200);
          $(".first_menu").removeClass("hover_a");
          $(".admin_menu").removeClass("hover_a");
          $(".last_menu").removeClass("hover_a");
        });

        $(".slider_on ul").slick({
          slidesToShow: 1,
          slidesToScroll: 1,
          dots: true,
          arrows: true,
          pauseOnHover: true,
          autoplay: true,
          infinite: true,
          centerMode: true,
          variableWidth: true,
        });

        $(".m_menu_open").click(function () {
          $(".m_menu").addClass("m_on");
        });
        $(".m_menu_close").click(function () {
          $(".m_menu").removeClass("m_on");
        });

        $(".menu").children().eq().addClass("on");

        $(".trackClick").click((e) => {
          fbq("trackCustom", e.currentTarget.id);
        });
      </script>
    </div>
     <div style="position: fixed; right: 80px; bottom:0px; z-index: 999999;">
       <img type="button" src="/2ndProject/plantcare/Plant_files/websocket_icon.png" onclick="window.open('/2ndProject/plantcare/MultiChatMain.jsp', '', 'width=400,height=400');" alt="소켓이미지" style="width: 100px; height: 100px"/>
    </div>
  </body>
</html>

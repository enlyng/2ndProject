<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-164229575-1"></script>
<script>
    window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-164229575-1');
</script>

<!-- Naver Analytics -->
<meta name="naver-site-verification" content="7106a9f437dc45d25f934336c4d338f0b2a33a97" />

<!-- Facebook Pixel Code -->
<script>
    !function(f,b,e,v,n,t,s)
    {if(f.fbq)return;n=f.fbq=function(){n.callMethod?
    n.callMethod.apply(n,arguments):n.queue.push(arguments)};
    if(!f._fbq)f._fbq=n;n.push=n;n.loaded=!0;n.version='2.0';
    n.queue=[];t=b.createElement(e);t.async=!0;
    t.src=v;s=b.getElementsByTagName(e)[0];
    s.parentNode.insertBefore(t,s)}(window, document,'script',
    'https://connect.facebook.net/en_US/fbevents.js');
    fbq('init', '653878285453364');
    fbq('track', 'PageView');
</script>
<noscript><img height="1" width="1" style="display:none"
        src="https://www.facebook.com/tr?id=653878285453364&ev=PageView&noscript=1" /></noscript>
<!-- End Facebook Pixel Code -->

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="title" content="(주)체인지메이커">
<meta name="description" content="도심 속 자연을 선물합니다 - (주)체인지메이커 -">
<meta name="keywords"
    content="체인지메이커, 플랜테리어, 그린오피스, 식물케어, 식물렌탈, 식물, 인테리어, 화훼, 꽃집예약서비스, 반려식물, 분갈이, 자연친화적공간, 공간디자인, 실내녹조화">
<meta property="og:image" content="https://www.changemaker.kr/images/img_meta.jpg">
<meta property="og:description" content="도심 속 자연을 선물합니다 - (주)체인지메이커 -">
<meta property="og:title" content="(주)체인지메이커">
<meta name="naver-site-verification" content="61aae5394e49aa659c8bce4779df77a794608d84" />
<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<title>Plantcare</title>

<!-- <link rel="stylesheet" href="https://www.changemaker.kr/css/main.css" type="text/css" />
<link rel="stylesheet" href="https://www.changemaker.kr/css/default.css" type="text/css" />
<link rel="stylesheet" href="https://www.changemaker.kr/css/reset.css" type="text/css" />
<link rel="stylesheet" href="https://www.changemaker.kr/css/sub.css" type="text/css" />
<link rel="stylesheet" href="https://www.changemaker.kr/css/slick.css" type="text/css" />


<link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700,900&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900&display=swap" rel="stylesheet">

<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
    src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=xinvkhmb9z"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="https://www.changemaker.kr/jQuery/slick.js"></script>


<link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css"/>
<script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script> -->
</head>

<body>
    <div class="contwrap">
  
<jsp:include page="./commons/Header.jsp" />
        <div class="sub_intro qna_intro">
    <div class="pc_none intro_img"><img src="Plant_files/bg_qna.png" alt="체인지메이커에게 문의하세요" /></div>
    <p class="sub_title mb_none">체인지메이커에게<br>문의하세요</p>
</div>
<div class = "qna_create">
    <form class = "qna_form" method="POST" action = "../plantcare/qnawrite_customer.do">
        <input type="hidden" name="_token" value="fP5R1JpvIvX390HYV01ssn0DmzWDn5R9TtAQC7CW">        <table class = "qna_table">
            <colgroup>
                <col style="width:15%;">
                <col style="width:35%;">
                <col style="width:15%;">
                <col style="width:35%;">
            </colgroup>
            <tbody>
                <tr>
                    <td class = "qna_tag_name">이름<span>*</span></td>
                    <td><input type="text" name = "name" required></td>
                    <td class = "qna_tag_name">이메일<span>*</span></td>
                    <td><input type="email" name = "email" required></td>
                </tr>
                <tr>
                    <td class = "qna_tag_name">연락처<span>*</span></td>
                    <td><input type="tel" name="phone" required></td>
                    <td class = "qna_tag_name">비밀번호<span>*</span></td>
                    <td><input type="password" name="pass" required></td>
                </tr>
                <tr>
                    <td class = "qna_tag_name">제목<span>*</span></td>
                    <td colspan="3"><input type="text" name="title" required></td>
                </tr>
                <tr>
                    <td class = "qna_tag_name">내용<span>*</span></td>
                    <td colspan="3"><textarea rows='10' name = "content" required></textarea></td>
                </tr>
            </tbody>
        </table>
        <button type="submit">등록하기</button>
    </form>
</div>
<jsp:include page="./commons/Footer.jsp" />	

    <!--     <script>
    $(".first_menu").mouseenter(function(){
        $(".menu_2depth").slideDown(300);
        $(".customer").hide();
        $(".about").show();
        $(".first_menu").addClass("hover_a");
    });

    $(".last_menu").mouseenter(function(){
        $(".menu_2depth").slideDown(300);
        $(".about").hide();
        $(".customer").show();
        $(".last_menu").addClass("hover_a");
    });

    $(".header").mouseleave(function(){
        $(".menu_2depth").slideUp(200);
        $(".first_menu").removeClass("hover_a");
        $(".last_menu").removeClass("hover_a");
    });

    $(".no_2depth").mouseenter(function(){
        $(".menu_2depth").slideUp(200);
        $(".first_menu").removeClass("hover_a");
        $(".last_menu").removeClass("hover_a");
    });

    $(".slider_on ul").slick({
						slidesToShow: 1,
						slidesToScroll: 1,
						dots: true,
						arrows: true,
						pauseOnHover: true,
						autoplay:true,
						infinite:true,
						centerMode: true,
						variableWidth: true
                    });

    $(".m_menu_open").click(function(){
        $(".m_menu").addClass("m_on");
    });
    $(".m_menu_close").click(function(){
        $(".m_menu").removeClass("m_on");
    });
                    
    $('.menu').children()
                    .eq(5)
                    .addClass('on');

    $('.trackClick').click((e)=>{
        fbq('trackCustom', e.currentTarget.id)
    })
</script>    --> </div>

    <script type="text/javascript" src="//wcs.naver.net/wcslog.js"></script>
    <script type="text/javascript">
        if(!wcs_add) var wcs_add = {};
wcs_add["wa"] = "5c143a3a26f6c0";
wcs_do();
    </script>
</body>

</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>${pageTitle}</title>

    <!-- 제이쿼리 불러오기 -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <!-- 테일윈드 불러오기 -->
    <!-- 노말라이즈, 라이브러리 해결 -->
    <script src="https://unpkg.com/tailwindcss-jit-cdn"></script>

    <!-- 폰트어썸 불러오기 !-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />

    <link rel="stylesheet" href="/resource/common.css" />
    <script src = "/resource/common.js" defer="defer"></script>
</head>
<body>


<header>
    <div class = "h-20 flex container mx-auto">
    <a href="/" class="flex items-center px-3">
        <span>로고</span>
    </a>

    <div class = "flex-grow"></div>

    <ul class="flex">
        <li>
            <a class="h-full flex items-center px-3 hover:underline" href="/">
                <span>홈</span>
            </a>
        </li>
        <li>
            <a class="h-full flex items-center px-3 hover:underline" href="/usr/member/join">
                <span>회원가입</span>
            </a>
        </li>
        <li>
            <a class="h-full flex items-center px-3 hover:underline" href="/usr/member/login">
                <span>로그인</span>
            </a>
        </li>
    </ul>
        </div>
    </header>

    <section class = "mt-5">
        <div class="container mx-auto px-3">
            <h1>${pageTitle}페이지</h1>
        </div>
    </section>

<main>
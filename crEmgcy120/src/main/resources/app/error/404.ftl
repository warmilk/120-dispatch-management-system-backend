<#assign  base="${springMacroRequestContext.contextPath}" />

<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>404</title>
    <link rel="stylesheet" href="${base}/css/error/error.css">
</head>
<body>
<div class="error-404">
    <div class="img">
        <img src="${base}/images/error/404_icon.png" alt="">
    </div>
    <div class="font">
        <h3 class="title">404</h3>
        <p class="text">访问的页面不存在</p>
        <p class="text-english">Page is not found</p>
        <p class="back"><a href="#" onclick="history.go(-1)">返回 →</a></p>
    </div>
</div>
</body>
</html>
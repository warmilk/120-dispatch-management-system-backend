<#assign  base="${springMacroRequestContext.contextPath}" />

<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>500</title>
    <link rel="stylesheet" href="${base}/css/error/error.css">
</head>
<body>
<div class="error-404">
    <div class="img">
       <img src="${base}/images/error/500_icon.png" alt="">
    </div>
    <div class="font">
        <h3 class="title-500"></h3>
        <p class="text">正在审核中</p>
        <p class="back"><a href="javascript:window.history.go(-1);">返回 →</a></p>
    </div>
</div>
</body>
</html>
<html>
<head>
    <meta charset="utf-8">
    <title>错误提示</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="alert alert-dismissable alert-danger">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4>
                    错误!
                </h4> <strong>${msg!"失败"}</strong>
                <h6><a href="${url}" class="alert-link">点此处返回 2s后自动跳转</a></h6>
            </div>
        </div>
    </div>
</div>

</body>

<script>
    setTimeout('location.href="${url}"', 2000);
</script>

</html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html dir="rtl" lang="fa">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
    <link href="resources/css/login.css" rel="stylesheet"/>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<div class="container">

    <form class="form-signin">
        <h2 class="form-signin-heading">ورود به سامانه</h2>
        <label for="inputEmail" class="sr-only">نام کاربری</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="نام کاربری" required="required" autofocus="autofocus"/>
        <label for="inputPassword" class="sr-only">رمز عبور</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="رمز عبور" required="required"/>
        <div class="checkbox">

            <input type="checkbox" value="remember-me"/>
            <label style="margin-right: 20px;"> من رو یادت باشه :))
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">ورود</button>
    </form>

</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
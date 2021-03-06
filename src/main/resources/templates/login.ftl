<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>reCaptcha Demo</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">

    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>

    <!--<script type="text/javascript" src="js/main2.js"></script>-->
    <script type="text/javascript" src="/wro/all.js"></script>
</head>
<body ng-app="reCaptchaDemo" ng-controller="AppCtrl">
<div class="container" style="margin-top: 60px">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <h1 class="page-header">ReCaptcha Demo</h1>
            <form style="margin-bottom: 30px" name="form" autocomplete="off" novalidate ng-submit="form.$valid && sendForm(auth)">
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email"
                           class="form-control"
                           id="exampleInputEmail1"
                           placeholder="Email"
                           required
                           ng-model="auth.email">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password"
                           class="form-control"
                           id="exampleInputPassword1"
                           placeholder="Password"
                           required
                           ng-model="auth.password">
                </div>
                <recaptcha sitekey="6LdVNpIUAAAAAHiu2OcmKtBVBU-iGhvVCgqrw4lO"
                           ng-model="auth.recaptchaResponse" hl="ru">
                </recaptcha>
                <button type="submit" class="btn btn-default" style="margin-top:30px" ng-disabled="form.$invalid">
                    Submit
                </button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
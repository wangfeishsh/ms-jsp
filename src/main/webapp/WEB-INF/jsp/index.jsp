<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script>
        function dosubmit1() {
            document.form.action = "/kq/online";
            document.form.submit();
        }
        function dosubmit2() {
            document.form.action = "/bf/online";
            document.form.submit();
        }
        function dosubmit3() {
            document.form.action = "/sft/online";
            document.form.submit();
        }

        function dosubmit4() {
            document.form.action = "/ll/online";
            document.form.submit();
        }
        function dosubmit5() {
            document.form.action = "/ll/wap";
            document.form.submit();
        }
        function dosubmit6() {
            document.form.action = "/ll/web";
            document.form.submit();
        }
        function dosubmit7() {
            document.form.action = "/ll/app";
            document.form.submit();
        }
    </script>
</head>
<body>
<form name="form" method="get">
    <fieldset>
        <input type="button" id="submit1" value="提交快钱" onclick="dosubmit1()"/>
        <input type="button" id="submit2" value="提交宝付" onclick="dosubmit2()"/>
        <input type="button" id="submit3" value="提交盛付通" onclick="dosubmit3()"/>
    </fieldset>
    <fieldset>
        <input type="button" id="submit4" value="提交连连Online" onclick="dosubmit4()"/>
        <input type="button" id="submit5" value="提交连连Wap" onclick="dosubmit5()"/>
        <input type="button" id="submit6" value="提交连连Web" onclick="dosubmit6()"/>
        <input type="button" id="submit7" value="提交连连App" onclick="dosubmit7()"/>
    </fieldset>
</form>

</body>

</html>
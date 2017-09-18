<%-- 
    Document   : home
    Created on : May 9, 2016, 10:48:09 PM
    Author     : Mohan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Order App | Dashboard</title>

        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

        <!-- Bootstrap 3.3.5 -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css">
        <!-- Ionicons -->
        <!--<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">-->

        <!-- Theme style -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/AdminLTE.min.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/skins/_all-skins.min.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jQueryUI/jquery-ui.min.css">
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <!--start js import-->

        <!-- jQuery 2.1.4 -->
        <script src="${pageContext.request.contextPath}/resources/jQuery/jQuery-2.1.4.min.js"></script>
        <!-- jQuery UI 1.11.4 -->
        <script src="${pageContext.request.contextPath}/resources/jQueryUI/jquery-ui.min.js"></script>
        <!-- jQuery Toaster -->
        <script src="${pageContext.request.contextPath}/resources/jQueryToaster/jquery.toaster.js"></script>
        <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
        <script>
            $.widget.bridge('uibutton', $.ui.button);
        </script>
        <!-- Bootstrap 3.3.5 -->
        <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
        <!-- AdminLTE App -->
        <script src="${pageContext.request.contextPath}/resources/dist/js/app.min.js"></script>
        <!--datatables-->
        <script src="${pageContext.request.contextPath}/resources/datatables/jquery.dataTables.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/datatables/dataTables.bootstrap.min.js"></script>


        <!--end js import-->

        <div class="wrapper">
            <jsp:include page="/WEB-INF/views/main-header.jsp"/>

            <jsp:include page="/WEB-INF/views/main-sidebar.jsp"/>

            <div class="content-wrapper">

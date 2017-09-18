<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--start top contents of page-->
<jsp:include page="/WEB-INF/views/import-top.jsp"/>
<!--end top contents of page-->

<!--start page content-->
<section class="content-header">
    <h1>
        User Control Panel
        <small>view user information and other options</small>

    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Control Panel</a></li>
        <li class="active">User Control Panel</li>
    </ol>
</section>

<section class="content">
    <!--start item basic information-->
    <div class="box box-primary">
        <div class="box-header with-border">
            <h3 class="box-title">User List</h3>

            <div class="pull-right" >
                <a class="btn btn-xs btn-success" href="${pageContext.request.contextPath}/app/user-form/new"><i class="fa fa-plus"></i>&nbsp;New User</a>
            </div>
        </div>

        <div class="box-body  no-padding" id="transactor-list">
            <table class="table table-hover table-bordered table-striped" id="item-table">
                <thead>
                <th>#</th>
                <th>Name</th>
                <th>Item Ctrl.</th>
                <th>Customer Ctrl.</th>
                <th>Supplier Ctrl.</th>
                <th>User Ctrl.</th>
                <th>Cust. App.</th>
                <th>Order App.</th>
                <th>Reports</th>
                <th>Mobile</th>
                <th>Status</th>
                <th></th>
                </thead>
                <tbody>
                    <c:forEach items="${users}" var="i" varStatus="loop">
                        <tr id="row-${i.indexNo}">
                            <td>${loop.index+1}</td>
                            <td>${i.name}</td>
                            <td><c:if test="${i.itemControlPanel}"><i class="fa fa-check"></i></c:if></td>
                            <td><c:if test="${i.customerControlPanel}"><i class="fa fa-check"></i></c:if></td>
                            <td><c:if test="${i.supplierControlPanel}"><i class="fa fa-check"></i></c:if></td>
                            <td><c:if test="${i.userControlPanel}"><i class="fa fa-check"></</c:if></td>
                            <td><c:if test="${i.customerApproval}"><i class="fa fa-check"></</c:if></td>
                            <td><c:if test="${i.orderApproval}"><i class="fa fa-check"></</c:if></td>
                            <td><c:if test="${i.reports}"><i class="fa fa-check"></</c:if></td>
                            <td><c:if test="${i.mobileApp}"><i class="fa fa-check"></</c:if></td>
                            <td>
                                <c:if test="${i.active}">
                                    <a class="btn btn-xs btn-success" data-toggle="tooltip" title="Click here to deactivate" id="status-${i.indexNo}" onclick="toggleActive('${i.indexNo}');">Active</a>
                                </c:if>
                                <c:if test="${!i.active}">
                                    <a class="btn btn-xs btn-danger" data-toggle="tooltip" title="Click here to activate"  id="status-${i.indexNo}" onclick="toggleActive('${i.indexNo}');">Deactivated</a>
                                </c:if>
                            </td>
                            <td>
                                <a class="btn btn-xs btn-primary"  href="${pageContext.request.contextPath}/app/user-form/view/${i.indexNo}">View</a>
                                <a class="btn btn-xs btn-warning" href="${pageContext.request.contextPath}/app/user-form/edit/${i.indexNo}">Edit</a>
                                <a class="btn btn-xs btn-danger" onclick="deleteTransactor('${i.indexNo}');">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </div>

</section>
<!--end page content-->

<script>
    <jsp:include page="user-list.js"/>
</script>

<!--start bottom contents of page-->
<jsp:include page="/WEB-INF/views/import-bottom.jsp"/>
<!--end bottom contents of page-->

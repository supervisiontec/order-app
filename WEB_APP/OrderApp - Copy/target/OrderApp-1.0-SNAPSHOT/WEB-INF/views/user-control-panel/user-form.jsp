<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--start top contents of page-->
<jsp:include page="/WEB-INF/views/import-top.jsp"/>
<!--end top contents of page-->

<!--start page content-->
<section class="content-header">
    <h1>
        User Control Panel
        <small>create new users</small>
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
            <h3 class="box-title">User Information</h3>
        </div>

        <div class="box-body  no-padding" id="item-list">
            <!--content-->
            <div class="form-group col-lg-12">
                <label for="name">Name</label>
                <input type="text"  class="form-control" id="name" placeholder="Input name here" value="${user.name}">
            </div>

            <div class="form-group col-lg-12">
                <label class="checkbox-inline" >
                    <input type="checkbox" id="itemControlPanel" <c:if test="${user.itemControlPanel}">checked</c:if> >
                    Item Control Panel
                </label>

                <label class="checkbox-inline" >
                    <input type="checkbox" id="customerControlPanel" <c:if test="${user.customerControlPanel}">checked</c:if>>
                    Customer Control Panel
                </label>


                <label class="checkbox-inline" >
                    <input type="checkbox" id="supplierControlPanel" <c:if test="${user.supplierControlPanel}">checked</c:if>>
                    Supplier Control Panel
                </label>

                <label class="checkbox-inline" >
                    <input type="checkbox" id="userControlPanel" <c:if test="${user.userControlPanel}">checked</c:if>>
                    User Control Panel
                </label>

                <label class="checkbox-inline" >
                    <input type="checkbox" id="customerApproval" <c:if test="${user.customerApproval}">checked</c:if>>
                    Customer Approval
                </label>

                <label class="checkbox-inline" >
                    <input type="checkbox" id="orderApproval" <c:if test="${user.orderApproval}">checked</c:if>>
                    Order Approval
                </label>

                <label class="checkbox-inline" >
                    <input type="checkbox" id="reports" <c:if test="${user.reports}">checked</c:if>>
                    Reports
                </label>

                <label class="checkbox-inline" >
                    <input type="checkbox" id="mobileApp" <c:if test="${user.mobileApp}">checked</c:if>>
                    Mobile App
                </label>
            </div>
        </div>
        <div class="box-footer">
            <c:if test="${action=='new'}">
                <button type="button" class="btn btn-primary" onclick="saveUser();">
                    <i class="fa fa-save"></i> 
                    &nbsp;Save
                </button>
                <button type="button" class="btn btn-default" onclick="clear();">
                    <i class="fa fa-close"></i> 
                    &nbsp;Discard
                </button>
                <a type="button" class="btn btn-default" href="${pageContext.request.contextPath}/app/user-list">
                    <i class="fa fa-backward"></i> 
                    &nbsp;Go Back
                </a>
            </c:if>
            <c:if test="${action=='edit'}">
                <button type="button" class="btn btn-primary" onclick="updateUser();">
                    <i class="fa fa-save"></i> 
                    &nbsp;Update
                </button>
                <a type="button" class="btn btn-default" href="${pageContext.request.contextPath}/app/user-list">
                    <i class="fa fa-backward"></i> 
                    &nbsp;Go Back
                </a>
            </c:if>
            <c:if test="${action=='view'}">
                <a type="button" class="btn btn-default" href="${pageContext.request.contextPath}/app/user-list">
                    <i class="fa fa-backward"></i> 
                    &nbsp;Go Back
                </a>
            </c:if>
        </div>
    </div>

    <!--start new route dialog-->
    <!--    <div id="new-route-dialog" class="modal modal-primary fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                        <h4 class="modal-title">New Route</h4>
                    </div>
                    <div class="modal-body">
                        <input type="text" class="form-control" id="new-route-name" placeholder="Enter new route name">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-outline" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-outline" onclick="newRoute();">Save changes</button>
                    </div>
                </div>
            </div>
        </div>-->
    <!--end new route dialog-->

</section>
<!--end page content-->

<script>
    var rootPath = '${pageContext.request.contextPath}' + '/app';
    var action = '<c:out value="${action}"/>';

    var indexNo = <c:out value="${user!=null?user.indexNo:'null'}"/>;

    if (action == 'view') {
        $(":input").attr("disabled", "disabled");
    }

    <jsp:include page="user-form.js"/>
</script>

<!--start bottom contents of page-->
<jsp:include page="/WEB-INF/views/import-bottom.jsp"/>
<!--end bottom contents of page-->

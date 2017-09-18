<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--start top contents of page-->
<jsp:include page="/WEB-INF/views/import-top.jsp"/>
<!--end top contents of page-->

<!--start page content-->
<section class="content-header">
    <h1>
        Supplier Control Panel
        <small>create new suppliers</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Control Panel</a></li>
        <li class="active">Supplier Control Panel</li>
    </ol>
</section>

<section class="content">
    <!--start item basic information-->
    <div class="box box-primary">
        <div class="box-header with-border">
            <h3 class="box-title">Supplier Information</h3>
        </div>

        <div class="box-body  no-padding" id="item-list">
            <!--content-->

            <div class="form-group col-lg-8">
                <label for="name">Name</label>
                <input type="text"  class="form-control" id="name" placeholder="Input name here" value="${transactor.name}">
            </div>

            <div class="form-group col-lg-4">
                <label for="name">Contact Person</label>
                <input type="text"  class="form-control" id="contactPerson" placeholder="Input name here" value="${transactor.contactPerson}">
            </div>

            <div class="form-group col-lg-4">
                <label for="mobile">Mobile Number</label>
                <input type="text"  class="form-control" id="mobile" placeholder="Input mobile here" value="${transactor.mobile}">
            </div>

            <div class="form-group col-lg-4">
                <label for="telephone1">Telephone Number 01</label>
                <input type="text"  class="form-control" id="telephone1" placeholder="Input telephone here" value="${transactor.telephone1}">
            </div>

            <div class="form-group col-lg-4">
                <label for="telephone2">Telephone Number 02</label>
                <input type="text"  class="form-control" id="telephone2" placeholder="Input telephone here" value="${transactor.telephone2}">
            </div>

            <div class="form-group col-lg-4">
                <label for="addressLine1">Address Line 1</label>
                <input type="text"  class="form-control" id="addressLine1" placeholder="Address line 1" value="${transactor.addressLine1}">
            </div>

            <div class="form-group col-lg-4">
                <label for="addressLine2">Address Line 2</label>
                <input type="text"  class="form-control" id="addressLine2" placeholder="Address line 2" value="${transactor.addressLine2}">
            </div>

            <div class="form-group col-lg-4">
                <label for="addressLine3">Address Line 3</label>
                <input type="text"  class="form-control" id="addressLine3" placeholder="Address line 3" value="${transactor.addressLine3}">
            </div>

            <div class="form-group col-lg-4">
                <label for="fax">Fax Number</label>
                <input type="text"  class="form-control" id="fax" placeholder="Input fax here" value="${transactor.fax}">
            </div>

            <div class="form-group col-lg-8">
                <label for="email">E-mail</label>
                <input type="text"  class="form-control" id="email" placeholder="Input e-mail here" value="${transactor.email}">
            </div>

<!--            <div class="form-group col-lg-4">
                <label for="route">Route</label>

                <div class="input-group">
                    <input type="text"  class="form-control" id="route" placeholder="Input route here" value="${transactor.MRoute.name}">

                    <span class="input-group-btn">
                        <button class="btn btn-primary btn-flat" type="button" onclick="showNewRoute();">
                            <i class="fa fa-plus"></i>
                        </button>
                    </span>
                </div>
            </div>-->

            <div class="form-group col-lg-6">
                <label for="creditLimit">Credit Limit</label>
                <input type="number"  class="form-control" id="creditLimit" placeholder="Input credit limit here" value="${transactor.creditLimit}">
            </div>

            <div class="form-group col-lg-6">
                <label for="creditAmount">Credit Amount</label>
                <input type="number"  class="form-control" id="creditAmount" placeholder="Input credit amount here" value="${transactor.creditAmount}">
            </div>
        </div>
        <div class="box-footer">
            <c:if test="${action=='new'}">
                <button type="button" class="btn btn-primary" onclick="saveTransactor();">
                    <i class="fa fa-save"></i> 
                    &nbsp;Save
                </button>
                <button type="button" class="btn btn-default" onclick="clear();">
                    <i class="fa fa-close"></i> 
                    &nbsp;Discard
                </button>
                <a type="button" class="btn btn-default" href="${pageContext.request.contextPath}/app/supplier-list">
                    <i class="fa fa-backward"></i> 
                    &nbsp;Go Back
                </a>
            </c:if>
            <c:if test="${action=='edit'}">
                <button type="button" class="btn btn-primary" onclick="updateTransactor();">
                    <i class="fa fa-save"></i> 
                    &nbsp;Update
                </button>
                <a type="button" class="btn btn-default" href="${pageContext.request.contextPath}/app/supplier-list">
                    <i class="fa fa-backward"></i> 
                    &nbsp;Go Back
                </a>
            </c:if>
            <c:if test="${action=='view'}">
                <a type="button" class="btn btn-default" href="${pageContext.request.contextPath}/app/supplier-list">
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

    var indexNo = <c:out value="${transactor!=null?transactor.indexNo:'null'}"/>;
    var selectedRoute = null;

    if (action == 'view') {
        $(":input").attr("disabled", "disabled");
    }

    <jsp:include page="supplier-form.js"/>
</script>

<!--start bottom contents of page-->
<jsp:include page="/WEB-INF/views/import-bottom.jsp"/>
<!--end bottom contents of page-->

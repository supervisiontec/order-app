<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--start top contents of page-->
<jsp:include page="/WEB-INF/views/import-top.jsp"/>
<!--end top contents of page-->

<!--start page content-->
<section class="content-header">
    <h1>
        Customer Approval
        <small>approve pending customers</small>

    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-check"></i> Approval</a></li>
        <li class="active">customer approval</li>
    </ol>
</section>

<section class="content">
    <!--start item basic information-->
    <div class="box box-primary">
        <div class="box-header with-border">
            <h3 class="box-title">Customer List</h3>
        </div>

        <div class="box-body  no-padding" id="transactor-list">
            <table class="table table-hover" id="item-table">
                <thead>
                <th>#</th>
                <th>Code</th>
                <th>Name</th>
                <th>Route</th>
                <th>Telephone</th>
                <th>Address</th>
                <th>Approval Status</th>
                </thead>
                <tbody>
                    <c:forEach items="${transactors}" var="i" varStatus="loop">
                        <tr id="row-${i.indexNo}">
                            <td>${loop.index+1}</td>
                            <td>${i.code}</td>
                            <td>${i.name}</td>
                            <td>${i.MRoute.name}</td>
                            <td>${i.mobile}, ${i.telephone1}, ${i.telephone2}</td>
                            <td>${i.addressLine1}, ${i.addressLine2}, ${i.addressLine3}</td>
                            <td>
                                <c:if test="${i.approved}">
                                    <a class="btn btn-xs btn-success" data-toggle="tooltip" title="Click here to deactivate" id="status-${i.indexNo}" onclick="toggleApprove('${i.indexNo}');">Approved</a>
                                </c:if>
                                <c:if test="${!i.approved}">
                                    <a class="btn btn-xs btn-danger" data-toggle="tooltip" title="Click here to activate"  id="status-${i.indexNo}" onclick="toggleApprove('${i.indexNo}');">Pending</a>
                                </c:if>
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
    <jsp:include page="customer-approval.js"/>
</script>

<!--start bottom contents of page-->
<jsp:include page="/WEB-INF/views/import-bottom.jsp"/>
<!--end bottom contents of page-->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--start top contents of page-->
<jsp:include page="/WEB-INF/views/import-top.jsp"/>
<!--end top contents of page-->

<!--start page content-->
<section class="content-header">
    <h1>
        Item Control Panel
        <small>view item information and other options</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Control Panel</a></li>
        <li class="active">Item Control Panel</li>
    </ol>
</section>

<section class="content">
    <!--start item basic information-->
    <div class="box box-primary">
        <div class="box-header with-border">
            <h3 class="box-title">Item List</h3>
            
            <div class="pull-right" >
                <a class="btn btn-xs btn-success" href="${pageContext.request.contextPath}/app/item-form/new"><i class="fa fa-plus"></i>&nbsp;New Item</a>
            </div>
        </div>

        <div class="box-body  no-padding" id="item-list">
            <table class="table table-hover" id="item-table">
                <thead>
                <th>#</th>
                <th>Code</th>
                <th>Name</th>
                <th>Department</th>
                <th>Main Category</th>
                <th>Sub Category</th>
                <th>Status</th>
                <th></th>
                </thead>
                <tbody>
                    <c:forEach items="${items}" var="i" varStatus="loop">
                        <tr id="row-${i.indexNo}">
                            <td>${loop.index+1}</td>
                            <td>${i.code}</td>
                            <td>${i.name}</td>
                            <td>${i.MDepartment.name}</td>
                            <td>${i.MMainCategory.name}</td>
                            <td>${i.MSubCategory.name}</td>
                            <td>
                                <c:if test="${i.active}">
                                    <a class="btn btn-xs btn-success" data-toggle="tooltip" title="Click here to deactivate" id="status-${i.indexNo}" onclick="toggleActive('${i.indexNo}');">Active</a>
                                </c:if>
                                <c:if test="${!i.active}">
                                    <a class="btn btn-xs btn-danger" data-toggle="tooltip" title="Click here to activate"  id="status-${i.indexNo}" onclick="toggleActive('${i.indexNo}');">Deactivated</a>
                                </c:if>
                            </td>
                            <td>
                                <a class="btn btn-xs btn-primary"  href="${pageContext.request.contextPath}/app/item-form/view/${i.indexNo}">View</a>
                                <a class="btn btn-xs btn-warning" href="${pageContext.request.contextPath}/app/item-form/edit/${i.indexNo}">Edit</a>
                                <a class="btn btn-xs btn-danger" onclick="deleteItem('${i.indexNo}');">Delete</a>
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
    <jsp:include page="item-list.js"/>
</script>

<!--start bottom contents of page-->
<jsp:include page="/WEB-INF/views/import-bottom.jsp"/>
<!--end bottom contents of page-->

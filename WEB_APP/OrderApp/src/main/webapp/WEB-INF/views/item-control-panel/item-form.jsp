<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--start top contents of page-->
<jsp:include page="/WEB-INF/views/import-top.jsp"/>
<!--end top contents of page-->

<!--start page content-->
<section class="content-header">
    <h1>
        Item Control Panel
        <small>create new items</small>
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
            <h3 class="box-title">Item Information</h3>
        </div>
        <div class="box-body" id="item-form">

            <div class="form-group col-lg-4">
                <label for="code">Code</label>
                <input type="text" class="form-control" id="code" placeholder="Enter item code" value="${item.code}">
            </div>

            <div class="form-group col-lg-4">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" placeholder="Enter item name" value="${item.name}">
            </div>

            <div class="form-group col-lg-4">
                <label for="printDescription">Print Description</label>
                <input type="text" class="form-control" id="printDescription" placeholder="Enter item print description" value="${item.printDescription}">
            </div>

            <div class="form-group col-lg-12">
                <label for="supplier">Supplier</label>
                <input type="text" class="form-control" id="supplier" placeholder="Enter item supplier" value="${item.MTransactor.name}">
            </div>

            <div class="form-group col-lg-4">
                <label for="department">Department</label>

                <div class="input-group">
                    <input type="text" class="form-control" id="department" placeholder="Enter item department" value="${item.MDepartment.name}">

                    <span class="input-group-btn">
                        <button class="btn btn-primary btn-flat" type="button" onclick="showNewDepartment();">
                            <i class="fa fa-plus"></i>
                        </button>
                    </span>
                </div>
            </div>

            <div class="form-group col-lg-4">
                <label for="mainCategory">Main Category</label>

                <div class="input-group">
                    <input type="text" class="form-control" id="mainCategory" placeholder="Enter item main category" value="${item.MMainCategory.name}">

                    <span class="input-group-btn">
                        <button class="btn btn-primary btn-flat" type="button" onclick="showNewMainCategory();">
                            <i class="fa fa-plus"></i>
                        </button>
                    </span>
                </div>
            </div>

            <div class="form-group col-lg-4">
                <label for="subCategory">Sub Category</label>

                <div class="input-group">
                    <input type="text" class="form-control" id="subCategory" placeholder="Enter item sub category" value="${item.MSubCategory.name}">

                    <span class="input-group-btn">
                        <button class="btn btn-primary btn-flat" type="button" onclick="showNewSubCategory();">
                            <i class="fa fa-plus"></i>
                        </button>
                    </span>
                </div>
            </div>

            <div class="form-group col-lg-4">
                <label for="unit">Unit</label>
                <input type="text" class="form-control" id="unit" placeholder="Enter item unit" value="${item.defaultUnit}">
            </div>

            <div class="form-group col-lg-2">
                <label for="costPrice">Cost Price</label>
                <input type="number" class="form-control" id="costPrice" placeholder="Enter cost price" value="${item.costPrice}">
            </div>

            <div class="form-group col-lg-2">
                <label for="wholeSalePrice">Retail Price</label>
                <input type="number" class="form-control" id="retailPrice" placeholder="Enter retail price" value="${item.retailPrice}">
            </div>

            <div class="form-group col-lg-4">
                <label for="lastSalePrice">Maximum discount percent</label>
                <input type="number" class="form-control" id="maxDiscountPercent" placeholder="Enter maximum discount percnet" value="${item.maxDiscountPercent}">
            </div>
        </div>

        <div class="box-footer">
            <c:if test="${action=='new'}">
                <button type="button" class="btn btn-primary" onclick="saveItem();">
                    <i class="fa fa-save"></i> 
                    &nbsp;Save
                </button>
                <button type="button" class="btn btn-default" onclick="clear();">
                    <i class="fa fa-close"></i> 
                    &nbsp;Discard
                </button>
                <a type="button" class="btn btn-default" href="${pageContext.request.contextPath}/app/item-list">
                    <i class="fa fa-backward"></i> 
                    &nbsp;Go Back
                </a>
            </c:if>
            <c:if test="${action=='edit'}">
                <button type="button" class="btn btn-primary" onclick="updateItem();">
                    <i class="fa fa-save"></i> 
                    &nbsp;Update
                </button>
                <a type="button" class="btn btn-default" href="${pageContext.request.contextPath}/app/item-list">
                    <i class="fa fa-backward"></i> 
                    &nbsp;Go Back
                </a>
            </c:if>
            <c:if test="${action=='view'}">
                <a type="button" class="btn btn-default" href="${pageContext.request.contextPath}/app/item-list">
                    <i class="fa fa-backward"></i> 
                    &nbsp;Go Back
                </a>
            </c:if>

        </div>
    </div>
    <!--end item basic information-->

    <!--start new department dialog-->
    <div id="new-department-dialog" class="modal modal-primary fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title">New Department</h4>
                </div>
                <div class="modal-body">
                    <input type="text" class="form-control" id="new-department-name" placeholder="Enter new department name">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-outline" onclick="newDepartment();">Save changes</button>
                </div>
            </div>
        </div>
    </div>
    <!--end new department dialog-->

    <!--start new main category dialog-->
    <div id="new-main-category-dialog" class="modal modal-primary fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title">New Main Category</h4>
                </div>
                <div class="modal-body">
                    <input type="text" class="form-control" id="new-main-category-name" placeholder="Enter new main category name">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-outline" onclick="newMainCategory();">Save changes</button>
                </div>
            </div>
        </div>
    </div>
    <!--end new main category dialog-->

    <!--start new sub category dialog-->
    <div id="new-sub-category-dialog" class="modal modal-primary fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title">New Sub Category</h4>
                </div>
                <div class="modal-body">
                    <input type="text" class="form-control" id="new-sub-category-name" placeholder="Enter new sub category name">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-outline" onclick="newSubCategory();">Save changes</button>
                </div>
            </div>
        </div>
    </div>
    <!--end new main category dialog-->

</section>
<!--end page content-->

<script>
    var rootPath = '${pageContext.request.contextPath}' + '/app';

    var action = '<c:out value="${action}"/>';

    var indexNo = <c:out value="${item==null?'null':item.indexNo}"/>;
    var selectedDepartment = <c:out value="${item==null?'null':item.MDepartment.indexNo}"/>;
    var selectedMainCategory = <c:out value="${item==null?'null':item.MMainCategory.indexNo}"/>;
    var selectedSubCategory = <c:out value="${item==null?'null':item.MSubCategory.indexNo}"/>;
    var selectedSupplier = '<c:out value="${item==null?'null':item.MTransactor.indexNo}"/>';

    if (action == 'view') {
        $(":input").attr("disabled", "disabled");
    }

    <jsp:include page="item-form.js"/>
</script>

<!--start bottom contents of page-->
<jsp:include page="/WEB-INF/views/import-bottom.jsp"/>
<!--end bottom contents of page-->

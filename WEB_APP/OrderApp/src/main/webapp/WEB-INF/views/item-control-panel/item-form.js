//department list autocomplete
$("#department").autocomplete({
    source: function (request, response) {
        var matcher = new RegExp($.ui.autocomplete.escapeRegex(request.term), "i");
        $.ajax({
            url: rootPath + "/rest/list-department",
            dataType: "json",
            success: function (data) {
                response($.map(data, function (v, i) {
//                    var text = v.name;
//                    if (text && (!request.term || matcher.test(text))) {
                        return {
                            label: v.name,
                            value: v.indexNo
                        };
//                    }
                }));
            }
        });
    },
    select: function (event, ui) {
        event.preventDefault();
        $("#department").val(ui.item.label);
        selectedDepartment = ui.item.value;
    },
    focus: function (event, ui) {
        event.preventDefault();
        $("#department").val(ui.item.label);
    }
});
//main category list autocomplete
$("#mainCategory").autocomplete({
    source: function (request, response) {
        var matcher = new RegExp($.ui.autocomplete.escapeRegex(request.term), "i");
        $.ajax({
            url: rootPath + "/rest/list-main-categories/" + selectedDepartment,
            dataType: "json",
            success: function (data) {
                console.log(data);
                response($.map(data, function (v, i) {
//                    var text = v.name;
//                    if (text && (!request.term || matcher.test(text))) {
                        return {
                            label: v.name,
                            value: v.indexNo
                        };
//                    }
                }));
            }
        });
    },
    select: function (event, ui) {
        event.preventDefault();
        $("#mainCategory").val(ui.item.label);
        selectedMainCategory = ui.item.value;
    },
    focus: function (event, ui) {
        event.preventDefault();
        $("#mainCategory").val(ui.item.label);
    }
});
//sub category list autocomplete
$("#subCategory").autocomplete({
    source: function (request, response) {
        var matcher = new RegExp($.ui.autocomplete.escapeRegex(request.term), "i");
        $.ajax({
            url: rootPath + "/rest/list-sub-categories/" + selectedMainCategory,
            dataType: "json",
            success: function (data) {
                console.log(data);
                response($.map(data, function (v, i) {
//                    var text = v.name;
//                    if (text && (!request.term || matcher.test(text))) {
                        return {
                            label: v.name,
                            value: v.indexNo
                        };
//                    }
                }));
            }
        });
    },
    select: function (event, ui) {
        event.preventDefault();
        $("#subCategory").val(ui.item.label);
        selectedSubCategory = ui.item.value;
    },
    focus: function (event, ui) {
        event.preventDefault();
        $("#subCategory").val(ui.item.label);
    }
});
//sub category list autocomplete
$("#supplier").autocomplete({
    source: function (request, response) {
        var matcher = new RegExp($.ui.autocomplete.escapeRegex(request.term), "i");
        $.ajax({
            url: rootPath + "/rest/list-suppliers",
            dataType: "json",
            success: function (data) {
                console.log(data);
                response($.map(data, function (v, i) {
//                    var text = v.name;
//                    if (text && (!request.term || matcher.test(text))) {
                        return {
                            label: v.name,
                            value: v.indexNo
                        };
//                    }
                }));
            }
        });
    },
    select: function (event, ui) {
        event.preventDefault();
        $("#supplier").val(ui.item.label);
        selectedSupplier = ui.item.value;
        console.log(selectedSupplier);
    },
    focus: function (event, ui) {
        event.preventDefault();
        $("#supplier").val(ui.item.label);
    }
});
function showNewDepartment() {
    $("#new-department-dialog").modal('show');
}

function newDepartment() {
    var name = $("#new-department-name").val();
    $.ajax({
        url: rootPath + "/rest/new-department/" + name,
        datatype: "json",
        success: function (data) {
            selectedDepartment = data;
            $("#department").val(name);
            $.toaster({priority: "info", title: 'OK', message: "Department saved successfully !"});
        }
    });
    $("#new-department-name").val(null);
    $("#new-department-dialog").modal('hide');
}

function showNewMainCategory() {
    if (!!selectedDepartment) {
        $("#new-main-category-dialog").modal('show');
    }
}

function newMainCategory() {
    var name = $("#new-main-category-name").val();
    $.ajax({
        url: rootPath + "/rest/new-main-category/" + name + "/" + selectedDepartment,
        datatype: "json",
        success: function (data) {
            selectedMainCategory = data;
            $("#mainCategory").val(name);
            $.toaster({priority: "info", title: 'OK', message: "Main Category saved successfully !"});
        }
    });
    $("#new-main-category-name").val(null);
    $("#new-main-category-dialog").modal('hide');
}

function showNewSubCategory() {
    if (!!selectedMainCategory) {
        $("#new-sub-category-dialog").modal('show');
    }
}

function newSubCategory() {
    var name = $("#new-sub-category-name").val();
    $.ajax({
        url: rootPath + "/rest/new-sub-category/" + name + "/" + selectedMainCategory,
        datatype: "json",
        success: function (data) {
            selectedSubCategory = data;
            $("#subCategory").val(name);
            $.toaster({priority: "info", title: 'OK', message: "Sub Category saved successfully !"});
        }
    });
    $("#new-sub-category-name").val(null);
    $("#new-sub-category-dialog").modal('hide');
}

$.fn.serializeObject = function ()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

function initItem() {
    var code = $("#code").val();
    var name = $("#name").val();
    var printDescription = $("#printDescription").val();
    var supplier = selectedSupplier;
    var department = selectedDepartment;
    var mainCategory = selectedMainCategory;
    var subCategory = selectedSubCategory;
    var unit = $("#unit").val();
    var costPrice = $("#costPrice").val();
    var retailPrice = $("#retailPrice").val();
    var maxDiscountPercent = $("#maxDiscountPercent").val();
    var active = true;
    var json =
            {
                "indexNo":indexNo,
                "code": code,
                "name": name,
                "printDescription": printDescription,
                "supplier": supplier,
                "department": department,
                "mainCategory": mainCategory,
                "subCategory": subCategory,
                "defaultUnit": unit,
                "costPrice": costPrice,
                "retailPrice": retailPrice,
                "maxDiscountPercent": maxDiscountPercent,
                "active": active
            };

    return json;
}

function saveItem() {
    var json = initItem();
    
    console.log(json.toString());

    $.ajax({
        contentType: 'application/json',
        type: 'POST',
        data: JSON.stringify(json),
        datatype: 'json',
        processData: false,
        url: rootPath + "/rest/new-item",
        success: function (data, textStatus) {
            clear();

            $.toaster({priority: "info", title: 'OK', message: "Item saved successfully !"});
        }
    });
}

function updateItem() {
    var json = initItem();

    $.ajax({
        contentType: 'application/json',
        type: 'POST',
        data: JSON.stringify(json),
        datatype: 'json',
        processData: false,
        url: rootPath + "/rest/update-item",
        success: function (data, textStatus) {
            $.toaster({priority: "info", title: 'OK', message: "Item updated successfully !"});
        }
    });
}

function clear() {
    $("#code").val(null);
    $("#name").val(null);
    $("#printDescription").val(null);
    $("#supplier").val(null);
    $("#department").val(null);
    $("#mainCategory").val(null);
    $("#subCategory").val(null);
    $("#unit").val(null);
    $("#costPrice").val(null);
    $("#retailPrice").val(null);
    $("#maxDiscountPercent").val(null);
    selectedSupplier = null;
    selectedDepartment = null;
    selectedMainCategory = null;
    selectedSubCategory = null;
}
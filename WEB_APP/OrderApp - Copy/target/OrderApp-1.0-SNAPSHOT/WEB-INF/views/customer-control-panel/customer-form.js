$("#route").autocomplete({
    source: function (request, response) {
        var matcher = new RegExp($.ui.autocomplete.escapeRegex(request.term), "i");
        $.ajax({
            url: rootPath + "/rest/list-route",
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
        $("#route").val(ui.item.label);
        selectedRoute = ui.item.value;
    },
    focus: function (event, ui) {
        event.preventDefault();
        $("#route").val(ui.item.label);
    }
});

function showNewRoute() {
    $("#new-route-dialog").modal('show');
}

function newRoute() {
    var name = $("#new-route-name").val();
    $.ajax({
        url: rootPath + "/rest/new-route/" + name,
        datatype: "json",
        success: function (data) {
            selectedDepartment = data;
            $("#route").val(name);
            $.toaster({priority: "info", title: 'OK', message: "Route saved successfully !"});
        }
    });
    $("#new-route-name").val(null);
    $("#new-route-dialog").modal('hide');
}

function initTransactor() {
    var code = $("#code").val();
    var name = $("#name").val();
    var contactPerson = $("#contactPerson").val();
    var mobile = $("#mobile").val();
    var telephone1 = $("#telephone1").val();
    var telephone2 = $("#telephone2").val();
    var addressLine1 = $("#addressLine1").val();
    var addressLine2 = $("#addressLine2").val();
    var addressLine3 = $("#addressLine3").val();
    var fax = $("#fax").val();
    var email = $("#email").val();
    var route = selectedRoute;
    var creditLimit = $("#creditLimit").val();
    var creditAmount = $("#creditAmount").val();

    var json = {
        "indexNo":indexNo,
        "code": code,
        "name": name,
        "contactPerson": contactPerson,
        "mobile": mobile,
        "telephone1": telephone1,
        "telephone2": telephone2,
        "addressLine1": addressLine1,
        "addressLine2": addressLine2,
        "addressLine3": addressLine3,
        "fax": fax,
        "email": email,
        "route": route,
        "creditLimit": creditLimit,
        "creditAmount": creditAmount
    };

    return json;
}

function saveTransactor() {
    var json = initTransactor();

    $.ajax({
        contentType: 'application/json',
        type: 'POST',
        data: JSON.stringify(json),
        datatype: 'json',
        processData: false,
        url: rootPath + "/rest/new-customer",
        success: function (data, textStatus) {
            clear();

            $.toaster({priority: "info", title: 'OK', message: "Customer saved successfully !"});
        }
    });
}

function updateTransactor() {
    var json = initTransactor();

    $.ajax({
        contentType: 'application/json',
        type: 'POST',
        data: JSON.stringify(json),
        datatype: 'json',
        processData: false,
        url: rootPath + "/rest/update-customer",
        success: function (data, textStatus) {
            $.toaster({priority: "info", title: 'OK', message: "Customer updated successfully !"});
        }
    });
}

function clear() {
    indexNo = null;
    $("#code").val(null);
    $("#name").val(null);
    $("#contactPerson").val(null);
    $("#mobile").val(null);
    $("#telephone1").val(null);
    $("#telephone2").val(null);
    $("#addressLine1").val(null);
    $("#addressLine2").val(null);
    $("#addressLine3").val(null);
    $("#fax").val(null);
    $("#email").val(null);
    selectedRoute = null;
    $("#creditLimit").val(null);
    $("#creditAmount").val(null);
}
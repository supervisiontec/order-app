function initUser() {
    var name = $("#name").val();
    var itemControlPanel = $("#itemControlPanel").is(':checked')?1:0;
    var customerControlPanel = $("#customerControlPanel").is(':checked')?1:0;
    var supplierControlPanel = $("#supplierControlPanel").is(':checked')?1:0;
    var userControlPanel = $("#userControlPanel").is(':checked')?1:0;
    var customerApproval = $("#customerApproval").is(':checked')?1:0;
    var orderApproval = $("#orderApproval").is(':checked')?1:0;
    var reports = $("#reports").is(':checked')?1:0;
    var mobileApp = $("#mobileApp").is(':checked')?1:0;
    
    var json = {
        "indexNo":indexNo,
        "name": name,
        "itemControlPanel": itemControlPanel,
        "customerControlPanel": customerControlPanel,
        "supplierControlPanel": supplierControlPanel,
        "userControlPanel": userControlPanel,
        "customerApproval": customerApproval,
        "orderApproval": orderApproval,
        "reports": reports,
        "mobileApp": mobileApp
    };

    console.log(json);

    return json;
}

function saveUser() {
    var json = initUser();

    $.ajax({
        contentType: 'application/json',
        type: 'POST',
        data: JSON.stringify(json),
        datatype: 'json',
        processData: false,
        url: rootPath + "/rest/new-user",
        success: function (data, textStatus) {
            clear();

            $.toaster({priority: "info", title: 'OK', message: "User saved successfully !"});
        }
    });
}

function updateUser() {
    var json = initUser();

    $.ajax({
        contentType: 'application/json',
        type: 'POST',
        data: JSON.stringify(json),
        datatype: 'json',
        processData: false,
        url: rootPath + "/rest/update-user",
        success: function (data, textStatus) {
            $.toaster({priority: "info", title: 'OK', message: "User updated successfully !"});
        }
    });
}

function clear() {
    $("#name").val(null);
    $("#itemControlPanel").val(null);
    $("#customerControlPanel").val(null);
    $("#supplierControlPanel").val(null);
    $("#userControlPanel").val(null);
    $("#userApproval").val(null);
    $("#orderApproval").val(null);
    $("#reports").val(null);
    $("#mobileApp").val(null);
}
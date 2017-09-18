function toggleActive(indexNo) {
    $.ajax({
        contentType: 'application/json',
        type: 'POST',
        datatype: 'json',
        url: "./rest/toggle-activation-supplier/" + indexNo,
        success: function (data, textStatus) {
            $.toaster({priority: "info", title: 'OK', message: "Activation status changed !"});

            var component = $("#status-" + indexNo);
            component.removeClass("btn-success");
            component.removeClass("btn-danger");

            console.log(data);

            if (data == true) {
                component.addClass("btn-success");
                component.text("Active");
            } else {
                component.addClass("btn-danger");
                component.text("Deactivated");
            }
        }
    });
}

function deleteTransactor(indexNo) {
    $.ajax({
        contentType: 'application/json',
        type: 'POST',
        datatype: 'json',
        url: "./rest/delete-supplier/" + indexNo,
        success: function (data, textStatus) {
            var component = $("#row-" + indexNo);

            if (data == true) {
                $.toaster({priority: "info", title: 'OK', message: "Supplier deleted successfully !"});
                component.remove();
            }else{
                $.toaster({priority: "danger", title: 'ERROR', message: "Failed to delete supplier !"});
            }
        }
    });
}
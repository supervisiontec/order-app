function toggleApprove(indexNo) {
    $.ajax({
        contentType: 'application/json',
        type: 'POST',
        datatype: 'json',
        url: "./rest/toggle-approval-customer/" + indexNo,
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
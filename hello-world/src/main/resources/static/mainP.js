$(document).ready(function () {

    $("#search-form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {
    var accountVar = $("#account").val();
    var startDateVar = $("#start-date").val();
    var endDateVar = $("#end-date").val();

    var filter = {}
    filter["account"] = accountVar;
    filter["startDate"] = startDateVar;
    filter["endDate"] = endDateVar;

    console.log(filter);

    $.ajax({
        url: "/api/v1/account/transactions",
        type: 'POST',
        contentType: "application/json",
        data: JSON.stringify(filter),
        success: function(response){
            var json = "<h4>Ajax Response</h4>"
                            + JSON.stringify(response) ;
                        $('#feedback').html(json);

                        console.log("SUCCESS : ", response);
                        $("#btn-search").prop("disabled", false);
        },
        error: function (e) {
            var json = "<h4>Ajax Response</h4>" + e.responseText;
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });
/*

    var search = {}
    search["username"] = $("#account").val();

    $("#btn-search").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/search",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + JSON.stringify(data, null, 4) + "&lt;/pre&gt;";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + e.responseText + "&lt;/pre&gt;";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });
*/
}
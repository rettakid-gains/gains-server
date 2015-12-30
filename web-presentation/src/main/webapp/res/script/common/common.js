var successString = "<SUCCESS>d8087287-ae6f-46ad-9761-66c4f165cf5d</SUCCESS>";

$(document).ready(function () {
    $('.modal-trigger').leanModal();
});

(function ($) {
    $(function () {

        $('.button-collapse').sideNav();
        $('.parallax').parallax();

    }); // end of document ready
})(jQuery); // end of jQuery name space

function customAjaxCall(ajaxObj) {

    if (ajaxObj.error == null) {
        ajaxObj.error = function (data, status, error) {
            console.error("There was an error", status, error);
        }
    }

    if (ajaxObj.timeout == null) {
        ajaxObj.timeout = 30000;
    }

    if (ajaxObj.statusCode == null) {
        ajaxObj.statusCode = {
            200: function () {
                if (ajaxObj.valid != null) {
                    ajaxObj.success = ajaxObj.valid;
                }
                console.log("valid");
                ajaxObj.success();
            },
            203: function (data) {
                ajaxObj.invalid(data);
            },
            412: function (data) {
                ajaxObj.invalid(data);
            },
            404: function () {
                window.location.assign("/meds/presentation/error/404");
            },
            403: function () {
                window.location.assign("/meds/presentation/error/403");
            },
            500: function () {
                window.location.assign("/meds/presentation/error/500");
            }
        };
    }

    $.ajax(ajaxObj);
}

function initToast(toastText) {
    $(document).ready(function () {
        createToast(toastText);
    });
}

function initErrorToast(toastText, index) {
    $(document).ready(function () {
        setTimeout(function () {
            createErrorToast(toastText, index);
        }, index * 1000)
    });
}

function createToast(toastText) {
    if (toastText != null && toastText != "") {
        Materialize.toast(toastText, 4000);
    }
}

function createErrorToast(toastText, index) {
    if (toastText != null && toastText != "") {
        Materialize.toast(toastText, 8000, "red darken-4");
    }
}

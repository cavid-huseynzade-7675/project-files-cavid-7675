$(document).ready(() => {
    $("#proglasdirmaB").click(function() {
        $("#proglasdirmaD").slideToggle("slow", function() {
            var x = $("#progD").height();
            console.log(x);

            if (x == 91) {
                $("#progD").css("height", "275px");
            } else {
                $("#progD").css("height", "125px");
            }
        });
    });

    $("#dilB").click(function() {
        $("#dilD").slideToggle("slow", function() {
            var x = $("#dilDd").height();
            console.log(x);

            if (x == 91) {
                $("#dilDd").css("height", "275px");
            } else {
                $("#dilDd").css("height", "125px");
            }
        });
    });

    $("#lahiyeB").click(function() {
        $("#lahiyeD").slideToggle("slow", function() {
            var x = $("#lahD").height();
            console.log(x);

            if (x == 91) {
                $("#lahD").css("height", "275px");
            } else {
                $("#lahD").css("height", "125px");
            }
        });
    });

    $("#workB").click(function() {
        $("#workD").slideToggle("slow", function() {
            var x = $("#worD").height();
            console.log(x);

            if (x == 91) {
                $("#worD").css("height", "275px");
            } else {
                $("#worD").css("height", "125px");
            }
        });
    });

    $("#bilik").click(function() {
        $("#bilikDd").slideToggle("slow", function() {});
    });

    $("#haqqindaB").click(function() {
        $("#haqqindaDd").slideToggle("slow", function() {});
    });
    $("#haqqB").click(function() {
        $("#haqqDd").slideToggle("slow", function() {
            var x = $("#haqq").height();
            console.log(x);

            if (x == 91) {
                $("#haqq").css("height", "275px");
            } else {
                $("#haqq").css("height", "125px");
            }
        });
    });
});
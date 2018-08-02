document.addEventListener("DOMContentLoaded", function () {

    var time = document.querySelector("#time");
    var submit = document.querySelector("#submit");
    var p = document.querySelector("p");

    time.addEventListener("keyup", function () {
        if (isNaN(this.value) || this.value === "") {
            submit.disabled = true;
            p.innerText = "Write the proper number with . as decimal separator";
        } else {
            submit.removeAttribute("disabled");
            p.innerText = "";
        }
    });

});


// $(document).ready(function() {
//     console.log("aaaa");
//     // page is ready
//     $('#calendar').fullCalendar({
//         weekends: false
//         // calendar properties
//     })
// });

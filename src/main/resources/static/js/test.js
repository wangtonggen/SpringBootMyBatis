$(function () {
    $("#btn").click(function () {
        // alert("hello");
        $(this).animate({
            borderRadius: "50%",
            borderColor: "#4CAF50",
            backgroundColor: "#4CAF50",
            left:"+=100px",
            color:"#ffffff",
            scale:"1.25",
            // boxShadow:"0 0 30px #44f"
        }, 1000);
    });
});
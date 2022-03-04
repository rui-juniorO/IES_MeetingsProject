$(document).ready(function() {
    var queryString = location.search.substring(1);
    var a = queryString.split("|");
    var shoppingId = a[0];
    
    $("form").submit(function (event) {
        var formData = {
            title: $("#title").val(),
            userId: user["id"],
            startDate: $("starDate").val(),
            startTime: $("#starTime").val(),
            duration: $("#duration").val(),
            paswword: $("#paswword").val(),
            description: $("#description").val(),
        };
        
        $.ajax({
            url: "http://" + self.location.hostname + ":8080/api/v1/meetings",
            type: "POST",
            data: JSON.stringify(formData),
            contentType: "application/json",
        }).done(function (data) {
            console.log(data);
            window.location.href = "http://" + self.location.hostname + ":5500/home.html";
        });
    
        event.preventDefault();
    });

    $(function() {
        $('.time').datetimepicker({
            format: 'HH:mm',
        });
    });

    function readCookie(name) {
        var i, c, ca, nameEQ = name + "=";
        ca = document.cookie.split(';');
        for(i=0;i < ca.length;i++) {
            c = ca[i];
            while (c.charAt(0)==' ') {
                c = c.substring(1,c.length);
            }
            if (c.indexOf(nameEQ) == 0) {
                return c.substring(nameEQ.length,c.length);
            }
        }
        return '';
    }

    user = readCookie('login');
    if(user) {
        user = JSON.parse(user);
        window.location.href = "http://" + self.location.hostname + ":5500/home.html";
        
    }
});

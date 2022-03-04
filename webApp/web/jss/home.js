$(document).ready(function() {
    let isSecurity = false;



    function showMeetings(meetings) {
        var contend = "";
        for (var meeting of meetings) {
            cards +=
                ` <div id="" class="w3-container w3-card w3-white w3-round w3-margin"><br>
                <span class="w3-right w3-opacity">${meeting.startDate}</span>
                <h4>${meeting.title}</h4><br>
                <p>${meeting.startTime}</p>
                <hr class="w3-clear">
                <p>000${meeting.id}</p>
                <hr class="w3-clear">
                <p>${meeting.description}</p>
                <button type="button" class="w3-button w3-theme-d1 w3-margin-bottom"><i class=""></i>Ver</button> 
                <button type="button" class="w3-button w3-theme-d2 w3-margin-bottom"><i class=""></i>Editar</button>
                <button type="button" class="w3-button w3-theme-d2 w3-margin-bottom"><i class=""></i>Deletar</button> 
          </div>`
        }
        $('#proximas').html(contend);
    }

    function showMeetings2(meetings) {
        var contend = "";
        for (var meeting of meetings) {
            cards +=
                ` <div id="" class="w3-container w3-card w3-white w3-round w3-margin"><br>
                <span class="w3-right w3-opacity">${meeting.startDate}</span>
                <h4>${meeting.title}</h4><br>
                <p>${meemeetingtings.startTime}</p>
                <hr class="w3-clear">
                <p>000${meeting.id}</p>
                <hr class="w3-clear">
                <p>${meeting.description}</p>
                <button type="button" class="w3-button w3-theme-d1 w3-margin-bottom"><i class=""></i>Ver</button> 
                <button type="button" class="w3-button w3-theme-d2 w3-margin-bottom"><i class=""></i>Editar</button>
                <button type="button" class="w3-button w3-theme-d2 w3-margin-bottom"><i class=""></i>Deletar</button> 
          </div>`
        }
        $('#anteriores').html(contend);
    }

    (function worker() {
        $.ajax({
            url: "http://" + self.location.hostname + ":8080/api/v1/meetingsUndone",
            success: function(data) {
                showMeetings(data);
                showMeetings2(data);
            },
            complete: function() {
                // Schedule the next request when the current one's complete
                setTimeout(worker, 1000);
            }
        });
    })();

    function readCookie(name) {
        var i, c, ca, nameEQ = name + "=";
        ca = document.cookie.split(';');
        for (i = 0; i < ca.length; i++) {
            c = ca[i];
            while (c.charAt(0) == ' ') {
                c = c.substring(1, c.length);
            }
            if (c.indexOf(nameEQ) == 0) {
                return c.substring(nameEQ.length, c.length);
            }
        }
        return '';
    }

    user = readCookie('login');
    if (user) {
        user = JSON.parse(user);
        window.location.href = "http://" + self.location.hostname + ":5500/home.html";

    }
});
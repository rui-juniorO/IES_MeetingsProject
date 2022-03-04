$(document).ready(function() {
    let isSecurity = false;
    var a = queryString.split("|");
    var meetingId = a[0];

    function showMeetings(meetings) {
        var contend = "";
        for (var meeting of meetings) {
            cards += 
            ` <div class="row">
            <div class="col-md-4 offset-md-4">
                
                <div class="form-group">
                    <label for="topico">Tópico</label>
                    <label type="text" class="form-control" id="topico" name="topico">${meetings.title}</label>
                </div>
                <div class="form-group">
                    <label for="start-time">Data de inicio</label>
                    <label type="date" class="form-control date" id="start-time" name="start-time" data-toggle="datetimepicker" data-target="#start-time">${meetings.startDate}</label>
                </div>
                <div class="form-group">
                    <label for="duration">Duração</label>
                    <label type="time" class="form-control time" id="duration" name="duration">${meetings.duration}</label>
                </div>
                <div class="form-group">
                    <label for="duration">Participantes</label>
                    <label type="text" class="form-control" id="Participantes" name="Participantes">Participantes</label>
                </div>
                <button type="submit" class="btn btn-primary">Edit</button>
                
            </div>
        </div>`
        }
        $('#meeting').html(contend);
    }
    
    (function worker(meetingId) {
        $.ajax({
            url: "http://" + self.location.hostname + ":8080/api/v1/meeting/"+meetingId, 
            success: function(data) {
                showMeetings(data);
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

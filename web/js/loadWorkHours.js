/**
 * Created by mario on 11/22/2015.
 */
var workHours=[];
function addWorkHour(){
    var start_time=$("#start_time").val();
    var end_time=$("#end_time").val();
    var day= $("#weekdays").val();
    workHours.push({
       "day":day,
        "start_time":start_time,
        "end_time":end_time
    });
    newWorkHours();
}

function newWorkHours(){
    var workHourSection=$("#workHourRow").clone();
    $("#workHourRow").removeAttr("id","workHourRow");
    $("#start_time").attr("readonly", true).attr("type", "text").removeAttr("id","start_time");
    $("#end_time").attr("readonly", true).attr("type", "text").removeAttr("id","end_time");
    $("#weekdays").attr("disabled", true).attr("type", "text").removeAttr("id","day");
    $("#workHoursSection").append(workHourSection);
}

function sendWorkHours(){
    $.ajax({
        type: "GET",
        url: "/tasks",
        data: workHours,
        success: success
    });
}

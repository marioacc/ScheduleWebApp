/**
 * Created by mario on 11/22/2015.
 */
var workHours={
    hours:[]
};
function addWorkHour(){
    var start_time=$("#start_time").val();
    var end_time=$("#end_time").val();
    var day= $("#weekdays").val();
    workHours.hours.push({
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
    console.log(workHours);
    $.ajax({
        type: "GET",
        url: "/neworkhours",
        data: {"workHours":JSON.stringify(workHours)},
        success: function (data){
            window.location= "/tasks.jsp";
        }
    });
}

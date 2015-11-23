/**
 * Created by mario on 11/23/2015.
 */
var tasks={
    tasks:[]
};
function addTask(){
    var start_time=$("#task_time").val();
    var priority=$("#priority").val();
    var description= $("#taskname").val();
    var end_time= $("#task_timestamp").val();

    tasks.tasks.push({
        "priority":priority,
        "duration":start_time,
        "description":description,
        "end_time":end_time

    });
    newTask();
}

function newTask(){
    var TaskSection=$("#taskRow").clone();
    $("#taskRow").removeAttr("id","task");
    $("#task_time").attr("readonly", true).attr("type", "text").removeAttr("id","task_time");
    $("#priority").attr("disabled", true).attr("type", "text").removeAttr("id","priority");
    $("#taskname").attr("readonly", true).attr("type", "text").removeAttr("id","taskname");
    $("#task_timestamp").attr("readonly", true).attr("type", "text").removeAttr("id","task_timestamp");
    $("#taskSection").append(TaskSection);
}

function sendTasks(){
    console.log(tasks);
    $.ajax({
        type: "GET",
        url: "/addtasks",
        data: {"tasks":JSON.stringify(tasks)},
        success: function (data){

        }
    });
}

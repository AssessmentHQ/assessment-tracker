// highlights which page you are on in main nav
let onHome = offPage;
let onBatch = onPage;
let onAssess = offPage;
let onNotes = offPage;

// Sets the main navigation
function setMainNav() {
    return `
    <a class="nav-link ${onHome} d-flex align-items-center justify-content-center justify-content-md-start" title="Home" href="home.html"><i class="fa fa-home" aria-hidden="true"></i>&nbsp;<span class="d-none d-md-inline">Home</span></a>
    <a class="nav-link ${onBatch} d-flex align-items-center justify-content-center justify-content-md-start" title="Batch" href="specific_batch_week.html"><i class="fa fa-users" aria-hidden="true"></i>&nbsp;<span class="d-none d-md-inline">Batch</span></a>
    <a class="nav-link ${onAssess} d-flex align-items-center justify-content-center justify-content-md-start" title="Assessments" href="#"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>&nbsp;<span class="d-none d-md-inline">Assessments</span></a>
    <a class="nav-link ${onNotes} d-flex align-items-center justify-content-center justify-content-md-start" title="Notes" href="#">
        <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi bi-journal-text" viewBox="0 0 16 16">
            <path d="M5 10.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1h-2a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5z"/>
            <path d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2z"/>
            <path d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1z"/>
        </svg>
    &nbsp;<span class="d-none d-md-inline">Notes</span>
    </a>`;
}

let batch = {
    id: 1,
    name: "",
    trainingTrack:"",
    startDate:"",
    currentWeek:5,
    totalWeeks:10
} 


function getWeeks() {
    let weekTitles = document.getElementsByClassName("week-title")
    let weekTopics = document.getElementsByClassName("week-topic")
    let weekDescriptions = document.getElementsByClassName("weekDescription")
    let weeks = []
    let count = 1
    Array.prototype.forEach.call(weekTitles, function (element) {
        let week = new Week(count, element.value)
        weeks.push(week)
        count++
    });
    return weeks
}

const panels = document.getElementById("panels");

function addWeek(totalWeeks){
    weeks = getWeeks()
    weekId = document.getElementById("week-title").value
    for(i = 1; i <= totalWeeks; i++){
        let gotAssessments = getAssessments(i)

    panels.innerHTML +=
    `
    <div class="d-flex mb-5">
                        <div id="week_${i}" class="col col-12 p-0">
                            <div class="card bg-darker">
                                <div class="card-body rounded">
                                    <h3 class="card-title"><strong>Week ${i}</strong></h3>
                                    <p class="card-text" id="week${i}Assessments">
                                        ${gotAssessments ? gotAssessments : "-No Assessments Yet-"}
                                    </p>
                                    <button id="addAssessmentBtn" class="btn btn-primary">Add Assessment To This Week</button>
                                </div>
                            </div>
                        </div>
                        
                    </div>
    `
    }
}
addWeek(batch.totalWeeks)

//Get all Current Assessments for a Week
function getAssessments(weekId) {
//set the caller_complete to the function that is supposed to receive the response
let response_func = getAssessments_complete;
//endpoint: rest api endpoint
let endpoint = "/batchs/batchId/assessments/weekId"
//set the url by adding (base_url/java_base_url) + endpoint
//options:
//base_url(python)
//java_base_url(java)
let url = base_url + endpoint;
//request_type: type of request
let request_type = "GET";
//location you want the response to load
let response_loc = "loadResult";
//optional:location you want the load animation to be generated while awaiting the response
//can be set for any location but will most often be set to response_loc
//can be left blank if not needed
let load_loc = response_loc;
//optional:json data to send to the server
//can be left blank if not needed
let jsonData = "";
console.log(jsonData);

// ajaxgetAssessments(request_type, url, response_func, response_loc, load_loc, jsonData)
}
//ajax on-complete function: receives the response from an ajax request
function getAssessments_complete(status, response, response_loc, load_loc) {
    //do some logic with the ajax data that was returned
    //do this if you are expecting a json object - JSON.parse(response)

    //The var "load_loc" is set in case the response message is different from the action to be loaded into the named location
    //example:
    //-- you want a message to say "ajax done!" in a popup while the data is compiled and loaded somewhere else

    //action if code 200
    if(status == 200) {
        //load the response into the response_loc
        document.getElementById(response_loc).innerHTML = response;
        //action if code 201
    } else if(status == 201) {
        document.getElementById(response_loc).innerHTML = JSON.parse(response);
        //action if code 400
    } else if(status == 400) {
        //load the response into the response_loc
        document.getElementById(response_loc).innerHTML = response;
    }
}




//Get all Current weeks for a Batch
function getAllWeeks() {
    //set the caller_complete to the function that is supposed to receive the response
    let response_func = getAllWeeks_complete;
    //endpoint: rest api endpoint
    let endpoint = "/batchs/batchId/"
    //set the url by adding (base_url/java_base_url) + endpoint
    //options:
    //base_url(python)
    //java_base_url(java)
    let url = base_url + endpoint;
    //request_type: type of request
    let request_type = "GET";
    //location you want the response to load
    let response_loc = "loadResult";
    //optional:location you want the load animation to be generated while awaiting the response
    //can be set for any location but will most often be set to response_loc
    //can be left blank if not needed
    let load_loc = response_loc;
    //optional:json data to send to the server
    //can be left blank if not needed
    let jsonData = "";
    console.log(jsonData);

    ajaxgetAllWeeks(request_type, url, response_func, response_loc, load_loc, jsonData)
}
//ajax on-complete function: receives the response from an ajax request
function getAllWeeks_complete(status, response, response_loc, load_loc) {
    //do some logic with the ajax data that was returned
    //do this if you are expecting a json object - JSON.parse(response)

    //The var "load_loc" is set in case the response message is different from the action to be loaded into the named location
    //example:
    //-- you want a message to say "ajax done!" in a popup while the data is compiled and loaded somewhere else

    //action if code 200
    if(status == 200) {
        //load the response into the response_loc
        document.getElementById(response_loc).innerHTML = response;
        //action if code 201
    } else if(status == 201) {
        document.getElementById(response_loc).innerHTML = JSON.parse(response);
        //action if code 400
    } else if(status == 400) {
        //load the response into the response_loc
        document.getElementById(response_loc).innerHTML = response;
    }
}

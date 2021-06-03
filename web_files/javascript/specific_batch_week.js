// highlights which page you are on in main nav
let onHome = offPage;
let onBatch = onPage;
let onAssess = offPage;
let onNotes = offPage;


let batch = {
    id: 1,
    name: "",
    trainingTrack: "",
    startDate: "",
    currentWeek: 71,
    totalWeeks: 4
}


const panels = document.getElementById("panels");

function addWeek(totalWeeks) {
    weekId = document.getElementById("week-title").value
    for (i = 1; i <= totalWeeks; i++) {
        panels.innerHTML += newWeek(i)
    }
}

function displayAssessments(assessments){
    display = ""
    Array.prototype.forEach.call(assessments, (assessment)=>{
        display += `<li id=assessent${assessment.assessmentId}>${assessment.assessmentTitle}</li>`
    });
    return display
}
// holds the styling for the batches
function newWeek(week) {
    let gotAssessments = getAssessments(i)
    return       `
    <div class="d-flex mb-5">
                        <div id="week_${week}" class="col col-12 p-0">
                            <div class="card bg-darker">
                                <div class="card-body rounded">
                                    <h3 class="card-title"><strong>Week ${week}</strong></h3>
                                    <ul class="card-text" id="week${week}Assessments">
                                        ${gotAssessments ? displayAssessment(gotAssessments) : "-No Assessments Yet-"}
                                    </ul>
                                    <button id="addAssessmentBtn" class="btn btn-primary">Add Assessment To This Week</button>
                                </div>
                            </div>
                            
                        </div>
        `;
}
//Get all Current Assessments for a Week
function getAssessments(weekId) {
    //set the caller_complete to the function that is supposed to receive the response
    let response_func = getAssessments_complete;
    //endpoint: rest api endpoint
    let endpoint =  `assessments/batch/${batch.id}/${weekId}`
    //set the url by adding (base_url/java_base_url) + endpoint
    //options:
    //base_url(python)
    //java_base_url(java)
    let url = java_base_url + endpoint;
    //request_type: type of request
    let request_type = "GET";
    //location you want the response to load
    let response_loc = `week${weekId}Assessments`;
    //optional:location you want the load animation to be generated while awaiting the response
    //can be set for any location but will most often be set to response_loc
    //can be left blank if not needed
    let load_loc = response_loc;
    //optional:json data to send to the server
    //can be left blank if not needed
    let jsonData = "";
    console.log(jsonData);

    ajaxCaller(request_type, url, response_func, response_loc, load_loc, jsonData)
}
//ajax on-complete function: receives the response from an ajax request
function getAssessments_complete(status, response, response_loc, load_loc) {
    //do some logic with the ajax data that was returned
    //do this if you are expecting a json object - JSON.parse(response)

    //The var "load_loc" is set in case the response message is different from the action to be loaded into the named location
    //example:
    //-- you want a message to say "ajax done!" in a popup while the data is compiled and loaded somewhere else

    //action if code 200
    if (status == 200) {
        //load the response into the response_loc
        document.getElementById(response_loc).innerHTML = displayAssessments(JSON.parse(response));
        //action if code 201
    } else if (status == 201) {
        document.getElementById(response_loc).innerHTML = JSON.parse(response);
        //action if code 400
    } else if (status == 400) {
        //load the response into the response_loc
        document.getElementById(response_loc).innerHTML = response;
    }
}
function pageDataToLoad() {
    addWeek(batch.totalWeeks)
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
    if (status == 200) {
        //load the response into the response_loc
        document.getElementById(response_loc).innerHTML = response;
        //action if code 201
    } else if (status == 201) {
        document.getElementById(response_loc).innerHTML = JSON.parse(response);
        //action if code 400
    } else if (status == 400) {
        //load the response into the response_loc
        document.getElementById(response_loc).innerHTML = response;
    }
}

/*
    This is the "home.html" page specific js/JQuery override file
    Use this to write custom js/JQuery code that will be accessible to "home.html" only

    ---------Standards and Best Practices-------------------
    -- 1. Make sure to always copy and paste this header to each *.js,*.css file to map the important functionality
    -- 2. Use the page specific code sparingly, do your best to write relative Dynamic code - will save time and energy
    -- 3. When reaching Production please "minify" all js/css files to eliminate comments and condense the files
    -- 4. "Min" file naming pattern should be as follows:
            Page specific - "[name].min.[version #].[js/css]"
            Main files    - "main.min.[version #].[js/css]"
    -- 5. Please remove this file from the production version to keep file structure integrity and security reasons
    --------Standards and Best Practices End---------------
*/
/*
    -------------------Code Chapters-----------------------
    -- 1. Global var Declarations
    -- 2. Ajax
    -- 3. Onload.Body Initializers
    -- 4. Listeners
    -- 5. Arrow/Anonymous Functions
    -- 6. Misc Named Functions
    -------------------Code Chapters End-------------------
*/

// Chapter 1. Global var Declarations ---------------------
// highlights which page you are on in main nav
let onHome = offPage;
let onBatch = onPage;
let onAssess = offPage;
let onNotes = offPage;

// which information the user chooses to view. i.e. batches by year.
var wantedBatchData = [];
// Chapter 1. Global var Declarations End -----------------

// Chapter 2. Ajax ----------------------------------------

//Caller function: calls an ajax request
//Function Description goes here
function caller() {
    //set the caller_complete to the function that is supposed to receive the response
    //naming convention: [this function name]_complete
    let response_func = caller_complete;
    //endpoint: rest api endpoint
    let endpoint = "user"
    //set the url by adding (base_url/java_base_url) + endpoint
    //options:
    //base_url(python)
    //java_base_url(java)
    let url = base_url + endpoint;
    //request_type: type of request
    //options:
    //"GET", "POST", "OPTIONS", "PATCH", "PULL", "HEAD", "DELETE", "CONNECT", "TRACE"
    let request_type = "POST";
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

    ajaxCaller(request_type, url, response_func, response_loc, load_loc, jsonData)
}
//ajax on-complete function: receives the response from an ajax request
function caller_complete(status, response, response_loc, load_loc) {
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

// Retrieving the data for all batches Function
function getBatchData(trainer_id, year) {
    //set the caller_complete to the function that is supposed to receive the response
    //naming convention: [this function name]_complete
    let response_func = getBatchData_complete;
    //endpoint: rest api endpoint
    let endpoint = "batches/" + trainer_id + "/" + year + "/"
    //set the url by adding (base_url/java_base_url) + endpoint
    //options:
    //base_url(python)
    //java_base_url(java)
    let url = base_url + endpoint;
    //request_type: type of request
    //options:
    //"GET", "POST", "OPTIONS", "PATCH", "PULL", "HEAD", "DELETE", "CONNECT", "TRACE"
    let request_type = "GET";
    //location you want the response to load
    let response_loc = "loadResult";
    //optional:location you want the load animation to be generated while awaiting the response
    //can be set for any location but will most often be set to response_loc
    //can be left blank if not needed
    let load_loc = "logload";
    //optional:json data to send to the server
    //can be left blank if not needed
    let jsonData = " ";
    console.log(jsonData);

    ajaxCaller(request_type, url, response_func, response_loc, load_loc, jsonData)
}
//ajax on-complete function: receives the response from an ajax request
function getBatchData_complete(status, response) {
    //do some logic with the ajax data that was returned
    //do this if you are expecting a json object - JSON.parse(response)

    //The var "load_loc" is set in case the response message is different from the action to be loaded into the named location
    //example:
    //-- you want a message to say "ajax done!" in a popup while the data is compiled and loaded somewhere else

    //action if code 200
    if(status == 200) {
        let objects = [];
        // console.log(JSON.parse(response));
        let object = JSON.parse(response);
        let ascending = true;

        let year = object.year;

        if (object.length > 1){
            for (i = 0; i < object.length; i++){
                if (object[i].year == year){
                    objects.push(object[i]);
                    // console.log(object[i]);
                }
            }
        } else {
            if (object.year == year){
                objects.push(object);
            } 
        }
         
        sortedObjects = [];
        if (ascending == true){
            sortedObjects = objects.sort((a, b) => b.startDate 
            < a.startDate ? 1: -1);
        } else {
            sortedStudents = objects.sort((a, b) => b.startDate 
            > a.startDate ? 1: -1);
        }
    
        // console.log(sortedObjects);
        wantedBatchData.push(sortedObjects);
        console.log(wantedBatchData);
    } else if(status == 400) {
        //load the response into the response_loc
        document.getElementById(response_loc).innerHTML = response;
    }
    
    // console.log(response);
}

// Chapter 2. Ajax End ------------------------------------

// Chapter 3. Onload.Body Initializers --------------------
// Chapter 3. Onload.Body Initializers End ----------------

// Chapter 4. Listeners -----------------------------------
// Chapter 4. Listeners End -------------------------------

// Chapter 5. Arrow/Anonymous Functions -------------------
// Chapter 5. Arrow/Anonymous Functions End ---------------

// Chapter 6. Misc Named Functions ------------------------

// Sets the main navigation
function setMainNav() {
    return `
    <a class="nav-link ${onHome} d-flex align-items-center justify-content-center justify-content-md-start" title="Home" href="home.html"><i class="fa fa-home" aria-hidden="true"></i>&nbsp;<span class="d-none d-md-inline">Home</span></a>
    <a class="nav-link ${onBatch} d-flex align-items-center justify-content-center justify-content-md-start" title="Batch" href="batch_home.html"><i class="fa fa-users" aria-hidden="true"></i>&nbsp;<span class="d-none d-md-inline">Batch</span></a>
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

// Gets all batches from a specific year
function getByYear(year, ascending=true){
    let objects = [];
    let batchData = Object();

    if (year.length > 1){
        for (i = 0; i < year.length; i++){
            getBatchData(loginData.id, year[i]);
            console.log("multiple years");
        }
    } else {
        getBatchData(loginData.id, year);
        console.log("one year");
    }
}

getByYear([2020, 2021]);

// Shows each week for each batch we have chosen to display
// function getByWeek(object, week, ascending=true){
//     let objects = [];

//     if (object.length > 1){
//         for (i = 0; i < object.length; i++){
//             for(obj in object[i]){
//                 if (obj.week == week){
//                     objects.push(obj);
//                 }
//             }
//         }
        
//         const sortedObjects = [];
//         if (ascending == true){
//             sortedObjects = objects.sort((a, b) => b.startDate 
//             < a.startDate ? 1: -1);
//         } else {
//             sortedStudents = objects.sort((a, b) => b.startDate 
//             > a.startDate ? 1: -1);
//         }

//         return sortedObjects = [];
//     } else {
//         for (obj in object){
//             if (obj.week == week){
//                 objects.push(obj);
//             }
//         }
    
//         const sortedObjects = [];
//         if (ascending == true){
//             sortedObjects = objects.sort((a, b) => b.startDate 
//             < a.startDate ? 1: -1);
//         } else {
//             sortedStudents = objects.sort((a, b) => b.startDate 
//             > a.startDate ? 1: -1);
//         }
    
//         return sortedObjects;
//     }
// }

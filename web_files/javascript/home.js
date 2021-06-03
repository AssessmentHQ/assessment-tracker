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
let onHome = onPage;
let onBatch = offPage;
let onAssess = offPage;
let onNotes = offPage;
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
    let request_type = "PATCH";
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

//Caller function: calls an ajax request
//Function Description goes here
function loadBatchesbyYear(trainerId) {
    //set the caller_complete to the function that is supposed to receive the response
    //naming convention: [this function name]_complete
    let response_func = loadBatchesbyYear_complete;
    //endpoint: rest api endpoint
    let endpoint = "trainers/years/"+trainerId
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
    let response_loc = "yearsWorked";
    //optional:location you want the load animation to be generated while awaiting the response
    //can be set for any location but will most often be set to response_loc
    //can be left blank if not needed
    let load_loc = "batchLoader";
    //optional:json data to send to the server
    //can be left blank if not needed
    let jsonData = "";
    console.log(jsonData);

    ajaxCaller(request_type, url, response_func, response_loc, load_loc, jsonData)
}
//ajax on-complete function: receives the response from an ajax request
function loadBatchesbyYear_complete(status, response, response_loc, load_loc) {
    //do some logic with the ajax data that was returned
    //do this if you are expecting a json object - JSON.parse(response)

    //The var "load_loc" is set in case the response message is different from the action to be loaded into the named location
    //example:
    //-- you want a message to say "ajax done!" in a popup while the data is compiled and loaded somewhere else
    let jsonHolder = JSON.parse(response);
    //action if code 200
    if(status == 200) {
        batches = jsonHolder[0];
        //loop structure to load data into element
        $.each(batches,(element => {
            //load the response into the response_loc
            document.getElementById(response_loc).innerHTML += newBatch(batches[element]);
            branchData(loginData.id, batches[element], "batch_"+batches[element]);
        }));
        //action if code 201
    } else if(status == 201) {
        document.getElementById(response_loc).innerHTML = JSON.parse(response);
        //action if code 400
    } else if(status == 400) {
        //load the response into the response_loc
        document.getElementById(response_loc).innerHTML = response;
    }
    console.log(batches);
}

//Caller function: calls an ajax request
//Function Description goes here
function branchData(trainerId, year, response_loc) {
    //set the caller_complete to the function that is supposed to receive the response
    //naming convention: [this function name]_complete
    let response_func = branchData_complete;
    //endpoint: rest api endpoint
    let endpoint = "batches/"+trainerId+"/"+year;
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
    //let response_loc = "yearsWorked";
    //optional:location you want the load animation to be generated while awaiting the response
    //can be set for any location but will most often be set to response_loc
    //can be left blank if not needed
    let load_loc = "batchLoader";
    //optional:json data to send to the server
    //can be left blank if not needed
    let jsonData = "";
    console.log(jsonData);

    ajaxCaller(request_type, url, response_func, response_loc, load_loc, jsonData)
}
//ajax on-complete function: receives the response from an ajax request
function branchData_complete(status, response, response_loc, load_loc) {
    //do some logic with the ajax data that was returned
    //do this if you are expecting a json object - JSON.parse(response)

    //The var "load_loc" is set in case the response message is different from the action to be loaded into the named location
    //example:
    //-- you want a message to say "ajax done!" in a popup while the data is compiled and loaded somewhere else
    let jsonHolder = JSON.parse(response);
    //action if code 200
    if(status == 200) {
        batches = jsonHolder[0];
        let myDate = new Date(batches.startDate);
        
        console.log(myDate.getUTCMonth());
        //load the response into the response_loc
        document.getElementById(response_loc).innerHTML += newBatchBtn(batches.name, myDate.getUTCMonth());
        //action if code 201
    } else if(status == 201) {
        document.getElementById(response_loc).innerHTML = JSON.parse(response);
        //action if code 400
    } else if(status == 400) {
        //load the response into the response_loc
        document.getElementById(response_loc).innerHTML = response;
    }
    console.log(batches);
}

// Chapter 2. Ajax End ------------------------------------

// Chapter 3. Onload.Body Initializers --------------------
// Chapter 3. Onload.Body Initializers End ----------------

// Chapter 4. Listeners -----------------------------------
// Chapter 4. Listeners End -------------------------------

// Chapter 5. Arrow/Anonymous Functions -------------------
// Chapter 5. Arrow/Anonymous Functions End ---------------

// Chapter 6. Misc Named Functions ------------------------
//data to load on this page
// should be replicated for each page to abstract the load process in case the user was not logged in on load
function pageDataToLoad() {
    loadinfoByClass("trainerName", loginData.first_name+" "+loginData.last_name);
    loadBatchesbyYear(loginData.id);
}

function loadinfoByClass(theClass, dataToLoad) {
    let trainerName = document.getElementsByClassName(theClass);
    Array.from(trainerName).forEach(element => {
        element.innerHTML = dataToLoad;
    });
}
// holds the styling for the batches
function newBatch(year) {
    return `<div id="batch_${year}" class="d-flex-inline-block flex-fill p-4 mr-2 my-2 bg-darker border border-dark">
    <h4 class="card-title">${year}</h4>
    <hr class="bg-light" />
    </div>`;
}
// holds the styling for the batches
function newBatchBtn(btnName,monthName) {
    return `
    <h6 class="card-title">${months[monthName]}</h6>
    <button class="d-inline-block my-2 btn btn-light text-primary border border-dark bg-darker p-1 rounded">${btnName}</button>
    `;
}

// Chapter 6. Misc Named Functions ------------------------

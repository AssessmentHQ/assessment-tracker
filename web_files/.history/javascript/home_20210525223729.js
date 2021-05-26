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

    //action if code 200
    if(status == 200) {
        //load the response into the response_loc
        document.getElementById(response_loc).innerHTML = response;
    } else if(status == 201) {
        console.log("the response status was: " + JSON.parse(response));
        document.getElementById(response_loc).innerHTML = JSON.parse(response);
    } else if(status == 400) {
        console.log("oops there was an issue with status code: " + status);
        //load the response into the response_loc
        document.getElementById(response_loc).innerHTML = response;
    }
}

// Chapter 2. Ajax End ------------------------------------

// Chapter 3. Onload.Body Initializers --------------------
// Chapter 3. Onload.Body Initializers End ----------------

// Chapter 4. Listeners -----------------------------------
// Chapter 4. Listeners End -------------------------------

// Chapter 5. Arrow/Anonymous Functions -------------------
// Chapter 5. Arrow/Anonymous Functions End ---------------

// Chapter 6. Misc Named Functions ------------------------

// Chapter 6. Misc Named Functions ------------------------

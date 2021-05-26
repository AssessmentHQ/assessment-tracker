/*
    This is the master(main) js/JQuery override file
    Use this to write custom js/JQuery code that will be universally accessible

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

//This is the base url that we are using this base will always be applied it is global scope
let base_url = "http://localhost:5000/";
let java_base_url ="http://localhost:7001/";

// Chapter 1. Global var Declarations End -----------------

// Chapter 2. Ajax ----------------------------------------

// This Ajax Call is a Singleton(only 1 instance)
// All Ajax calls pass through here
function ajaxCaller(request_type, url, response_func, response_loc, load_loc, jsonData) {
    //create the loading object dynamically ----------

    //check if load_loc exists
    if(document.getElementById(load_loc)) {
        //play the loading animation until it is done loading
        //resets the load location to nothing
        document.getElementById(load_loc).innerHTML = "";
        //creates loader
        let pre_load_ani = document.createElement("div");
        // Class:"loader" is a full css animation
        // If you wish to change the loading animation
        // CSS Location = main.css ".loader"
        pre_load_ani.setAttribute("class", "loader");
        //appends loader to loader loc
        document.getElementById(load_loc).appendChild(pre_load_ani);
    }

    //load factory end ------------------------------

    //create the ajax object
    let ajax = new XMLHttpRequest();
    //initiate the ajax function
    ajax.onreadystatechange = function () {
        if (this.readyState == 4) {
            //readystate:4 means the response has come back
            console.log("Ajax Complete! Loading result");

            //remove the loading animation
            document.getElementById(load_loc).innerHTML = "";

            //set response_holder to hold the response data
            let response_holder = this.responseText;

            //send the response to this function
            response_func(this.status, response_holder, response_loc, load_loc)

        }
    }

    //request_type:represents the request type: GET, POST, PUT, etc....
    //url:represents the base_url + the endpoint
    ajax.open(request_type, url, true);

    //optional: checks if json data is being passed
    if(jsonData) {
        ajax.setRequestHeader("Content-Type", "application/json");
        ajax.send(JSON.stringify(jsonData));
    } else {
        ajax.send();
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

//  --------- Manipulating sessionStorage -------------

//retrieves the session and saves it somewhere
//if expecting an object pass in optional second arg, make it true
//Getter
function getSession(getData, isObj) {
    if(isObj) {
        return JSON.parse(sessionStorage[getData]);
    } else {
        return sessionStorage[getData];
    }
}

// Adding new value to storage
function newStorage(key, val) {
    if(sessionStorage.getItem(key) == undefined) {
        sessionStorage.setItem(key, val);
    }
}

//save a value to a session
//if object must save as JSON.stringify(val)
//do this or break up the object and pass in
//Setter
function saveSession(key, val) {
    //check if val is an object and turn to string
    let stringVal;
    if(typeof(val) === "object") {
        stringVal = JSON.stringify(val);
    } else {
        stringVal = val;
    }
    //save session if exists else create a new session key pair
    if(sessionStorage.getItem(key) != undefined) {
        sessionStorage.removeItem(key);
        sessionStorage.setItem(key, stringVal);
    }
    else {
        newStorage(key, stringVal);
    }
}

// Remove all storage data
function wipeStorage() {
    sessionStorage.clear();
}

// Chapter 6. Misc Named Functions ------------------------

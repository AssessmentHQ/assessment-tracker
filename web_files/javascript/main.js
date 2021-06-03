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
let loginData = new Object();
let batches = new Object();
//holds the string value of months
let months = new Array("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
// main header content
let mainHeader = `
<nav class="nav top-nav navbar-expand-lg d-flex justify-content-between bg-dark" aria-labelledby="Topbar navigation">
    <a class="navbar-toggler rounded-0" type="button" data-toggle="collapse" data-target="#navbarToggle" aria-controls="navbarToggle" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon text-darker text-center rounded-0">
            <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">
                <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z"/>
            </svg>
        </span>
    </a>
    <a class="navbar-brand order-md-1 order-xs-1" href="#"><img src="images/rev-logo.png" alt="Revature Logo"></a>
    <a id="loginBtn" data-toggle="modal" data-target="#loginModal" data-preLoad="Some content to pre-load" class="nav-link text-dark bg-info d-flex order-md-3 order-xs-2 align-items-center mr-3">Login &nbsp;<i class="fa fa-sign-in" aria-hidden="true"></i></a>
    <div class="collapse navbar-collapse order-md-2 order-xs-3 col-xs-12 bg-dark py-3" id="navbarToggle">
        <form class="mr-5 col-md-9 col-sm-12">
            <div class="input-group">
                <div class="input-group-prepend">
                    <label for="search" id="searchLabel" class="input-group-text bg-darkest border-none text-light"><i class="fa fa-search" aria-hidden="true"></i></label>
                </div>
                <input id="search" class="form-control bg-darkest border-none col-12" type="search" placeholder="Search" aria-label="Search" aria-describedby="Search a batch" />
            </div>
        </form>
    </div>
</nav>`;
// represents you are on this page in main nav
let onPage = "text-light";
// represents you are not on this page in main nav
let offPage = "text-dark";
// must login message
//var to set the body of the page to if user is not logged in
let mustLogin = `
<div class="col-sm-1-10">
    <div class="card mb-5 bg-darker p-3">
        <div class="card-body rounded p-3">
            <h3 class="card-title"><strong>Please Login</strong></h3>
            <p class="">If you would like to view your batches then please <a data-toggle="modal" href="#loginModal">login Here</a>, or you may click the link above.</p>
        </div>
    </div>
</div>`;
// temporarily holds the main body content if user is not logged in until user logs in
let tempMainContentHolder = $("#mainbody").html();

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
// Login Function
// email for the login(obj)
function logMeIN(email) {
    //set the caller_complete to the function that is supposed to receive the response
    //naming convention: [this function name]_complete
    let response_func = logMeIN_complete;
    //endpoint: rest api endpoint
    let endpoint = "trainer/"
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
    let load_loc = "logload";
    //optional:json data to send to the server
    //can be left blank if not needed
    let jsonData = email;
    console.log(jsonData);

    ajaxCaller(request_type, url, response_func, response_loc, load_loc, jsonData)
}
//ajax on-complete function: receives the response from an ajax request
function logMeIN_complete(status, response, response_loc, load_loc) {
    //do some logic with the ajax data that was returned
    //do this if you are expecting a json object - JSON.parse(response)

    //The var "load_loc" is set in case the response message is different from the action to be loaded into the named location
    //example:
    //-- you want a message to say "ajax done!" in a popup while the data is compiled and loaded somewhere else

    //action if code 200
    if(status == 200) {
        $("#loginBtn").html(`Log Out &nbsp;<i class="fa fa-sign-out" aria-hidden="true"></i>`);
        document.getElementById("loginBtn").setAttribute("data-target", "#logoutModal");
        //save the session
        saveSession(loginData, response);
        // loads it back to the object
        loginData = getSession(loginData, true);
        // hides the modal after login is successful
        $('#loginModal').modal('hide');
        // reset page content back to the actual page
         $("#mainbody").html(tempMainContentHolder);
         pageDataToLoad();

        //action if code 201
    } else if(status == 201) {
        document.getElementById(response_loc).innerHTML = JSON.parse(response);
        //action if code 400
    } else if(status == 400) {
        //load the response into the response_loc
        document.getElementById(response_loc).innerHTML = response;
    }
    console.log(loginData);
}

// Chapter 2. Ajax End ------------------------------------

// Chapter 3. Onload.Body Initializers --------------------

//set a standard for form validation


//Iterates through all forms on a page then cancels the forms default functions
//validates form data based on elements attributes and 'is-valid' class
(function() {
    'use strict';
    window.addEventListener('load', function() {
        //set up header content
        $("#headContent").html(mainHeader);
        
        //session data space
        // Logged in check
        if(getSession(loginData, true)){
            loginData = getSession(loginData, true);
            pageDataToLoad();
            $("#loginBtn").html(`Log Out&nbsp;<i class="fa fa-sign-out" aria-hidden="true"></i>`);
            document.getElementById("loginBtn").setAttribute("data-target", "#logoutModal");
        } else {
            tempMainContentHolder = $("#mainbody").html();
            $("#mainbody").html(mustLogin);
        }
        console.log(loginData);

        //set up main nav links
        //this is so you do not have to copy paste to every page
        $("#navController").html(setMainNav());

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.getElementsByClassName('needs-validation');
        // Loop over them and prevent submission
        Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
                event.stopPropagation();
                event.preventDefault();
                if (form.checkValidity() === false) {
                    //at least one element does not have a valid value
                    console.log("Form not valid");
                } else {
                    //all elements are valid
                    console.log("Form is valid");
                }
                form.classList.add('was-validated');
            }, false);
        });
    }, false);
})();
// Chapter 3. Onload.Body Initializers End ----------------

// Chapter 4. Listeners -----------------------------------
// Chapter 4. Listeners End -------------------------------

// Chapter 5. Arrow/Anonymous Functions -------------------
// Chapter 5. Arrow/Anonymous Functions End ---------------

// Chapter 6. Misc Named Functions ------------------------

// Sets the main navigation
function setMainNav() {
    //some of these are stretch goal links so they are commented out until they can be completed
    return `
    <a class="nav-link ${onHome} d-flex align-items-center justify-content-center justify-content-md-start" title="Home" href="home.html"><i class="fa fa-home" aria-hidden="true"></i>&nbsp;<span class="d-none d-md-inline">Home</span></a>
    <a class="nav-link ${onBatch} d-flex align-items-center justify-content-center justify-content-md-start" title="Batch" href="specific_batch_week.html"><i class="fa fa-users" aria-hidden="true"></i>&nbsp;<span class="d-none d-md-inline">Batch</span></a>
    <!--<a class="nav-link ${onAssess} d-flex align-items-center justify-content-center justify-content-md-start" title="Assessments" href="#"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>&nbsp;<span class="d-none d-md-inline">Assessments</span></a>
    <a class="nav-link ${onNotes} d-flex align-items-center justify-content-center justify-content-md-start" title="Notes" href="#">
        <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi bi-journal-text" viewBox="0 0 16 16">
            <path d="M5 10.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1h-2a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5z"/>
            <path d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2z"/>
            <path d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1z"/>
        </svg>
    &nbsp;<span class="d-none d-md-inline">Notes</span>
    </a>-->`;
}

// ---------- pulling and saving form data ------------

// logout function
function logout(){
    $("#loginBtn").html(`Login&nbsp;<i class="fa fa-sign-in" aria-hidden="true"></i>`);
    document.getElementById("loginBtn").setAttribute("data-target", "#loginModal");
    tempMainContentHolder = $("#mainbody").html();
    $("#mainbody").html(mustLogin);
}

/*
 * Extracts form elements and maps to passed in object
 */
 function extractObjectFromForm($fieldContainer,objectType) {
    var innerArray=[];
    var obj = $.map($fieldContainer.find(":input"), function(n, i)
    {
        var o = {};
        if($(n).is("input:text") 
                || $(n).is("textarea") 
                || $(n).is("input:hidden") 
                || $(n).is("input:password"))
            o[n.name] = $(n).val();
        else if($(n).is("input:checkbox"))
            o[n.name] = ($(n).is(":checked") ? true:false);
        else if(n.type == 'radio') {
            if(innerArray.indexOf(n.name)==-1) {
                innerArray.push(n.name);
            }
        }
        else
            o[n.name] = $(n).val();
        return o;
    });
    $.each(innerArray,function(index,item){
        var iobj={};
        iobj[item]=$("input[name='"+item+"']:checked").val();
        obj.push(iobj);
    });
    return getObjectFromObject(obj,objectType);
}


// Takes a object created from a form scour and
// converts it to an Object type
function getObjectFromObject(formObject,outputObject) {
    $.each(formObject,function(index,item){
        $.each(item,function(key,value){
            if(key) {
                outputObject[key] = services[key];
                if(typeof(value) == "boolean") {
                    outputObject[key].isSelected = value;
                } else {
                    outputObject[key].quantity = value;
                }
                if(value == "" || value == false) {
                    delete outputObject[key];
                }
            }
        });
    });
    console.log(outputObject);
    return outputObject;
}

//pre-load both the services page and the activities page
function preloadService(formObject) {
    $.each(formObject,function(index,item){
        if(document.getElementById(index)) {
            if(typeof(formObject[index].isSelected) == 'boolean') {
                $('#'+index).prop('checked', true);
            } else {
                document.getElementById(index).value = formObject[index].quantity;
            }
        }
    });
}

//  --------- Manipulating sessionStorage -------------

//Directs user to another page
//use to customize any functionality to send a user to a new page
function goToPage(newSpot) {
    window.location.href = newSpot;
}

//retrieves the session and saves it somewhere
//if expecting an object pass in optional second arg, make it true
//Getter
function getSession(getData, isObj) {
    if(isObj && sessionStorage[getData]) {
        return JSON.parse(sessionStorage[getData]);
    } else if(sessionStorage[getData]) {
        return sessionStorage[getData];
    } else {
        return;
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

//this sets the date ranges allowed for a form input["date"] element
function getDateFormat(myDate, addDay, addMonth, addYear) {
    myDate.setUTCDate(myDate.getUTCDate());
    //to increase the future date just add a number to it ex. +5
    let n = myDate.getUTCHours()+4;
    let dd = myDate.getUTCDate()+addDay;
    let mm = myDate.getUTCMonth()+1+addMonth; //January is 0!
    myDate.getUTC
    let yyyy = myDate.getFullYear()+addYear;
    if(dd<10){
        dd='0'+dd
    } 
    if(mm<10){
        mm='0'+mm
    } 

    myDate = yyyy+'-'+mm+'-'+dd;
    return myDate;
}

// finds the difference between 2 dates in days
function dateDiff(date1, date2) {
    let diff = (date2 - date1)/1000;
    diff = Math.abs(Math.floor(diff));
    dateDiffHolder = Math.floor(diff/(24*60*60));
    if(date1 > date2) {
        dateDiffHolder = 0;
    }
    return dateDiffHolder+1;
}
// Chapter 6. Misc Named Functions ------------------------

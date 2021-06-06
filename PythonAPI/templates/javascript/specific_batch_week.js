// highlights which page you are on in main nav
let onHome = onPage;
let onBatch = offPage;
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

weekCount = 0

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

function addWeek(){
    weeks = getWeeks()
    weekCount += 1
    document.getElementById("panels").innerHTML += 
    `
    <div id="week ${weekCount}" class="col-sm-1-10">
                    <div class="card mb-5 bg-darker p-3">
                        <div class="card-body rounded p-3">
                            <h3 class="card-title"><strong>Week ${weekCount}</strong></h3>
                            <p class="cart-topic">Outsourcing Your Work and You.</p>
                            <p class="card-text" class-"weekDescription">
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                            </p>
                            <button id="addAssessmentBtn">Add Assessment To This Week</button>
                            <button id="viewAssessmentsBtn">View Assessments For This Week</button>
                            <button id="deletePanelBtn">Delete This Week</button>
                        </div>
                    </div>
                </div>
    `
}
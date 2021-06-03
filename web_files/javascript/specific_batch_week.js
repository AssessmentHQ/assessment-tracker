// highlights which page you are on in main nav
let onHome = offPage;
let onBatch = onPage;
let onAssess = offPage;
let onNotes = offPage;

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
//data to load on this page
// should be replicated for each page to abstract the load process in case the user was not logged in on load
function pageDataToLoad() {
    // put what you want to load on the page if you are logged in
}

function getByYear(object, year, ascending=true){
    let objects = [];

    for(obj in object){
        if (obj.year == year){
            objects.push(obj);
        }
    }

    const sortedObjects;
    if (ascending == true){
        sortedObjects = objects.sort((a, b) => b.startDate 
        < a.startDate ? 1: -1);
    } else {
        sortedStudents = objects.sort((a, b) => b.startDate 
        > a.startDate ? 1: -1);
    }

    return sortedObjects;
}

function getByWeek(object, week, ascending=true){
    let objects = [];

    if (object.length > 1){
        for (i = 0; i < object.length; i++){
            for(obj in object[i]){
                if (obj.week == week){
                    objects.push(obj);
                }
            }
        }

        const sortedObjects;
    if (ascending == true){
        sortedObjects = objects.sort((a, b) => b.startDate 
        < a.startDate ? 1: -1);
    } else {
        sortedStudents = objects.sort((a, b) => b.startDate 
        > a.startDate ? 1: -1);
    }

        return sortedObjects;
    } else {
        for (obj in object){
            if (obj.week == week){
                objects.push(obj);
            }
        }
    
        const sortedObjects;
        if (ascending == true){
            sortedObjects = objects.sort((a, b) => b.startDate 
            < a.startDate ? 1: -1);
        } else {
            sortedStudents = objects.sort((a, b) => b.startDate 
            > a.startDate ? 1: -1);
        }
    
        return sortedObjects;
    }
}

// Sets the main navigation
function setMainNav() {
    return `
    <a class="nav-link ${onHome} d-flex align-items-center justify-content-sm-center justify-content-md-start" title="Home" href="home.html"><i class="fa fa-home" aria-hidden="true"></i>&nbsp;<span class="d-sm-none d-md-inline">Home</span></a>
    <a class="nav-link ${onBatch} d-flex align-items-center justify-content-sm-center justify-content-md-start" title="Batch" href="batch_home.html"><i class="fa fa-users" aria-hidden="true"></i>&nbsp;<span class="d-sm-none d-md-inline">Batch</span></a>
    <a class="nav-link ${onAssess} d-flex align-items-center justify-content-sm-center justify-content-md-start" title="Assessments" href="#"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>&nbsp;<span class="d-sm-none d-md-inline">Assessments</span></a>
    <a class="nav-link ${onNotes} d-flex align-items-center justify-content-sm-center justify-content-md-start" title="Notes" href="#">
        <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi bi-journal-text" viewBox="0 0 16 16">
            <path d="M5 10.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1h-2a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5z"/>
            <path d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2z"/>
            <path d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1z"/>
        </svg>
    &nbsp;<span class="d-sm-none d-md-inline">Notes</span>
    </a>`;
}
package controllers;
import io.javalin.http.Handler;
import com.google.gson.Gson;



public class AssessmentController {

    private AssesmentService as;
    private Gson gson = new Gson();


    public AssessmentController(AssesmentService as){
        //need servivce
        this.as =as;
    }

    public Handler getNotesForTrainee = (context) -> {
       
    };
    public Handler getAssesmentForTrainee = (context) -> {

    };
    public Handler createAssessment = (context) -> {

    };
    public Handler updateGradeForAssessment = (context) -> {

    };
    public Handler updateWeightForAssessment = (context) -> {

    };

}

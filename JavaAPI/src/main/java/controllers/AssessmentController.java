package controllers;
import io.javalin.http.Handler;
import com.google.gson.Gson;
//import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Logger;
import services.AssessmentService;


public class AssessmentController {
    private static Logger aclog = Logger.getLogger(AssessmentController.class);

    private AssessmentService as;
    private Gson gson = new Gson();


    public AssessmentController(AssessmentService as){

        //need servivce
        this.as =as;
    }

    public Handler getNotesForTrainee = (context) -> {
        log.info("attempting to get notes");
    };
    public Handler getAssesmentForTrainee = (context) -> {
        log.info("attempting to get assesments for a trainee");
    };
    public Handler createAssessment = (context) -> {
        log.info("attempting to create an assessment");
    };
    public Handler updateGradeForAssessment = (context) -> {
        log.info("attempting to update the grade on an assessment");
    };
    public Handler updateWeightForAssessment = (context) -> {
        log.info("attempting to update the weight on an assessment");
    };

}

package app;

import io.javalin.Javalin;
import controllers.AssessmentControlller;
import controllers.AssessmentService;
public class App {
    public static void main(String[] args) {


        Javalin app = Javalin.create();
        establishRoutes(app);
        app.start(7001);

    }

    private static void establishRoutes(Javalin app) {
        //Need a Repo
        //AssessmentRepo ar= new AssessmentRepo();
        //Need a Service
        AssessmentService as= new AssessmentService();
        app.get("/Testing", (context) -> context.result("Testing"));


        //EndPoints
        AssessmentControlller as= new AssessmentControlller(as);
        app.get("/getAssessments/:id/:weekid",as.getAssesmentForTrainee);
        app.get("/notes/:id/:weekid/",as.getNotesForTrainee);
        app.post("/assessments",as.createAssessment);
        app.put("/assessments/:id/",as.updateGradeForAssessment);
        app.put("/getAssessments/:id/:weekid",as.updateWeightForAssessment);


    }

}

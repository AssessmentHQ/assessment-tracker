package app;

import io.javalin.Javalin;
import controllers.AssessmentController;
import services.AssessmentService;
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
        AssessmentController ac = new AssessmentController(as);
        app.get("/assessments/:id/:weekid",ac.getAssessmentForTrainee);
        app.get("/notes/:id/:weekid/",ac.getNotesForTrainee);
        app.post("/assessments",ac.createAssessment);
        app.post("/assessments/:id/",ac.insertGrade);
        app.put("/assessments/:id/",ac.updateWeightForAssessment);
        app.post("/types",ac.createType);
        app.put("/assessments/:id/",ac.updateTypeForAssessment);

    }

}

package controllers;

import io.javalin.http.Handler;
import com.google.gson.Gson;
import models.Grade;
import models.Note;
import models.Assessment;
import models.AssessmentType;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import services.AssessmentService;

import java.util.List;

public class AssessmentController {
    private static Logger aclogger = LogManager.getLogger(AssessmentController.class);

    private AssessmentService as;
    private Gson gson = new Gson();

    public AssessmentController(AssessmentService as) {
        // Setting Service
        this.as = as;
    }

    public Handler getAssessments = (context) -> {
        try {
            aclogger.info("attempting to get all assessments");
            List<Assessment> assessment = as.getAssessments();
            context.contentType("application/json");
            context.result(gson.toJson(assessment));
        } catch (Exception e) {
            aclogger.info(e);
        }

    };


    public Handler getAssessmentsByTraineeId = (context) -> {
        try {
            int traineeId = Integer.parseInt(context.pathParam("id"));
            aclogger.info("attempting to get all assessments");
            List<Assessment> assessment = as.getAssessmentsByTraineeId(traineeId);
            context.contentType("application/json");
            context.result(gson.toJson(assessment));
        } catch (Exception e) {
            aclogger.info(e);
        }

    };

    public Handler getGradesForWeek = (context) -> {
        try {
            aclogger.info("attempting to get assessments for a trainee");
            int traineeId = Integer.parseInt(context.pathParam("id"));
            String weekId = context.pathParam("weekid");
            aclogger.info("attempting to get assessments");
            List<Grade> grades = as.getGradesForWeek(traineeId, weekId);
            context.contentType("application/json");
            context.result(gson.toJson(grades));
        } catch (Exception e) {
            aclogger.info(e);
        }

    };

    public Handler getBatchWeek = (context) -> {
        try {
            aclogger.info("attempting to get assessments for a batch by week");
            int batchId = Integer.parseInt(context.pathParam("id"));
            String weekId = context.pathParam("weekid");
            aclogger.info("attempting to get assessments");
            List<Assessment> assessments = as.getBatchWeek(batchId, weekId);
            context.contentType("application/json");
            context.result(gson.toJson(assessments));
        } catch (Exception e) {
            aclogger.info(e);
        }
    };

    public Handler getNotesForTrainee = (context) -> {
        try {
            aclogger.info("attempting to get notes params");
            int id = Integer.parseInt(context.pathParam("id"));
            String weekId = context.pathParam("weekid");
            aclogger.info("attempting to get notes");
            List<Note> notes = as.getNotesForTrainee(id, weekId);
            context.contentType("application/json");
            context.result(gson.toJson(notes));
        } catch (Exception e) {
            aclogger.info(e);
        }
    };

    public Handler createAssessment = (context) -> {
        try {
            aclogger.info("attempting to create an assessment");
            Assessment assessment = gson.fromJson(context.body(), Assessment.class);
            Assessment updatedAssessment = as.createAssessment(assessment);
            context.contentType("application/json");
            aclogger.info("attempting to return updated assessment");
            context.result(gson.toJson(updatedAssessment));
        } catch (Exception e) {
            aclogger.info(e);
        }

    };

    public Handler insertGrade = (context) -> {
        try {
            aclogger.info("attempting to update the grade on an assessment");
            Grade grade = gson.fromJson(context.body(), Grade.class);
            Grade insertedGrade = as.insertGrade(grade);
            context.contentType("application/json");
            aclogger.info("attempting to return inserted  grade");
            context.result(gson.toJson(insertedGrade));
        } catch (Exception e) {
            aclogger.info(e);
        }
    };

    public Handler adjustWeight = (context) -> {
        aclogger.info("attempting to update the weight on an assessment");
        try {
            aclogger.info("attempting to update the grade on an assessment");
            int weight = Integer.parseInt(context.pathParam("weight"));
            int assessmentId = Integer.parseInt(context.pathParam("assessmentId"));
            boolean wasUpdated = as.adjustWeight(assessmentId, weight);
            context.contentType("application/json");
            aclogger.info("attempting to return updatedWeight");
            context.result(gson.toJson(wasUpdated));
        } catch (Exception e) {
            aclogger.info(e);
        }
    };
    public Handler createAssessmentType = (context) -> {
        try {
            aclogger.info("attempting to create a Type for assessments");
            AssessmentType assessmentType = gson.fromJson(context.body(), AssessmentType.class);
            AssessmentType updatedAssessmentType = as.createAssessmentType(assessmentType);
            context.contentType("application/json");
            aclogger.info("attempting to return updated type");
            context.result(gson.toJson(updatedAssessmentType));
        } catch (Exception e) {
            aclogger.info(e);
        }
    };
    public Handler assignAssessmentType = (context) -> {
        aclogger.info("attempting to update type for assessment");
        try {
            int typeId = Integer.parseInt(context.pathParam("typeId"));
            int assessmentId = Integer.parseInt(context.pathParam("assessmentId"));
            boolean wasUpdated = as.updateTypeForAssessment(assessmentId,typeId);
            context.contentType("application/json");
            aclogger.info("attempting to return updated type for assessment");
            context.result(gson.toJson(wasUpdated));
        } catch (Exception e) {
            aclogger.info(e);
        }
    };
    public Handler getGradeForAssociate = (context) -> {
        try{
            int associateId = Integer.parseInt(context.pathParam("associateId"));
            int assessmentId = Integer.parseInt(context.pathParam("assessmentId"));
            Grade grade = as.getGradeForAssociate(associateId, assessmentId);
            context.contentType("application/json");
            context.result(gson.toJson(grade));
        }catch (Exception e){
            aclogger.info(e);
        }
    };
}

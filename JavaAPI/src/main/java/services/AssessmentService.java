package services;

import dao.AssessmentDAO;
import dao.AssessmentDAOImpl;
import models.Assessment;
import models.Grade;
import models.Note;
import models.AssessmentType;
import util.dbconnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssessmentService {
    AssessmentDAO assessmentDAO = new AssessmentDAOImpl();

    public List<Assessment> getAssessments() throws SQLException {
        List<Assessment> assessments = assessmentDAO.getAssessments();
        return assessments;
    }

    public List<Assessment> getAssessmentsByTraineeId(int traineeId) throws SQLException {
        List<Assessment> assessments = assessmentDAO.getAssessmentsByTraineeId(traineeId);
        return assessments;
    }

    public List<Assessment> getWeekAssessments(int traineeId, String weekId) throws SQLException {
        List<Assessment> weekAssessments = assessmentDAO.getWeekAssessments(traineeId, weekId);
        return weekAssessments;

    }

    public Assessment createAssessment(Assessment assessment) throws SQLException {
        return assessmentDAO.createAssessment(assessment);
    }

    public boolean adjustWeight(int assessmentId, int weight) throws SQLException {
        return assessmentDAO.adjustWeight(assessmentId, weight);
    }

    public AssessmentType createAssessmentType(AssessmentType assessmentType) throws SQLException {
        return assessmentDAO.createAssessmentType(assessmentType.getName(), assessmentType.getDefaultWeight());
    }

    public List<Note> getNotesForTrainee(int id, String weekId) {
        return assessmentDAO.getNotesForTrainee(id, weekId);
    }

    public Grade insertGrade(Grade grade) {
        // TODO write method to insert grade
        return null;
    }

    public int assignAssessmentType(int ypeId) {
        // TODO write method to assign assessment type
        return -99;
    }

    public List<Assessment> getBatchWeek(int batchId, String weekId) throws SQLException{
        return assessmentDAO.getBatchWeek(batchId, weekId);
    }
}

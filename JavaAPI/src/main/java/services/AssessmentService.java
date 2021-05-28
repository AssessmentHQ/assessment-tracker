package services;

import dao.AssessmentDAO;
import dao.AssessmentDAOImpl;
import models.Assessment;
import models.Grade;
import models.Note;

import java.sql.SQLException;
import java.util.List;

public class AssessmentService {
    AssessmentDAO assessmentDAO = new AssessmentDAOImpl();

    public Assessment createAssessment(Assessment assessment) throws SQLException {
        return assessmentDAO.createAssessment(assessment.getWeekId(), assessment.getBatchId());
    }

    public Grade insertGrade(Grade grade) {
        return null;
    }

    public Assessment getAssesmentForTrainee(int id, String weekId) {
        return null;
    }

    public List<Note> getNotesForTrainee(int id, String weekId) {
        return null;
    }

    public int updateWeightForAssessment(int weight) {
        return 0;
    }
}

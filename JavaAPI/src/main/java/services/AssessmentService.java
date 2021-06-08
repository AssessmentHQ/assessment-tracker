package services;

import dao.AssessmentDAO;
import dao.AssessmentDAOImpl;
import models.Assessment;
import models.Grade;
import models.Note;
import models.AssessmentType;

import java.sql.SQLException;
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

    public List<Grade> getGradesForWeek(int traineeId, String weekId) throws SQLException {
        List<Grade> grades = assessmentDAO.getGradesForWeek(traineeId, weekId);
        return grades;

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

    public boolean updateTypeForAssessment(int assessmentId, int typeId) throws SQLException {
        return assessmentDAO.assignAssessmentType(assessmentId, typeId);
    }

    public Grade insertGrade(Grade grade) throws SQLException {
        if(assessmentDAO.getGradeForAssociate(grade.getAssociateId(), grade.getAssessmentId()) == null){
            return assessmentDAO.insertGrade(grade);
        }
        else{return assessmentDAO.updateGrade(grade);}
    }


    public List<Assessment> getBatchWeek(int batchId, String weekId) throws SQLException{
        return assessmentDAO.getBatchWeek(batchId, weekId);
    }
    public Grade getGradeForAssociate(int associateId, int assessmentId) throws SQLException {
        return assessmentDAO.getGradeForAssociate(associateId, assessmentId);
    }
}

package dao;

import models.Assessment;
import models.Grade;
import models.Note;
import models.AssessmentType;

import java.util.List;
import java.sql.SQLException;

public interface AssessmentDAO {
    public List<Assessment> getAssessments() throws SQLException;

    public List<Assessment> getAssessmentsByTraineeId(int traineeId) throws SQLException;

    public List<Grade> getGradesForWeek(int traineeId, String weekId) throws SQLException;

    public List<Assessment> getBatchWeek(int batchId, String weekId) throws SQLException;

    public Assessment createAssessment(Assessment a) throws SQLException;

    public boolean adjustWeight(int assessmentId, int weight) throws SQLException;

    public AssessmentType createAssessmentType(String name, int defaultWeight) throws SQLException;

    public boolean assignAssessmentType(int assessmentId, int typeId) throws SQLException;

    public List<Note> getNotesForTrainee(int id, String weekId);

    public Grade insertGrade(Grade grade);



    public Grade getGradeForAssociate(int associateId, int assessmentId) throws SQLException;

    public Grade updateGrade(Grade grade) throws SQLException;

}

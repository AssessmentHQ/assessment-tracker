package dao;

import models.Assessment;
import models.Grade;
import models.Note;
import models.Type;

import java.util.List;
import java.sql.SQLException;

public interface AssessmentDAO {
    public List<Assessment> getAssessments() throws SQLException;

    public List<Assessment> getWeekAssessments(String weekId, int batchId) throws SQLException;

    public Assessment createAssessment(String weekId, int batchId) throws SQLException;

    public boolean adjustWeight(int assessmentId, int weight) throws SQLException;

    public Type createAssessmentType(String name, int defaultWeight) throws SQLException;

    public boolean assignAssessmentType(int assessmentId, int typeId) throws SQLException;

    public List<Note> getNotesForTrainee(int id, String weekId);

    public Grade insertGrade(Grade grade);

    public int assignAssessmentType(int typeId);

}

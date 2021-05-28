package dao;

import models.Assessment;
import models.Type;

import java.util.List;
import java.sql.SQLException;

public interface AssessmentDAO {
    public List<Assessment> getAssessments() throws SQLException;

    public List<Assessment> getWeekAssessments(String weekId, int batchId) throws SQLException;

    public Assessment createAssessment(String weekId, int batchId) throws SQLException;

    public boolean adjustWeight(int assessmentId, int weight) throws SQLException;

    public Type createAssessmentType(String name, int defaultWeight) throws SQLException;

    public boolean assignAssessmentType(int assessmentId) throws SQLException;

}

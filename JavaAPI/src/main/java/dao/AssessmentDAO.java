package dao;
import models.Assessment;
import models.Type;

import java.sql.ResultSet;
import java.util.List;
import java.sql.SQLException;

public interface AssessmentDAO {
    public abstract List<Assessment> getAssessments() throws SQLException;
    public abstract List<Assessment> getWeekAssessments(String weekId, int batchId) throws SQLException;
    public abstract Assessment createAssessment(String weekId, int batchId) throws SQLException;

    public abstract boolean adjustWeight(int assessmentId, int weight) throws SQLException;
    public abstract Type createAssessmentType(String name, int defaultWeight) throws SQLException;

    public abstract boolean assignAssessmentType(int assessmentId) throws SQLException;
}

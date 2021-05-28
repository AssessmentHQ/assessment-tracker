package dao;
import models.Assessment;
import models.Type;

import java.sql.ResultSet;
import java.util.List;
import java.sql.SQLException;

public abstract class AssessmentDAO {
    public abstract List<Assessment> getAssessments() throws SQLException;
    public abstract List<Assessment> getWeekAssessments(String weekId, int batchId) throws SQLException;
    public abstract Assessment createAssessment(String weekId, int batchId) throws SQLException;
    public abstract boolean insertGrade(int assessmentId, int batchId, int traineeId) throws SQLException;
    public abstract boolean adjustWeight(int assessmentId) throws SQLException;
    public abstract Type createAssessmentType(String name, int defaultWeight) throws SQLException;
    public abstract boolean assignAssessmentType(int assessmentId) throws SQLException;
    public abstract Assessment buildAssessment(ResultSet rs) throws SQLException;
    public abstract Type buildType(ResultSet rs) throws SQLException;
}

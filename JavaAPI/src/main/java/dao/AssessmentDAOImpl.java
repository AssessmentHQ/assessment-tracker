package dao;

import models.Assessment;
import util.dbconnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssessmentDAOImpl implements AssessmentDAO{

    @Override
    public List<Assessment> getAssessments() throws SQLException {
        try {
            String sql = "SELECT * FROM assessments";
            PreparedStatement ps = dbconnection.getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Assessment> assessments = new ArrayList<Assessment>();

            while (rs.next()) {
                assessments.add(buildAssessment(rs));
            }

            return assessments;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Assessment> getWeekAssessments(String weekId, int batchId) throws SQLException {
        try {
            String sql = "SELECT * FROM assessments WHERE week_number = ?";
            PreparedStatement ps = dbconnection.getConnection().prepareStatement(sql);
            ps.setString(1, weekId);

            ResultSet rs = ps.executeQuery();

            List<Assessment> assessments = new ArrayList<Assessment>();

            while (rs.next()) {
                assessments.add(buildAssessment(rs));
            }

            return assessments;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Assessment createAssessment(String weekId, int batchId) throws SQLException {
        try {
            String sql = "INSERT INTO assessments VALUES (DEFAULT,\"\",0,?,?,0) RETURNING *";
            PreparedStatement ps = dbconnection.getConnection().prepareStatement(sql);
            ps.setInt(1, batchId);
            ps.setString(2, weekId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                Assessment assessment = buildAssessment(rs);
                return assessment;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean adjustWeight(int assessmentId, int weight) throws SQLException {
        try {
            String sql = "UPDATE assessments SET weight=? WHERE assessment_id=?";
            PreparedStatement ps = dbconnection.getConnection().prepareStatement(sql);
            ps.setInt(1, weight);
            ps.setInt(2, assessmentId);

            ResultSet rs = ps.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String createAssessmentType(String assessmentType) throws SQLException {
        return null;
    }

    @Override
    public boolean assignAssessmentType(int assessmentId) throws SQLException {
        return false;
    }

    @Override
    public Assessment buildAssessment(ResultSet rs) throws SQLException {
        Assessment assessment = new Assessment();
        assessment.setAssessmentId(rs.getInt("id"));
        assessment.setAssessmentTitle(rs.getString("title"));
        assessment.setTypeId(rs.getInt("type_id"));
        assessment.setBatchId(rs.getInt("batch_id"));
        assessment.setWeekId(rs.getString("week_number"));
        assessment.setAssessmentWeight(rs.getInt("weight"));
        assessment.setCategoryId(rs.getInt("category_id"));

        return assessment;
    }
}

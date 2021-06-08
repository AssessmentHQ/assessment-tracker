package dao;

import models.Assessment;
import models.Grade;
import models.Note;
import models.AssessmentType;
import util_project.dbconnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssessmentDAOImpl implements AssessmentDAO {

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
    public List<Assessment> getAssessmentsByTraineeId(int traineeId) throws SQLException {
        try {
            String sql = "SELECT * FROM grades AS g JOIN assessments a ON " +
                    "g.assessment_id = a.id WHERE associate_id = ?";
            PreparedStatement ps = dbconnection.getConnection().prepareStatement(sql);
            ps.setInt(1, traineeId);

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
    public List<Assessment> getBatchWeek(int batchId, String weekId) throws SQLException {
        try {
            String sql = "SELECT * FROM assessments WHERE batch_id = ? AND week = ?";
            PreparedStatement ps = dbconnection.getConnection().prepareStatement(sql);
            ps.setInt(1, batchId);
            ps.setString(2, weekId);

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
    public Grade getGradeForAssociate(int associateId, int assessmentId) throws SQLException {
        try {
            String sql = "SELECT g.id, g.assessment_id, g.score, g.associate_id FROM grades as g JOIN assessments a " +
                    "ON g.assessment_id = a.id WHERE" +
                    " associate_id = ? AND assessment_id = ?";
            PreparedStatement ps = dbconnection.getConnection().prepareStatement(sql);
            ps.setInt(1, associateId);
            ps.setInt(2, assessmentId);

            ResultSet rs = ps.executeQuery();


            if (rs.next()) {
                return buildGrade(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Grade updateGrade(Grade grade) throws SQLException {
        try {
            String sql = "UPDATE grades SET score=? WHERE assessment_id=? and associate_id=? RETURNING *";

            PreparedStatement ps = dbconnection.getConnection().prepareStatement(sql);
            ps.setDouble(1, grade.getScore());
            ps.setInt(2, grade.getAssessmentId());
            ps.setInt(3, grade.getAssociateId());

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return buildGrade(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Grade> getGradesForWeek(int traineeId, String weekId) throws SQLException {
        try {
            String sql = "SELECT g.id, g.assessment_id, g.score, g.associate_id FROM grades as g JOIN assessments a " +
                    "ON g.assessment_id = a.id WHERE" +
                    " associate_id = ? AND week = ?";
            PreparedStatement ps = dbconnection.getConnection().prepareStatement(sql);
            ps.setInt(1, traineeId);
            ps.setString(2, weekId);

            ResultSet rs = ps.executeQuery();

            List<Grade> grades = new ArrayList<Grade>();

            while (rs.next()) {
                grades.add(buildGrade(rs));
            }

            return grades;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Assessment createAssessment(Assessment a) throws SQLException {
        try {
            String sql = "INSERT INTO assessments VALUES (DEFAULT,?,?,?,?,?,?) RETURNING *";
            PreparedStatement ps = dbconnection.getConnection().prepareStatement(sql);
            ps.setInt(1, a.getCategoryId());
            ps.setInt(2, a.getTypeId());
            ps.setString(3, a.getAssessmentTitle());
            ps.setDouble(4, a.getAssessmentWeight());
            ps.setInt(5, a.getBatchId());
            ps.setString(6, a.getWeekId());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
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
            String sql = "UPDATE assessments SET weight=? WHERE id=?";
            PreparedStatement ps = dbconnection.getConnection().prepareStatement(sql);
            ps.setInt(1, weight);
            ps.setInt(2, assessmentId);

            ps.executeUpdate();
            dbconnection.getConnection().commit();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public AssessmentType createAssessmentType(String name, int defaultWeight) throws SQLException {
        try {
            String sql = "INSERT INTO types values (default, %s, %s) returning id";
            PreparedStatement ps = dbconnection.getConnection().prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, defaultWeight);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                AssessmentType assessmentType = buildType(rs);
                return assessmentType;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean assignAssessmentType(int assessmentId, int typeId) throws SQLException {
        try {
            String sql = "UPDATE assessments SET type_id=? WHERE id=?";

            PreparedStatement ps = dbconnection.getConnection().prepareStatement(sql);
            ps.setInt(1, typeId);
            ps.setInt(2, assessmentId);

            ps.executeUpdate();
            dbconnection.getConnection().commit();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Note> getNotesForTrainee(int id, String weekId) {
        List<Note> notes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM notes WHERE associate_id=? AND week=?";
            PreparedStatement ps = dbconnection.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, weekId);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                notes.add(buildNote(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notes;
    }

    @Override
    public Grade insertGrade(Grade grade) {
        try {
            String sql = "INSERT INTO grades VALUES (DEFAULT,?,?,?) RETURNING *";
            PreparedStatement ps = dbconnection.getConnection().prepareStatement(sql);
            ps.setInt(1, grade.getAssessmentId());
            ps.setInt(3, grade.getAssociateId());
            ps.setDouble(2, grade.getScore());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Grade grade1 = buildGrade(rs);
                return grade1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Note buildNote(ResultSet rs) throws SQLException {
        return new Note(rs.getInt("id"), rs.getInt("batch_id"), rs.getInt("associate_id"),  rs.getString("week"), rs.getString("content")
              );
    }

    public Assessment buildAssessment(ResultSet rs) throws SQLException {
        Assessment assessment = new Assessment();
        assessment.setAssessmentId(rs.getInt("id"));
        assessment.setAssessmentTitle(rs.getString("title"));
        assessment.setTypeId(rs.getInt("type_id"));
        assessment.setBatchId(rs.getInt("batch_id"));
        assessment.setWeekId(rs.getString("week"));
        assessment.setAssessmentWeight(rs.getInt("weight"));
        assessment.setCategoryId(rs.getInt("category_id"));

        return assessment;
    }

    public AssessmentType buildType(ResultSet rs) throws SQLException {
        AssessmentType assessmentType = new AssessmentType();
        assessmentType.setTypeId(rs.getInt("id"));
        assessmentType.setName(rs.getString("type_name"));
        assessmentType.setDefaultWeight(rs.getInt("weight"));

        return assessmentType;
    }

    public Grade buildGrade(ResultSet rs) throws SQLException {
        Grade grade = new Grade();
        grade.setGradeId(rs.getInt("id"));
        grade.setAssessmentId(rs.getInt("assessment_id"));
        grade.getAssociateId(rs.getInt("associate_id"));
        grade.setScore(rs.getDouble("score"));

        return grade;
    }

    public static void main(String[] args) {
        try {
            System.out.println(new AssessmentDAOImpl().getGradeForAssociate(1, 1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}


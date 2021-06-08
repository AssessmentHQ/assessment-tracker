package daoTests;

import dao.AssessmentDAOImpl;
import models.Assessment;
import models.Grade;
import models.Note;
import org.mockito.*;
import org.testng.Assert;
import org.testng.annotations.*;
import util_project.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class AssessmentDaoTests {

    @Mock
    private Connection mockConn;
    @Mock
    private PreparedStatement mockPs;
    @Mock
    private ResultSet mockRs;


    @InjectMocks
    AssessmentDAOImpl assessmentDAOImpl;

    //----------------------------------------------------------------------

    @BeforeSuite
    public void setup() throws Exception {
        // Initialize the class to be tested
        assessmentDAOImpl = new AssessmentDAOImpl();
        MockitoAnnotations.openMocks(this);

        Mockito.when(mockConn.prepareStatement(Mockito.any(String.class))).thenReturn(mockPs);
        Mockito.when(mockPs.executeQuery()).thenReturn(mockRs);
    }

    @BeforeMethod
    public void setup2() throws Exception {


    }
    //----------------------------------------------------------------------

    private void createAssessmentRs() throws SQLException {

        Mockito.when(mockRs.next()).thenReturn(true).thenReturn(false);
        Mockito.when(mockRs.getInt("id")).thenReturn(1);
        Mockito.when(mockRs.getString("title")).thenReturn("Title");
        Mockito.when(mockRs.getInt("type_id")).thenReturn(1);
        Mockito.when(mockRs.getInt("batch_id")).thenReturn(1);
        Mockito.when(mockRs.getString("week")).thenReturn("weekNumber");
        Mockito.when(mockRs.getInt("weight")).thenReturn(1);
        Mockito.when(mockRs.getInt("category_id")).thenReturn(1);

    }

    private void createNotesRs() throws SQLException {

        Mockito.when(mockRs.next()).thenReturn(true).thenReturn(false);
        Mockito.when(mockRs.getInt("id")).thenReturn(1);
        Mockito.when(mockRs.getString("title")).thenReturn("Title");
        Mockito.when(mockRs.getInt("type_id")).thenReturn(1);
        Mockito.when(mockRs.getInt("batch_id")).thenReturn(1);
        Mockito.when(mockRs.getString("week")).thenReturn("weekNumber");
        Mockito.when(mockRs.getInt("weight")).thenReturn(1);
        Mockito.when(mockRs.getInt("category_id")).thenReturn(1);

    }

    private void createGradeRs() throws SQLException {

        Mockito.when(mockRs.next()).thenReturn(true).thenReturn(false);
        Mockito.when(mockRs.getInt("id")).thenReturn(3);
        Mockito.when(mockRs.getInt("assessment_id")).thenReturn(3);
        Mockito.when(mockRs.getInt("associate_id")).thenReturn(3);
        Mockito.when(mockRs.getDouble("score")).thenReturn(50.0);


    }

    //----------------------------------------------------------------------

    @Test
    public void testGetAssessments() throws Exception {
        createAssessmentRs();
        try (MockedStatic<dbconnection> mockedStatic = Mockito.mockStatic(dbconnection.class)) {
            mockedStatic.when(dbconnection::getConnection).thenReturn(mockConn);
            List<Assessment> newAssessments = assessmentDAOImpl.getAssessments();
            Assert.assertEquals(newAssessments.get(0).getAssessmentTitle(), "Title");
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    //----------------------------------------------------------------------

    @Test
    public void testGetAssessmentsByTraineeId() throws Exception {
        createAssessmentRs();
        Mockito.when(mockRs.getInt("id")).thenReturn(2);
        try (MockedStatic<dbconnection> mockedStatic = Mockito.mockStatic(dbconnection.class)) {
            mockedStatic.when(dbconnection::getConnection).thenReturn(mockConn);
            List<Assessment> newAssessments = assessmentDAOImpl.getAssessmentsByTraineeId(2);
            Assert.assertEquals(newAssessments.get(0).getAssessmentId(), 2);
        } catch (Exception e) {
            System.out.println("error");
        }

    }

    //----------------------------------------------------------------------

    @Test
    public void testGetWeekAssessments() throws Exception {
        createAssessmentRs();
        Mockito.when(mockRs.getInt("associate_id")).thenReturn(2);
        Mockito.when(mockRs.getString("week")).thenReturn("weekNumber");
        try (MockedStatic<dbconnection> mockedStatic = Mockito.mockStatic(dbconnection.class)) {
            mockedStatic.when(dbconnection::getConnection).thenReturn(mockConn);
            List<Grade> newGrades = assessmentDAOImpl.getGradesForWeek(2,"weekNumber");
            Assert.assertEquals(newGrades.get(0).getAssociateId(), 2);
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    //----------------------------------------------------------------------

    @Test
    public void testGetBatchWeek() throws Exception {
        createAssessmentRs();
        Mockito.when(mockRs.getString("week")).thenReturn("weekNumber");
        try (MockedStatic<dbconnection> mockedStatic = Mockito.mockStatic(dbconnection.class)) {
            mockedStatic.when(dbconnection::getConnection).thenReturn(mockConn);
            List<Assessment> newAssessments = assessmentDAOImpl.getBatchWeek(2,"weekNumber");
            Assert.assertEquals(newAssessments.get(0).getWeekId(), "weekNumber");
        } catch (Exception e) {
            System.out.println("error");
        }

    }

    //----------------------------------------------------------------------
    @Test
    public void testCreateAssessment() throws Exception {
        createAssessmentRs();

        Assessment Assessment= new Assessment();
        Assessment.setAssessmentId(1);
        Assessment.setAssessmentTitle("Title");
        Assessment.setTypeId(1);
        Assessment.setBatchId(1);
        Assessment.setWeekId("weekNumber");
        Assessment.setAssessmentWeight(1);
        Assessment.setCategoryId(1);


        try (MockedStatic<dbconnection> mockedStatic = Mockito.mockStatic(dbconnection.class)) {
            mockedStatic.when(dbconnection::getConnection).thenReturn(mockConn);
            Assessment newAssessment = assessmentDAOImpl.createAssessment(Assessment);
            Assert.assertEquals(newAssessment.getAssessmentId(), Assessment.getAssessmentId());
            Assert.assertEquals(newAssessment.getAssessmentTitle(), Assessment.getAssessmentTitle());
            Assert.assertEquals(newAssessment.getAssessmentWeight(), Assessment.getAssessmentWeight());
            Assert.assertEquals(newAssessment.getWeekId(), Assessment.getWeekId());
            Assert.assertEquals(newAssessment.getCategoryId(), Assessment.getCategoryId());
        } catch (Exception e) {
            System.out.println("error");
        }

    }
    //----------------------------------------------------------------------

    @Test
    public void testAdjustWeightTrue() throws Exception {
        try (MockedStatic<dbconnection> mockedStatic = Mockito.mockStatic(dbconnection.class)) {
            mockedStatic.when(dbconnection::getConnection).thenReturn(mockConn);
            boolean didAdjust = assessmentDAOImpl.adjustWeight(1,1);
            Assert.assertTrue(didAdjust);
        } catch (Exception e) {
            System.out.println("error");
        }
    }

//    @Test
//    public void testAdjustWeightFalse() throws Exception {
//        try (MockedStatic<dbconnection> mockedStatic = Mockito.mockStatic(dbconnection.class)) {
//            mockedStatic.when(dbconnection::getConnection).thenReturn(mockConn);
//            Mockito.doThrow(new SQLException()).when(mockPs).executeUpdate();
//            boolean didAdjust = assessmentDAOImpl.adjustWeight(1,1);
//            Assert.assertTrue(didAdjust);
//        } catch (Exception e) {
//            System.out.println("error");
//        }
//
//    }

    //----------------------------------------------------------------------

    @Test
    public void testCreateAssessmentType() throws Exception {
        createAssessmentRs();
        Mockito.when(mockRs.getString("week")).thenReturn("weekNumber");
        try (MockedStatic<dbconnection> mockedStatic = Mockito.mockStatic(dbconnection.class)) {
            mockedStatic.when(dbconnection::getConnection).thenReturn(mockConn);
            List<Assessment> newAssessments = assessmentDAOImpl.getBatchWeek(2,"weekNumber");
            Assert.assertEquals(newAssessments.get(0).getWeekId(), "weekNumber");
        } catch (Exception e) {
            System.out.println("error");
        }

    }

    //----------------------------------------------------------------------




    //----------------------------------------------------------------------

    @Test
    public void testGetNotesForTrainee() throws Exception {
        createAssessmentRs();
        try (MockedStatic<dbconnection> mockedStatic = Mockito.mockStatic(dbconnection.class)) {
            mockedStatic.when(dbconnection::getConnection).thenReturn(mockConn);
            List<Note> newNotes = assessmentDAOImpl.getNotesForTrainee(2,"weekNumber");
            Assert.assertEquals(newNotes.get(0).getWeekId(), "weekNumber");
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    //----------------------------------------------------------------------
    @Test
    public void testInsertGrade() throws Exception {
        createGradeRs();
        Grade grade=new Grade();
        grade.setGradeId(3);
        grade.setAssessmentId(3);
        grade.setAssociateId(3);
        grade.setScore(50.0);
        try (MockedStatic<dbconnection> mockedStatic = Mockito.mockStatic(dbconnection.class)) {
            mockedStatic.when(dbconnection::getConnection).thenReturn(mockConn);
            Grade newGrade = assessmentDAOImpl.insertGrade(grade);
            Assert.assertSame(newGrade.getGradeId(), grade.getGradeId());
            Assert.assertSame(newGrade.getAssessmentId(), grade.getAssessmentId());
            Assert.assertSame(newGrade.getAssociateId(), grade.getAssociateId());
            Assert.assertTrue(newGrade.getScore()== grade.getScore());
        } catch (Exception e) {
            System.out.println("error");
        }
    }


    //----------------------------------------------------------------------

    @AfterMethod
    void tearDown() {

    }

    @AfterSuite
    static void tearDownAll() {

    }


}

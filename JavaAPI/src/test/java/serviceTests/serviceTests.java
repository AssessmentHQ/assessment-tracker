package serviceTests;
import dao.AssessmentDAO;
import dao.AssessmentDAOImpl;
import models.Assessment;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import services.AssessmentService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class serviceTests {

    @Mock
    AssessmentDAO adao;

    @InjectMocks
    AssessmentService assessmentService;

    @BeforeSuite
    public void setup(){
        // Initialize the class to be tested
        assessmentService = new AssessmentService();
        MockitoAnnotations.openMocks(this);

    }


    //----------------------------------------------------------------------

    @Test
    public void testGetAssessments() throws Exception {
        List<Assessment> assessments = new ArrayList<Assessment>();
        assessments.add(new Assessment());
        Mockito.when(adao.getAssessments()).thenReturn(assessments);
        List<Assessment> newAssessments =assessmentService.getAssessments();
        Assert.assertFalse(newAssessments.isEmpty());

    }
    @Test (expectedExceptions= SQLException.class)
    public void testGetAssessmentsSQLException() throws Exception {
        Mockito.when(adao.getAssessments()).thenThrow(SQLException.class);
        List<Assessment> newAssessments =assessmentService.getAssessments();
    }

    //----------------------------------------------------------------------

    @Test
    public void testGetAssessmentsByTraineeIdNotEmpty() throws Exception {
        List<Assessment> assessments = new ArrayList<Assessment>();
        assessments.add(new Assessment());
        Mockito.when(adao.getAssessmentsByTraineeId(2)).thenReturn(assessments);
        List<Assessment> newAssessments =assessmentService.getAssessmentsByTraineeId(2);
        Assert.assertFalse(newAssessments.isEmpty());

    }
    @Test
    public void testGetAssessmentsByTraineeIdEmpty() throws Exception {
        List<Assessment> assessments = new ArrayList<Assessment>();
        Mockito.when(adao.getAssessmentsByTraineeId(2)).thenReturn(assessments);
        List<Assessment> newAssessments =assessmentService.getAssessmentsByTraineeId(2);
        Assert.assertTrue(newAssessments.isEmpty());

    }

    @Test(expectedExceptions= SQLException.class)
    public void testGetAssessmentsByTraineeIdSqlException() throws Exception {
        Mockito.when(adao.getAssessmentsByTraineeId(2)).thenThrow(SQLException.class);
        assessmentService.getAssessmentsByTraineeId(2);
    }

    //----------------------------------------------------------------------


    @Test
    public void testGetWeekAssessmentsNotEmpty() throws Exception {
        List<Assessment> assessments = new ArrayList<Assessment>();
        assessments.add(new Assessment());
        Mockito.when(adao.getWeekAssessments(1, "something")).thenReturn(assessments);
        List<Assessment> newAssessments =assessmentService.getWeekAssessments(1, "something");
        Assert.assertFalse(newAssessments.isEmpty());

    }

    @Test
    public void testGetWeekAssessmentsEmpty() throws Exception {
        List<Assessment> assessments = new ArrayList<Assessment>();
        Mockito.when(adao.getWeekAssessments(1, "something")).thenReturn(assessments);
        List<Assessment> newAssessments =assessmentService.getWeekAssessments(1, "something");
        Assert.assertTrue(newAssessments.isEmpty());

    }

    @Test(expectedExceptions= SQLException.class)
    public void testGetWeekAssessmentsEmptySqlException() throws Exception {
        Mockito.when(adao.getWeekAssessments(2, "something")).thenThrow(SQLException.class);
        assessmentService.getWeekAssessments(2, "something");
    }

    //----------------------------------------------------------------------

    @Test
    public void testCreateAssessment() throws Exception {
        Assessment assessment = new Assessment();
        Mockito.when(adao.createAssessment(assessment)).thenReturn(assessment);
        Assessment newAssessment =assessmentService.createAssessment(assessment);
        Assert.assertTrue(assessment==newAssessment);
    }

    @Test(expectedExceptions= SQLException.class)
    public void testCreateAssessmentSQLException() throws Exception {
        Assessment assessment = new Assessment();
        Mockito.when(adao.createAssessment(assessment)).thenThrow(SQLException.class);
        assessmentService.createAssessment(assessment);
    }

    //----------------------------------------------------------------------

//    @Test
//    public void testAdjustWeight() throws Exception {
//        Assessment assessment = new Assessment();
//        Mockito.when(adao.createAssessment(assessment)).thenReturn(assessment);
//        Assessment newAssessment =adao.createAssessment(assessment);
//        Assert.assertTrue(assessment==newAssessment);
//    }
    
    //----------------------------------------------------------------------



    @AfterMethod
    void tearDown() {

    }

    @AfterSuite
    static void tearDownAll() {

    }

}

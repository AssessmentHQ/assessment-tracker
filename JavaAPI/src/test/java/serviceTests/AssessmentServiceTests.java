

package serviceTests;
import dao.AssessmentDAOImpl;
import models.Assessment;
import models.AssessmentType;
import models.Grade;
import models.Note;
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


public class AssessmentServiceTests {

    @Mock
    AssessmentDAOImpl adao;

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
        List<Assessment> assessments = new ArrayList<>();
        assessments.add(new Assessment());
        Mockito.when(adao.getAssessments()).thenReturn(assessments);
        List<Assessment> newAssessments =assessmentService.getAssessments();
        Assert.assertFalse(newAssessments.isEmpty());

    }
    @Test (expectedExceptions= SQLException.class)
    public void testGetAssessmentsSQLException() throws Exception {
        Mockito.when(adao.getAssessments()).thenThrow(SQLException.class);
        assessmentService.getAssessments();
    }

    //----------------------------------------------------------------------

    @Test
    public void testGetAssessmentsByTraineeIdNotEmpty() throws Exception {
        List<Assessment> assessments = new ArrayList<>();
        assessments.add(new Assessment());
        Mockito.when(adao.getAssessmentsByTraineeId(2)).thenReturn(assessments);
        List<Assessment> newAssessments =assessmentService.getAssessmentsByTraineeId(2);
        Assert.assertFalse(newAssessments.isEmpty());

    }
    @Test
    public void testGetAssessmentsByTraineeIdEmpty() throws Exception {
        List<Assessment> assessments = new ArrayList<>();
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
        List<Grade> grades = new ArrayList<>();
        grades.add(new Grade());
        Mockito.when(adao.getGradesForWeek(1, "something")).thenReturn(grades);
        List<Grade> newGrades =assessmentService.getGradesForWeek(1, "something");
        Assert.assertFalse(newGrades.isEmpty());

    }

    @Test
    public void testGetWeekAssessmentsEmpty() throws Exception {
        List<Grade> grades = new ArrayList<>();
        Mockito.when(adao.getGradesForWeek(1, "something")).thenReturn(grades);
        List<Grade> newGrades =assessmentService.getGradesForWeek(1, "something");
        Assert.assertTrue(newGrades.isEmpty());

    }

    @Test(expectedExceptions= SQLException.class)
    public void testGetWeekAssessmentsEmptySqlException() throws Exception {
        Mockito.when(adao.getGradesForWeek(2, "something")).thenThrow(SQLException.class);
        assessmentService.getGradesForWeek(2, "something");
    }

    //----------------------------------------------------------------------

    @Test
    public void testCreateAssessment() throws Exception {
        Assessment assessment = new Assessment();
        Mockito.when(adao.createAssessment(assessment)).thenReturn(assessment);
        Assessment newAssessment =assessmentService.createAssessment(assessment);
        Assert.assertSame(assessment, newAssessment);
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

    @Test
    public void testCreateAssessmentType() throws Exception {
        AssessmentType assessmentType = new AssessmentType();
        Mockito.when(adao.createAssessmentType(assessmentType.getName(),assessmentType.getDefaultWeight())).thenReturn(assessmentType);
        AssessmentType newAssessmentType =assessmentService.createAssessmentType(assessmentType);
        Assert.assertSame(newAssessmentType, assessmentType);
    }

    @Test(expectedExceptions= SQLException.class)
    public void testCreateAssessmentTypeSQLException() throws Exception {
        AssessmentType assessmentType = new AssessmentType();
        Mockito.when(adao.createAssessmentType(assessmentType.getName(),assessmentType.getDefaultWeight())).thenThrow(SQLException.class);
        assessmentService.createAssessmentType(assessmentType);

    }

    //----------------------------------------------------------------------

    @Test
    public void testGetNotesForTrainee()  {
        List<Note> notes =new ArrayList<>();
        Mockito.when(adao.getNotesForTrainee(1,"test")).thenReturn(notes);
        List<Note> newNotes =assessmentService.getNotesForTrainee(1,"test");
        Assert.assertSame(notes, newNotes);
    }

//       This method has no exception
//    @Test(expectedExceptions= SQLException.class)
//    public void testGetNotesForTraineeSQLException() throws Exception {
//        Mockito.when(adao.getNotesForTrainee(1,"test")).thenThrow(SQLException.class);
//        assessmentService.getNotesForTrainee(1,"test");
//
//    }

    //----------------------------------------------------------------------
//    @Test
//    public void testupdateTypeForAssessment() throws Exception {
//        Assessment assessment = new Assessment();
//        Mockito.when(adao.createAssessment(assessment)).thenReturn(assessment);
//        Assessment newAssessment =adao.createAssessment(assessment);
//        Assert.assertTrue(assessment==newAssessment);
//    }

    //----------------------------------------------------------------------

    @Test
    public void testInsertGrade() throws SQLException {
        Grade grade =new Grade();
        Mockito.when(adao.insertGrade(grade)).thenReturn(grade);
        Grade newGrade =assessmentService.insertGrade(grade);
        Assert.assertSame(grade, newGrade);
    }

    //----------------------------------------------------------------------

    @Test
    public void testGetBatchWeek() throws Exception {
        List<Assessment> assessments = new ArrayList<>();
        Mockito.when(adao.getBatchWeek(1,"test")).thenReturn(assessments);
        List<Assessment>  newAssessments =assessmentService.getBatchWeek(1,"test");
        Assert.assertSame(newAssessments, assessments);
    }

    //----------------------------------------------------------------------

    @AfterMethod
    void tearDown() {

    }

    @AfterSuite
    static void tearDownAll() {

    }

}





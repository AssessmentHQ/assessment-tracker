package daoTests;
import dao.AssessmentDAO;
import dao.AssessmentDAOImpl;
import models.Assessment;
import models.AssessmentType;
import models.Grade;
import models.Note;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.mockito.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import services.AssessmentService;
import util_project.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class AssessmentDaoTests {

    // Dependencies
    @Mock
    private Connection mockConn;
    @Mock
    private Grade mockGrade;
    @Mock
    private PreparedStatement mockPs;
    @Mock
    private ResultSet mockRs;

    // Class to be tested
    @InjectMocks
    AssessmentDAOImpl assessmentDAOImpl;

    //----------------------------------------------------------------------
    @BeforeSuite
    public void setup()throws Exception{
        // Initialize the class to be tested
        assessmentDAOImpl = new AssessmentDAOImpl();
        MockitoAnnotations.openMocks(this);
        // Create our Mock objects
//        mockConn  = Mockito.mock(Connection.class);
//        mockGrade = Mockito.mock(Grade.class);
//        mockPs    = Mockito.mock(PreparedStatement.class);
//        mockRs    = Mockito.mock(ResultSet.class);

        try (MockedStatic<dbconnection> mockedStatic = Mockito.mockStatic(dbconnection.class)) {
            mockedStatic.when(dbconnection::getConnection).thenReturn(mockConn);
        }

        Mockito.when(mockConn.prepareStatement(Mockito.any(String.class))).thenReturn(mockPs);
        Mockito.when(mockPs.executeQuery()).thenReturn(mockRs);

    }


    private void createAssessmentRs() throws SQLException {
        Mockito.when(mockRs.next()).thenReturn(true).thenReturn(false);
        Mockito.when(mockRs.getInt("id")).thenReturn(1);
        Mockito.when(mockRs.getString("title")).thenReturn("Title");
        Mockito.when(mockRs.getInt("type_id")).thenReturn(1);
        Mockito.when(mockRs.getInt("batch_id")).thenReturn(1);
        Mockito.when(mockRs.getString("week_number")).thenReturn("weekNumber");
        Mockito.when(mockRs.getInt("weight")).thenReturn(1);
        Mockito.when(mockRs.getInt("category_id")).thenReturn(1);
    }


    //----------------------------------------------------------------------
    @Test
    public void testGetAssessments() throws Exception{

//        Mockito.when(mockRs.getInt("id"));
//        Mockito.when(mockRs.getString("title"));
//        Mockito.when(mockRs.getInt("type_id"));
//        Mockito.when(mockRs.getInt("batch_id"));
//        Mockito.when(mockRs.getString("week_number"));
//        Mockito.when(mockRs.getInt("weight"));
//        Mockito.when(mockRs.getInt("category_id"));
        List<Assessment> returnedAssessments = assessmentDAOImpl.getAssessments();
        Assert.assertNotNull(returnedAssessments);
    }

    //----------------------------------------------------------------------


    //----------------------------------------------------------------------


    @AfterEach
    void tearDown() {

    }

    @AfterAll
    static void tearDownAll() {

    }


}

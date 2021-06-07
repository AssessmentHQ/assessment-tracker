package daoTests;

import dao.AssessmentDAO;
import dao.AssessmentDAOImpl;
import models.Grade;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import util_project.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testInsertGrade {
    // Class to be tested
    private AssessmentDAO adao;

    // Dependencies
    private Connection mockConn;
    private Grade mockGrade;
    private PreparedStatement mockPs;
    private ResultSet mockRs;

    // Test Data
    private Grade sampleGrade;


    @Before
    public void setup() throws Exception {
        // Create our Mock objects
        mockConn  = Mockito.mock(Connection.class);
        mockGrade = Mockito.mock(Grade.class);
        mockPs    = Mockito.mock(PreparedStatement.class);
        mockRs    = Mockito.mock(ResultSet.class);

        // Since getconnection is a static method, get a static mock object
        try (MockedStatic<dbconnection> mockedStatic = Mockito.mockStatic(dbconnection.class)) {
            mockedStatic.when(dbconnection::getConnection).thenReturn(mockConn);
        }

        // When prepareStatement is called on the connection, return the prepared statement
        // When executeQuery is called, return the result set
        Mockito.when(mockConn.prepareStatement(Mockito.any(String.class))).thenReturn(mockPs);
        Mockito.when(mockPs.executeQuery()).thenReturn(mockRs);

        // Initialize the class to be tested
        adao = new AssessmentDAOImpl();

        sampleGrade = new Grade(2, 3, 4, 80);
    }

    @Test
    public void testNotNuLL() throws Exception {
        Grade returnedGrade = adao.insertGrade(new Grade());
        assertNotNull(returnedGrade);
    }

    @Test
    public void testScoreNotNegative() throws Exception {
        // TODO: Should we return the grade that was set in the DB, instead of a boolean
        /*
        Grade returnedGrade = adao.insertGrade(1, 3, 4);
        assertTrue(returnedGrade.getScore() > 0, "Expected Score greater than 0");
        */
    }

    @Test
    public void testValidGradeId() throws Exception {
        // TODO: Should we return the grade that was set in the DB, instead of a boolean
        /*
        Grade returnedGrade = adao.insertGrade(1, 3, 4);
        assertTrue(returnedGrade.getGradeId() > 0, "Expected gradeId greater than 0");
        */
    }

    @Test
    public void testValidAssessmentId() throws Exception {
        // TODO: Should we return the grade that was set in the DB, instead of a boolean
        /*
        Grade returnedGrade = adao.insertGrade(1, 3, 4);
        assertTrue(returnedGrade.getAssessmentId() > 0, "Expected assessmentId greater than 0");
         */
    }

    @Test
    public void testValidTrainerId() throws Exception {
        // TODO: Should we return the grade that was set in the DB, instead of a boolean
        /*
        Grade returnedGrade = adao.insertGrade(1, 3, 4);
        assertTrue(returnedGrade.getTrainerId() > 0, "Expected TrainerId greater than 0");
        */
    }

    @AfterEach
    void tearDown() {

    }

    @AfterAll
    static void tearDownAll() {

    }
}

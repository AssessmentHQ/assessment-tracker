package daoTests;

import dao.AssessmentDAOImpl;
import models.Assessment;
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
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class testCreateAssessment {
    // Class to be tested
    private AssessmentDAOImpl adao;

    // Dependencies
    private Connection mockConn;
    private Grade mockGrade;
    private PreparedStatement mockPs;
    private ResultSet mockRs;

    // Test Data
    private Assessment sampleAssessment;
    private Assessment sa1,sa2,sa3;

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

        ArrayList<String> sampleNote = new ArrayList<String>();
        sampleNote.add("Needs Improvement");

        // Create a sample assessment", 1,
        sampleAssessment = new Assessment(1, "Test Assessment", 1, 3, "3", 30, 4,sampleNote);
        sa1 = new Assessment(2,"Test 1",1,3,"5",20,1,sampleNote);
    }

    @Test
    public void testNotNull() throws Exception {
        Assessment returnedAssessment = adao.createAssessment(sampleAssessment);
        assertNotNull(returnedAssessment);
    }

    @Test
    public void testCorrectBatchIdSet() throws Exception {
        Assessment returnedAssessment = adao.createAssessment(sa1);
        assertNotNull(returnedAssessment);
        assertEquals(3, returnedAssessment.getBatchId());
    }

    @Test
    public void testCorrectWeekIdSet() throws Exception {
        Assessment returnedAssessment = adao.createAssessment(sa1);
        assertNotNull(returnedAssessment);
        assertEquals("5", returnedAssessment.getWeekId());
    }

    @AfterEach
    void tearDown() {

    }

    @AfterAll
    static void tearDownAll() {

    }

}
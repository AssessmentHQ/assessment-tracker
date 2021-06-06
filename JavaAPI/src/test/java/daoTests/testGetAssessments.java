package daoTests;

import dao.AssessmentDAOImpl;
import models.Assessment;
import models.Grade;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

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

public class testGetAssessments {
    // Class to be tested
    private AssessmentDAOImpl adao;

    // Dependencies
    private Connection mockConn;
    private Grade mockGrade;
    private PreparedStatement mockPs;
    private ResultSet mockRs;

    // Test Data
    private ArrayList<Assessment> sampleAssessments;

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

        // Populate some sample notes
        ArrayList<String> sampleNotes1 = new ArrayList<String>();
        sampleNotes1.add("Good Day");
        sampleNotes1.add("Bad Day");
        sampleNotes1.add("Need Feedback");

        ArrayList<String> sampleNotes2 = new ArrayList<String>();
        sampleNotes2.add("Excellent worker");
        sampleNotes2.add("Best Coder");

        ArrayList<String> sampleNotes3 = new ArrayList<String>();
        sampleNotes3.add("Needs Improvement");


        // Create Some sample assessments
        Assessment sampleAssessment1 = new Assessment(1, "Test Assessment 1", 1, 1, "1", 30, 2,sampleNotes1);
        Assessment sampleAssessment2 = new Assessment(1, "Test Assessment 2", 2, 2, "2", 10, 3,sampleNotes2);
        Assessment sampleAssessment3 = new Assessment(1, "Test Assessment 3", 3, 3, "3", 5, 7,sampleNotes3);

        // Create the sample list of assessments
        sampleAssessments = new ArrayList<Assessment>();
        sampleAssessments.add(sampleAssessment1);
        sampleAssessments.add(sampleAssessment2);
        sampleAssessments.add(sampleAssessment3);
    }

    @Test
    public void testNotNull() throws Exception{
        List<Assessment> returnedAssessments = adao.getAssessments();
        assertNotNull(returnedAssessments);
    }

    @Test
    public void testGetCorrectSize() throws Exception {
        List<Assessment> returnedAssessments = adao.getAssessments();

        // Test to for correct number of Assessments
        assertEquals(3, returnedAssessments.size());
    }

    @AfterEach
    void tearDown() {

    }

    @AfterAll
    static void tearDownAll() {

    }


}

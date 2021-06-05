package daoTests;

import dao.AssessmentDAOImpl;
import models.AssessmentType;
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

import static org.junit.jupiter.api.Assertions.*;

public class testCreateAssessmentType {
    // Class to be tested
    private AssessmentDAOImpl adao;

    // Dependencies
    private Connection mockConn;
    private Grade mockGrade;
    private PreparedStatement mockPs;
    private ResultSet mockRs;

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
    }

    @Test
    public void testNotNull() throws Exception {
        AssessmentType returnedAssessmentType = adao.createAssessmentType("Quiz", 1);
        assertNotNull(returnedAssessmentType);
    }

    @Test
    public void testIsEmpty() throws Exception {
        AssessmentType returnedAssessmentType = adao.createAssessmentType("Quiz", 1);
        assertNotNull(returnedAssessmentType);
    }

    @AfterEach
    void tearDown() {

    }

    @AfterAll
    static void tearDownAll() {

    }

}

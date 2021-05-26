package models;

import java.util.ArrayList;
import java.util.List;

public class Assessment {
    private String assessmentTitle;
    private int typeId;
    private Grade grade;
    private int traineeId;
    private int batchId;
    private String weekId;
    private int assessmentWeight;

    private int categoryId;
    private List<String> notes;

    public Assessment() {
        super();
        assessmentTitle = "";
        typeId = 0;
        grade = new Grade();
        traineeId = 0;
        batchId = 0;
        weekId = "";
        assessmentWeight = 0;
        categoryId = 0;
        notes = new ArrayList<String>();
    }

    public Assessment(String assessmentTitle, int typeId, Grade grade, int traineeId, int batchId, String weekId,
            int assessmentWeight, int categoryId, List<String> notes) {
        super();
        this.assessmentTitle = assessmentTitle;
        this.typeId = typeId;
        this.grade = grade;
        this.traineeId = traineeId;
        this.batchId = batchId;
        this.weekId = weekId;
        this.assessmentWeight = assessmentWeight;
        this.categoryId = categoryId;
        this.notes = notes;
    }

    public String getAssessmentTitle() {
        return assessmentTitle;
    }

    public void setAssessmentTitle(String assessmentTitle) {
        this.assessmentTitle = assessmentTitle;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public int getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(int traineeId) {
        this.traineeId = traineeId;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public String getWeekId() {
        return weekId;
    }

    public void setWeekId(String weekId) {
        this.weekId = weekId;
    }

    public int getAssessmentWeight() {
        return assessmentWeight;
    }

    public void setAssessmentWeight(int assessmentWeight) {
        this.assessmentWeight = assessmentWeight;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Assessment [assessmentTitle=" + assessmentTitle + ", assessmentWeight=" + assessmentWeight
                + ", batchId=" + batchId + ", categoryId=" + categoryId + ", grade=" + grade + ", notes=" + notes
                + ", traineeId=" + traineeId + ", typeId=" + typeId + ", weekId=" + weekId + "]";
    }

}

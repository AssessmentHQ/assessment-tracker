package models;

import java.util.ArrayList;
import java.util.List;

public class Assessment {
    private int assessmentId;
    private String assessmentTitle;
    private int typeId;
    private int batchId;
    private String weekId;
    private int assessmentWeight;
    private int categoryId;
    private List<String> notes;

    public Assessment() {
        super();
        assessmentId = 0;
        assessmentTitle = "";
        typeId = 1;
        batchId = 1;
        weekId = "";
        assessmentWeight = 1;
        categoryId =1;
        notes = new ArrayList<String>();
    }

    public Assessment(int assessmentId, String assessmentTitle, int typeId, int batchId, String weekId,
            int assessmentWeight, int categoryId, List<String> notes) {
        super();
        this.assessmentId = assessmentId;
        this.assessmentTitle = assessmentTitle;
        this.typeId = typeId;
        this.batchId = batchId;
        this.weekId = weekId;
        this.assessmentWeight = assessmentWeight;
        this.categoryId = categoryId;
        this.notes = notes;
    }

    public int getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
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
        return "Assessment [assessmentId=" + assessmentId + ", assessmentTitle=" + assessmentTitle
                + ", assessmentWeight=" + assessmentWeight + ", batchId=" + batchId + ", categoryId=" + categoryId
                + ", notes=" + notes + ", typeId=" + typeId + ", weekId=" + weekId + "]";
    }

}

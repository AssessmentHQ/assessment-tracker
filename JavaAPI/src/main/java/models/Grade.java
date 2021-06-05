package models;

public class Grade {
    private int gradeId;
    private int assessmentId;
    private int associateId;
    private double score;

    public Grade() {
        super();
        gradeId = 0;
        assessmentId = 0;
        associateId = 0;
        score = 0;
    }

    public Grade(int gradeId, int assessmentId, int associateId, double score) {
        super();
        this.gradeId = gradeId;
        this.assessmentId = assessmentId;
        this.associateId = associateId;
        this.score = score;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public int getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
    }

    public int getAssociateId() {
        return associateId;
    }

    public void getAssociateId(int traineeId) {
        this.associateId = traineeId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Grade [assessmentId=" + assessmentId + ", gradeId=" + gradeId + ", score=" + score + ", traineeId="
                + associateId + "]";
    }

}

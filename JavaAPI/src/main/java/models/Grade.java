package models;

public class Grade {
    private int gradeId;
    private int assessmentId;
    private int trainerId;
    private double score;

    public Grade() {
        super();
        gradeId = 0;
        assessmentId = 0;
        trainerId = 0;
        score = 0;
    }

    public Grade(int gradeId, int assessmentId, int trainerId, double score) {
        super();
        this.gradeId = gradeId;
        this.assessmentId = assessmentId;
        this.trainerId = trainerId;
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

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Grade [assessmentId=" + assessmentId + ", gradeId=" + gradeId + ", score=" + score + ", trainerId="
                + trainerId + "]";
    }

}

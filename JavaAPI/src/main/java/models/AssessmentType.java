package models;

public class AssessmentType {
    private int typeId;
    private String name;
    private int defaultWeight;

    public AssessmentType() {
        super();
        typeId = 0;
        name = "";
        defaultWeight = 0;
    }

    public AssessmentType(int typeId, String name, int defaultWeight) {
        super();
        this.typeId = typeId;
        this.name = name;
        this.defaultWeight = defaultWeight;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefaultWeight() {
        return defaultWeight;
    }

    public void setDefaultWeight(int defaultWeight) {
        this.defaultWeight = defaultWeight;
    }

    @Override
    public String toString() {
        return "Type [defaultWeight=" + defaultWeight + ", name=" + name + ", typeId=" + typeId + "]";
    }

}

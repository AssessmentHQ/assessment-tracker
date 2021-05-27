package models;

public class Category {
    private int categoryId;
    private String name;

    public Category() {
        super();
        categoryId = 0;
        name = "";
    }

    public Category(int categoryId, String name) {
        super();
        this.categoryId = categoryId;
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", name=" + name + "]";
    }

}

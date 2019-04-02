package task.one.sharedpreferences;

public class Book {

    private String Title;
    private String Category;
    private String Description;
    private int Thumnail;

    public Book() {
    }

    public Book(String title, String category, String description, int thumnail) {
        Title = title;
        Category = category;
        Description = description;
        Thumnail = thumnail;
    }

    public String getTitle() {
        return Title;
    }

    public String getCategory() {
        return Category;
    }

    public String getDescription() {
        return Description;
    }

    public int getThumnail() {
        return Thumnail;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setThumnail(int thumnail) {
        Thumnail = thumnail;
    }
}

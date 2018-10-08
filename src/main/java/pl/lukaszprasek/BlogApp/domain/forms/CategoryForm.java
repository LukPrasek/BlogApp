package pl.lukaszprasek.BlogApp.domain.forms;

public class CategoryForm {
    private String name;

    public CategoryForm(String name) {
        this.name = name;
    }

    public CategoryForm() {
    }

    public String getName() {

        return name;

    }

    public void setName(String name) {
        this.name = name;
    }
}

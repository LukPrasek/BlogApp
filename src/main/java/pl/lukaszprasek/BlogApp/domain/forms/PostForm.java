package pl.lukaszprasek.BlogApp.domain.forms;

public class PostForm {
    private String title;
    private String article;
    private String author;
    private int category;

    public PostForm() {
    }

    public PostForm(String title, String article, String author, int category) {
        this.title = title;
        this.article = article;
        this.author = author;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}

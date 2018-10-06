package pl.lukaszprasek.BlogApp.domain.entities;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private int id;
    @Column(name = "category_name")
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PostEntity> posts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PostEntity> getPosts() {
        return posts;
    }

    public void setPosts(List<PostEntity> posts) {
        this.posts = posts;
    }
}

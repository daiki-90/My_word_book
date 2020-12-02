package models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "wordBooks")
@NamedQueries({
    @NamedQuery(
            name = "getAllMyWordBooks",
            query = "SELECT w FROM WordBook AS w WHERE w.user = :user ORDER BY w.id DESC"
            ),
    @NamedQuery(
            name = "getAllMyWordBooksCount",
            query = "SELECT COUNT(w) FROM WordBook AS w WHERE w.user = :user"
            ),

})
@Entity

public class WordBook {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Lob
    @Column(name = "comment", nullable = false)
    private String comment;

    @Column(name = "wordBook_date", nullable = false)
    private Date wordBook_date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getWordBook_date() {
        return wordBook_date;
    }

    public void setWordBook_date(Date wordBook_date) {
        this.wordBook_date = wordBook_date;
    }




}

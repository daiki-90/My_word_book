package models;


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

@Table(name = "words")
@NamedQueries({
    @NamedQuery(
            name = "getAllWords",
            query = "SELECT w FROM Word AS w WHERE w.wordBook = :wordBook ORDER BY w.id DESC"
            ),
    @NamedQuery(
            name = "getAllWordsCount",
            query = "SELECT COUNT(w) FROM Word AS w WHERE w.wordBook = :wordBook"
            )
})
@Entity
public class Word {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "wordBook_id", nullable = false)
    private WordBook wordBook;

    @Column(name = "word", length = 255, nullable = false)
    private String word;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public WordBook getWordBook() {
        return wordBook;
    }

    public void setWordBook(WordBook wordBook) {
        this.wordBook = wordBook;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



}

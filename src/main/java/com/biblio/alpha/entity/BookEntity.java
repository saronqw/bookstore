package com.biblio.alpha.entity;

import com.biblio.alpha.entity.purchase.PurchaseEntity;
import com.biblio.alpha.entity.purchase.PurchaseId;
import com.biblio.alpha.model.api.request.BookParamsRequest;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Validated
@Entity
@Table(name = "books")
public class BookEntity {

    public BookEntity() {

    }

    public void edit(BookParamsRequest bookParamsRequest) {
        this.author = bookParamsRequest.getAuthor();
        this.cover = bookParamsRequest.getCover();
        this.date = bookParamsRequest.getDate();
        this.editor = bookParamsRequest.getEditor();
        this.genre = bookParamsRequest.getGenre();
        this.height = bookParamsRequest.getHeight();
        this.language = bookParamsRequest.getLanguage();
        this.length = bookParamsRequest.getLength();
        this.pageNumber = bookParamsRequest.getPageNumber();
        this.price = bookParamsRequest.getPrice();
        this.publisher = bookParamsRequest.getPublisher();
        this.rating = bookParamsRequest.getRating();
        this.series = bookParamsRequest.getSeries();
        this.title = bookParamsRequest.getTitle();
        this.translator = bookParamsRequest.getTranslator();
        this.url = bookParamsRequest.getUrl();
        this.weight = bookParamsRequest.getWeight();
        this.width = bookParamsRequest.getWidth();
    }

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    /*@OneToMany(mappedBy = "id.bookEntity", cascade = CascadeType.ALL)
    private List<PurchaseEntity> purchaseEntityList = new ArrayList<>();*/

    @NotNull(message = "The value must be not null")
    @Column(name = "title")
    private String title;

    @NotEmpty
    @NotBlank
    @NotNull(message = "The value must be not null")
    @Column(name = "author")
    private String author;

    @NotNull(message = "The value must be not null")
    @Column(name = "price")
    private Long price;

    @NotNull(message = "The value must be not null")
    @Min(value = 1, message = "The value must be positive")
    @Column(name = "page_num")
    private Long pageNumber;

    @Column(name = "editor")
    private String editor;

    @Column(name = "cover")
    private String cover;

    @Min(value = 1, message = "The value must be positive")
    @Column(name = "weight")
    private Long weight;

    @Column(name = "genre")
    private String genre;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "series")
    private String series;

    @Column(name = "translator")
    private String translator;

    @Column(name = "language")
    private String language;

    @Column(name = "date")  // NEED CHANGE
    private Long date;

    @Min(value = 1, message = "The value must be positive")
    @Column(name = "height")
    private Long height;

    @Min(value = 1, message = "The value must be positive")
    @Column(name = "width")
    private Long width;

    @Min(value = 1, message = "The value must be positive")
    @Column(name = "length")
    private Long length;

    @Min(value = 1, message = "The value must be range of 1 to 10")
    @Max(value = 10, message = "The value must be range of 1 to 10")
    @Column(name = "rating")
    private Long rating;

    @NotNull(message = "The value must be not null")
    @Column(name = "url")
    private String url;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "bookId=" + bookId +
                ", title=" + title +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", pageNumber=" + pageNumber +
                ", editor='" + editor + '\'' +
                ", cover='" + cover + '\'' +
                ", weight=" + weight +
                ", genre='" + genre + '\'' +
                ", publisher='" + publisher + '\'' +
                ", series='" + series + '\'' +
                ", translator='" + translator + '\'' +
                ", language='" + language + '\'' +
                ", date=" + date +
                ", height=" + height +
                ", width=" + width +
                ", length=" + length +
                ", rating=" + rating +
                ", url='" + url + '\'' +
                '}';
    }
}

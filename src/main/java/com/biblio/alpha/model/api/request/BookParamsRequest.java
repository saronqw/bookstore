package com.biblio.alpha.model.api.request;

import com.biblio.alpha.entity.BookEntity;

public class BookParamsRequest {

    public BookParamsRequest(String author, String cover, Long date, String editor, String genre, Long height, String language, Long length, Long pageNumber, Long price, String publisher, Double rating, String series, String title, String translator, String url, Long weight, Long width) {
        this.author = author;
        this.cover = cover;
        this.date = date;
        this.editor = editor;
        this.genre = genre;
        this.height = height;
        this.language = language;
        this.length = length;
        this.pageNumber = pageNumber;
        this.price = price;
        this.publisher = publisher;
        this.rating = rating;
        this.series = series;
        this.title = title;
        this.translator = translator;
        this.url = url;
        this.weight = weight;
        this.width = width;
    }

    private String author;
    private String cover;
    private Long date;
    private String editor;
    private String genre;
    private Long height;
    private String language;
    private Long length;
    private Long pageNumber;
    private Long price;
    private String publisher;
    private Double rating;
    private String series;
    private String title;
    private String translator;
    private String url;
    private Long weight;
    private Long width;

    public BookParamsRequest(BookEntity bookEntity) {

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }
}

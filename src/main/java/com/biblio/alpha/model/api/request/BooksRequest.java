package com.biblio.alpha.model.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BooksRequest {
    private Integer page;
    private Integer count;
    private String typeSort;

    @JsonProperty
    private Boolean isRevert;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getTypeSort() {
        return typeSort;
    }

    public void setTypeSort(String typeSort) {
        this.typeSort = typeSort;
    }

    public Boolean getRevert() {
        return isRevert;
    }

    public void setRevert(Boolean revert) {
        isRevert = revert;
    }

    @Override
    public String toString() {
        return "BooksRequest{" +
                "page=" + page +
                ", count=" + count +
                ", typeSort='" + typeSort + '\'' +
                ", isRevert=" + isRevert +
                '}';
    }
}

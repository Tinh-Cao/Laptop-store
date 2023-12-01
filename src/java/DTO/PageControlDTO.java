/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author TInh
 */
public class PageControlDTO {
    private String urlPattern;
    private int recordPerPage;
    private int totalPage;
    private int totalRecord;
    private int page;

    public PageControlDTO() {
    }   

    public PageControlDTO(String urlPattern, int recordPerPage, int totalPage, int totalRecord, int page) {
        this.urlPattern = urlPattern;
        this.recordPerPage = recordPerPage;
        this.totalPage = totalPage;
        this.totalRecord = totalRecord;
        this.page = page;
    }

    public String getUrlPattern() {
        return urlPattern;
    }

    public void setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern;
    }

    public int getRecordPerPage() {
        return recordPerPage;
    }

    public void setRecordPerPage(int recordPerPage) {
        this.recordPerPage = recordPerPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
    
}

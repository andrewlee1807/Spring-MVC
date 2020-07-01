package com.abc.andrew.command;

import com.abc.andrew.dto.BookDTO;

import java.util.List;

public class BookCommand {
    private BookDTO pojo;
    private List<Integer> listID;
    private int page;
    private int pageLimitItem;
    private int maxPage;
    private int idBookEdit;

    public BookCommand() {
    }

    public BookDTO getPojo() {
        return pojo;
    }

    public void setPojo(BookDTO pojo) {
        this.pojo = pojo;
    }

    public List<Integer> getListID() {
        return listID;
    }

    public void setListID(List<Integer> listID) {
        this.listID = listID;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageLimitItem() {
        return pageLimitItem;
    }

    public void setPageLimitItem(int pageLimitItem) {
        this.pageLimitItem = pageLimitItem;
    }

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    public int getIdBookEdit() {
        return idBookEdit;
    }

    public void setIdBookEdit(int idBookEdit) {
        this.idBookEdit = idBookEdit;
    }
}

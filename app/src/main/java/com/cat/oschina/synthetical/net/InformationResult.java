package com.cat.oschina.synthetical.net;

import com.cat.oschina.net.Notice;
import com.cat.oschina.synthetical.entity.Information;

import java.util.Collection;
import java.util.List;

public class InformationResult {
    private List<Information> newslist;
    private Notice notice;

    public List<Information> getNewsList() {
        return newslist;
    }

    public void setNewsList(List<Information> newsList) {
        this.newslist = newsList;
    }

    public Notice getNotice() {
        return notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }
}

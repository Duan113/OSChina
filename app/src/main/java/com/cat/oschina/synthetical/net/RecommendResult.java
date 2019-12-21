package com.cat.oschina.synthetical.net;

import com.cat.oschina.net.Notice;
import com.cat.oschina.synthetical.entity.Recommend;

import java.util.List;

public class RecommendResult {
    private Notice notice;
    private List<Recommend> bloglist;

    public void setNotice(Notice notice) {
        this.notice = notice;
    }

    public Notice getNotice() {
        return notice;
    }

    public void setBloglist(List<Recommend> bloglist) {
        this.bloglist = bloglist;
    }

    public List<Recommend> getBloglist() {
        return bloglist;
    }
}

package com.cat.oschina.synthetical.net;

import com.cat.oschina.tool.Notice;
import com.cat.oschina.tweet.entity.Hot;

import java.util.List;

public class HotResult {
    private Notice notice;
    private List<Hot> tweetlist;
    public void setNotice(Notice notice) {
        this.notice = notice;
    }
    public Notice getNotice() {
        return notice;
    }

    public void setTweetlist(List<Hot> tweetlist) {
        this.tweetlist = tweetlist;
    }
    public List<Hot> getTweetlist() {
        return tweetlist;
    }
}

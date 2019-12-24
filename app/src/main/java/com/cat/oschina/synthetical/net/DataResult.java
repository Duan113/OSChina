package com.cat.oschina.synthetical.net;

import com.cat.oschina.tool.Notice;
import com.cat.oschina.tweet.entity.Data;

import java.util.List;

public class DataResult {
        private Notice notice;
        private List<Data> tweetlist;
        public void setNotice(Notice notice) {
            this.notice = notice;
        }
        public Notice getNotice() {
            return notice;
        }

        public void setTweetlist(List<Data> tweetlist) {
            this.tweetlist = tweetlist;
        }
        public List<Data> getTweetlist() {
            return tweetlist;
        }
}

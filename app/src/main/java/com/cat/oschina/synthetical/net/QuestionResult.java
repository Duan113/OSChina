package com.cat.oschina.synthetical.net;
import com.cat.oschina.net.Notice;
import com.cat.oschina.synthetical.entity.Question;
import java.util.List;
public class QuestionResult {
    private List<Question> post_list;
    private Notice notice;

    public void setPost_list(List<Question> post_list) {
        this.post_list = post_list;
    }

    public List<Question> getPost_list() {
        return post_list;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }

    public Notice getNotice() {
        return notice;
    }

}


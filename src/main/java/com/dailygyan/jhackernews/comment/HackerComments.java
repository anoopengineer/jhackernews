package com.dailygyan.jhackernews.comment;

import java.util.List;

public interface HackerComments {

    public List<Comment> getComments(String id);

    public List<Comment> getCommentsSubmittedBy(String userName);

}

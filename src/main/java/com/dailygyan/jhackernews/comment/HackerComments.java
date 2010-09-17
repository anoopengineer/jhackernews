package com.dailygyan.jhackernews.comment;

import java.util.List;

import com.dailygyan.jhackernews.user.AuthToken;

public interface HackerComments {

    public List<Comment> getComments(String id);

    public List<Comment> getCommentsSubmittedBy(String userName);
    
    public boolean postComment(String userName, AuthToken token, Long id, String comment);

}

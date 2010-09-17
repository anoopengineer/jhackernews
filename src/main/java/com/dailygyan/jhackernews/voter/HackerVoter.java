package com.dailygyan.jhackernews.voter;

import com.dailygyan.jhackernews.user.AuthToken;

public interface HackerVoter {
    
    public boolean voteUp(String userName, AuthToken token, Long id);
    
    public boolean voteDown(String userName, AuthToken token, Long id);

}

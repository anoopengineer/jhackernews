package com.dailygyan.jhackernews.user;

public class User {

    String username;

    String createdAgo;

    String about;

    Long karma;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the createdAgo
     */
    public String getCreatedAgo() {
        return createdAgo;
    }

    /**
     * @return the about
     */
    public String getAbout() {
        return about;
    }

    /**
     * @return the karma
     */
    public Long getKarma() {
        return karma;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "User [about=" + about + ", createdAgo=" + createdAgo
                + ", karma=" + karma + ", username=" + username + "]";
    }

}

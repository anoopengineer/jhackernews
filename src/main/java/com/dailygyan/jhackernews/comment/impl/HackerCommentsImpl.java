/*
 * Copyright (C) 2010 Anoop Engineer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dailygyan.jhackernews.comment.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.dailygyan.jhackernews.comment.Comment;
import com.dailygyan.jhackernews.comment.HackerComments;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * The Class HackerCommentsImpl.
 */
public class HackerCommentsImpl implements HackerComments {

    /** The gson. */
    private Gson gson;

    /**
     * Instantiates a new hacker news impl.
     */
    public HackerCommentsImpl() {
        gson = new Gson();
    }

    /* (non-Javadoc)
     * @see com.dailygyan.jhackernews.comment.HackerComments#getComments(java.lang.String)
     */
    public List<Comment> getComments(String id) {
        return fetch(" http://api.ihackernews.com/comments/" + id);
    }

    /* (non-Javadoc)
     * @see com.dailygyan.jhackernews.comment.HackerComments#getCommentsSubmittedBy(java.lang.String)
     */
    public List<Comment> getCommentsSubmittedBy(String userName) {
        return fetch("http://api.ihackernews.com/threads/" + userName);
    }

    /**
     * Fetch.
     * 
     * @param urlString the url string
     * @return the list
     */
    private List<Comment> fetch(String urlString) {
        URL url = null;
        List<Comment> commentList = null;
        try {
            url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn
                    .getInputStream()));

            StringBuilder stringBuilder = new StringBuilder();
            String inputLine = null;

            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine.trim());
            }
            in.close();

            commentList = gson.fromJson(stringBuilder.toString(),
                    new TypeToken<List<Comment>>() {
                    }.getType());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return commentList;
    }

}

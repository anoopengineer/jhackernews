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
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

import com.dailygyan.jhackernews.comment.Comment;
import com.dailygyan.jhackernews.comment.HackerComments;
import com.dailygyan.jhackernews.user.AuthToken;
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

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.dailygyan.jhackernews.comment.HackerComments#getComments(java.lang
     * .String)
     */
    public List<Comment> getComments(String id) {
        return fetch(" http://api.ihackernews.com/comments/" + id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.dailygyan.jhackernews.comment.HackerComments#getCommentsSubmittedBy
     * (java.lang.String)
     */
    public List<Comment> getCommentsSubmittedBy(String userName) {
        return fetch("http://api.ihackernews.com/threads/" + userName);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.dailygyan.jhackernews.comment.HackerComments#postComment(java.lang
     * .String, com.dailygyan.jhackernews.user.AuthToken, java.lang.Long,
     * java.lang.String)
     */
    public boolean postComment(String userName, AuthToken token, Long id,
            String comment) {
        if (userName == null || token == null || id == null || comment == null) {
            throw new IllegalArgumentException(
                    "Arguments to postComment method cannot be null");
        }

        String data = createData(userName, token, id, comment);
        return post(data);
    }

    /**
     * Creates the data.
     * 
     * @param userName
     *            the user name
     * @param token
     *            the token
     * @param id
     *            the id
     * @param comment
     *            the comment
     * @return the string
     */
    private String createData(String userName, AuthToken token, Long id,
            String comment) {
        String data = null;
        try {
            data = URLEncoder.encode("username", "UTF-8") + "="
                    + URLEncoder.encode(userName, "UTF-8");
            data += "&" + URLEncoder.encode("token", "UTF-8") + "="
                    + URLEncoder.encode(token.getToken(), "UTF-8");
            data += "&" + URLEncoder.encode("id", "UTF-8") + "="
                    + URLEncoder.encode(id.toString(), "UTF-8");

            data += "&" + URLEncoder.encode("comment", "UTF-8") + "="
                    + URLEncoder.encode(comment, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            data = null;
            e.printStackTrace();
        }
        return data;
    }

    /**
     * Post.
     * 
     * @param data
     *            the data
     * @return true, if successful
     */
    private boolean post(String data) {
        if (null == data) {
            return false;
        }

        boolean retVal = false;
        HttpURLConnection conn = null;
        try {
            URL url = new URL("http://api.ihackernews.com/comment");

            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            conn.setRequestProperty("Content-Length", ""
                    + Integer.toString(data.getBytes().length));
            conn.setRequestProperty("Content-Language", "en-US");

            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn
                    .getOutputStream());
            wr.write(data);
            wr.flush();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn
                    .getInputStream()));
            StringBuffer buffer = new StringBuffer();
            String inputLine = null;

            while ((inputLine = in.readLine()) != null) {
                buffer.append(inputLine);
            }

            if ("true".equalsIgnoreCase(buffer.toString())) {
                retVal = true;
            } else {
                retVal = false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

        return retVal;
    }

    /**
     * Fetch.
     * 
     * @param urlString
     *            the url string
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

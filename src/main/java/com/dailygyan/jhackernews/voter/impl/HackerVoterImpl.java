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
package com.dailygyan.jhackernews.voter.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.dailygyan.jhackernews.user.AuthToken;
import com.dailygyan.jhackernews.voter.HackerVoter;

public class HackerVoterImpl implements HackerVoter {

    public boolean voteDown(String userName, AuthToken token, Long id) {
        return vote(userName, token, id, 1);
    }

    public boolean voteUp(String userName, AuthToken token, Long id) {
        return vote(userName, token, id, 0);
    }

    /**
     * Vote.
     * 
     * @param userName
     *            the user name
     * @param token
     *            the token
     * @param id
     *            the id
     * @param direction
     *            0 = upvote, 1 = downvote
     * @return true, if successful
     */
    private boolean vote(String userName, AuthToken token, Long id,
            int direction) {
        if(userName == null || token == null || id == null){
            throw new IllegalArgumentException("Arguments to vote methods cannot be null");
        }
        
        String data = createData(userName, token, id, direction);
        return post(data);
    }

    private String createData(String userName, AuthToken token, Long id,
            int direction) {
        String data = null;
        try {
            data = URLEncoder.encode("username", "UTF-8") + "="
                    + URLEncoder.encode(userName, "UTF-8");
            data += "&" + URLEncoder.encode("token", "UTF-8") + "="
                    + URLEncoder.encode(token.getToken(), "UTF-8");
            data += "&" + URLEncoder.encode("id", "UTF-8") + "="
                    + URLEncoder.encode(id.toString(), "UTF-8");

            String dir = (direction == 0) ? "up" : "down";
            data += "&" + URLEncoder.encode("direction", "UTF-8") + "="
                    + URLEncoder.encode(dir, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            data = null;
            e.printStackTrace();
        }
        return data;
    }

    private boolean post(String data) {
        if (null == data) {
            return false;
        }

        boolean retVal = false;
        HttpURLConnection conn = null;
        try {
            URL url = new URL("http://api.ihackernews.com/vote");

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

}

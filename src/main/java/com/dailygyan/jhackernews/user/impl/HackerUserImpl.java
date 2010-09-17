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
package com.dailygyan.jhackernews.user.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.dailygyan.jhackernews.user.AuthToken;
import com.dailygyan.jhackernews.user.HackerUser;
import com.dailygyan.jhackernews.user.User;
import com.google.gson.Gson;

/**
 * The Class HackerUserImpl.
 */
public class HackerUserImpl implements HackerUser {

    /** The gson. */
    private Gson gson;

    /**
     * Instantiates a new hacker news impl.
     */
    public HackerUserImpl() {
        gson = new Gson();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.dailygyan.jhackernews.user.HackerUser#getUserProfile(java.lang.String
     * )
     */
    public User getUserProfile(String userName) {
        return fetch("http://api.ihackernews.com/profile/" + userName);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.dailygyan.jhackernews.user.HackerUser#login(java.lang.String,
     * java.lang.String)
     */
    public AuthToken login(String userName, String password) {

        HttpURLConnection conn = null;
        AuthToken retVal = null;
        try {
            URL url = new URL("http://api.ihackernews.com/login");

            String data = URLEncoder.encode("username", "UTF-8") + "="
                    + URLEncoder.encode(userName, "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") + "="
                    + URLEncoder.encode(password, "UTF-8");

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
            in.close();
            wr.close();

            retVal = gson.fromJson(buffer.toString(), AuthToken.class);
        } catch (Exception e) {
            e.printStackTrace();
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
     * @return the user
     */
    private User fetch(String urlString) {
        URL url = null;
        User user = null;
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
            user = gson.fromJson(stringBuilder.toString(), User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

}

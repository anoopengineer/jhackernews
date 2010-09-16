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
import java.net.URL;
import java.net.URLConnection;

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

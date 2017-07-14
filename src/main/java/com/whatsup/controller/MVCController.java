package com.whatsup.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DelMonroe on 7/11/17.
 */
@Controller
public class MVCController {

    @RequestMapping(path="/admin", method = RequestMethod.GET)
    public String adminPage(){
        return "dashboard_admin";
    }


    @RequestMapping(path="/users", method = RequestMethod.GET)
    public String userPage() { return "dashboard_user";}


    @RequestMapping(path="/yelptest", method = RequestMethod.GET)
    @ResponseBody
    public String showYelp() throws IOException, URISyntaxException {
        CloseableHttpClient client = HttpClients.createDefault();

        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("grant_type", "client_credentials"));
        formparams.add(new BasicNameValuePair("client_id", "qoki5XUClSAHUg-8xN8eTg"));
        formparams.add(new BasicNameValuePair("client_secret", "fMXre7kUwan40vX4gvBKVYirqX8s9tYFvPlKF9ZbCBA3uQTYn1fpsxyP7WBEUhxJ"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);

        HttpPost post = new HttpPost("https://api.yelp.com/oauth2/token");
        post.setEntity(entity);
        CloseableHttpResponse response = client.execute(post);
        BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

        String output;
        String json = "";
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            json += output;
        }
        JSONObject jsonObject = new JSONObject(json);
        String token = jsonObject.getString("access_token");
        System.out.println(token);

        URIBuilder builder = new URIBuilder();
        builder.setScheme("https").setHost("api.yelp.com").setPath("/v3/businesses/search")
                .setParameter("location", "san antonio, tx")
                //.setParameter("access_token", token)
                .setParameter("latitude", "29.42458")
                .setParameter("longitude", "-98.49461");
        URI uri = builder.build();

        HttpGet get = new HttpGet(uri);
        get.setHeader("Authorization", String.format("bearer %s", token));
        response = client.execute(get);
        br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }


        return "yelpAPI";
    }
}


package com.epicodus.mylendinglibrary;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

public class BooksService {
    public static void findBooks(String book, Callback callback){
        //OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(Constants.GOOGLE_API, Constants.GOOGLE_OAUTH);

        OkHttpClient client = new OkHttpClient.Builder()
               // .addInterceptor(new SigningInterceptor(consumer))
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.GOOGLE_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter("q",Constants.GOOGLE_BOOK);
        urlBuilder.addQueryParameter("key", Constants.GOOGLE_API);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}

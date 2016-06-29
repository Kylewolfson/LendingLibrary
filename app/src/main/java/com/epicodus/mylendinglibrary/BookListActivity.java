package com.epicodus.mylendinglibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class BookListActivity extends AppCompatActivity {
    public static final String TAG = BookListActivity.class.getSimpleName();
    @Bind(R.id.bookListView) ListView mBookListView;
    String[] bookList = new String[]{"Book","Book","Book","Book","Book","Book","Book","Book","Book","Book","LastBook" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        ButterKnife.bind(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, bookList);
        mBookListView.setAdapter(adapter);
        getBooks("_LettPDhwR0C");
    }

    private void getBooks(String book){
        final BooksService booksService = new BooksService();
        booksService.findBooks(book, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    Log.v(TAG, jsonData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

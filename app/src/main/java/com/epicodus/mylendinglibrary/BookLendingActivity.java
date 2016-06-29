package com.epicodus.mylendinglibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BookLendingActivity extends AppCompatActivity {
    @Bind(R.id.bookLending) ListView mBookLendView;
    String[] bookList = new String[]{"Book","Book","Book","Book","Book","Book","Book","Book","Book","Book","LastBook" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_lending);
        ButterKnife.bind(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, bookList);
        mBookLendView.setAdapter(adapter);
    }
}

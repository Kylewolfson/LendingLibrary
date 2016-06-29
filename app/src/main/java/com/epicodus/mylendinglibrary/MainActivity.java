package com.epicodus.mylendinglibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.signUp) ImageButton mSignUp;
    @Bind(R.id.bookList) ImageButton mBookList;
    @Bind(R.id.bookLending) ImageButton mBookLending;
    @Bind(R.id.bookBorrowing) ImageButton mBookBorrowed;
    @Bind(R.id.readingSpot) ImageButton mReadingSpot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mSignUp.setOnClickListener(this);
        mBookList.setOnClickListener(this);
        mBookLending.setOnClickListener(this);
        mBookBorrowed.setOnClickListener(this);
        mReadingSpot.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(view == mSignUp) {
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        } else if (view == mBookList) {
            Intent intent = new Intent(MainActivity.this, BookListActivity.class);
            startActivity(intent);
        } else if (view == mBookLending){
            Intent intent = new Intent(MainActivity.this, BookLendingActivity.class);
            startActivity(intent);
        } else if (view == mBookBorrowed){
            Intent intent = new Intent(MainActivity.this, BookBorrowedActivity.class);
            startActivity(intent);
        } else if (view == mReadingSpot) {
            Intent intent = new Intent(MainActivity.this, ReadingActivity.class);
            startActivity(intent);
        }
    }
}

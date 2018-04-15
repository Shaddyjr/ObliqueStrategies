package com.mahdispw.android.obliquestrategies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView mainView;

    static final String LAST_INDEX = "item_index";

    String[] quotes;
    Integer item_index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            // Restore value of members from saved state
            item_index = savedInstanceState.getInt(LAST_INDEX);
        }

        setContentView(R.layout.activity_main);
        mainView = findViewById(R.id.quote);
        quotes = getResources().getStringArray(R.array.quotes);

        if(item_index != null){
            displayQuote();
        }
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can save the view hierarchy state
        super.onRestoreInstanceState(savedInstanceState);
        item_index = savedInstanceState.getInt(LAST_INDEX);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(LAST_INDEX, item_index);

        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }

    /*
    * Responsible for randomly selecting and index from the quote array and storing in
    * global variable
     */
    private void randQuote(){
        item_index = new Random().nextInt(quotes.length);
    }

    /*
    * Responsible for displaying the current item index from the quote array
     */
    public void displayQuote(){
        mainView.setText(quotes[item_index]);
    }

    // must accept a view object when button clicked
    public void showNewQuote(View v){
        randQuote();
        displayQuote();
    }
}

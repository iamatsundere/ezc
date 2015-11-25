package com.example.phuctruong.ezc.View;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.phuctruong.ezc.Adapter.AlphabetRecyclerAdapter;
import com.example.phuctruong.ezc.Adapter.IngredientRecylerAdapter;
import com.example.phuctruong.ezc.Model.AlphabetItem;
import com.example.phuctruong.ezc.Model.Ingredient;
import com.example.phuctruong.ezc.R;

import java.util.ArrayList;
import java.util.List;

public class PriceActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price);

        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar_price);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        TextView txt = (TextView) toolbar.findViewById(R.id.app_bar_title);
        txt.setText("GIÁ CẢ HÀNG HÓA");


//        RecyclerView rcv_alphabets = (RecyclerView) findViewById(R.id.rcv_alphabets);
//        rcv_alphabets.setLayoutManager(new LinearLayoutManager(this));
//        AlphabetRecyclerAdapter alphabetRecyclerAdapter = new AlphabetRecyclerAdapter(getLettersList(), this);
//        rcv_alphabets.setAdapter(alphabetRecyclerAdapter);

        RecyclerView rcv_ingredients = (RecyclerView) findViewById(R.id.rcv_ingredients);
        rcv_ingredients.setLayoutManager(new LinearLayoutManager(this));
        IngredientRecylerAdapter ingredientRecylerAdapter = new IngredientRecylerAdapter(getData(), this);
        rcv_ingredients.setAdapter(ingredientRecylerAdapter);
    }

    public List<AlphabetItem> getLettersList()
    {
        List<AlphabetItem> alphabetItems = new ArrayList<>();
        for (char k='A'; k <='Z'; k++)
        {
            AlphabetItem item=new AlphabetItem();
            item.setTagName(k+"");
            alphabetItems.add(item);
        }
        return alphabetItems;
    }

    public List<Ingredient> getData() {
        List<Ingredient> ingredientList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Ingredient ingredient = new Ingredient();
            ingredient.setName("i know place");
            ingredient.setPrice("100,000VND");
            ingredient.setUnit("/gram");
            ingredientList.add(ingredient);
        }
        return ingredientList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_price, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) this.getSystemService(Context.SEARCH_SERVICE);

        android.support.v7.widget.SearchView searchView = null;
        if (searchItem != null) {
            searchView = (android.support.v7.widget.SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(this.getComponentName()));
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Sets the up search view theme.
     *
     * @param searchView
     *            the new up search view theme
     */


}

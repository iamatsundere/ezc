package com.example.phuctruong.ezc.View;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.phuctruong.ezc.Adapter.AlphabetRecyclerAdapter;
import com.example.phuctruong.ezc.Adapter.IngredientRecylerAdapter;
import com.example.phuctruong.ezc.Adapter.RecipeRecyclerAdapter;
import com.example.phuctruong.ezc.Model.AlphabetItem;
import com.example.phuctruong.ezc.Model.Recipe;
import com.example.phuctruong.ezc.R;

import java.util.ArrayList;
import java.util.List;

public class RecipeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar_recipe);
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
        txt.setText("RECIPES");

//        RecyclerView rcv_alphabets = (RecyclerView) findViewById(R.id.rcv_alphabets);
//        rcv_alphabets.setLayoutManager(new LinearLayoutManager(this));
//        AlphabetRecyclerAdapter alphabetRecyclerAdapter = new AlphabetRecyclerAdapter(getLettersList(), this);
//        rcv_alphabets.setAdapter(alphabetRecyclerAdapter);
//
        RecyclerView rec_recipes = (RecyclerView) findViewById(R.id.rcv_recipes);
        rec_recipes.setLayoutManager(new LinearLayoutManager(this));
        RecipeRecyclerAdapter recipeRecyclerAdapter = new RecipeRecyclerAdapter(getRecipeData(), this);
        rec_recipes.setAdapter(recipeRecyclerAdapter);

    }

    public List<AlphabetItem> getLettersList()
    {
        List<AlphabetItem> alphabetItems = new ArrayList<AlphabetItem>();
        for (char k='A'; k <='Z'; k++)
        {
            AlphabetItem item=new AlphabetItem();
            item.setTagName(k+"");
            alphabetItems.add(item);
        }
        return alphabetItems;
    }

    public List<Recipe> getRecipeData() {
        List<Recipe> recipeList = new ArrayList<Recipe>();
        Recipe rObject;
        for (char k = 'A'; k <= 'Z'; k++)
            for (int i = 0; i < 3; i++) {
                String s = "";
                for (int j = 0; j < 3; j++)
                    s += k + "";
                rObject = new Recipe(s, 0);
                recipeList.add(rObject);
            }
        return recipeList;
    }



    public void OnRecipeClick(View view) {
        Intent intent = new Intent(getApplicationContext(),RecipeDetailActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_recipe, menu);

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
}

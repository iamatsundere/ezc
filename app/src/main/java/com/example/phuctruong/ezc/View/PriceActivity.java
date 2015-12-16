package com.example.phuctruong.ezc.View;

import android.app.SearchManager;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.phuctruong.ezc.Adapter.IngredientRecylerAdapter;
import com.example.phuctruong.ezc.Control.JsonParser;
import com.example.phuctruong.ezc.Model.AlphabetItem;
import com.example.phuctruong.ezc.Model.Ingredient;
import com.example.phuctruong.ezc.R;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PriceActivity extends ActionBarActivity {

    public static List<Ingredient> listI;
    public static List<Ingredient> listIT;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price);

        context = this;
        listI = new ArrayList<>();
        listI = getData();
        listIT = new ArrayList<>();

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

        PushContentToView(listI);
    }

    public void PushContentToView(List<Ingredient> list)
    {
        RecyclerView rcv_ingredients = (RecyclerView) findViewById(R.id.rcv_ingredients);
        rcv_ingredients.setLayoutManager(new LinearLayoutManager(this));
        IngredientRecylerAdapter ingredientRecylerAdapter = new IngredientRecylerAdapter(list, this);
        rcv_ingredients.setAdapter(ingredientRecylerAdapter);
    }

    public List<AlphabetItem> getLettersList() {
        List<AlphabetItem> alphabetItems = new ArrayList<>();
        for (char k = 'A'; k <= 'Z'; k++) {
            AlphabetItem item = new AlphabetItem();
            item.setTagName(k + "");
            alphabetItems.add(item);
        }
        return alphabetItems;
    }

    public List<Ingredient> getData() {
        List<Ingredient> ingredientList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(i + "");
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

        SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                listIT = new ArrayList<>();
                for (Ingredient i : listI)
                    if (i.getName().contains(query))
                        listIT.add(i);
                PushContentToView(listIT);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.compareTo("") == 0) {
                    listIT = listI;
                    PushContentToView(listI);
                }
                return false;
            }
        };
        searchView.setOnQueryTextListener(queryTextListener);
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


    private class AsynTask extends AsyncTask<String, ArrayList<Ingredient>, ArrayList<Ingredient>> {

        JSONArray dataJsonArr = null;
        String yourJsonStringUrl = "http://192.168.30.1:8080/test/Ingredient";
        ArrayList<Ingredient> listIngredient = new ArrayList<Ingredient>();

        @Override
        protected ArrayList<Ingredient> doInBackground(String... params) {
            // TODO Auto-generated method stub
            try {
                // instantiate our json parser
                JsonParser jParser = new JsonParser();

                // -------- add value post request
                ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
                // postParameters.add((NameValuePair) new
                // BasicNameValuePair("x",
                // Double.toString(mMap.getMyLocation().getLatitude())));
                // postParameters.add((NameValuePair) new
                // BasicNameValuePair("y",
                // Double.toString(mMap.getMyLocation().getLongitude())));
                postParameters.add((NameValuePair) new BasicNameValuePair("x", "21.054284"));
                postParameters.add((NameValuePair) new BasicNameValuePair("y", "105.787111"));
                // get json string from url
                JSONObject json = jParser.getJSONFromUrl(yourJsonStringUrl, postParameters);

                // get the array of users
                dataJsonArr = json.getJSONArray("Ingredient");
                // loop through all users
                Ingredient tmp=new Ingredient();
                for (int i = 0; i < dataJsonArr.length(); i++) {

                    JSONObject c = dataJsonArr.getJSONObject(i);
                    // Log.d(i + " c obj", c.get("name") + "");
                    // tmp.setBackground(c.get("background").toString());
                    // tmp.setPhone(c.get("phone").toString());
                    // tmp.setDescription(c.get("description").toString());
                    // tmp.setType(c.get("type").toString());
                    listIngredient.add(tmp);
                }

            } catch (Exception e) {

            }
            return listIngredient;

        }

        @Override
        protected void onPostExecute(ArrayList<Ingredient> strFromDoInBg) {

            

        }
    }


}

package com.example.phuctruong.ezc.View;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.phuctruong.ezc.Model.Category;
import com.example.phuctruong.ezc.R;

import java.util.ArrayList;

public class CategoryActivity extends ActionBarActivity {

    GridView grdv;
    ArrayList<Category> plist;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar_catgr);
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
        txt.setText("DANH MỤC");

        grdv = (GridView) findViewById(R.id.grid);
        setUpView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_category, menu);

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


    private void loadData() {
        ArrayList<Category> l = new ArrayList<Category>();
        l.add(new Category("NƯỚNG", R.id.image, R.id.icon_number_recipe));
        l.add(new Category("SÚP", R.id.image, R.id.icon_number_recipe));
        l.add(new Category("LẨU", R.id.image, R.id.icon_number_recipe));
        l.add(new Category("XÀO", R.id.image, R.id.icon_number_recipe));
        l.add(new Category("HẤP", R.id.image, R.id.icon_number_recipe));
        l.add(new Category("LUỘC", R.id.image, R.id.icon_number_recipe));
        plist = new ArrayList<Category>();
        plist.addAll(l);
    }

    public void setUpView() {
        loadData();
        grdv.setAdapter(new PlaceAdapter());
    }

    public class PlaceAdapter extends BaseAdapter {
        /* (non-Javadoc)
         * @see android.widget.Adapter#getCount()
         */
        public PlaceAdapter() {
            super();
        }

        @Override

        public int getCount() {
            return plist.size();
        }

        /* (non-Javadoc)
         * @see android.widget.Adapter#getItem(int)
         */
        @Override
        public Category getItem(int arg0) {
            return plist.get(arg0);
        }

        /* (non-Javadoc)
         * @see android.widget.Adapter#getItemId(int)
         */
        @Override
        public long getItemId(int arg0) {
            return arg0;
        }

		/* (non-Javadoc)
         * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
		 */

        @Override
        public View getView(int position, View v, ViewGroup parent) {
            // TODO Auto-generated method stub
            if (v == null)
                v = getLayoutInflater().inflate(R.layout.item_category, null);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), RecipeActivity.class);
                    startActivity(i);
                }
            });
            Category l = getItem(position);
            TextView bt = (TextView) v.findViewById(R.id.item_category_name);
            bt.setText(l.getName());

            ImageView img = (ImageView) v.findViewById(R.id.item_category_img);
            img.setImageResource(l.getImage());

            ImageView ic = (ImageView) v.findViewById(R.id.item_category_icon);
            ic.setImageResource(l.getIcon());
            return v;
        }


    }
}

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
import android.widget.ListView;
import android.widget.TextView;

import com.example.phuctruong.ezc.Model.MenuObject;
import com.example.phuctruong.ezc.R;

import java.util.ArrayList;

public class MenuActivity extends ActionBarActivity {

    ListView lw;
    ArrayList<MenuObject> plist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar_menu);
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
        txt.setText("MENU");

        lw = (ListView) findViewById(R.id.lsvMenu);
        setUpView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_menu, menu);

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
        ArrayList<MenuObject> l = new ArrayList<MenuObject>();
        l.add(new MenuObject("MENU X", "120,250", 16, 18));
        l.add(new MenuObject("MENU Y", "250,000", 6, 8));
        l.add(new MenuObject("MENU YX", "250,000", 12, 8));
        l.add(new MenuObject("MENU AA", "250,000", 6, 9));
        l.add(new MenuObject("MENU A", "50,000", 6, 10));
        l.add(new MenuObject("MENU B", "1,020,000", 10, 8));
        l.add(new MenuObject("MENU B", "1,020,000", 10, 8));
        l.add(new MenuObject("MENU B", "1,020,000", 10, 8));
        l.add(new MenuObject("MENU B", "1,020,000", 10, 8));
        l.add(new MenuObject("MENU B", "1,020,000", 10, 8));
        l.add(new MenuObject("MENU B", "1,020,000", 10, 8));
        l.add(new MenuObject("MENU B", "1,020,000", 10, 8));
        l.add(new MenuObject("MENU B", "1,020,000", 10, 8));
        plist = new ArrayList<MenuObject>();
        plist.addAll(l);
    }

    public void setUpView() {
        loadData();
        lw.setAdapter(new PlaceAdapter());
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
        public MenuObject getItem(int arg0) {
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
                v = getLayoutInflater().inflate(R.layout.item_menu, null);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), MenuDetailActivity.class);
                    startActivity(intent);
                }
            });
            MenuObject td = getItem(position);

            TextView tw1 = (TextView) v.findViewById(R.id.menu_name);
            tw1.setText(td.getName());

            TextView tw2 = (TextView) v.findViewById(R.id.menu_price);
            tw2.setText(td.getPrice());

            TextView tw3 = (TextView) v.findViewById(R.id.menu_qty_recipe_content);
            tw3.setText(td.getQtyRecipe() + "");
////
            TextView tw4 = (TextView) v.findViewById(R.id.menu_qty_people_content);
            tw4.setText(td.getQtyAttendance() + "");

            return v;
        }


    }
}

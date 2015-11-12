package com.example.phuctruong.ezc.View;

import android.app.SearchManager;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.phuctruong.ezc.R;

public class MenuDetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);

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
        txt.setText("MENU X");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_menu_detail, menu);

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

//    @Override
//    public void onClick(View v)
//    {
//        super.onClick(v);
//        if (v.getId() == R.id.btn_dish_tab)
//            page.setCurrentItem(0, true);
//        else if (v.getId() == R.id.btn_ingredient_tab)
//            page.setCurrentItem(1, true);
//    }
//
//
//    private void initTabs()
//    {
//        findViewById(R.id.btn_dish_tab).setOnClickListener(this);
//        findViewById(R.id.btn_ingredient_tab).setOnClickListener(this);
//        setCurrentTab(0);
//    }
//    private void setCurrentTab(int page)
//    {
//        if (currentTab != null)
//            currentTab.setEnabled(true);
//        if (page == 0)
//            currentTab = findViewById(R.id.btn_dish_tab);
//        else if (page == 1)
//            currentTab = findViewById(R.id.btn_ingredient_tab);
//        currentTab.setEnabled(false);
//
//    }
//
//    private void initPager()
//    {
//        page = (ViewPager) findViewById(R.id.pager);
//        page.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//
//            @Override
//            public void onPageSelected(int page)
//            {
//                setCurrentTab(page);
//            }
//
//            @Override
//            public void onPageScrolled(int arg0, float arg1, int arg2)
//            {
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int arg0)
//            {
//            }
//        });
//        page.setAdapter(new DummyPageAdapter(getSupportFragmentManager()));
//    }
//
//    /**
//     * The Class DummyPageAdapter is a dummy pager adapter for ViewPager. You
//     * can customize this adapter as per your needs.
//     */
//    private class DummyPageAdapter extends FragmentPagerAdapter
//    {
//
//        /**
//         * Instantiates a new dummy page adapter.
//         *
//         * @param fm
//         *            the FragmentManager
//         */
//        public DummyPageAdapter(FragmentManager fm)
//        {
//            super(fm);
//        }
//
//        /* (non-Javadoc)
//         * @see android.support.v4.app.FragmentPagerAdapter#getItem(int)
//         */
//        @Override
//        public Fragment getItem(int pos)
//        {
////            if (pos == 0)
////                return new list1();
////            if (pos == 1)
////                return new list2();
//            return null;
//        }
//
//        /* (non-Javadoc)
//         * @see android.support.v4.view.PagerAdapter#getCount()
//         */
//        @Override
//        public int getCount()
//        {
//            return 2;
//        }
//    }

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

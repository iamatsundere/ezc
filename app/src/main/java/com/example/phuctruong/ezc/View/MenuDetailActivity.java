package com.example.phuctruong.ezc.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.phuctruong.ezc.R;
import com.example.phuctruong.ezc.View.MenuDetailTabs.mnu_detail_rcp;
import com.example.phuctruong.ezc.View.MenuDetailTabs.mnu_detail_ingredient;

public class MenuDetailActivity extends ActionBarActivity {

    private Button bt1, bt2;
    private ViewPager page;
    private View currentTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);

        page=(ViewPager) findViewById(R.id.pager);

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
        txt.setText("MENU X");
        initTabs();
        initPager();
    }

    public void OnRecipeClick(View view) {
        Intent intent = new Intent(getApplicationContext(),RecipeDetailActivity.class);
        startActivity(intent);
    }

    public void onMenuTabChanged(View v) {
        if (v.getId() == R.id.btn_dish_tab)
            page.setCurrentItem(0, true);
        else if (v.getId() == R.id.btn_ingredient_tab)
            page.setCurrentItem(1, true);
    }


    private void initTabs() {

        View btn_dish = findViewById(R.id.btn_dish_tab);
        btn_dish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page.setCurrentItem(0, true);
            }
        });

        View btn_ingredient = findViewById(R.id.btn_ingredient_tab);
        btn_ingredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page.setCurrentItem(1, true);
            }
        });
        page.setCurrentItem(0, true);
    }

    private void setCurrentTab(int page) {
        if (currentTab != null)
            currentTab.setEnabled(true);
        if (page == 0)
            currentTab = findViewById(R.id.btn_dish_tab);
        else if (page == 1)
            currentTab = findViewById(R.id.btn_ingredient_tab);
        currentTab.setEnabled(false);

    }

    private void initPager() {
        page = (ViewPager) findViewById(R.id.pager);
        page.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int page) {
                setCurrentTab(page);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
        page.setAdapter(new DummyPageAdapter(getSupportFragmentManager()));
    }

    /**
     * The Class DummyPageAdapter is a dummy pager adapter for ViewPager. You
     * can customize this adapter as per your needs.
     */
    private class DummyPageAdapter extends FragmentPagerAdapter {

        /**
         * Instantiates a new dummy page adapter.
         *
         * @param fm the FragmentManager
         */
        public DummyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        /* (non-Javadoc)
         * @see android.support.v4.app.FragmentPagerAdapter#getItem(int)
         */
        @Override
        public Fragment getItem(int pos) {
            if (pos == 0)
                return new mnu_detail_rcp();
            if (pos == 1)
                return new mnu_detail_ingredient();
            return null;
        }

        /* (non-Javadoc)
         * @see android.support.v4.view.PagerAdapter#getCount()
         */
        @Override
        public int getCount() {
            return 2;
        }
    }
}

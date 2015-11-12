package com.example.phuctruong.ezc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.phuctruong.ezc.View.CategoryActivity;
import com.example.phuctruong.ezc.View.MenuActivity;
import com.example.phuctruong.ezc.View.PriceActivity;
import com.example.phuctruong.ezc.View.SettingActivity;
/**
 * Created by Phuc Truong on 10/17/2015.
 */
public class MainActivity extends AppCompatActivity {

    private RelativeLayout btnCategory,btnMenu,btnSetting,btnPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnCategory = (RelativeLayout) findViewById(R.id.btnCategory);
        btnCategory.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), CategoryActivity.class);
                startActivity(i);

            }
        });

        btnMenu = (RelativeLayout) findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent menu = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(menu);
            }
        });

        btnPrice = (RelativeLayout) findViewById(R.id.btnPrice);
        btnPrice.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PriceActivity.class);
                startActivity(i);
            }
        });

        btnSetting = (RelativeLayout) findViewById(R.id.btnSetting);
        btnSetting.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

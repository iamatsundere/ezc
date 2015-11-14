package com.example.phuctruong.ezc.View.MenuDetailTabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.phuctruong.ezc.Adapter.IngredientRecylerAdapter;
import com.example.phuctruong.ezc.Model.Ingredient;
import com.example.phuctruong.ezc.R;

import java.util.ArrayList;
import java.util.List;

public class mnu_detail_ingredient extends Fragment {
    ArrayList<String> values = new ArrayList<String>();
    RecyclerView rcv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recyclerview_template, null);
        rcv = (RecyclerView) v.findViewById(R.id.recyclerview_template);
        rcv.setLayoutManager(new LinearLayoutManager(v.getContext()));
        IngredientRecylerAdapter ingredientRecylerAdapter = new IngredientRecylerAdapter(getData(), v.getContext());
        rcv.setAdapter(ingredientRecylerAdapter);
        return v;
    }

    public List<Ingredient> getData() {
        List<Ingredient> ingredientList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Ingredient ingredient = new Ingredient();
            ingredient.setName("i know place");
            ingredient.setPrice("100,000VND");
            ingredient.setUnit("/gram");
            ingredientList.add(ingredient);
        }
        return ingredientList;
    }

}

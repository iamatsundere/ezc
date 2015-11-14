package com.example.phuctruong.ezc.View.MenuDetailTabs;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.phuctruong.ezc.Adapter.RecipeRecyclerAdapter;
import com.example.phuctruong.ezc.Model.Recipe;
import com.example.phuctruong.ezc.R;
import com.example.phuctruong.ezc.View.RecipeDetailActivity;

import java.util.ArrayList;
import java.util.List;


public class mnu_detail_rcp extends Fragment {
    RecyclerView rcv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recyclerview_template, container, false);
        rcv = (RecyclerView) v.findViewById(R.id.recyclerview_template);
        rcv.setLayoutManager(new LinearLayoutManager(v.getContext()));
        RecipeRecyclerAdapter recipeRecyclerAdapter = new RecipeRecyclerAdapter(getRecipeData(), v.getContext());
        rcv.setAdapter(recipeRecyclerAdapter);
        SetViewClick(rcv);
        return v;

    }

    public List<Recipe> getRecipeData() {
        List<Recipe> recipeList = new ArrayList<Recipe>();
        Recipe rObject;
        for (char k = 'A'; k <= 'Z'; k++)
            for (int i = 0; i < 1; i++) {
                String s = "";
                for (int j = 0; j < 3; j++)
                    s += k + "";
                rObject = new Recipe(s, 0);
                recipeList.add(rObject);
            }
        return recipeList;
    }

    public void SetViewClick(final ViewGroup viewParent) {
        for (int i = 0; i < viewParent.getChildCount(); i++) {
            View viewChild = viewParent.getChildAt(i);
            viewChild.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(viewParent.getContext(), RecipeDetailActivity.class);
                    startActivity(intent);
                }
            });
            ViewGroup viewGroup = (ViewGroup) viewChild;
            if (viewGroup.getChildCount() >= 1)
                SetViewClick(viewGroup);
        }
    }
}

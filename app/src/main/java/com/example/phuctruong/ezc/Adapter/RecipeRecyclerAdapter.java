package com.example.phuctruong.ezc.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.phuctruong.ezc.Model.Recipe;
import com.example.phuctruong.ezc.R;
import com.example.phuctruong.ezc.View.RecipeActivity;
import com.example.phuctruong.ezc.ViewHolder.RecipeVH;

import java.util.Collections;
import java.util.List;

/**
 * Created by Phuc Truong on 10/17/2015.
 */
public class RecipeRecyclerAdapter extends RecyclerView.Adapter<RecipeVH> {

    private List<Recipe> rcpList = Collections.emptyList();
    private Context context;

    public RecipeRecyclerAdapter(List<Recipe> rcpList, Context context) {
        this.rcpList = rcpList;
        this.context = context;
        notifyDataSetChanged();
    }

    @Override
    public RecipeVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, null);
        RecipeVH rcpVH = new RecipeVH(view);
        return rcpVH;
    }

    @Override
    public void onBindViewHolder(RecipeVH holder, int position) {
        final Recipe currentItem = rcpList.get(position);
        holder.txvName.setText(currentItem.getName());
        Log.d("PID", currentItem.getPictureID()+"");
//        holder.imgPicture.setBackgroundResource(currentItem.getPictureID());
    }

    @Override
    public int getItemCount() {
        return rcpList == null ? 0 : rcpList.size();
    }

}

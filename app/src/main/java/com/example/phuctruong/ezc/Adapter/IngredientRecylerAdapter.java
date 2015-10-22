package com.example.phuctruong.ezc.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.phuctruong.ezc.Model.Ingredient;
import com.example.phuctruong.ezc.R;
import com.example.phuctruong.ezc.ViewHolder.IngredientVH;

import java.util.Collections;
import java.util.List;

/**
 * Created by Phuc Truong on 10/17/2015.
 */
public class IngredientRecylerAdapter extends RecyclerView.Adapter<IngredientVH> {

    private LayoutInflater inflater;
    private List<Ingredient> igdList = Collections.emptyList();
    private Context context;

    public IngredientRecylerAdapter(List<Ingredient> catgrList, Context context) {
        this.igdList = catgrList;
        this.context = context;
        notifyDataSetChanged();
    }

    @Override
    public IngredientVH onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_ingredient, null);
        IngredientVH catgrVH = new IngredientVH(view);

        return catgrVH;
    }

    private View.OnClickListener placeOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            CardView card=(CardView)v;
            Log.e("RES", String.valueOf(card.getId()));
        }
    };

    @Override
    public void onBindViewHolder(IngredientVH holder, int position) {
        final Ingredient currentItem = igdList.get(position);
        holder.txvName.setText(currentItem.getName());
        holder.txvUnit.setText(currentItem.getUnit());
        holder.txvPrice.setText(currentItem.getPrice());
    }

    @Override
    public int getItemCount() {
        return igdList == null ? 0 : igdList.size();
    }

}

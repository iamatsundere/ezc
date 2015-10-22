package com.example.phuctruong.ezc.ViewHolder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.phuctruong.ezc.R;

/**
 * Created by Phuc Truong on 10/17/2015.
 */
public class IngredientVH extends RecyclerView.ViewHolder {
    public TextView txvName;
    public TextView txvPrice;
    public TextView txvUnit;
    public CardView itemCardView;


    public IngredientVH(View itemView) {
        super(itemView);
        txvName=(TextView) itemView.findViewById(R.id.item_ingredient_name);
        txvPrice=(TextView) itemView.findViewById(R.id.item_ingredient_price);
        txvUnit=(TextView) itemView.findViewById(R.id.item_ingredient_unit);
        itemCardView=(CardView) itemView.findViewById(R.id.item_ingredient);
    }
}

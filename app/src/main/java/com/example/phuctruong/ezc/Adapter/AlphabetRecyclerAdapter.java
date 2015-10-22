package com.example.phuctruong.ezc.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.phuctruong.ezc.Model.AlphabetItem;
import com.example.phuctruong.ezc.Model.Ingredient;
import com.example.phuctruong.ezc.R;
import com.example.phuctruong.ezc.ViewHolder.AlphabetVH;
import com.example.phuctruong.ezc.ViewHolder.IngredientVH;

import java.util.Collections;
import java.util.List;

/**
 * Created by Phuc Truong on 10/17/2015.
 */
public class AlphabetRecyclerAdapter extends RecyclerView.Adapter<AlphabetVH> {
    private LayoutInflater inflater;
    private List<AlphabetItem> alphabetItems = Collections.emptyList();
    private Context context;

    public AlphabetRecyclerAdapter(List<AlphabetItem> catgrList, Context context) {
        this.alphabetItems = catgrList;
        this.context = context;
        notifyDataSetChanged();
    }

    @Override
    public AlphabetVH onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_alphabet, null);
        AlphabetVH catgrVH = new AlphabetVH(view);
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
    public void onBindViewHolder(AlphabetVH holder, int position) {
        final AlphabetItem alphabetItem = alphabetItems.get(position);
        holder.txvTagName.setText(alphabetItem.getTagName());
    }

    @Override
    public int getItemCount() {
        return alphabetItems == null ? 0 : alphabetItems.size();
    }

}

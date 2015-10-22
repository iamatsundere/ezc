package com.example.phuctruong.ezc.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.phuctruong.ezc.R;

import org.w3c.dom.Text;

/**
 * Created by Phuc Truong on 10/17/2015.
 */
public class RecipeVH extends RecyclerView.ViewHolder {
    public TextView txvName;
    public ImageView imgPicture;

    public RecipeVH(View itemView) {
        super(itemView);
        txvName=(TextView) itemView.findViewById(R.id.item_recipe_name);
//        imgPicture=(ImageView) itemView.findViewById(R.id.item_recipe_img);
    }
}

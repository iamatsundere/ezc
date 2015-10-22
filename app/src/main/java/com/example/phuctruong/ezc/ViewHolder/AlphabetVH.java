package com.example.phuctruong.ezc.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.phuctruong.ezc.R;

/**
 * Created by Phuc Truong on 10/17/2015.
 */
public class AlphabetVH extends RecyclerView.ViewHolder {
    public TextView txvTagName;

    public AlphabetVH(View itemView) {
        super(itemView);
        txvTagName=(TextView) itemView.findViewById(R.id.txv_tagname);
    }
}

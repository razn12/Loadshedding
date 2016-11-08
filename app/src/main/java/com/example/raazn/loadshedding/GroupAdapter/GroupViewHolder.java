package com.example.raazn.loadshedding.GroupAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.raazn.loadshedding.R;

/**
 * Created by raazn on 25-Oct-16.
 */

public class GroupViewHolder extends RecyclerView.ViewHolder {

    public TextView t1,t2,t3,t4;
    ImageView bulb;
    public GroupViewHolder(View v) {
        super(v);
        t1=(TextView)v.findViewById(R.id.day);
        t2=(TextView)v.findViewById(R.id.phase1);
        t3=(TextView)v.findViewById(R.id.phase2);
        bulb=(ImageView)v.findViewById(R.id.bulb);
        t4=(TextView)v.findViewById(R.id.tim);

    }
}

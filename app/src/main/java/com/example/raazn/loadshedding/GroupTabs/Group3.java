package com.example.raazn.loadshedding.GroupTabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.raazn.loadshedding.GroupAdapter.GroupAdapter;
import com.example.raazn.loadshedding.GroupAdapter.StatusCheck;
import com.example.raazn.loadshedding.R;

/**
 * Created by raazn on 15-Oct-16.
 */
public class Group3 extends Fragment {
    private RecyclerView mRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.activity_group, container, false);
        mRecyclerView=(RecyclerView) v.findViewById(R.id.recycleView);
        TextView t=(TextView)v.findViewById(R.id.timer);
        ImageView light=(ImageView)v.findViewById(R.id.light);
        TextView grp=(TextView)v.findViewById(R.id.grp);
        TextView p1=(TextView)v.findViewById(R.id.p1);
        TextView p2=(TextView)v.findViewById(R.id.p2);
        StatusCheck statusCheck =new StatusCheck(3,t,v.getContext(), light, grp, p1, p2);
        statusCheck.setStatus();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        mRecyclerView.setAdapter(new GroupAdapter(v.getContext(),3));
        return v;
    }
}

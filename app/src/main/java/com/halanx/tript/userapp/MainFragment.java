package com.halanx.tript.userapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    Button but1;
    private RecyclerView recyclerView;
    private Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //using the button in frag
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        but1 = (Button) rootView.findViewById(R.id.item_container);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , Item.class);
                startActivity(intent);
            }
        });
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        adapter=new Adapter(getActivity(),getData());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager myLinearLayout = new LinearLayoutManager(getActivity());
        myLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(myLinearLayout);
        return rootView;
    }

    public static List<Info> getData(){
        List<Info> data = new ArrayList<>();
        int icon_id[] = {R.drawable.ic_menu_camera,
                R.drawable.ic_menu_gallery ,
                R.drawable.ic_menu_send,
                R.drawable.ic_menu_share };
        String text[] = {"item1" , "item2", "item3", "item4"};
        for (int i=0; i<icon_id.length && i<text.length;i++){
            Info current = new Info();
            current.icon_id = icon_id[i];
            current.title = text[i];
            data.add(current);
        }
        return data;
    }
}
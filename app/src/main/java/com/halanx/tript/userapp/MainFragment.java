package com.halanx.tript.userapp;

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
public class MainFragment extends Fragment implements Adapter.ClickListener {
    Button but1;
    private RecyclerView recyclerView, recyclerView2;
    private Adapter adapter,adapter2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //using the button in frag
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        adapter=new Adapter(getActivity(),getData());
        adapter.setClickListener(this);


        recyclerView.setAdapter(adapter);
        LinearLayoutManager myLinearLayout = new LinearLayoutManager(getActivity());
        myLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(myLinearLayout);

        recyclerView2 = (RecyclerView) rootView.findViewById(R.id.recycler2);
        adapter2=new Adapter(getActivity(),getData());
        recyclerView2.setAdapter(adapter2);
        LinearLayoutManager myLinearLayout2 = new LinearLayoutManager(getActivity());
        myLinearLayout2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(myLinearLayout2);


        return rootView;
    }

    public static List<Info> getData(){
        List<Info> data = new ArrayList<>();
        int icon_id[] = {R.drawable.a,
                R.drawable.b ,
                R.drawable.c,
                R.drawable.d };
        String text[] = {"item1" , "item2", "item3", "item4"};
        for (int i=0; i<icon_id.length && i<text.length;i++){
            Info current = new Info();
            current.icon_id = icon_id[i];
            current.title = text[i];
            data.add(current);
        }
        return data;
    }

    @Override
    public void itemClicked(View view, int position){
        startActivity(new Intent(getActivity(),Item.class));
    }
}
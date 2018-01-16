package com.msapps.allin;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

/**
 * Created by Maninder on 3/26/2017.
 */

public class SearchFragment extends Fragment {
    private ArrayList<Contact> searchableUsers = new ArrayList<>();
    private boolean initialized = false;
    public SearchFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_search,container,false);
        if(!initialized) {
            searchableUsers.add(new Contact("@UCLA", R.drawable.general_logo));
            searchableUsers.add(new Contact("@DECAICDC", R.drawable.general_logo));
            searchableUsers.add(new Contact("@UofT", R.drawable.general_logo));
            searchableUsers.add(new Contact("@UWaterloo", R.drawable.general_logo));
            searchableUsers.add(new Contact("@Stanford", R.drawable.general_logo));
            searchableUsers.add(new Contact("@Harvard", R.drawable.general_logo));
            initialized = true;
        }

        fillView(rootView);
        return rootView;
    }

    public void fillView(View view){
        SearchAdapter adapter = getAdapter(view);
        ListView listView = (ListView) view.findViewById(R.id.search_list);
        if(listView != null) {
            listView.setAdapter(adapter);
        }
    }
    public SearchAdapter getAdapter(View view){
        SearchView searchView = (SearchView) view.findViewById(R.id.search_bar);
        String query = searchView.getQuery().toString();
        return new SearchAdapter(getActivity(),searchableUsers,query);
    }
}

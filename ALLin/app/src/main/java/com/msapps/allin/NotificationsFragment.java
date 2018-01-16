package com.msapps.allin;

import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Maninder on 3/26/2017.
 */

public class NotificationsFragment extends Fragment{
    private ArrayList<Contact> contactRequests = new ArrayList<>();
    private ArrayList<Contact> contactsAdded;
    boolean initialized = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_notifications,container,false);
        if(!initialized) {
            contactRequests.add(new Contact("Bill Gates", R.drawable.general_logo));
            contactRequests.add(new Contact("Steve Jobs", R.drawable.general_logo));
            contactRequests.add(new Contact("Justin Trudeau", R.drawable.general_logo));
            contactRequests.add(new Contact("Donald Trump", R.drawable.general_logo));
            contactRequests.add(new Contact("Michael Jordan", R.drawable.general_logo));
            contactRequests.add(new Contact("John Doe", R.drawable.general_logo));
            initialized = true;
        }
        fillView(rootView);
        return rootView;
    }

    public void fillView(View view){
        NotificationsAdapter adapter = new NotificationsAdapter(getActivity(), contactRequests,contactsAdded);
        ListView listView = (ListView) view.findViewById(R.id.notifications_list_view);
        if(listView != null) {
            listView.setAdapter(adapter);
        }
    }
    public void setContacts(ArrayList<Contact> contactsList){
        contactsAdded = contactsList;
    }
}

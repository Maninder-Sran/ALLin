package com.msapps.allin;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Maninder on 3/26/2017.
 */

public class ContactsFragment extends Fragment{
    private ArrayList<Contact> contacts;
    private ArrayList<ContactInfo> accounts;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_contacts,container,false);

        fillView(rootView);
        return rootView;
    }

    public void fillView(View view){
        ContactsAdapter adapter = new ContactsAdapter(getActivity(), contacts,accounts);
        ListView listView = (ListView) view.findViewById(R.id.contacts_list);
        if(listView != null) {
            listView.setAdapter(adapter);
        }
    }
    public void setContacts(ArrayList<Contact> contactsList,ArrayList<ContactInfo> accounts){
        contacts = contactsList;
        this.accounts = accounts;
    }
}

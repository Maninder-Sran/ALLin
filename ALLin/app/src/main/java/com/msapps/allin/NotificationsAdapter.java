package com.msapps.allin;

import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Maninder on 4/25/2017.
 */

public class NotificationsAdapter extends ArrayAdapter<Contact> {
    Context context;
    ArrayList<Contact> contacts;
    public NotificationsAdapter (Activity context, ArrayList<Contact> contactRequests, ArrayList<Contact> contacts){
        super(context,0,contactRequests);
        this.context = context;
        this.contacts = contacts;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null){
           listItemView = LayoutInflater.from(getContext()).inflate(R.layout.notifications_list_item,parent,false);
        }
        final Contact contactRequest = getItem(position);

        Button acceptButton = (Button) listItemView.findViewById(R.id.accept_button);
        acceptButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                contacts.add(contactRequest);
                remove(contactRequest);
            }
        });

        Button declineButton = (Button) listItemView.findViewById(R.id.decline_button);
        declineButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                remove(contactRequest);

            }
        });

        TextView contactRequestName =  (TextView) listItemView.findViewById(R.id.notifications_contact_name);
        contactRequestName.setText(contactRequest.getName());

        ImageView pictureView = (ImageView) listItemView.findViewById(R.id.picture_view);
        if(contactRequest.getImageResourceId() == 0){
            pictureView.setVisibility(View.GONE);
        }
        pictureView.setImageResource(contactRequest.getImageResourceId());

        return listItemView;
    }
}

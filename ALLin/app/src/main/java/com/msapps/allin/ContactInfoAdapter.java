package com.msapps.allin;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Maninder on 4/24/2017.
 */

public class ContactInfoAdapter extends ArrayAdapter<ContactInfo> {

    public ContactInfoAdapter(Activity context, ArrayList<ContactInfo> contactInfos){
        super(context,0,contactInfos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.profile_list_item,parent,false);
        }
        ContactInfo contactInfo = getItem(position);

        TextView accountType =  (TextView) listItemView.findViewById(R.id.account_type);
        accountType.setText(contactInfo.getAccountType());

        TextView accountName = (TextView) listItemView.findViewById(R.id.account_name);
        accountName.setText(contactInfo.getAccountName());

        ImageView logoView = (ImageView) listItemView.findViewById(R.id.logo_view);
        if(contactInfo.getLogo() == 0){
            logoView.setVisibility(View.GONE);
        }
        logoView.setImageResource(contactInfo.getLogo());

        return listItemView;
    }
}

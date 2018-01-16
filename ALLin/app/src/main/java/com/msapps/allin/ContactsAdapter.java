package com.msapps.allin;

import android.app.Activity;
import android.app.Dialog;
import android.support.annotation.IdRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.accountType;

/**
 * Created by Maninder on 4/25/2017.
 */

public class ContactsAdapter extends ArrayAdapter<Contact> {
    private ArrayList<ContactInfo> accounts;
    private ArrayList<Contact> contacts;

    public ContactsAdapter (Activity context, ArrayList<Contact> contacts, ArrayList<ContactInfo> accounts){
        super(context,0,contacts);
        this.accounts = accounts;
        this.contacts = contacts;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.contacts_list_item,parent,false);
        }
        final Contact contact = getItem(position);

        Button editButton = (Button) listItemView.findViewById(R.id.edit_button);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRadioButtonDialog(accounts,contacts,position);
            }
        });
        TextView contactName =  (TextView) listItemView.findViewById(R.id.contact_name);
        contactName.setText(contact.getName());

        ImageView profilePicture = (ImageView) listItemView.findViewById(R.id.profile_picture);
        if(contact.getImageResourceId() == 0){
            profilePicture.setVisibility(View.GONE);
        }
        profilePicture.setImageResource(contact.getImageResourceId());

        return listItemView;
    }

    private void showRadioButtonDialog(ArrayList<ContactInfo> accounts, final ArrayList<Contact> contacts, int position) {
        final int index = position;
        final Dialog dialog = new Dialog(getContext());

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.contacts_settings_radio_dialog);


        RadioButton r1 = (RadioButton) dialog.findViewById(R.id.radio_general);
        RadioButton r2 = (RadioButton) dialog.findViewById(R.id.radio_facebook);
        RadioButton r3 = (RadioButton) dialog.findViewById(R.id.radio_twitter);
        RadioButton r4 = (RadioButton) dialog.findViewById(R.id.radio_snapchat);
        RadioButton r5 = (RadioButton) dialog.findViewById(R.id.radio_linkedin);

        r1.setVisibility(View.GONE);
        r2.setVisibility(View.GONE);
        r3.setVisibility(View.GONE);
        r4.setVisibility(View.GONE);
        r5.setVisibility(View.GONE);

        for(ContactInfo contactInfo : accounts){
            if(contactInfo.getAccountType().equals("General")){
                r1.setVisibility(View.VISIBLE);
            }else if(contactInfo.getAccountType().equals("Facebook")){
                r2.setVisibility(View.VISIBLE);
            }else if(contactInfo.getAccountType().equals("Twitter")){
                r3.setVisibility(View.VISIBLE);
            }else if(contactInfo.getAccountType().equals("Snapchat")){
                r4.setVisibility(View.VISIBLE);
            }else if(contactInfo.getAccountType().equals("LinkedIn")){
                r5.setVisibility(View.VISIBLE);
            }
        }
        Button deleteButton = (Button) dialog.findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                remove(contacts.get(index));
                dialog.hide();
            }
        });
        dialog.show();
    }
}

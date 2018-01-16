package com.msapps.allin;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Maninder on 4/26/2017.
 */

public class SearchAdapter extends ArrayAdapter<Contact> {
    private Context context;
    private String query = null;

    public SearchAdapter(Activity context, ArrayList<Contact> users, String query) {
        super(context, 0, users);
        this.context = context;
        this.query = query;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.search_list_item, parent, false);
        }
        final Contact user = getItem(position);

        Button addButton = (Button) listItemView.findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove(user);
            }
        });

        TextView userName = (TextView) listItemView.findViewById(R.id.user_name);
        userName.setText(user.getName());

        ImageView pictureView = (ImageView) listItemView.findViewById(R.id.profile_picture);
        if (user.getImageResourceId() == 0) {
            pictureView.setVisibility(View.GONE);
        }
        pictureView.setImageResource(user.getImageResourceId());
        return listItemView;
    }
}

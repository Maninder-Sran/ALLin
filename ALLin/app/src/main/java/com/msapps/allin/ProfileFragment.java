package com.msapps.allin;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.hardware.display.DisplayManagerCompat;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.accountType;


/**
 * Created by Maninder on 3/26/2017.
 */

public class ProfileFragment extends Fragment{
    private DisplayMetrics dm = new DisplayMetrics();
    private ArrayList<ContactInfo> info;
    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        rootView = inflater.inflate(R.layout.fragment_profile,container,false);
        LinearLayout editButton = (LinearLayout) rootView.findViewById(R.id.profile_page);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRadioButtonDialog();
            }
        });

        fillView(rootView);

        return rootView;
    }
    private void showRadioButtonDialog() {

        final Dialog dialog = new Dialog(getActivity());

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.radiobutton_dialog);

        final RadioGroup rg = (RadioGroup) dialog.findViewById(R.id.radio_group);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int selectedId = rg.getCheckedRadioButtonId();

                RadioButton r1 = (RadioButton) rg.findViewById(R.id.radio_general);
                RadioButton r2 = (RadioButton) rg.findViewById(R.id.radio_facebook);
                RadioButton r3 = (RadioButton) rg.findViewById(R.id.radio_twitter);
                RadioButton r4 = (RadioButton) rg.findViewById(R.id.radio_snapchat);
                RadioButton r5 = (RadioButton) rg.findViewById(R.id.radio_linkedin);

                if(r1.isChecked()){
                    addAccount(new GeneralInfo(R.drawable.general_logo,"General"));
                }
                if(r2.isChecked()){
                    addAccount(new Facebook(R.drawable.facebook_logo,"Facebook"));
                }
                if(r3.isChecked()){
                    addAccount(new Twitter(R.drawable.twitter_logo,"Twitter"));
                }
                if(r4.isChecked()){
                    addAccount(new Snapchat(R.drawable.snapchat_logo,"Snapchat"));
                }
                if(r5.isChecked()){
                    addAccount(new LinkedIn(R.drawable.linkedin_logo,"LinkedIn"));
                }
                dialog.hide();
            }
        });
        dialog.show();
    }
    public void addAccount(ContactInfo accountType){
        info.add(accountType);
        fillView(rootView);
    }
    public void setAccounts(ArrayList<ContactInfo> accounts){
        this.info = accounts;
    }
    public void fillView(View view){
        ContactInfoAdapter adapter = new ContactInfoAdapter(getActivity(), info);
        final ListView listView = (ListView) view.findViewById(R.id.profile_info_list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String accountType = info.get(i).getAccountType();

                Intent intent = new Intent(getActivity(), EditActivity.class);

                intent.putExtra("Item Number",String.valueOf(i));
                intent.putExtra("Account Type",accountType);
                intent.putExtra("Account Name",info.get(i).getAccountName());
                intent.putExtra("Email",info.get(i).getEmail());

                if(accountType.equals("Facebook") || accountType.equals("Twitter")){

                    intent.putExtra("Website", info.get(i).getWebsite());

                }else if(accountType.equals("LinkedIn")){

                    intent.putExtra("Phone Number", info.get(i).getPhoneNumber());
                    intent.putExtra("Website", info.get(i).getWebsite());

                }else if(accountType.equals("General")){

                    intent.putExtra("Phone Number", info.get(i).getPhoneNumber());
                    intent.putExtra("Address",info.get(i).getAddress());

                }
                startActivityForResult(intent,1);
            }
        });
        if(listView != null) {
            listView.setAdapter(adapter);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                String accountType = data.getStringExtra("Account Type");
                int itemNumber = Integer.valueOf(data.getStringExtra("Item Number"));

                info.get(itemNumber).setEmail(data.getStringExtra("Email"));
                info.get(itemNumber).setAccountName(data.getStringExtra("Account Name"));

                if (accountType.equals("Facebook") || accountType.equals("Twitter")) {

                    info.get(itemNumber).setWebsite(data.getStringExtra("Website"));

                } else if (accountType.equals("LinkedIn")) {

                    info.get(itemNumber).setPhoneNumber(data.getStringExtra("Phone Number"));
                    info.get(itemNumber).setWebsite(data.getStringExtra("Website"));

                } else if (accountType.equals("General")) {

                    info.get(itemNumber).setPhoneNumber(data.getStringExtra("Phone Number"));
                    info.get(itemNumber).setAddress(data.getStringExtra("Address"));

                }
            }
        }
    }
}

package com.msapps.allin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.R.attr.accountType;
import static android.R.attr.key;
import static android.R.attr.queryActionMsg;

public class EditActivity extends AppCompatActivity {
    private String itemNumber;
    private String accountType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText accountNameView = (EditText) findViewById(R.id.edit_account_name);
        EditText emailView = (EditText) findViewById(R.id.edit_email);
        EditText phoneNumberView = (EditText) findViewById(R.id.edit_phone_number);
        EditText addressView = (EditText) findViewById(R.id.edit_address);
        EditText websiteView = (EditText) findViewById(R.id.edit_website_url);

        this.accountType = retrieveData(savedInstanceState, "Account Type");
        this.itemNumber = retrieveData(savedInstanceState, "Item Number");
        getSupportActionBar().setTitle(accountType);
        if (accountType.equals("Facebook") || accountType.equals("Twitter")) {

            accountNameView.setText(retrieveData(savedInstanceState, "Account Name"));
            emailView.setText(retrieveData(savedInstanceState, "Email"));
            websiteView.setText(retrieveData(savedInstanceState, "Website"));

            findViewById(R.id.phone_number_forum).setVisibility(View.GONE);
            findViewById(R.id.address_forum).setVisibility(View.GONE);

        } else if (accountType.equals("Snapchat")) {

            accountNameView.setText(retrieveData(savedInstanceState, "Account Name"));
            emailView.setText(retrieveData(savedInstanceState, "Email"));

            findViewById(R.id.phone_number_forum).setVisibility(View.GONE);
            findViewById(R.id.address_forum).setVisibility(View.GONE);
            findViewById(R.id.website_forum).setVisibility(View.GONE);

        } else if (accountType.equals("LinkedIn")) {

            accountNameView.setText(retrieveData(savedInstanceState, "Account Name"));
            emailView.setText(retrieveData(savedInstanceState, "Email"));
            phoneNumberView.setText(retrieveData(savedInstanceState, "Phone Number"));
            websiteView.setText(retrieveData(savedInstanceState, "Website"));

            findViewById(R.id.address_forum).setVisibility(View.GONE);

        } else if (accountType.equals("General")) {

            accountNameView.setText(retrieveData(savedInstanceState, "Account Name"));
            emailView.setText(retrieveData(savedInstanceState, "Email"));
            phoneNumberView.setText(retrieveData(savedInstanceState, "Phone Number"));
            addressView.setText(retrieveData(savedInstanceState, "Address"));

            findViewById(R.id.website_forum).setVisibility(View.GONE);
        }

        Button saveButton = (Button) findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnData();
            }
        });
    }

    public String retrieveData(Bundle savedInstanceState, String key) {
        String result;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                result = null;
            } else {
                result = extras.getString(key);
            }
        } else {
            result = (String) savedInstanceState.getSerializable(key);
        }
        return result;
    }

    public void returnData() {

        EditText accountNameView = (EditText) findViewById(R.id.edit_account_name);
        EditText emailView = (EditText) findViewById(R.id.edit_email);
        EditText phoneNumberView = (EditText) findViewById(R.id.edit_phone_number);
        EditText addressView = (EditText) findViewById(R.id.edit_address);
        EditText websiteView = (EditText) findViewById(R.id.edit_website_url);

        Intent returnIntent = new Intent();
        returnIntent.putExtra("Account Type", this.accountType);
        returnIntent.putExtra("Item Number", this.itemNumber);
        returnIntent.putExtra("Email",emailView.getText().toString());
        returnIntent.putExtra("Account Name", accountNameView.getText().toString());

        if (accountType.equals("Facebook") || accountType.equals("Twitter")) {

            returnIntent.putExtra("Website", websiteView.getText().toString());

        } else if (accountType.equals("LinkedIn")) {

            returnIntent.putExtra("Phone Number", phoneNumberView.getText().toString());
            returnIntent.putExtra("Website", websiteView.getText().toString());

        } else if (accountType.equals("General")) {

            returnIntent.putExtra("Phone Number", phoneNumberView.getText().toString());
            returnIntent.putExtra("Address", addressView.getText().toString());

        }
        setResult(Activity.RESULT_OK, returnIntent);
        Toast.makeText(getApplicationContext(), "Information Saved",Toast.LENGTH_SHORT).show();
        finish();
    }
}

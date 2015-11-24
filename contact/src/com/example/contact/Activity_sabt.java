package com.example.contact;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by hassan on 11/24/2015.
 */
public class Activity_sabt extends Activity {
    Long tempId = null;
    EditText textName;
    EditText txtfname;

    private ContactHelper contactHelper;
    ContactAdapter contactAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sabt);


        contactHelper = new ContactHelper(this);


        textName = (EditText) findViewById(R.id.name);
        txtfname=(EditText)findViewById(R.id.fname);
        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact contact = new Contact();
                contact.id = tempId;
                contact.name = textName.getText().toString();
                contact.fname=txtfname.getText().toString();
                if (tempId == null) {
                    contactHelper.Add(contact);
                } else {
                    contactHelper.update(contact);
                }
                tempId = null;
                textName.setText("");
                txtfname.setText("");
                contactAdapter.setContactArrayList(contactHelper.getAll());
                contactAdapter.notifyDataSetChanged();
                ListView listView = (ListView) findViewById(R.id.list1);
                listView.setAdapter(contactAdapter);
                startActivity(new Intent(Activity_sabt.this,MyActivity.class));
            }
        });
    }

}

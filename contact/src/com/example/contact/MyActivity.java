package com.example.contact;

import android.app.Activity;
import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    Long tempId = null;
    EditText textName;
    EditText txtfname;
    private ContactHelper contactHelper;
    ContactAdapter contactAdapter;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.edit().putString("active", "yes").commit();

        contactHelper = new ContactHelper(this);

        ListView listView = (ListView) findViewById(R.id.list1);
        contactAdapter = new ContactAdapter(MyActivity.this,contactHelper.getAll());
        listView.setAdapter(contactAdapter);

        Button btn=(Button)findViewById(R.id.btnadd);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyActivity.this, Activity_sabt.class);
                startActivity(intent);

            }
        });

    }

    public void EditContact(Contact contact){
        tempId = contact.id;
        textName.setText(contact.name);
        txtfname.setText(contact.fname);
    }
    public void DeleteContact(Contact contact) {
        contactHelper.delete(contact.id);
        contactAdapter.setContactArrayList(contactHelper.getAll());
        contactAdapter.notifyDataSetChanged();
    }


}

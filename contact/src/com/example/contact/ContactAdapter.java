package com.example.contact;


import android.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {
    private  MyActivity activity;
    private ArrayList<Contact> contactArrayList;




    public ContactAdapter(MyActivity activity, ArrayList<Contact> contactArrayList) {
        this.activity = activity;
        this.contactArrayList = contactArrayList;
    }


    public void setContactArrayList(ArrayList<Contact> contactArrayList){
        this.contactArrayList = contactArrayList;
    }

    @Override
    public int getCount() {
        return contactArrayList.size();
    }

    @Override
    public Contact getItem(int i) {
        return contactArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if (view == null){

            view = LayoutInflater.from(activity).inflate(R.layout.list_item, viewGroup, false);
            holder = new Holder();
            holder.txtID = (TextView) view.findViewById(R.id.item_id);
            holder.txtName = (TextView) view.findViewById(R.id.item_name);
            holder.btnDelete = (Button) view.findViewById(R.id.btnRemove);
            holder.btnEdit = (Button) view.findViewById(R.id.btnEdit);
            holder.txtfname=(TextView)view.findViewById(R.id.fname);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }
        final Contact contact = contactArrayList.get(i);
        holder.txtID.setText(contact.id + "");
        holder.txtName.setText(contact.name);


        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog = new AlertDialog.Builder(activity)
                        .setTitle("Are you sure?")
                        .setMessage("Name: " + contact.name)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                activity.DeleteContact(contact);
                            }
                        })
                        .setNegativeButton("No", null)
                        .create();
                dialog.show();
            }
        });

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        return view;
    }

    public class Holder{
        TextView txtfname,txtName, txtID;
        Button btnEdit, btnDelete;
    }
}

package com.example.contact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class ContactHelper {
    private DBHelper dbHelper;

    public ContactHelper(Context context){
        dbHelper = new DBHelper(context);
    }

    public long Add(Contact contact){
        ContentValues c = new ContentValues();
        c.put("name", contact.name);
        dbHelper.openDB();
        long a = dbHelper.db.insert(DBHelper.CONTACTS_TABLE_NAME, null, c);
        dbHelper.closeDB();
        return a;
    }

    public ArrayList<Contact> getAll(){
        dbHelper.openDB();
        Cursor cursor = dbHelper.db.rawQuery("SELECT * FROM " + DBHelper.CONTACTS_TABLE_NAME, null);
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        if (cursor.moveToFirst()){
            do {
                Contact contact = new Contact();
                contact.id = cursor.getLong(cursor.getColumnIndex("id"));
                contact.name = cursor.getString(cursor.getColumnIndex("name"));
                contacts.add(contact);
            } while (cursor.moveToNext());

        }
        dbHelper.closeDB();
        return contacts;
    }

    public Contact getContact(long id){
        dbHelper.openDB();
        Cursor cursor = dbHelper.db.rawQuery("SELECT * FROM " + DBHelper.CONTACTS_TABLE_NAME + " WHERE id = ? ",
                new String[]{String.valueOf(id)});
        if (cursor.moveToFirst()){
            Contact contact = new Contact();
            contact.id = cursor.getLong(cursor.getColumnIndex("id"));
            contact.name = cursor.getString(cursor.getColumnIndex("name"));
            contact.fname=cursor.getString(cursor.getColumnIndex("fname"));
            dbHelper.closeDB();
            return contact;
        }
        return null;
    }

    public void update(Contact contact){
        dbHelper.openDB();
        ContentValues c = new ContentValues();
        c.put("name", contact.name);
        c.put("fname",contact.fname);
        dbHelper.db.update(DBHelper.CONTACTS_TABLE_NAME, c, " id = ? ", new String[]{String.valueOf(contact.id)});
        dbHelper.closeDB();
    }

    public void delete(long id){
        dbHelper.openDB();
        dbHelper.db.delete(DBHelper.CONTACTS_TABLE_NAME, " id = ? ", new String[]{String.valueOf(id)});
        dbHelper.closeDB();
    }
}

package com.claireshu.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    EditText etEditItem;
    int position; // saves the position in the array of the item being edited

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        // position and string data sent from the main screen of the todo list
        position = getIntent().getIntExtra("position", 0);
        String item = getIntent().getStringExtra("item");

        // sets up the edit text field, handles putting cursor at the end
        etEditItem = (EditText) findViewById(R.id.etEditItem);
        etEditItem.setText(item);
        etEditItem.setSelection(etEditItem.getText().length());

    }


    public void onAddItem(View view) {
        // gets text from field
        etEditItem = (EditText) findViewById(R.id.etEditItem);
        String newItem = etEditItem.getText().toString();

        // sends data back to main activity
        Intent data = new Intent();
        data.putExtra("item", newItem);
        data.putExtra("position", position);
        setResult(RESULT_OK, data);
        finish();
    }

}


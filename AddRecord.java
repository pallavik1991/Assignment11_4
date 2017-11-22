package com.example.akaash.assignment11_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddRecord extends AppCompatActivity {

    private EditText ed_fname,ed_lname;
    private Button btnadd;
    String var_fname,var_lname;
    DbHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        db=new DbHandler(AddRecord.this);
        ed_fname=(EditText)findViewById(R.id.ed_fname);
        ed_lname=(EditText)findViewById(R.id.ed_lname);
        btnadd=(Button)findViewById(R.id.btnadd);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                var_fname=ed_fname.getText().toString();
                var_lname=ed_lname.getText().toString();
                db.insert(new Person(var_fname,var_lname));
                Toast.makeText(getApplicationContext(),"Added successfully",Toast.LENGTH_LONG).show();
            }
        });
    }
}

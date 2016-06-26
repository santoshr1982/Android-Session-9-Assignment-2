package com.alertdialogbox1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlertDialogBoxTest extends AppCompatActivity implements View.OnClickListener {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_box_test);

        mButton = (Button) findViewById(R.id.show_alert_dialog);

        mButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        final AlertDialog.Builder aleBuilder = new AlertDialog.Builder(this,R.style.CustomDialog);

        Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_SHORT).show();

        aleBuilder.setTitle("Confirm Delete...");
        aleBuilder.setMessage("Are you sure you want to delete this?");


        aleBuilder.setIcon(R.drawable.cancel);

        aleBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(getApplicationContext(), "Deleted..."+i, Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });

        aleBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(getApplicationContext(),"Will not be deleted."+i,Toast.LENGTH_SHORT).show();
                dialogInterface.cancel();

            }
        });

        aleBuilder.setCancelable(false);
        aleBuilder.create();
        aleBuilder.show();


    }
}

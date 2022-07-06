package com.example.internetchecket;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView= findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo= connectivityManager.getActiveNetworkInfo();

            if (networkInfo!=null && networkInfo.isConnected()){
                textView.setText("Internet is Connected!");
            }

//            else {
//                textView.setText("No Internet !");
//            }
//            ************  We can also show a warning if there is no internet ***********
                else {

                   textView.setText("");
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("No Internet !")
                            .setMessage("Please connect to internet")
                            .show();


            }




            }
        });
    }

    // ++++++++++++++++++++++++++++ overRide+++++++++++++++++++++++++++++

// ----------------Exiting App Alert start ----------------------------
    @Override
    public void onBackPressed() {
       // super.onBackPressed();   //with this line \\\ super.onBackPressed(); /// program kick you out from the App.

    new AlertDialog.Builder(MainActivity.this)
            .setTitle("Confirm Exit")
            .setMessage("Do you really want to exit?")
            .setIcon(R.drawable.alert_icon)

            // we took 2 button "" setNegativeButton"" and "" setPositiveButton"" in this alert dialogue.
            .setNegativeButton("NO Thanks", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            })
            .setPositiveButton("Yes, Exit!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    finishAndRemoveTask();
                }
            })
            // 2 button ends here


            .show();

    }



// ----------------- Exiting app Alert finish----------------------------
}
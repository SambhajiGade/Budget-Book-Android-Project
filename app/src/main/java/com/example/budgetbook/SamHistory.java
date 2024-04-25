package com.example.budgetbook;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.budgetbook.MainActivity;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SamHistory extends AppCompatActivity {

    public static ArrayList<String> sam = new ArrayList<>();
    public static ArrayList<String> sam1 = new ArrayList<>();

   private DialogInterface.OnClickListener dialogClickListener;

    public ListView lv ;

    public void addsam(sample sp)
    {
//        this.sam.clear();
//        this.sam1.clear();

        this.sam = sp.getSam();
        this.sam1 = sp.getSam1();

    }

    @Override
      public void onBackPressed(){
        this.sam.clear();
        this.sam1.clear();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sam_history);

        lv = findViewById(R.id.listview);

        History_page s = new History_page(this,R.layout.history_xml,sam,sam1);
        lv.setAdapter(s);

    }

    public void s(int i){

    }

    public void DeleteAction(int index){
//        AlertDialog.Builder builder;
//        builder = new AlertDialog.Builder(this);
//      //  builder.setMessage("Are You sure to delete?");
//
//        //Setting message manually and performing action on button click
//        builder.setMessage("Are You sure to delete?")
//                .setCancelable(false)
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        //  Action for 'Yes' Button
//                        //exit application
//                    //    finish();
//                     //   System.exit(0);
//                      int a =  new MainActivity().deleted(index);
//                    }
//                })
//                .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        //  Action for 'No' Button
//                      //  Toast.makeText(getApplicationContext(),"Cancel",Toast.LENGTH_SHORT).show();
//
//                    }
//                });
//        //Creating dialog box
//        AlertDialog alert = builder.create();
//        //Setting the title manually
//        alert.setTitle("SAM");
//        alert.show();


        // on below line we are creating a builder variable for our alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        // on below line we are setting message for our dialog box.
        builder.setMessage("Select yes to display toast message and no to dismiss the dialog ?")
                // on below line we are setting positive button
                // and setting text to it.
                .setPositiveButton("Yes", dialogClickListener)
                // on below line we are setting negative button
                // and setting text to it.
                .setNegativeButton("No", dialogClickListener)
                // on below line we are calling
                // show to display our dialog.
                .show();

    }

/*
    public void setdata(ArrayList<String> sam,ArrayList<String> sam1){
        this.sam = sam;
        this.sam1 = sam1;
    }

    public ArrayList<String> get1(){
        return sam;
    }

    public ArrayList<String> get2(){
        return sam1;
    }
*/
}
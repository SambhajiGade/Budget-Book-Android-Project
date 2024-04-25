package com.example.budgetbook;

import static java.util.Objects.*;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Objects;

public class History_page extends ArrayAdapter<String> {


    public ArrayList<String> sam;
    public ArrayList<String> sam1;
    private Context con;

   // public String [] sam1;

    public History_page(@NonNull Context context, int resource,@NonNull ArrayList<String> sam ,@NonNull ArrayList<String> sam1){
        super( context, resource, sam);
        //super(context,resource,sam);

        con = context;
        this.sam= sam;
        this.sam1= sam1;
    }
/*
    public History_page(@NonNull Context context, int resource,@NonNull ArrayList<String> sam ,@NonNull String[] sam1){
        super( context, resource, sam);
        //super(context,resource,sam);

        con = context;
        this.sam= sam;
        this.sam1= sam1;
    }
*/

    @Nullable
    @Override
    public String getItem(int position) {
        return sam.get(position);
    }

    @Nullable
    public String getItem1(int position) {
        return sam1.get(position);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.history_xml, parent, false);

        TextView tv = convertView.findViewById(R.id.textView5);
         TextView tv1 = convertView.findViewById(R.id.textView2);
        tv.setText(getItem(position));
        tv1.setText(getItem1(position));

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   Toast.makeText(con, "This is " + position, Toast.LENGTH_SHORT).show();
             //   new SamHistory().DeleteAction(position);
            }
        });


        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(con,"Long pressed : "+position, Toast.LENGTH_SHORT).show();
             new SamHistory().DeleteAction(position);
               return true;
            }
        });


        return convertView;

    }
}

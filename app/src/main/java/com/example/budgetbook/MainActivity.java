package com.example.budgetbook;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
// import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.timepicker.TimeFormat;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity
{

    Button save, clearall;
    EditText notepad, rs;
    RadioButton credit, debit, online, offline;
    RadioGroup rd2, rd3;
    ImageButton history;


    Spinner sp;
    int g = 0;
    Boolean f;

    String Upi,Time,cdate,ctime;
    String mode = "Select UPI";
    String d2 = "Select Date Here...";

    ArrayList<String> upi = new ArrayList<>();


    TextView Date;
    DatePickerDialog.OnDateSetListener setListener;
    int d,m,y,M=3;

   public ArrayList<String> sam_data1 = new ArrayList<String>();
    public ArrayList<String> sam_data2 = new ArrayList<String>();

    db_data db = new db_data(this, "sam", null, 1);
    SamHistory sh = new SamHistory();


    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = findViewById(R.id.spinner);

        save = findViewById(R.id.save);
        clearall = findViewById(R.id.All_Clear);
        history = findViewById(R.id.history);

        Date = findViewById(R.id.Date);
        notepad = findViewById(R.id.NotePad);
        rs = findViewById(R.id.Rs);

        rd2 = findViewById(R.id.onof);
        rd3 = findViewById(R.id.CD);

        credit = findViewById(R.id.credit);
        debit = findViewById(R.id.debit);

        online = findViewById(R.id.online);
        offline = findViewById(R.id.offline);

        rd2.setVisibility(View.GONE);
        sp.setVisibility(View.GONE);

     //   db_data db = new db_data(this, "sam", null, 1);


        Calendar calendar = Calendar.getInstance();
        final int Year = calendar.get(Calendar.YEAR);
        final int Month = calendar.get(Calendar.MONTH);
        final int Day = calendar.get(Calendar.DAY_OF_MONTH);

        M = calendar.get(Calendar.MONTH);

        cdate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        ctime = DateFormat.getTimeInstance(TimeFormat.CLOCK_12H).format(calendar.getTime());
        Time = cdate +" "+ ctime;






        Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, android.R.style.
                        Theme_Holo_Light_Dialog_MinWidth,setListener,Year,Month,Day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1+1;
                M=Month;
                M+=1;
                d=i2;
                m=i1;
                y=i;
                String d3 = i2 + "/" + i1 + "/" + i;
                Date.setText(d3);

             //   notepad.setText(Time);
            }
        };


        credit.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view)
            {
                rd2.setVisibility(View.VISIBLE);
            }
        });

        debit.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view)
            {
                rd2.setVisibility(View.VISIBLE);
            }
        });

        online.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view)
            {
                sp.setVisibility(View.VISIBLE);
            }
        });

        offline.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view)
            {
                sp.setVisibility(View.GONE);
            }
        });


//        ArrayList<String> upi = new ArrayList<>();
        upi.add("Select UPI");
        upi.add("GPAY");
        upi.add("PhonePe");
        upi.add("Paytm");
        upi.add("Amazon Pay");
        upi.add("WhatsApp");

        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, upi);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(ad);


        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                Upi = adapterView.getItemAtPosition(i).toString();
                if (Upi.equals(mode))
                {
                    g = 0;
                }
                else
                {
                    Toast.makeText(adapterView.getContext(), "Selected : " + Upi, Toast.LENGTH_SHORT).show();
                    g = 1;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
                g = 0;
            }
        });


        clearall.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view)
            {
                Date.setText(d2);
                rs.setText("");
                notepad.setText("");
                rd2.setVisibility(View.GONE);
                sp.setVisibility(View.GONE);
                sp.setSelection(0);
                // sp.bringToFront();
                rd2.clearCheck();
                rd3.clearCheck();
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                String Rs = rs.getText().toString();
                String Note = notepad.getText().toString();
                String d1 = Date.getText().toString();
                int r = 0;

                if (d1.equals(d2)) {
                    Toast.makeText(MainActivity.this, "Today's date is chosen...!", Toast.LENGTH_SHORT).show();
                    d = Day;
                    m = M;
                    y = Year;
                }

                if(y<Year){
                    f=true;
                }
                else if(y==Year && m<M){
                    f=true;
                }
                else if(y==Year && m==M && d<=Day){
                    f=true;
                }
                else {
                    f=false;
                }


                if (Rs.length() != 0) {
                    r = Integer.valueOf(Rs);
                }

                if (f) {
                    m+=1;
                    if (r > 0 && r <= 30000) {
                        if (credit.isChecked()) {
                            if (online.isChecked()) {
                                if (g == 1) {

                                    db.adddata(new data(d, m, y, r, "Credited", "-", Note, "With UPI", "-", Upi,Time));
                                    Toast.makeText(MainActivity.this, "Data is successfully added", Toast.LENGTH_SHORT).show();

                                    Date.setText(d2);
                                    rs.setText("");
                                    notepad.setText("");
                                    rd2.clearCheck();
                                    rd3.clearCheck();
                                    rd2.setVisibility(View.GONE);
                                    sp.setSelection(0);
                                    sp.setVisibility(View.GONE);
                                    credit.setSaveEnabled(false);
                                    online.setSaveEnabled(false);

                                } else {
                                    Toast.makeText(MainActivity.this, "Select UPI Method", Toast.LENGTH_SHORT).show();
                                }

                            } else if (offline.isChecked()) {

                                db.adddata(new data(d, m, y, r, "Credited", "-", Note, "-", "Without UPI", "-",Time));
                                Toast.makeText(MainActivity.this, "Data is successfully added", Toast.LENGTH_SHORT).show();

                                rd2.setVisibility(View.GONE);
                                Date.setText(d2);
                                rs.setText("");
                                notepad.setText("");
                                rd2.clearCheck();
                                rd3.clearCheck();

                            } else {
                                Toast.makeText(MainActivity.this, "Select mode of payment Online or Offline", Toast.LENGTH_SHORT).show();
                            }

                        } else if (debit.isChecked()) {
                            if (online.isChecked()) {
                                if (g == 1) {

                                    db.adddata(new data(d, m, y, r, "-", "Debited", Note, "With UPI", "-", Upi,Time));
                                    Toast.makeText(MainActivity.this, "Data is successfully added", Toast.LENGTH_SHORT).show();

                                    Date.setText(d2);
                                    rs.setText("");
                                    notepad.setText("");
                                    rd2.clearCheck();
                                    rd3.clearCheck();
                                    rd2.setVisibility(View.GONE);
                                    sp.setSelection(0);
                                    sp.setVisibility(View.GONE);

                                } else {
                                    Toast.makeText(MainActivity.this, "Select UPI Method", Toast.LENGTH_SHORT).show();
                                }

                            } else if (offline.isChecked()) {

                                db.adddata(new data(d, m, y, r, "-", "Debited", Note, "-", "Without UPI", "-",Time));
                                Toast.makeText(MainActivity.this, "Data is successfully added", Toast.LENGTH_SHORT).show();

                                rd2.setVisibility(View.GONE);
                                Date.setText(d2);
                                rs.setText("");
                                notepad.setText("");
                                rd2.clearCheck();
                                rd3.clearCheck();

                            } else {
                                Toast.makeText(MainActivity.this, "Select mode of payment Online or offline", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Select mode of payment Credit or Debit", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Enter correct Amount...", Toast.LENGTH_SHORT).show();
                    }
                } else{
                    Toast.makeText(MainActivity.this, "Enter appropriete date...!", Toast.LENGTH_SHORT).show();
                }

            }
        });


        history.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view)
            {
                setdata1();
                setdata2();

                sh.addsam(new sample(sam_data1,sam_data2));

                ChangePage();

            }
        });

    }

    public void ChangePage() {
        Intent intent = new Intent(this, SamHistory.class);
        startActivity(intent);
    }

    public void setdata1(){
        sam_data1 = db.getdata_1();
    }

    public void setdata2(){
        sam_data2 =  db.getdata_2();
    }

    public int deleted(int index){
        Toast.makeText(MainActivity.this, "index is :"+index, Toast.LENGTH_SHORT).show();
        Log.d("sam : ","index is :"+index);
        return db.deletedata(index);


    }

}
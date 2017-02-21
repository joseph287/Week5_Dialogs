package com.example.mymac.week5_dialogs;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    Configuration configuration;
    @BindView(R.id.btn_date_ma) Button dateBtn;
    @BindView(R.id.tv_ma)
    TextView tv;

    @BindView(R.id.activity_main)
    LinearLayout rootLayout;
    int numofViews=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        configuration=getResources().getConfiguration();

        dateBtn.setOnClickListener( new MyLsntr());


        ScrollView scrollView=new ScrollView(this);
        LinearLayout sublayer=new LinearLayout(this);

        if (configuration.orientation ==Configuration.ORIENTATION_LANDSCAPE)
            sublayer.setOrientation(LinearLayout.HORIZONTAL);
        else
        sublayer.setOrientation(LinearLayout.VERTICAL);
        for(int i=0;i<numofViews;i++){
            Button btn=new Button(this);

            btn.setText("Btn"+i);
            btn.setWidth(20);
            btn.setHeight(10);
            sublayer.addView(btn);
        }
        scrollView.addView(sublayer);
        rootLayout.addView(sublayer);
    }
    class MyLsntr implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
                        {

                         tv.setText(""+year);


                        }
                    }, 2016, 0, 1);
                datePickerDialog.show();
            }
        }

    public void showDate(View view){

        AlertDialog.Builder alertBuilder=new AlertDialog.Builder(this);
        alertBuilder.setTitle("The Title of the Alert");
        alertBuilder.setMessage("Message  body to go in this are..");
        alertBuilder.setPositiveButton("Agreee", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
alertBuilder.show();
    }
}

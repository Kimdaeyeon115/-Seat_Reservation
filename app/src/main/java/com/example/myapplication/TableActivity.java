package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class TableActivity extends Activity {

    public static Context tableContext;

    TextView tvYear2, tvMonth2, tvDay2, tvHour2, tvMinute2;


    TextView seat,personnel,tvHour;
    Button btnInfo;
    Button btnNext;

    Button[] numButtons = new Button[15];
    Integer[] numBtnIDs = { R.id.BtnNum0,R.id.BtnNum1,R.id.BtnNum2,R.id.BtnNum3,R.id.BtnNum4,
            R.id.BtnNum5,R.id.BtnNum6,R.id.BtnNum7,
            R.id.BtnNum8,R.id.BtnNum9, R.id.BtnNum10,R.id.BtnNum11,
            R.id.BtnNum12, R.id.BtnNum13, R.id.BtnNum14,R.id.BtnNum15};
    int i;

    TextView tvName,tvPhone,stuIdNum;
    EditText dlgEdtName,dlgEdtPhone,dlgEdtstuidNum;
    View dialogView;


    Button btnReturnToDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);
        setTitle("레스토랑 자리 예약");

        tvYear2 = (TextView) findViewById(R.id.tvYear2);
        tvMonth2 = (TextView) findViewById(R.id.tvMonth2);
        tvDay2 = (TextView) findViewById(R.id.tvDay2);
        tvHour2 = (TextView) findViewById(R.id.tvHour2);
        tvMinute2 = (TextView) findViewById(R.id.tvMinute2);

        tvYear2.setText(((DaytimeActivity)DaytimeActivity.DayContext).tvYear.getText());
        tvMonth2.setText(((DaytimeActivity)DaytimeActivity.DayContext).tvMonth.getText());
        tvDay2.setText(((DaytimeActivity)DaytimeActivity.DayContext).tvDay.getText());
        tvHour2.setText(((DaytimeActivity)DaytimeActivity.DayContext).tvHour.getText());
        tvMinute2.setText(((DaytimeActivity)DaytimeActivity.DayContext).tvMinute.getText());


        btnReturnToDay =(Button)findViewById(R.id.BtnReturnToDay);
        btnReturnToDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tableContext = this;

        seat = (TextView) findViewById(R.id.Seat);
        personnel = (TextView) findViewById(R.id.Personnel);
        btnInfo = (Button)findViewById(R.id.BtnInfo);
        for(i=0;i<numButtons.length;i++){
            numButtons[i] = (Button)findViewById(numBtnIDs[i]);
        }
        tvHour =(TextView)findViewById(R.id.tvHour);

        tvName = (TextView)findViewById(R.id.tvName);
        tvPhone = (TextView)findViewById(R.id.tvPhone);
        btnInfo = (Button)findViewById(R.id.BtnInfo);
        stuIdNum = (TextView)findViewById(R.id.stuIdNum);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = (View) View.inflate(TableActivity.this,R.layout.dialog1,null);

                AlertDialog.Builder dlg = new AlertDialog.Builder(TableActivity.this);
                dlg.setTitle("예약자 정보 입력");
                dlg.setIcon(R.drawable.ic_menu_allfriends);
                dlg.setView(dialogView);

                dlg.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dlgEdtName = (EditText)dialogView.findViewById(R.id.dlgEdt1);
                                dlgEdtPhone =(EditText)dialogView.findViewById(R.id.dlgEdt2);
                                dlgEdtstuidNum = (EditText)dialogView.findViewById(R.id.dlgEdt3);

                                tvName.setText(dlgEdtName.getText().toString());
                                tvPhone.setText(dlgEdtPhone.getText().toString());
                                stuIdNum.setText(dlgEdtstuidNum.getText().toString());

                                Toast.makeText(getApplicationContext(),"예약자 정보 확인했습니다.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });

                dlg.setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),"취소했습니다.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                dlg.show();
            }
        });


        for(i=0;i<numButtons.length;i++){
            final int index;
            index = i;
            numButtons[index].setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    seat.setText((index+1)+"번 자리");
                    personnel.setText("1인좌석");
                    //stuIdNum.setText(dlgEdtstuidNum.getText().toString());
                    seat.setTextColor(Color.BLUE);
                    personnel.setTextColor(Color.BLUE);
                    Toast.makeText(getApplicationContext(),
                            "1인"+(index+1)+"번 좌석을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                }
            });
        }

        btnNext = (Button)findViewById(R.id.BtnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(seat.length() <= 0 || tvName.length() <= 0 || tvPhone.length() <= 0){

                    if(seat.length() <= 0){
                        Toast.makeText(getApplicationContext(),"좌석을 선택하세요"
                                ,Toast.LENGTH_SHORT).show();
                    }
                    if(tvName.length() <= 0 && tvPhone.length() <= 0){
                        Toast.makeText(getApplicationContext(),"예약자 정보를 입력하세요"
                                ,Toast.LENGTH_SHORT).show();
                    }
                    if(tvName.length() > 0 && tvPhone.length() <= 0){
                        Toast.makeText(getApplicationContext(),
                                "예약자 '연락처'는 필수 정보입니다.\n 예약자 정보를 다시 입력해주세요"
                                ,Toast.LENGTH_SHORT).show();
                    }
                    if(stuIdNum.length() > 0 && tvPhone.length() <= 0 && tvName.length() <= 0){
                        Toast.makeText(getApplicationContext(),
                                "예약자 '학번'는 필수 정보입니다.\n 예약자 정보를 다시 입력해주세요"
                                ,Toast.LENGTH_SHORT).show();
                    }
                    if(tvName.length() <= 0 && tvPhone.length() > 0){
                        Toast.makeText(getApplicationContext(),
                                "예약자 '성함'은 필수 정보입니다.\n 예약자 정보를 다시 입력해주세요"
                                ,Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Intent intent = new Intent(TableActivity.this,ConfirmActivity.class);
                    startActivity(intent);
                }

            }
        });

    }

}

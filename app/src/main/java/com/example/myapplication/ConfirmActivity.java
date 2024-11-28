package com.example.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class ConfirmActivity extends Activity {

    TextView tvYear3, tvMonth3, tvDay3, tvHour3, tvMinute3;

    TextView tvName2,tvPhone2;
    TextView seat2,stuIdNum2,dlgEdtstuidNum;
    Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm);
        setTitle("레스토랑 자리 예약 확정");

        tvYear3 = (TextView) findViewById(R.id.tvYear3);
        tvMonth3 = (TextView) findViewById(R.id.tvMonth3);
        tvDay3 = (TextView) findViewById(R.id.tvDay3);
        tvHour3 = (TextView) findViewById(R.id.tvHour3);
        tvMinute3 = (TextView) findViewById(R.id.tvMinute3);

        tvYear3.setText(((DaytimeActivity)DaytimeActivity.DayContext).tvYear.getText());
        tvMonth3.setText(((DaytimeActivity)DaytimeActivity.DayContext).tvMonth.getText());
        tvDay3.setText(((DaytimeActivity)DaytimeActivity.DayContext).tvDay.getText());
        tvHour3.setText(((DaytimeActivity)DaytimeActivity.DayContext).tvHour.getText());
        tvMinute3.setText(((DaytimeActivity)DaytimeActivity.DayContext).tvMinute.getText());

        Button btnReturn = (Button)findViewById(R.id.BtnReturnToTable);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvName2 = (TextView)findViewById(R.id.tvName2);
        tvPhone2 = (TextView)findViewById(R.id.tvPhone2);
        seat2 = (TextView)findViewById(R.id.Seat2);
        stuIdNum2 = (TextView)findViewById(R.id.stuIdNum2);
        dlgEdtstuidNum = (TextView)findViewById(R.id.dlgEdt3);


        tvName2.setText(((TableActivity)TableActivity.tableContext).tvName.getText());
        tvPhone2.setText(((TableActivity)TableActivity.tableContext).tvPhone.getText());
        seat2.setText(((TableActivity)TableActivity.tableContext).seat.getText());
        stuIdNum2.setText(((TableActivity)TableActivity.tableContext).stuIdNum.getText());

        btnConfirm =(Button)findViewById(R.id.BtnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dlg = new AlertDialog.Builder(ConfirmActivity.this);
                dlg.setTitle("예약 확정");
                dlg.setIcon(R.drawable.btn_exclamation);
                dlg.setMessage("정말 예약을 확정하시겠습니까?");
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"예약 확정 되었습니다.\n 완료 버튼을 누르세요",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"취소했습니다.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();

            }
        });

        Button btnFinish = (Button)findViewById(R.id.BtnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmActivity.this,EndActivity.class);
                startActivity(intent);
            }
        });

    }

}

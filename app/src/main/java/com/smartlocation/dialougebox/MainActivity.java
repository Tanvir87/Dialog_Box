package com.smartlocation.dialougebox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt_dummy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_dummy=(TextView)findViewById(R.id.txt_dummytext);
    }

    public void btn_showDialog(View view){
        final AlertDialog.Builder alert= new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.custom_dialog, null);

        final EditText txt_inputText=(EditText)mView.findViewById(R.id.txt_input);
        Button btn_cancel=(Button) mView.findViewById(R.id.btn_cancel);
        Button btn_ok=(Button) mView.findViewById(R.id.btn_ok);

        alert.setView(mView);
        final AlertDialog alertDialog = alert.create();
        alertDialog.setCanceledOnTouchOutside(false);

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alertDialog.dismiss();

            }
        });

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txt_dummy.setText(txt_inputText.getText().toString());
                alertDialog.dismiss();

            }
        });

        alertDialog.show();
    }
}

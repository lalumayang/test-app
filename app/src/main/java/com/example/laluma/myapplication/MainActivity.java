package com.example.laluma.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private EditText mEdtSex, mEdtAge;
    private Button mBtnOK;
    private TextView mTxtR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtSex = (EditText)findViewById(R.id.edtSex);
        mEdtAge = (EditText)findViewById(R.id.edtAge);
        mBtnOK = (Button)findViewById(R.id.btnOK);
        mTxtR = (TextView)findViewById(R.id.txtR);

        mBtnOK.setOnClickListener(btnOKOnClick);
    }

    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            String strSex = mEdtSex.getText().toString();
            int iAge=Integer.parseInt(mEdtAge.getText().toString());

            String strSug=getString(R.string.suggestion);
            if(strSex.equals(getString(R.string.sex_male)))
                if(iAge<30)
                    strSug+=getString(R.string.sug_not_hurry);
                else if(((iAge>=30))&&(iAge<=35))
                    strSug+=getString(R.string.sug_get_married);
                else
                    strSug+=getString(R.string.sug_find_couple);
            else
                if(iAge<28)
                    strSug+=getString(R.string.sug_not_hurry);
                else if(((iAge>=28))&&(iAge<=32))
                    strSug+=getString(R.string.sug_get_married);
                else
                    strSug+=getString(R.string.sug_find_couple);
        mTxtR.setText(strSug);

        }
    };
}

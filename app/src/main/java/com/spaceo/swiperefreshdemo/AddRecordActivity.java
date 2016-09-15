package com.spaceo.swiperefreshdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by  SpaceO on 14/9/16.
 */
public class AddRecordActivity  extends AppCompatActivity {



    private EditText editName;

    private Button btnSubmit;

    private ArrayList<String>  nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setContentView(R.layout.activity_addrecord);




        initControls();

    }

    private void initControls() {

       nameList = new ArrayList<String>();

        editName = (EditText)findViewById(R.id.editName);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);




        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                closeKeyboard(true);

                if(isValidate()){


                    String name = editName.getText().toString().trim();
                    nameList.add(name);

                    Intent mIntent = new Intent(AddRecordActivity.this,MainActivity.class);
                    mIntent.putExtra("array_list", nameList);
                    startActivity(mIntent);

                }

            }
        });

    }


    @Override
    public void onBackPressed() {

        startActivity(new Intent(AddRecordActivity.this,ViewRecordActivity.class));
        super.onBackPressed();

    }

    private boolean isValidate() {

        //Check for name is not empty
        if(editName.getText().toString().trim().length() == 0){
            setErrorMessage(editName, getString(R.string.msg_empty_name));
            return false;
        }



        return  true;
    }


    // set error message to Edittext
    private void setErrorMessage(EditText editName, String msg) {

        editName.requestFocus();
        editName.setError(msg);
    }






    public void closeKeyboard(boolean b) {

        View view = this.getCurrentFocus();

        if (b) {
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } else {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, 0);
        }
    }


}

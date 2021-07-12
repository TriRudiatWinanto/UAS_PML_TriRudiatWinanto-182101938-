package com.trw.uas_trirudiatwinanto_mobilelanjutan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.trw.uas_trirudiatwinanto_mobilelanjutan.model.PostPutDelUser;
import com.trw.uas_trirudiatwinanto_mobilelanjutan.rest.ApiClient;
import com.trw.uas_trirudiatwinanto_mobilelanjutan.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertActivity extends Activity {
    EditText editEmail, editFirstName, editLastName;
    Button btnInsert, btnBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        editEmail = (EditText)findViewById(R.id.editEmail);
        editFirstName = (EditText)findViewById(R.id.editNamaDepan);
        editLastName = (EditText)findViewById(R.id.editNamaBelakang);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelUser> postUserCall=mApiInterface.postUser(editEmail.getText().toString(),editFirstName.getText().toString(),editLastName.getText().toString());
                postUserCall.enqueue(new Callback<PostPutDelUser>() {
                    @Override
                    public void onResponse(Call<PostPutDelUser> call, Response<PostPutDelUser> response) {
                        MainActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelUser> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.ma.refresh();
                finish();
            }
        });

    }
}

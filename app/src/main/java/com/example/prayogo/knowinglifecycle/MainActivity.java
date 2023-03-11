package com.example.prayogo.knowinglifecycle;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText komentarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        komentarText = findViewById(R.id.komentar);
    }

    public MainActivity(){
        super();
    }

    protected void onStart(){
        Toast.makeText(this,"onStart", Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onStop(){
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
        //save data komentar
        saveDataKomentar(komentarText.getText().toString());
        super.onStop();
    }

    @Override
    protected void onPause() {
        Toast.makeText(this,"onPause", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        //ambil data komentar yang tersimpan
            String dataKomentar = ambilDataKomentar();
            komentarText.setText(dataKomentar);
            super.onResume();
    }

    private void saveDataKomentar(String value){
        SharedPreferences.Editor dataKomentar = this.getSharedPreferences("komentar", Context.MODE_PRIVATE).edit();
        dataKomentar.putString("keyKomentar", value);
        dataKomentar.commit();
    }

    private String ambilDataKomentar(){
        String result = this.getSharedPreferences("komentar", Context.MODE_PRIVATE).getString("keyKomentar", null);
        return result;
    }
}


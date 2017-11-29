package com.kowalczyk.fingerprintbsm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.kowalczyk.fingerprintbsm.db.DatabaseInit;
import com.kowalczyk.fingerprintbsm.model.MessageDao;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.textView3);
                textView.setText(getMessageDao().loadAll().get(0).getMessage());
            }
        });
    }

    private MessageDao getMessageDao() {
        return ((DatabaseInit) getApplication()).getDaoSession().getMessageDao();
    }
}

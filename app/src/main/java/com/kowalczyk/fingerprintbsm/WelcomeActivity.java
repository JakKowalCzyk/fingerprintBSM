package com.kowalczyk.fingerprintbsm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.kowalczyk.fingerprintbsm.db.DatabaseInit;
import com.kowalczyk.fingerprintbsm.model.Message;
import com.kowalczyk.fingerprintbsm.model.MessageDao;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private MessageDao getMessageDao() {
        return ((DatabaseInit) getApplication()).getDaoSession().getMessageDao();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getMessageDao().loadAll().isEmpty()) {
            setContentView(R.layout.activity_welcome);
            Button button = (Button) findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = ((EditText) findViewById(R.id.editText)).getText().toString();
                    Message message = new Message();
                    message.setMessage(text);

                    getMessageDao().save(message);

                    Intent i = new Intent(WelcomeActivity.this, DisplayActivity.class);
                    startActivity(i);
                }
            });
        } else {
            Intent i = new Intent(WelcomeActivity.this, DisplayActivity.class);
            startActivity(i);
        }
    }
}

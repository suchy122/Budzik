package com.example.budzik;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText plainText;
    TextView textView;
    MediaPlayer mediaPlayer;

    public void select(View view){
        plainText=findViewById(R.id.etText);
        textView=findViewById(R.id.textView);
        mediaPlayer=(MediaPlayer)MediaPlayer.create(this, R.raw.alarm);

        try
        {
            int time= Integer.parseInt(plainText.getText().toString());

            final int milliSeconds= time*1000;
            new CountDownTimer(milliSeconds, 1000){

                @Override
                public void onTick(long millisUntilFinished) {
                    textView.setText("00.0"+String.valueOf(millisUntilFinished/1000));
                }

                @Override
                public void onFinish() {
                    textView.setText("Alarm");
                    mediaPlayer.start();
                }
            }.start();

        }
        catch (RuntimeException e)
        {
            Toast.makeText(this, "Podaj czas w sekundach", Toast.LENGTH_SHORT).show();

        }



    }

    public void stop(View view){
        mediaPlayer.stop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
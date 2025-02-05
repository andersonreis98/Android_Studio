package com.example.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Button btIniciarThread, btPausaThread;
    Switch switchUnico;
    int numero = 0;
    private Handler handler = new Handler();
    private boolean pararExecucao = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btIniciarThread = findViewById(R.id.buttonInicia);
        btPausaThread = findViewById(R.id.buttonPausa);
        switchUnico = findViewById(R.id.switchUnico);
        btIniciarThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarThread();
            }
        });
        btPausaThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pararExecucao = true;
            }
        });

    }

    public void iniciarThread() {
//        Mythread mythread = new Mythread();
//        mythread.start();

        pararExecucao = false;
        MyRunnable runnable = new MyRunnable();
        new Thread(runnable).start();

    }

    class MyRunnable implements Runnable {

        @Override
        public void run() {
//            Handler handler1 = new Handler();
            for (int i = 0; i <= 15; i++) {
                if (pararExecucao) {
                    return;
                } else {
                    numero = i;
                    Log.d("ExecutaThread", "contador" + i);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            btIniciarThread.setText("contador" + numero);
                        }
                    });
//                handler1.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        btIniciarThread.setText("contador" + numero);
//                    }
//                });

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    class Mythread extends Thread {

        @Override
        public void run() {
            super.run();
            for (int i = 0; i <= 15; i++) {
                Log.d("ExecutaThread", "contador" + i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
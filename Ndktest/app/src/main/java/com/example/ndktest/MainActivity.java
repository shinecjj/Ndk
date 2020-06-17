package com.example.ndktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.qian.NativeCaller;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        mTextView = tv;
        tv.setText("" + 0000);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.setText("click");
                get();
            }
        });
    }

    private void get(){
        MyTask mTask = new MyTask();
        mTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    private class MyTask extends AsyncTask<String, Void, Long> {

        @Override
        protected void onPreExecute() {
            mTextView.setText("start");
        }

        @Override
        protected Long doInBackground(String... params) {
            long startTime = System.nanoTime();
            NativeCaller.getStringFromNative();
            long endTime = System.nanoTime();
            long diffTime = endTime - startTime;
            return diffTime;
        }

        @Override
        protected void onPostExecute(Long result) {
            mTextView.setText("" + result);
        }
    }


    public native String stringFromJNI();
}

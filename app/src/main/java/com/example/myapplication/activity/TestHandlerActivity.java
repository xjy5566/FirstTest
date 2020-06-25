package com.example.myapplication.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.entity.Person;

public class TestHandlerActivity extends AppCompatActivity {

    private TextView textview;
    private Button button;

    //在主线程中创建mHandler，所以自动绑定主线程
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 1:
                    System.out.println("handleMessage thread id " + Thread.currentThread().getId());
                    System.out.println("msg.arg1:" + msg.arg1);
                    System.out.println("msg.arg2:" + msg.arg2);
                    System.out.println("msg.obj:" + msg.obj.toString());
                    System.out.println("msg.setDate:" + msg.getData().get("QQ"));

                    textview.setText("success");
                    break;
            }
        }
    };

   private Handler mHandler2 = new Handler(new Handler.Callback() {
       @Override
       public boolean handleMessage(@NonNull Message msg) {
           switch (msg.what){
               case 1:
                   System.out.println("handleMessage thread id " + Thread.currentThread().getId());
                   System.out.println("msg.arg1:" + msg.arg1);
                   System.out.println("msg.arg2:" + msg.arg2);
                   System.out.println("msg.obj:" + msg.obj.toString());
                   System.out.println("msg.setDate:" + msg.getData().get("QQ"));

                   textview.setText("success");
                   break;
           }
           return false;
       }
   });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_handler);
        textview = (TextView)findViewById(R.id.textview);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Main thread id " + Thread.currentThread().getId());
                DownloadThread downloadThread = new DownloadThread();
                downloadThread.start();
            }
        });

    }
    class DownloadThread extends Thread{
        @Override
        public void run() {
            try{
                System.out.println("Download thread id " + Thread.currentThread().getId());
                System.out.println("开始下载文件");
                Thread.sleep(5000);//此处让线程DownloadThread休眠5秒中，模拟文件的耗时过程
                System.out.println("文件下载完成");
                //文件下载完成后更新UI
                Message msg = new Message();

                //what是自定义的一个Message的识别码，
                //作用：在Handler的handleMessage方法中根据what识别出不同的Message，以便我们做出不同的处理操作
                msg.what = 1;

                //arg1是自定义的一个Message的参数
                //作用：可以通过arg1和arg2给Message传入简单的数据
                msg.arg1 = 123;
                msg.arg2 = 321;

                String s = new String();
                s = "abc";

                msg.obj = s;

                Bundle bundle = new Bundle();
                bundle.putString("QQ",s);
                msg.setData(bundle);

                //将该Message发送给对应的Handler
                mHandler.sendMessage(msg);

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}


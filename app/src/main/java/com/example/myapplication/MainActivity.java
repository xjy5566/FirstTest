 package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.tencent.liteav.demo.play.SuperPlayerConst;
import com.tencent.liteav.demo.play.SuperPlayerView;

 public class MainActivity extends AppCompatActivity {

     WebView webview;
     SuperPlayerView  mSuperPlayerView;

     @Override
     protected void onResume() {
         super.onResume();
         // 重新开始播放
         if (mSuperPlayerView.getPlayState() == SuperPlayerConst.PLAYSTATE_PLAYING) {
             mSuperPlayerView.onResume();
             if (mSuperPlayerView.getPlayMode() == SuperPlayerConst.PLAYMODE_FLOAT) {
                 mSuperPlayerView.requestPlayMode(SuperPlayerConst.PLAYMODE_WINDOW);
             }
         }
     }


     @Override
     protected void onPause() {
         super.onPause();
         // 停止播放
         if (mSuperPlayerView.getPlayMode() != SuperPlayerConst.PLAYMODE_FLOAT) {
             mSuperPlayerView.onPause();
         }
     }

     @Override
     protected void onDestroy() {
         super.onDestroy();
         // 释放
         mSuperPlayerView.release();
         if (mSuperPlayerView.getPlayMode() != SuperPlayerConst.PLAYMODE_FLOAT) {
             mSuperPlayerView.resetPlayer();
         }
     }

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        webview = (WebView) findViewById(R.id.webview);
//        WebSettings webSettings = webview.getSettings();


        mSuperPlayerView = findViewById(R.id.main_super_player_view);

        /*SuperPlayerModel model = new SuperPlayerModel();
        model.url = "http://1252463788.vod2.myqcloud.com/95576ef5vodtransgzp1252463788/e1ab85305285890781763144364/v.f30.mp4";
     //   model.url = "https://vdept.bdstatic.com/7264673870437563415572616d64765a/4646355a49355074/ede5a25246ad36df99fdb25821b7b062e23e86b485b1e5d774916da0a2a138304f1dc8538efef11171f77535de063c60.mp4?auth_key=1591787115-0-0-6c3dd491bcca67250c66b51ae9a302fe";
        mSuperPlayerView.playWithModel(model);*/


//        SuperPlayerModel model = new SuperPlayerModel();
//        model.multiURLs = new ArrayList<>();
//        model.multiURLs.add(new SuperPlayerModel.SuperPlayerURL("http://1252463788.vod2.myqcloud.com/95576ef5vodtransgzp1252463788/e1ab85305285890781763144364/v.f10.mp4", "流畅"));
//        model.multiURLs.add(new SuperPlayerModel.SuperPlayerURL("http://1252463788.vod2.myqcloud.com/95576ef5vodtransgzp1252463788/e1ab85305285890781763144364/v.f20.mp4", "标清"));
//        model.multiURLs.add(new SuperPlayerModel.SuperPlayerURL("http://1252463788.vod2.myqcloud.com/95576ef5vodtransgzp1252463788/e1ab85305285890781763144364/v.f30.mp4", "高清"));
//        model.playDefaultIndex = 2;// 默认播放标清
//        mSuperPlayerView.playWithModel(model);


         Intent intent = new Intent(this, TestRecyclerViewActivity.class);
         startActivity(intent);


//       String s = "9557762000000200";
//
////       char a = 4;
////       char b = 6;
//
//       Toast.makeText(MainActivity.this,"输出: "+s.charAt(5),Toast.LENGTH_LONG).show();
//
//       if("6".equals(s.charAt(5))){
//            Toast.makeText(MainActivity.this,"hahah ",Toast.LENGTH_LONG).show();
//        }
//
//        if('6' == s.charAt(5)){
//            Toast.makeText(MainActivity.this,"恭喜 ",Toast.LENGTH_LONG).show();
//        }

//        // 设置与Js交互的权限
//        webSettings.setJavaScriptEnabled(true);
//        // 设置允许JS弹窗
//        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
//
//        // 步骤1：加载JS代码,格式规定为:file:///android_asset/文件名.html
//        webview.loadUrl("file:///android_asset/javascript.html");
//
//
//        //在android 7.0系统以上 已经摒弃了shouldOverrideUrlLoading(WebView view, String url)此方法，
//        // 所以，如果要拦截URL，我们需要做兼容性处理，重写shouldOverrideUrlLoading(WebView view, WebResourceRequest request)方法，
//        // 获取得到的可正常使用的URL
//        webview.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//
//                //步骤2：根据协议的参数，判断是否是所需要的url
//                //一般根据scheme（协议格式） & authority（协议名）判断（前两个参数）
//                //假定传入进来的 url = "js://webview?arg1=111&arg2=222"（同时也是约定好的需要拦截的）
//
//                Uri uri;
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    uri = request.getUrl();
//                    Toast.makeText(MainActivity.this,"request.getUrl()="+uri,Toast.LENGTH_LONG).show();
//                } else {
//                    uri = Uri.parse(request.toString());
//                    Toast.makeText(MainActivity.this,"uri="+uri,Toast.LENGTH_LONG).show();
//                }
//
//                // 如果url的协议 = 预先约定的 js 协议
//                // 就解析往下解析参数
//                if ( uri.getScheme().equals("js")) {
//
//                    // 如果 authority  = 预先约定协议里的 webview，即代表都符合约定的协议
//                    // 所以拦截url,下面JS开始调用Android需要的方法
//                    if (uri.getAuthority().equals("webview")) {
//
//                        //步骤3：执行JS所需要调用的逻辑
//                        System.out.println("js调用了Android的方法");
//                        // 可以在协议上带有参数并传递到Android上
//                        HashMap<String, String> params = new HashMap<>();
//                        Set<String> collection = uri.getQueryParameterNames();
//
////                        String result = "Android回调给JS的数据为useid=123456";
////                        view.loadUrl("javascript:returnResult(\"" + result + "\")");
//
//                    }
//
//                    return true;
//                }
//                return super.shouldOverrideUrlLoading(view, request);
//            }
//
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
//
//                String result = "Android回调给JS的数据为useid=123456";
//                webview.loadUrl("javascript:returnResult(\"" + result + "\")");
//            }
//
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                return super.shouldOverrideUrlLoading(view, url);
//            }
//        });
//
//
//        webview.setWebChromeClient(new WebChromeClient(){
//            @Override
//            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
//
//                // 拦截输入框(原理同方式2)
//                // 参数message:代表promt()的内容（不是url）
//                // 参数result:代表输入框的返回值
//
//                // 根据协议的参数，判断是否是所需要的url(原理同方式2)
//                // 一般根据scheme（协议格式） & authority（协议名）判断（前两个参数）
//                //假定传入进来的 url = "js://webview?arg1=111&arg2=222"（同时也是约定好的需要拦截的）
//
//                Uri uri = Uri.parse(message);
//
//                Toast.makeText(MainActivity.this,"uri="+uri,Toast.LENGTH_LONG).show();
//
//                // 如果url的协议 = 预先约定的 js 协议
//                // 就解析往下解析参数
//                if ( uri.getScheme().equals("js")) {
//
//                    // 如果 authority  = 预先约定协议里的 webview，即代表都符合约定的协议
//                    // 所以拦截url,下面JS开始调用Android需要的方法
//                    if (uri.getAuthority().equals("webview")) {
//
//                        // 执行JS所需要调用的逻辑
//                        System.out.println("js调用了Android的方法");
//                        // 可以在协议上带有参数并传递到Android上
//                        HashMap<String, String> params = new HashMap<>();
//                        Set<String> collection = uri.getQueryParameterNames();
//
//                        //参数result:代表消息框的返回值(输入值)
//                        result.confirm("Android回调给JS的数据为useid=123456");
//                    }
//                    return true;
//                }
//                return super.onJsPrompt(view, url, message, defaultValue, result);
//
//            }
//        });
//
//
////        LeakThread leakThread = new LeakThread();
////        leakThread.start();
//    }
//    class LeakThread extends Thread {
//        @Override
//        public void run() {
//            try {
//                Thread.sleep(60 * 60 * 1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}

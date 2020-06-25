package com.example.myapplication.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.myapplication.R;

/**
 * 测试类
 */
public class TestPermissionActivity extends AppCompatActivity {

    private Button button;

    private static final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_permission);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //使用兼容库就无需判断系统版本
                int hasWriteStoragePermission = ContextCompat.checkSelfPermission(getApplication(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if (hasWriteStoragePermission == PackageManager.PERMISSION_GRANTED) {
                    //拥有权限，执行操作
                    Toast.makeText(TestPermissionActivity.this,"权限申请成功",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(TestPermissionActivity.this,TestRecyclerViewActivity.class);
                    startActivity(intent);
                }else{
                    //没有权限，向用户请求权限
                    ActivityCompat.requestPermissions(TestPermissionActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == WRITE_EXTERNAL_STORAGE_REQUEST_CODE){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //用户同意，执行操作
                Toast.makeText(TestPermissionActivity.this,"权限申请成功",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(TestPermissionActivity.this,TestRecyclerViewActivity.class);
                startActivity(intent);

            }else{
                //用户不同意，向用户展示该权限作用
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    new AlertDialog.Builder(TestPermissionActivity.this)
                            .setMessage("这个权限是读取你本地的图片用的")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ActivityCompat.requestPermissions(TestPermissionActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
                                }
                            })
                            .setNegativeButton("Cancel", null)
                            .create()
                            .show();
                }else{
                    Toast.makeText(TestPermissionActivity.this,"你点击过了 拒绝 或者 不在询问 按钮",Toast.LENGTH_LONG).show();
                }
            }
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}

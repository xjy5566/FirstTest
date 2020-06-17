package com.example.myapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.PersonAdapter;
import com.example.myapplication.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class TestRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Person> personList = new ArrayList<Person>();
    private Person person;
    private PersonAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_recyclerview);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        initData();
        adapter = new PersonAdapter(personList);
        adapter.setOnRecyclerViewListener(new PersonAdapter.OnRecyclerViewListerner() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(TestRecyclerViewActivity.this,"点击事件",Toast.LENGTH_LONG).show();
            }

            @Override
            public boolean onItemLongClick(int position) {
                Toast.makeText(TestRecyclerViewActivity.this,"长点击事件",Toast.LENGTH_LONG).show();
                return false;
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private List<Person> initData(){
        for(int i=0 ; i<10 ;i++){
            person = new Person();
            person.setName("杰克"+i);
            person.setAge("10"+i);
            personList.add(person);
        }
        return personList;
    }
}

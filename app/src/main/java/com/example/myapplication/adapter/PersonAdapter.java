package com.example.myapplication.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.entity.Person;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter {

    private static final String TAG = PersonAdapter.class.getSimpleName();
    private List<Person> personList;
    private OnRecyclerViewListerner onRecyclerViewListerner;
   // private Context context;

    public PersonAdapter(List<Person> personList) {
        this.personList = personList;
    }

    public static interface OnRecyclerViewListerner{
        void onItemClick(int position);
        boolean onItemLongClick(int position);
    }
    public void setOnRecyclerViewListener(OnRecyclerViewListerner onRecyclerViewListerner){
        this.onRecyclerViewListerner = onRecyclerViewListerner;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_test_item_person, null);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Log.d(TAG, "onBindViewHolder, position: " + position + ", viewHolder: " + viewHolder);
        PersonViewHolder holder = (PersonViewHolder) viewHolder;
        holder.position = position;
        Person person = personList.get(position);
        holder.nameTv.setText(person.getName());
        holder.ageTv.setText(person.getAge() + "岁");
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        public View rootView;
        public TextView nameTv;
        public TextView ageTv;
        public int position;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = (TextView) itemView.findViewById(R.id.recycler_view_test_item_person_name_tv);
            ageTv = (TextView) itemView.findViewById(R.id.recycler_view_test_item_person_age_tv);
            rootView = itemView.findViewById(R.id.recycler_view_test_item_person_view);
            rootView.setOnClickListener(this);
            rootView.setOnLongClickListener(this);
        }
        @Override
        public void onClick(View v) {
            if (null != onRecyclerViewListerner) {
                onRecyclerViewListerner.onItemClick(position);
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if(null != onRecyclerViewListerner){
                return onRecyclerViewListerner.onItemLongClick(position);
            }
            return false;
        }
    }
}

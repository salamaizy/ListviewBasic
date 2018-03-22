package com.example.salaizy.listviewbasic;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //adapter class
    ArrayList<AdapterItems>    listnewsData = new ArrayList<AdapterItems>();
    MyCustomAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvlist = (ListView) findViewById(R.id.lvlist);


        //add data and view it
        listnewsData.add(new AdapterItems(1,R.drawable.ic_account_box_white_24dp,"developer"," I develop apps in Android"));
        listnewsData.add(new AdapterItems(2,R.drawable.ic_account_box_white_24dp,"Tester"," I test apps in every program"));
        listnewsData.add(new AdapterItems(3,R.drawable.ic_account_box_white_24dp,"admin"," I a admin in Startup "));
        listnewsData.add(new AdapterItems(4,R.drawable.ic_account_box_white_24dp,"Jobless"," I don't have any job but a code though"));
        myadapter=new MyCustomAdapter(listnewsData);

        lvlist.setAdapter(myadapter);

        lvlist.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final AdapterItems s = listnewsData.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void addnew(View view) {

        listnewsData.add(new AdapterItems(5,R.drawable.ic_account_box_white_24dp,"Jobless"," I don't have any job but a code though"));
        myadapter.notifyDataSetChanged();
    }

    //display news list
    private class MyCustomAdapter extends BaseAdapter {
        public ArrayList<AdapterItems>  listnewsDataAdpater ;

        public MyCustomAdapter(ArrayList<AdapterItems>  listnewsDataAdpater) {
            this.listnewsDataAdpater=listnewsDataAdpater;
        }


        @Override
        public int getCount() {
            return listnewsDataAdpater.size();
        }

        @Override
        public String getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater mInflater = getLayoutInflater();
            View myView = mInflater.inflate(R.layout.layout_ticket, null);

            final   AdapterItems s = listnewsDataAdpater.get(position);

            TextView tvID=( TextView)myView.findViewById(R.id.tvID);
            tvID.setText(String.valueOf(s.ID));

            TextView tvTitle =( TextView)myView.findViewById(R.id.tvTitle);
            tvTitle.setText(s.JobTitle);

            TextView tvDesc=( TextView)myView.findViewById(R.id.tvDesc);
            tvDesc.setText(s.Description);

            ImageView img=( ImageView)myView.findViewById(R.id.imgView);
            img.setImageResource(s.img);

            tvTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),s.JobTitle,Toast.LENGTH_SHORT).show();
                }
            });

            return myView;
        }

    }
}

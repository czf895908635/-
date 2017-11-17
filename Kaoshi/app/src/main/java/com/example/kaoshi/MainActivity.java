package com.example.kaoshi;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AbsListView.OnScrollListener {
    private ListView mListView;
    private Context mContext = MainActivity.this;
    private ArrayList<String> mList = new ArrayList<>();
    private MyAdapter mAdapter;
    private ProgressBar mMore;
    private View mView;
    private int mIndex = 0;
    private int mMax = 40;
    private Handler mHandler = new Handler();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ForData();
        bottomView();
        initView();
        mAdapter = new MyAdapter(mList, mContext);
        mListView.setAdapter(mAdapter);
    }
    private void initView() {
        mListView = (ListView) findViewById(R.id.lv);
        mListView.addFooterView(mView);
        //滑动监听
        mListView.setOnScrollListener(this);
    }
    private void ForData() {
        for (int i = 0; i < 10; i++) {
            mList.add("北京" + i);
        }
    }
    private void bottomView() {
        mView = getLayoutInflater().inflate(R.layout.progress_main, null);
        mMore = (ProgressBar) mView.findViewById(R.id.pro);

    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && mAdapter.getCount() == mIndex) {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        mList.add("上海" + i);
                    }
                    mAdapter.notifyDataSetChanged();
                }
            }, 1000);


        }


    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {
        mIndex = i2 - 1;
        if ( (i2-1)== mMax) {
            mListView.removeFooterView(mView);
        }


    }
}

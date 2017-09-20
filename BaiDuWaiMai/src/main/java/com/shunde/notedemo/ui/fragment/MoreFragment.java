package com.shunde.notedemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shunde.notedemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：dfy on 20/9/2017 22:12
 * <p>
 * 邮箱：dengfuyao@163.com
 */

public class MoreFragment extends Fragment {
    @BindView(R.id.tv)
    TextView mTv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_, null);
        ButterKnife.bind(this, rootView);
        initView();
        return rootView;
    }

    private void initView() {
        mTv.setText("更多");
    }
}

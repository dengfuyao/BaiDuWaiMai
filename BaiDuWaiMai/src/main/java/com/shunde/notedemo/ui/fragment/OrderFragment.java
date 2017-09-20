package com.shunde.notedemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shunde.notedemo.R;

import butterknife.ButterKnife;

/**
 * 作者：dfy on 20/9/2017 22:12
 * <p>
 * 邮箱：dengfuyao@163.com
 */

public class OrderFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_order, null);
        ButterKnife.bind(this, rootView);
        initView();
        return rootView;
    }

    private void initView() {

    }
}

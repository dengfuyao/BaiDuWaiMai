package com.shunde.notedemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.shunde.notedemo.ui.fragment.HomeFragment;
import com.shunde.notedemo.ui.fragment.MoreFragment;
import com.shunde.notedemo.ui.fragment.OrderFragment;
import com.shunde.notedemo.ui.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_fragment_container)
    FrameLayout  mMainFragmentContainer;
    @BindView(R.id.main_bottome_switcher_container)
    LinearLayout mMainBottomeSwitcherContainer;
//主界面用4个fragment,创建一个集合来装fragment
    private List<Fragment> mFragmentList = new ArrayList<>() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragment();
        initBottom();
        changeIndexUi(0);//默认在首页

    }

    /**
     * 初始化底部导航栏
     */
    private void initBottom() {
        int childCount = mMainBottomeSwitcherContainer.getChildCount();//获取子view个数
        for (int i= 0 ;i<childCount;i++){
            final View childView = mMainBottomeSwitcherContainer.getChildAt(i);//获取子控件
            //给每个bottom添加点击事件,选中时不可以点击,颜色改变
            childView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                //获取到选中的view
                    int index = mMainBottomeSwitcherContainer.indexOfChild(childView);
                    changeIndexUi(index);
                }
            });

        }
    }

    /**
     * 获取所有的子view,循环取出每个子view,当下标与这个view的下标相等时那么就说明是同一个
     * 子view这个view不能被点击,那么其他子view可以被点击,点击后切换到对应的fragment;
     * 被选中的bottom颜色改变并且不可以再次点击
     *
     * @param index  选中的下标
     */
    private void changeIndexUi(int index) {
        int childCount = mMainBottomeSwitcherContainer.getChildCount();
        for (int i = 0 ; i<childCount;i++){
            final View childAt = mMainBottomeSwitcherContainer.getChildAt(i);
            if (i==index){
                setEnabled(childAt,false);
            }else {
                setEnabled(childAt,true);
            }
        }
        //切换fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,mFragmentList.get(index)).commit();
    }

    private void setEnabled(View childAt, boolean b) {
        childAt.setEnabled(b);
        //处理子view中孙子的点击事件
        if (childAt instanceof ViewGroup){
            //获取孙子的个数
            int childCount = ((ViewGroup) childAt).getChildCount();
            for (int i = 0 ;i<childCount;i++){
                View childAt1 = ((ViewGroup) childAt).getChildAt(i);
                childAt1.setEnabled(b);
            }
        }
    }

    private void initFragment() {
        mFragmentList.add(new HomeFragment());
        mFragmentList.add(new OrderFragment());
        mFragmentList.add(new UserFragment());
        mFragmentList.add(new MoreFragment());
    }
}

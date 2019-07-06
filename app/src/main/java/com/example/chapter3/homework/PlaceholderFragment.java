package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static android.animation.ValueAnimator.*;

public class PlaceholderFragment extends Fragment {

    private View loadView ;
    private ListView mListView;
    private String [] data = {"item_One","item_Two","item_Three","item_Four",
            "item_Five","item_Six","item_Seven","item_Eight","item_Nine","item_Ten",
            "item_One","item_Two","item_Three","item_Four",
            "item_Five","item_Six","item_Seven","item_Eight","item_Nine","item_Ten",
            "item_One","item_Two","item_Three","item_Four",
            "item_Five","item_Six","item_Seven","item_Eight","item_Nine","item_Ten",
            "item_One","item_Two","item_Three","item_Four",
            "item_Five","item_Six","item_Seven","item_Eight","item_Nine","item_Ten"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View v =inflater.inflate(R.layout.fragment_placeholder, container, false);

        loadView = v.findViewById(R.id.loading_view);
        mListView = (ListView) v.findViewById(R.id.list_view);
        ArrayAdapter<String> array = new ArrayAdapter<String>(
                v.getContext(),android.R.layout.simple_list_item_1,data);

        mListView.setAdapter(array);
        return v;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mListView.setVisibility(View.INVISIBLE);


        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入

                ObjectAnimator animatorLoad = ObjectAnimator.ofFloat(loadView, "alpha",1f,0f);
                animatorLoad.setDuration(2000);
  //              animatorLoad.start();

                mListView.setVisibility(View.VISIBLE);
                ObjectAnimator animatorList = ObjectAnimator.ofFloat(mListView, "alpha",0f,1.0f);
                animatorList.setDuration(2000);
//
////                Log.d("animator", "------>animator_run");
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playTogether(animatorLoad,animatorList);
                animatorSet2.start();
            }
        }, 5000);
    }
}


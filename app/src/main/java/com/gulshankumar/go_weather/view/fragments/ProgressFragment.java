package com.gulshankumar.go_weather.view.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import com.gulshankumar.go_weather.R;
import com.gulshankumar.go_weather.databinding.FragmentProgressBinding;


public class ProgressFragment extends Fragment {
    
    public ProgressFragment() {
        // Required empty public constructor
    }
    
  
    public static ProgressFragment newInstance() {
        return  new ProgressFragment();
    }
    
 
    
    private FragmentProgressBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_progress,container,false);
        return binding.getRoot();
    }
    
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rotateLoader();
    }
    
    private void rotateLoader(){
        RotateAnimation rotate = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(1000);
        rotate.setRepeatCount(Animation.INFINITE);
        rotate.setInterpolator(new LinearInterpolator());
        binding.ivLoading.startAnimation(rotate);
    }
}

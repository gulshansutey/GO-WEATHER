package com.gulshankumar.go_weather.view.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gulshankumar.go_weather.viewModels.FragmentViewModel;
import com.gulshankumar.go_weather.R;
import com.gulshankumar.go_weather.databinding.FragmentErrorBinding;


public class ErrorFragment extends Fragment implements FragmentViewModel.FragmentClickCallbacks {
   
    private static final String ARG_PARAM_ERROR = "param1";
    
    private String errorMesg;
    
    private static FragmentInteractionListener interactionListener;
  
    public ErrorFragment() {
        // Required empty public constructor
    }
    
    public static ErrorFragment newInstance(String error,FragmentInteractionListener interactionListener) {
        ErrorFragment fragment = new ErrorFragment();
        ErrorFragment.interactionListener = interactionListener;
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_ERROR, error);
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            errorMesg = getArguments().getString(ARG_PARAM_ERROR);
        }
    }
    private FragmentErrorBinding fragmentErrorBinding;
    private FragmentViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
          fragmentErrorBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_error,container,false);
          viewModel = ViewModelProviders.of(this).get(FragmentViewModel.class);
          if (savedInstanceState == null){
              viewModel.setErrorMesg(errorMesg);
          }
          fragmentErrorBinding.setCallback(this);
          fragmentErrorBinding.setErrorViewModel(viewModel);
        return fragmentErrorBinding.getRoot();
    }
    
    
    @Override
    public void onRetry() {
        interactionListener.onRetry();
    }
    
    public interface FragmentInteractionListener{
        void onRetry();
    }
    
}

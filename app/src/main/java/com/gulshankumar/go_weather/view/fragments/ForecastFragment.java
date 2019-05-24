package com.gulshankumar.go_weather.view.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gulshankumar.go_weather.viewModels.FragmentViewModel;
import com.gulshankumar.go_weather.R;
import com.gulshankumar.go_weather.databinding.FragmentForecastBinding;
import com.gulshankumar.go_weather.models.WeatherForecastModel;


public class ForecastFragment extends Fragment {
    
    private static final String ARG_PARAM_DATA = "param1";
    
    private WeatherForecastModel forecastDataModel;
    private FragmentForecastBinding forecastBinding;
    private FragmentViewModel viewModel;
    
    public ForecastFragment() {
        // Required empty public constructor
    }
    
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param forecastDataModel Parameter 1.
     * @return A new instance of fragment ForecastFragment.
     */
    public static ForecastFragment newInstance(WeatherForecastModel forecastDataModel) {
        ForecastFragment fragment = new ForecastFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM_DATA, forecastDataModel);
        fragment.setArguments(args);
        return fragment;
    }
    
    @BindingAdapter("setAdapter")
    public static void bindRecyclerViewAdapter(RecyclerView recyclerView, RecyclerView.Adapter<?> adapter) {
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            forecastDataModel = getArguments().getParcelable(ARG_PARAM_DATA);
        }
    }
    
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        forecastBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_forecast, container, false);
        viewModel = ViewModelProviders.of(this).get(FragmentViewModel.class);
        if (forecastDataModel != null && savedInstanceState == null) {
            viewModel.setForecastAdapter(forecastDataModel.getForecast().getForecastdayList());
            viewModel.setCurrentLocation(forecastDataModel.getLocation().getLocationName());
            viewModel.setCurrentTemp(String.format("%s%s", forecastDataModel.getCurrent().getTemp().toString(), (char) 0x00B0));
        }
        
        forecastBinding.setViewModel(viewModel);
        return forecastBinding.getRoot();
    }
    
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
    }
    
    
}

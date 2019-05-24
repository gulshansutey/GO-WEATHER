package com.gulshankumar.go_weather.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gulshankumar.go_weather.BR;
import com.gulshankumar.go_weather.viewModels.FragmentViewModel;
import com.gulshankumar.go_weather.R;
import com.gulshankumar.go_weather.databinding.AdapterForecastRecyclerBinding;


public class ForecastRecyclerAdapter extends RecyclerView.Adapter<ForecastRecyclerAdapter.VH> {
    
    
    private int size;
    private FragmentViewModel viewModel;
    public ForecastRecyclerAdapter(FragmentViewModel viewModel, int size) {
        this.size = size;
        this.viewModel = viewModel;
    }
    
    public void setSize(int size) {
        this.size = size;
        notifyDataSetChanged();
    }
    
    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        AdapterForecastRecyclerBinding adapterBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.adapter_forecast_recycler, viewGroup, false);
        return new VH(adapterBinding);
    }
    
    @Override
    public void onBindViewHolder(@NonNull VH vh, int position) {
        vh.bindView(viewModel, position);
    }
    
    @Override
    public int getItemCount() {
        return size;
    }
    
    public class VH extends RecyclerView.ViewHolder {
        AdapterForecastRecyclerBinding adapterBinding;
        
        public VH(AdapterForecastRecyclerBinding adapterBinding) {
            super(adapterBinding.getRoot());
            this.adapterBinding = adapterBinding;
        }
        
        void bindView(FragmentViewModel viewModel, int position) {
            adapterBinding.setVariable(BR.adp_view_model, viewModel);
            adapterBinding.setVariable(BR.position, position);
            adapterBinding.executePendingBindings();
        }
    }
}

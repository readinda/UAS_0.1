package com.natania.uas_01.fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.natania.uas_01.R;
import com.natania.uas_01.adapter.GridDessert;
import com.natania.uas_01.adapter.ListSeaFood;
import com.natania.uas_01.model.DessertItem;
import com.natania.uas_01.model.ResponseDessert;
import com.natania.uas_01.model.SeafoodItem;
import com.natania.uas_01.network.InterfaceClient;
import com.natania.uas_01.network.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class DessertFragment extends Fragment {
    private GridDessert gridDessert;
    private InterfaceClient interfaceClient;
    private RecyclerView rvDessert;
    private List<DessertItem> result = new ArrayList<>();
    Context context;
    ProgressDialog loading;


    public DessertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dessert, container, false);

        loading = new ProgressDialog(getContext());

        rvDessert = v.findViewById(R.id.rv_Dessert);
        interfaceClient = RetrofitConfig.creatService(InterfaceClient.class);

        gridDessert = new GridDessert(getActivity(), result);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        rvDessert.setLayoutManager(layoutManager);
        context = getContext();

        loadDessert();

        return v;
    }

    private void loadDessert() {
        loading.setMessage("Loading ...");
        loading.show();

        Call<ResponseDessert> request = interfaceClient
                .getDessert("title","thumb");
        request.enqueue(new Callback<ResponseDessert>() {
            @Override
            public void onResponse(Call<ResponseDessert> call, Response<ResponseDessert> response) {
                result = response.body().getMeals();
                rvDessert.setAdapter(new GridDessert(context,result));
                gridDessert.notifyDataSetChanged();
                loading.dismiss();
            }

            @Override
            public void onFailure(Call<ResponseDessert> call, Throwable t) {
                Log.e("koneksi gagal", t.toString());

            }
        });
    }

}

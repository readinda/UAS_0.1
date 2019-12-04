package com.natania.uas_01.fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.natania.uas_01.R;
import com.natania.uas_01.adapter.GridDessert;
import com.natania.uas_01.adapter.ListSeaFood;
import com.natania.uas_01.model.ResponseSeaFood;
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
public class SeaFoodFragment extends Fragment {
    private ListSeaFood listSeaFood;
    private InterfaceClient interfaceClient;
    private RecyclerView rvSeaFood;
    private List<SeafoodItem> result = new ArrayList<>();
    Context context;

    public SeaFoodFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sea_food, container, false);

        rvSeaFood = v.findViewById(R.id.rv_seafood);
        interfaceClient = RetrofitConfig.creatService(InterfaceClient.class);

        listSeaFood = new ListSeaFood(getActivity(), result);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvSeaFood.setLayoutManager(layoutManager);
        context = getActivity();

        loadSeaFood();

        return v;
    }

    private void loadSeaFood() {
        Call<ResponseSeaFood> request = interfaceClient
                .getSeaFood("title","thumb");
        request.enqueue(new Callback<ResponseSeaFood>() {
            @Override
            public void onResponse(Call<ResponseSeaFood> call, Response<ResponseSeaFood> response) {
                result = response.body().getMeals();
                rvSeaFood.setAdapter(new ListSeaFood(context,result));
                listSeaFood.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseSeaFood> call, Throwable t) {
                Log.e("koneksi gagal", t.toString());

            }
        });
    }

}

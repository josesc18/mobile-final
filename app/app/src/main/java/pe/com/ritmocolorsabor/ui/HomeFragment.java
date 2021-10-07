package pe.com.ritmocolorsabor.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.*;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import pe.com.ritmocolorsabor.R;
import pe.com.ritmocolorsabor.adapter.CategoryAdapter;
import pe.com.ritmocolorsabor.adapter.ProductAdapter;
import pe.com.ritmocolorsabor.api.CategoryApi;
import pe.com.ritmocolorsabor.api.ProductApi;
import pe.com.ritmocolorsabor.model.Category;
import pe.com.ritmocolorsabor.model.Product;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    RecyclerView categoryRecyclerView, productRecyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        getCategories();
        getProducts();

        categoryRecyclerView = view.findViewById(R.id.categorylist);
        productRecyclerView = view.findViewById(R.id.productList);

        categoryRecyclerView.setLayoutManager(
                new LinearLayoutManager(getContext(),
                        LinearLayoutManager.HORIZONTAL,
                        false)
        );
        productRecyclerView.setLayoutManager(
                new LinearLayoutManager(getContext(),
                        LinearLayoutManager.VERTICAL,
                        false)
        );
        return view;
    }

    public void getCategories(){
        Call<List<Category>> call = CategoryApi.getCategoryService().getCategories();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if(!response.isSuccessful()){
                    Log.e("status ",""+response.code());
                    return;
                }

                List<Category> categoryList = response.body();
                CategoryAdapter adapter = new CategoryAdapter(getContext(),categoryList);
                categoryRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Log.e("error onFailure",t.getMessage());
            }
        });

    }

    public void getProducts(){

        Call<List<Product>> call = ProductApi.getProductService().getProducts();
        call.enqueue(new Callback<List<Product>>(){

            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if(!response.isSuccessful()){
                    Log.e("status ",""+response.code());
                    return;
                }
                List<Product> productList = response.body();
                ProductAdapter adapter = new ProductAdapter(getContext(),productList);
                productRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e("error onFailure",t.getMessage());
            }
        });

    }

}
package pe.com.ritmocolorsabor.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;

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


public class HomeActivity extends AppCompatActivity {

    RecyclerView categoryRecyclerView, productRecyclerView;
    BottomNavigationView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        menu = findViewById(R.id.navMemu);
        getCategories();
        getProducts();

        categoryRecyclerView = findViewById(R.id.categorylist);
        productRecyclerView = findViewById(R.id.productList);

        categoryRecyclerView.setLayoutManager(
                new LinearLayoutManager(getApplicationContext(),
                        LinearLayoutManager.HORIZONTAL,
                        false)
        );
        productRecyclerView.setLayoutManager(
                new LinearLayoutManager(getApplicationContext(),
                        LinearLayoutManager.VERTICAL,
                        false)
        );
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
                CategoryAdapter adapter = new CategoryAdapter(getApplicationContext(),categoryList);
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
                ProductAdapter adapter = new ProductAdapter(getApplicationContext(),productList);
                productRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e("error onFailure",t.getMessage());
            }
        });

    }

}
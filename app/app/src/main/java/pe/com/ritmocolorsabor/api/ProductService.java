package pe.com.ritmocolorsabor.api;

import java.util.List;

import pe.com.ritmocolorsabor.model.Product;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {
    @GET("product/")
    Call<List<Product>> getProducts();
}

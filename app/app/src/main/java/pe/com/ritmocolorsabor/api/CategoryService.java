package pe.com.ritmocolorsabor.api;

import java.util.List;

import pe.com.ritmocolorsabor.model.Category;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryService {
    @GET("category/")
    Call<List<Category>> getCategories();
}

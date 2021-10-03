package pe.com.ritmocolorsabor.api;

public class CategoryApi extends ClientAPI {

    public static CategoryService getCategoryService(){
        CategoryService categoryService = getRetrofit().create(CategoryService.class);
        return  categoryService;
    }

}

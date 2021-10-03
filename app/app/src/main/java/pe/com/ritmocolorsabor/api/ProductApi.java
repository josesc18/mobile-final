package pe.com.ritmocolorsabor.api;

public class ProductApi extends ClientAPI{

    public static ProductService getProductService(){
        ProductService productService = getRetrofit().create(ProductService.class);
        return  productService;
    }
}

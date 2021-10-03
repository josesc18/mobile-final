package pe.com.ritmocolorsabor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import pe.com.ritmocolorsabor.R;
import pe.com.ritmocolorsabor.model.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder>{

    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ProductAdapter.MyViewHolder(LayoutInflater
                .from(context)
                .inflate(R.layout.product_item_list, parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.lbl_product_name.setText(product.getName());
        holder.lbl_price.setText("S/ "+product.getPrice());
        holder.lbl_time.setText(product.getTime());
        Glide.with(context)
                .load(product.getImage())
                .into(holder.img_product);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView lbl_product_name,lbl_time,lbl_price;
        ImageView img_product;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            lbl_product_name = itemView.findViewById(R.id.lbl_product_name);
            lbl_time = itemView.findViewById(R.id.lbl_time);
            lbl_price = itemView.findViewById(R.id.lbl_price);
            img_product = itemView.findViewById(R.id.img_product);
        }
    }
}

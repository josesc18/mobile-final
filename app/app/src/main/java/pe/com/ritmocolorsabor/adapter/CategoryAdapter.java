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
import pe.com.ritmocolorsabor.model.Category;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private Context context;
    private List<Category> categoryList;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }


    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new CategoryAdapter.MyViewHolder(LayoutInflater
                .from(context)
                .inflate(R.layout.category_item,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.MyViewHolder holder, int position) {
        holder.category_name.setText(categoryList.get(position).getName());
        Glide.with(context).load(categoryList.get(position).getImage()).into(holder.category_img);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView category_name;
        ImageView category_img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            category_name = itemView.findViewById(R.id.lbl_name);
            category_img = itemView.findViewById(R.id.image_category);
        }
    }
}

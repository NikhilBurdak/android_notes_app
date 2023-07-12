package com.nebclass12organicchemistrynotes.app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nebclass12organicchemistrynotes.app.databinding.ItemSubcategoryBinding;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewHolder> {

    ArrayList<CategoryModel>list;
    Context context;
    int symb =1;

    public CategoryAdapter(ArrayList<CategoryModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_subcategory,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final CategoryModel model= list.get(position);

        holder.binding.subjectName.setText(model.getSubName());
        holder.binding.indicator.setText(String.valueOf(symb));
        holder.binding.subjectName.setTextColor(model.getTextColor());
        holder.binding.roundBack.setBackgroundResource(model.getRoundBack());
        holder.binding.verticalView.setBackgroundResource(model.getVerticalBack());

        symb++;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, ShowPdfActivity.class);
                intent.putExtra("pos",position);
                intent.putExtra("name",model.getSubName());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ItemSubcategoryBinding binding;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            binding = ItemSubcategoryBinding.bind(itemView);

        }
    }

}

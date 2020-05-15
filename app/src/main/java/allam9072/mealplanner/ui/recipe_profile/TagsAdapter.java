package allam9072.mealplanner.ui.recipe_profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import allam9072.mealplanner.R;

public class TagsAdapter extends RecyclerView.Adapter<TagsAdapter.mVH> {
    private Context context;
    private ArrayList<String> tags;

    public TagsAdapter(Context context, ArrayList<String> tags) {
        this.context = context;
        this.tags = tags;
    }

    @NonNull
    @Override
    public mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new mVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_tag, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull mVH holder, int position) {
        holder.textView.setText(tags.get(position));
    }

    @Override
    public int getItemCount() {
        return tags.size();
    }

    public class mVH extends RecyclerView.ViewHolder {
        TextView textView;

        public mVH(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_tag);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "toast", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

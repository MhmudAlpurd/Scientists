package ir.mpkmro.scientists.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import ir.mpkmro.scientists.ContentActivity;
import ir.mpkmro.scientists.Model.Person;
import ir.mpkmro.scientists.R;

public class PersonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Person> personList;
    View view;

    public PersonAdapter(Context context, List<Person> personList) {
        this.context = context;
        this.personList = personList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ItemViewHolder myViewHolder = (ItemViewHolder) holder;
        myViewHolder.item.setAnimation(AnimationUtils.loadAnimation(context,R.anim.item_anim));
        myViewHolder.name.setText(personList.get(position).getName());
        myViewHolder.field.setText(personList.get(position).getField());
        Picasso.with(context).load(personList.get(position).getImage()).resize(128, 128).into(myViewHolder.imageView);

        myViewHolder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ContentActivity.class);
                intent.putExtra("ID",personList.get(position).getId());
                intent.putExtra("NAME",personList.get(position).getName());
                intent.putExtra("FIELD",personList.get(position).getField());
                intent.putExtra("DISC",personList.get(position).getDisc());
                intent.putExtra("IMAGE",personList.get(position).getImage());


                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public void filterList(List<Person> filterList) {
        personList = filterList;
        notifyDataSetChanged();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imageView;
        TextView name, field;
        RelativeLayout item;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_id);
            name = itemView.findViewById(R.id.name_id);
            field = itemView.findViewById(R.id.field_id);
            item = itemView.findViewById(R.id.relative_id);
        }
    }
}

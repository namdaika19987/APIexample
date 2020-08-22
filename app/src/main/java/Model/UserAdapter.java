package Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.o7planning.apiexample.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserItemViewHolder> {
    private List<User> users;
    private Context context;

    public UserAdapter(List<User> users, Context c) {
        this.users = users;
        this.context = c;
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    @Override
    public UserItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);

        return new UserItemViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final UserItemViewHolder holder, final int position) {
        final User u = users.get(position);
        Picasso.with(context)
                .load(u.avatar_url)
                .into(holder.ivAvatar);
        holder.tvLoginName.setText(u.login);
        holder.tvId.setText(String.valueOf(u.id));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "day la item so "+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static class UserItemViewHolder extends RecyclerView.ViewHolder {
        public TextView tvLoginName;
        public TextView tvId;
        public ImageView ivAvatar;

        public UserItemViewHolder(View itemView) {
            super(itemView);
            tvLoginName = (TextView) itemView.findViewById(R.id.tv_login_name);
            tvId = (TextView) itemView.findViewById(R.id.tv_id);
            ivAvatar = (ImageView) itemView.findViewById(R.id.iv_avatar);
        }
    }
}

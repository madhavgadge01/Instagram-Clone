package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagram.R;
import com.example.instagram.data.Post;

import java.util.List;

public class postAdapter extends RecyclerView.Adapter<postAdapter.postViewHolder> {
    private List<Post> postList;
    private Context context;
    public postAdapter(List<Post> postList, Context context) {
        this.postList = postList;
        this.context = context;
    }
    @NonNull
    @Override
    public postViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_post_view, parent, false);
        return new postViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull postViewHolder holder, int position) {
        Post post = postList.get(position);

        // Set user & post data
        holder.userImage.setImageResource(post.getUserImage());
        holder.user_name.setText(post.getUser_name());
        holder.mainImage.setImageResource(post.getMainImage());
        holder.caption.setText(post.getCaption());
        holder.likedText.setText(post.getLikedText());
        holder.commentText.setText(post.getCommentText());

        if (post.isLiked()) {
            holder.likeButton.setImageResource(R.drawable.heartred);
        } else {
            holder.likeButton.setImageResource(R.drawable.likew);
        }
        // SAVE BUTTON: Set icon
        if (post.isSaved()) {
            Toast.makeText(context, "post Saved", Toast.LENGTH_SHORT).show();
            holder.saveButton.setImageResource(R.drawable.savewhite);

        } else {
            holder.saveButton.setImageResource(R.drawable.savew);
        }

        holder.likeButton.setOnClickListener(v -> {
            post.toggleLike();
            notifyItemChanged(holder.getAdapterPosition());
        });

        // SAVE BUTTON: Click listener
        holder.saveButton.setOnClickListener(v -> {
            post.toggleSaved();
            notifyItemChanged(holder.getAdapterPosition());
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    class postViewHolder extends RecyclerView.ViewHolder {
        private ImageView userImage, mainImage, likeButton, saveButton;
        private TextView user_name, likedText, commentText, caption;

        public postViewHolder(@NonNull View itemView) {
            super(itemView);

            userImage = itemView.findViewById(R.id.madhavv);
            mainImage = itemView.findViewById(R.id.mainPostImage);
            user_name = itemView.findViewById(R.id.user_name);
            likedText = itemView.findViewById(R.id.likeTextView);
            commentText = itemView.findViewById(R.id.commentText);
            caption = itemView.findViewById(R.id.postCaption);
            likeButton = itemView.findViewById(R.id.hurtImage);
            saveButton = itemView.findViewById(R.id.saree);
        }
    }
}
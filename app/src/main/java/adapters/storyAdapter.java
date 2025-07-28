package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagram.R;
import com.example.instagram.data.Story;

import java.util.List;

import adapters.listners.removeStoryListener;

public class storyAdapter extends RecyclerView.Adapter<storyAdapter.storyViewHolder> {
    private List<Story> storyList;
    private Context context;
    private removeStoryListener RemoveStoryListener;

    public storyAdapter(List<Story> storyList, Context context) {
        this.storyList = storyList;
        this.context = context;
    }

    public void remove(int position) {
        storyList.remove(position);
        notifyItemRemoved(position);
    }

    public void setOnRemoveStoryListener(removeStoryListener listener){
        this.RemoveStoryListener = listener;
    }

    @NonNull
    @Override
    public storyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.story_single_view,parent,false);
        storyViewHolder storyViewHolder=new storyViewHolder(view);
        return storyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull storyViewHolder holder, int position) {
        Story story=storyList.get(position);
        holder.storyView.setImageResource(story.getStoryImage());
        holder.StoryUserName.setText(story.getUserName());
        holder.storyView.setOnClickListener(View->{
            this.RemoveStoryListener.removeStory(View,position);
        });

    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    class storyViewHolder extends RecyclerView.ViewHolder {
        private ImageView storyView;
        private TextView StoryUserName;
        public storyViewHolder(@NonNull View itemView) {
            super(itemView);

            storyView=itemView.findViewById(R.id.storyImage);
            StoryUserName=itemView.findViewById(R.id.storyUserName);


        }
    }

}

package tr.com.mis49m.hw2base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by antonio on 11/1/2017.
 */

public class AdapterSer extends RecyclerView.Adapter<AdapterSer.ViewHolder>
{

    ArrayList<content> contents;

    public AdapterSer(ArrayList<content> contents) {
        this.contents = contents;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView profil;
        public TextView uname;
        public TextView postlanan;
        public ImageView imgcomment;
        public TextView ccomment;
        public ImageView like;
        public TextView countlike;

        public ViewHolder(View itemView) {
            super(itemView);
            profil = (ImageView) itemView.findViewById(R.id.profil);
            uname = (TextView) itemView.findViewById(R.id.uname);
            postlanan = (TextView) itemView.findViewById(R.id.postlanan);
            imgcomment = (ImageView) itemView.findViewById(R.id.imgcomment);
            ccomment = (TextView) itemView.findViewById(R.id.ccomment);
            like = (ImageView) itemView.findViewById(R.id.like);
            countlike = (TextView) itemView.findViewById(R.id.countlike);

        }
    }

    @Override
    public AdapterSer.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new AdapterSer.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterSer.ViewHolder viewHolder, final int position) {
        final content content = contents.get(position);

        viewHolder.uname.setText(content.getUsername());
        viewHolder.postlanan.setText(content.getMmes());
        viewHolder.ccomment.setText(content.getCountComment());
        viewHolder.countlike.setText(content.getCountLike());
        viewHolder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IncrementLikeCount(viewHolder, position);
            }
        });

    }

    public void IncrementLikeCount(AdapterSer.ViewHolder viewHolder, int position)
    {
        content content = contents.get(position);
        viewHolder.countlike.setText(content.getCountLike());
        content.setCountLike(new Integer(Integer.parseInt(content.getCountLike())+1).toString());
    }

    @Override
    public int getItemCount()
    {
        return contents.size();
    }



}

package com.ttdt.Adaper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ttdt.R;
import com.ttdt.modle.Song;

import java.util.List;

/**
 * Created by Administrator on 2017/9/19.
 */

public class SongListAdapter extends BaseAdapter {

    private Context context;
    private List<Song> songArray = null;
    public SongListAdapter(List<Song> songArray, Context context){
        this.songArray = songArray;
        this.context = context;
    }

    @Override
    public int getCount() {
        return songArray.size();
    }

    @Override
    public Object getItem(int position) {
        return songArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.song_item,null);
            viewHolder.song_name = (TextView) convertView.findViewById(R.id.song_name);
            viewHolder.song_index = (TextView) convertView.findViewById(R.id.song_index);
            viewHolder.song_artist = (TextView) convertView.findViewById(R.id.song_artist);
            viewHolder.song_album = (TextView) convertView.findViewById(R.id.song_album);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        Song song = songArray.get(position);
        viewHolder.song_name.setText(song.getName());
        viewHolder.song_index.setText(String.valueOf(position+1));
        viewHolder.song_artist.setText(song.getArtist());
        viewHolder.song_album.setText("--" + song.getAlbumName());
        return convertView;
    }
    class ViewHolder {
        TextView song_index;
        TextView song_name;
        TextView song_artist;
        TextView song_album;
    }

}

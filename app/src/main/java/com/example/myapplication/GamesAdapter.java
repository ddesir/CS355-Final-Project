package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.MessageFormat;
import java.util.ArrayList;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.ViewHolder> {
    private ArrayList<String> Databank;

    public GamesAdapter(ArrayList<String> listings) {
        Databank = listings;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Name;
        public TextView Type;
        public TextView GameServers;
        public TextView DevName;
        public ImageView Icon;
        public ImageView Icon2;

        public ViewHolder(View list) {
            super(list);
            Icon = list.findViewById(R.id.imageView);
            Name = list.findViewById(R.id.textView);
            Type = list.findViewById(R.id.textView2);

            Icon2 = list.findViewById(R.id.imageView);
            GameServers = list.findViewById(R.id.textView);
            DevName = list.findViewById(R.id.textView2);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup primary, int viewType) {
        Context context = primary.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View productView = inflater.inflate(R.layout.list_layout, primary, false);
        return new ViewHolder(productView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        String gameList = Databank.get(position);
        int count = 0;
        char newChar = '-';


        for (int i = 0; i < gameList.length(); i++) {
            if (gameList.charAt(i) == newChar) {
                count++;
            }
        }

        if (count == 1) {
            String Name;
            String Type;
            String[] PopList = gameList.split("-");
            Name = PopList[0];
            Type = PopList[1];

            ImageView imageView = viewHolder.Icon;

            switch (Type) {
                case "Racing":
                    imageView.setImageResource(R.drawable.racing);
                    break;
                case "Open World":
                    imageView.setImageResource(R.drawable.open_world);
                    break;
                case "Adventure":
                    imageView.setImageResource(R.drawable.adventure);
                    break;
                case "Sports":
                    imageView.setImageResource(R.drawable.sports);
                    break;
                case "Action":
                    imageView.setImageResource(R.drawable.action);
                    break;
                case "RPG":
                    imageView.setImageResource(R.drawable.rpg);
                    break;
                case "MMO":
                    imageView.setImageResource(R.drawable.mmo);
                    break;
                case "Shooter":
                    imageView.setImageResource(R.drawable.shooter);
                    break;
                case "Fighting":
                    imageView.setImageResource(R.drawable.fighting);
                    break;
                case "Gore":
                    imageView.setImageResource(R.drawable.gore);
                    break;
                case "Post-Apocalyptic":
                    imageView.setImageResource(R.drawable.post_apocalyptic);
                    break;
                case "Violent":
                    imageView.setImageResource(R.drawable.voilent);
                    break;
                case "FPS":
                    imageView.setImageResource(R.drawable.fps);
                    break;
                case "Co-Op":
                    imageView.setImageResource(R.drawable.co_op);
                    break;
                case "Single-Player":
                    imageView.setImageResource(R.drawable.single_player);
                    break;
                case "Millitary":
                    imageView.setImageResource(R.drawable.military);
                    break;
                case "Simulation":
                    imageView.setImageResource(R.drawable.racing);
                    break;
                case "Realistic":
                    imageView.setImageResource(R.drawable.racing);
                    break;
                case "MMORPG":
                    imageView.setImageResource(R.drawable.racing);
                    break;
                case "Massively Multiplayer":
                    imageView.setImageResource(R.drawable.racing);
                    break;
                case "Demons":
                    imageView.setImageResource(R.drawable.racing);
                    break;
                case "Zombies":
                    imageView.setImageResource(R.drawable.zombies);
                    break;
                case "Hack and Slash":
                    imageView.setImageResource(R.drawable.racing);
                    break;
                case "Turned-Based Combat":
                    imageView.setImageResource(R.drawable.racing);
                    break;
                case "JPRG":
                    imageView.setImageResource(R.drawable.racing);
                    break;
                case "Survival":
                    imageView.setImageResource(R.drawable.racing);
                    break;
                case "Team Based Shooter":
                    imageView.setImageResource(R.drawable.team_based_shooter);
                    break;
                case "Music":
                    imageView.setImageResource(R.drawable.music);
                    break;
                case "Dance":
                    imageView.setImageResource(R.drawable.racing);
                    break;
                case "Strategy":
                    imageView.setImageResource(R.drawable.racing);
                    break;
            }

            TextView textView = viewHolder.Name;
            textView.setText(Name);
            TextView textView2 = viewHolder.Type;
            textView2.setText(Type);
        }

        else if (count == 1) {
            String GameServers;
            String DevName;
            ImageView imageView = viewHolder.Icon2;

            String[] PopList = gameList.split("/");
            GameServers = PopList[1];

            switch (GameServers) {
                case "EA/Origin":
                    imageView.setImageResource(R.drawable.racing);
                    break;
                case "Battlenet":
                    imageView.setImageResource(R.drawable.racing);
                    break;
                case "Steam":
                    imageView.setImageResource(R.drawable.racing);
                    break;
                case "Uplay":
                    imageView.setImageResource(R.drawable.racing);
                    break;
                case "Epic Games":
                    imageView.setImageResource(R.drawable.racing);
                    break;
            }
            TextView textView = viewHolder.GameServers;
            textView.setText(GameServers);
        }
    }

    @Override
    public int getItemCount(){
        return Databank.size();
    }
}
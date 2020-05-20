package io.agora.tutorials1v1vcall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VideoFolderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_folder);

        RecyclerView recycler_view=findViewById(R.id.recycler_view);

        HomeListAdapter mHomeListAdapter = new HomeListAdapter(R.layout.item_layout, getFilesAllName("/storage/emulated/0/ScreenRecord"));
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        recycler_view.setAdapter(mHomeListAdapter);

        mHomeListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(VideoFolderActivity.this,VideoActivity.class).putExtra("path","/storage/emulated/0/ScreenRecord/"+getFilesAllName("/storage/emulated/0/ScreenRecord").get(position).getName()));
            }

        });
    }

    public static List<Item> getFilesAllName(String path) {
        File file=new File(path);
        File[] files=file.listFiles();
        if (files == null){
            Log.e("error","空目录");return null;}
        List<Item> s = new ArrayList<>();

        for(int i =0;i<files.length;i++){
            Item item=new Item();
            item.setName(files[i].getName());
            String time = new SimpleDateFormat("yyyy-MM-dd")
                    .format(new Date(files[i].lastModified()));
            item.setTime(time);
            s.add(0,item);
        }
        return s;
    }
}

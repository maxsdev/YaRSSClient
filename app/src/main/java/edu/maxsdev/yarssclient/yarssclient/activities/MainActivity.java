package edu.maxsdev.yarssclient.yarssclient.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.maxsdev.yarssclient.yarssclient.R;
import edu.maxsdev.yarssclient.yarssclient.adapters.OnItemClickListener;
import edu.maxsdev.yarssclient.yarssclient.adapters.RssChannelsAdapter;
import edu.maxsdev.yarssclient.yarssclient.entities.RssChannel;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Channels");

//        RssReader rssReader = new RssReader(getString(R.string.new_york_times_home_page_feed));
//        try {
//            List<RssItem> items = rssReader.getItems();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        RssChannelsAdapter adapter = new RssChannelsAdapter(getChannelsList(), new OnItemClickListener() {
            @Override
            public void onItemClick(RssChannel channel) {
                Toast.makeText(MainActivity.this, channel.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.content_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private List<RssChannel> getChannelsList() {
        List<RssChannel> list = new ArrayList<>();
        list.add(new RssChannel("New York Times home page",
                getString(R.string.new_york_times_home_page_feed), "New York Times home page"));
        list.add(new RssChannel("New York Times music news",
                getString(R.string.new_york_times_music_news_feed), "New York Times music news"));
        list.add(new RssChannel("Reuters technology news",
                getString(R.string.reuters_technology_news_feed), "Reuters technology news"));
        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

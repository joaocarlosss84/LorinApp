package com.example.joaocarlosss.lorinapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TabHost tabs = (TabHost) findViewById(R.id.tabHost);
        tabs.setup();
        tabs.setCurrentTab(0);

        for (int i = 0; i < 5; i++) {
            TabHost.TabSpec spec1 = tabs.newTabSpec("tag"+i);

            spec1.setContent(new TabHost.TabContentFactory() {
                public View createTabContent(String tag) {
                    View wv = getLayoutInflater().inflate(R.layout.activity_tab, tabs.getTabContentView(), false);
                    //you can change tab content here
                    ((Button) wv.findViewById(R.id.button)).setText("Button "+tag);
                    return(wv);
                }
            });
            spec1.setIndicator("Tab "+i);
            tabs.addTab(spec1);
        }

    }
}

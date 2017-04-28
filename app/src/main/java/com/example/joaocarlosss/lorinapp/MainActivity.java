package com.example.joaocarlosss.lorinapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    private int iCurrentTab;
    private TabHost tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tabs = (TabHost) findViewById(R.id.tabHost);
        tabs.setup();
        tabs.setCurrentTab(0);

        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener(){
            @Override
            public void onTabChanged(String tabId) {
//                this.iCurrentTab = tabId
//                if(TAB_1_TAG.equals(tabId)) {
//                    //destroy earth
//                }
//                if(TAB_2_TAG.equals(tabId)) {
//                    //destroy mars
//                }
            }});

        //oTP.getHour();
        //oTP.getMinute();


        for (int i = 0; i < 5; i++) {
            TabHost.TabSpec spec1 = tabs.newTabSpec("tag"+i);

            spec1.setContent(new TabHost.TabContentFactory() {
                public View createTabContent(String tag) {
                    View wv = getLayoutInflater().inflate(R.layout.activity_tab, tabs.getTabContentView(), false);
                    //you can change tab content here
                    ((Button) wv.findViewById(R.id.button)).setText("Button "+tag);
                    TimePicker oTP = (TimePicker) wv.findViewById(R.id.timePicker);
                    oTP.setIs24HourView(true);
                    oTP.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                        public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                            updateDisplay(hourOfDay, minute);
                        }
                    });

                    return(wv);
                }
            });
            spec1.setIndicator("Tab "+i);
            tabs.addTab(spec1);
        }

    }

    private void updateDisplay(int hourOfDay, int minute) {

        this.iCurrentTab = tabs.getCurrentTab();

    }
}

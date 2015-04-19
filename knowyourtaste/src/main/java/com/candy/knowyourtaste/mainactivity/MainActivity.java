package com.candy.knowyourtaste.mainactivity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.candy.knowyourtaste.R;
import com.candy.knowyourtaste.mainactivity.adapter.DrawerListAdapter;
import com.candy.knowyourtaste.mainactivity.fragments.RecommendFragment;
import com.candy.knowyourtaste.mainactivity.fragments.SocialFragment;

/**
 * Created by maqiang on 2015/4/18.
 */
public class MainActivity extends Activity {


    private Fragment[] mFragments;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragments=new Fragment[] {new RecommendFragment(),new SocialFragment(),new SocialFragment()};
        getFragmentManager().beginTransaction().replace(R.id.activity_main_fragments_container,mFragments[0])
                .commit();

        initDrawerLayout();
    }

    //≥ı ºªØDrawerLayout
    private void initDrawerLayout(){
        ListView mDrawerList;
        DrawerListAdapter mDrawerAdapter;
        final DrawerLayout mDrawerLayout;

        mDrawerLayout=(DrawerLayout)findViewById(R.id.activity_main_drawerLayout);
        mDrawerList=(ListView)findViewById(R.id.activity_main_drawer_listView);

        mDrawerAdapter=new DrawerListAdapter();
        mDrawerList.setAdapter(mDrawerAdapter);
        mDrawerList.setSelection(0);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getFragmentManager().beginTransaction().replace(R.id.activity_main_fragments_container,mFragments[position])
                        .commit();
                mDrawerLayout.closeDrawer(GravityCompat.START);
            }
        });
    }
}

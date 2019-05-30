package cn.edu.gdpt.viewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ViewPager vp;
    private List<View> list;
    private int[] imgs=new int[]{R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a};
    private vpAdapter vpAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        list=new ArrayList<>();
        for (int i=0;i<10;i++){
            View view=View.inflate(Main2Activity.this,R.layout.vp_item,null);
            ImageView imageView=view.findViewById(R.id.vp_item_iv);

            list.add(view);
            vpAdapter=new vpAdapter(list);
            vp.setAdapter(vpAdapter);
        }

    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
    }
}

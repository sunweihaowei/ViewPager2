package cn.edu.gdpt.viewpager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //总结，
    /*
    适配器，4方法
    项数，是否等于，add图，销毁图


    */
    private ViewPager vp;
    private int[] imgs=new int[]{R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a};
    private List<ImageView> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        for (int i=0;i<imgs.length;i++){
            ImageView imageView=new ImageView(MainActivity.this);
            imageView.setImageResource(imgs[i]);
            list.add(imageView);
        }

        MyPagerAdapter adapter=new MyPagerAdapter();
        vp.setAdapter(adapter);
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
    }
    class MyPagerAdapter extends PagerAdapter{
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        //这个布局等于对象，一般为下面
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view==o;
        }

        @NonNull
        @Override
        //加到页上去
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }

        @Override
        //销毁指定页
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}

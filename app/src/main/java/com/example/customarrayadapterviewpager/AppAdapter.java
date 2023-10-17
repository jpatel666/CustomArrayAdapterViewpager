package com.example.customarrayadapterviewpager;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class AppAdapter extends PagerAdapter {   //Alt+Enter

    //In ViewPager:-extends PagerAdapter {....}

    Activity mainActivity;
      //                                     //
    //MainActivity Is Not Use But Use Is Activity
    //Because Activity Is Use Of AppAdapter.class Is More Than One Use

    int[] img;

    public AppAdapter(Activity mainActivity, int[] img) {
        this.mainActivity = mainActivity;
        this.img = img;
    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;     //Condition Is True Otherwise Not Working
    }

    @NonNull
    @Override                                       //container
    public Object instantiateItem(@NonNull ViewGroup container, int position) {   //insta...(instantiateItem) Method Create Self

       //return super.instantiateItem(container, position);-----Remove Line
                                                                                          //
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.app_item_layour,container,false);
        ImageView ivImg = view.findViewById(R.id.ivImg);
        ivImg.setImageResource(img[position]);
        container.addView(view);               //container(Box) Store view
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {  //dest...(destroyItem) Method Create Self

        //super.destroyItem(container, position, object);-----Remove Line

        container.removeView((View) object);   //Casting view==object
    }
}

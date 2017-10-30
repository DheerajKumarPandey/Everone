package com.everone;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.everone.custome.CustomActivity;
import com.everone.fragment.FragmentDrawer;

import java.util.HashMap;

public class MainActivity extends CustomActivity implements BaseSliderView.OnSliderClickListener,
        ViewPagerEx.OnPageChangeListener,FragmentDrawer.FragmentDrawerListener{
    private SliderLayout slider_home_frag;
    private ImageButton img_btn_menu;
    private DrawerLayout drawer;
    private FragmentDrawer drawerFragment;
    private CardView card_car_booking, card_credit_card,card_flight,
            card_food,card_hotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img_btn_menu=(ImageButton)findViewById(R.id.img_btn_menu);
        slider_home_frag = (SliderLayout)findViewById(R.id.slider_home_frag);
        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("",R.drawable.banner);
        file_maps.put("",R.drawable.banner);
        file_maps.put("",R.drawable.banner);
        file_maps.put("",R.drawable.banner);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        DrawerLayout.LayoutParams lll = (DrawerLayout.LayoutParams) drawer.getLayoutParams();

//        lll.set
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        drawerFragment = (FragmentDrawer) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout), null);
        drawerFragment.setDrawerListener(this);
        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            slider_home_frag.addSlider(textSliderView);
        }
        slider_home_frag.setPresetTransformer(SliderLayout.Transformer.Default);
        slider_home_frag.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        slider_home_frag.setCustomAnimation(new DescriptionAnimation());
        slider_home_frag.setDuration(4000);
        slider_home_frag.addOnPageChangeListener(this);

        img_btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        card_car_booking=(CardView)findViewById(R.id.card_car_booking);
        card_credit_card=(CardView)findViewById(R.id.card_credit_card);
        card_flight=(CardView)findViewById(R.id.card_flight);
        card_food=(CardView)findViewById(R.id.card_food);
        card_hotel=(CardView)findViewById(R.id.card_hotel);


        card_car_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation shake;
                shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
                card_car_booking.startAnimation(shake);
            }
        });
        card_credit_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation shake;
                shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
                card_credit_card.startAnimation(shake);

            }
        });
        card_flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation shake;
                shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
                card_flight.startAnimation(shake);
            }
        });
        card_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation shake;
                shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
                card_food.startAnimation(shake);
            }
        });
        card_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation shake;
                shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
                card_hotel.startAnimation(shake);
            }
        });
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
////hkjhahkjgahkjhagkjhkjaghkjaghkjahgk
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onDrawerItemSelected(View view, int position) {

    }
}

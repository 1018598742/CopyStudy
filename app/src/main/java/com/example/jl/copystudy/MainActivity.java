package com.example.jl.copystudy;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.jl.copystudy.databinding.ActivityMainBinding;
import com.example.jl.copystudy.http.rx.RxBus;
import com.example.jl.copystudy.http.rx.RxBusBaseMessage;
import com.example.jl.copystudy.http.rx.RxCodeConstants;
import com.example.jl.copystudy.ui.book.BookFragment;
import com.example.jl.copystudy.ui.gank.GankFragment;
import com.example.jl.copystudy.ui.menu.NavAboutActivity;
import com.example.jl.copystudy.ui.menu.NavDeedBackActivity;
import com.example.jl.copystudy.ui.menu.NavDownloadActivity;
import com.example.jl.copystudy.ui.menu.NavHomePageActivity;
import com.example.jl.copystudy.ui.one.OneFragment;
import com.example.jl.copystudy.utils.CommonUtils;
import com.example.jl.copystudy.utils.ImgLoadUtil;
import com.example.jl.copystudy.view.MyFragmentPagerAdapter;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

import rx.functions.Action1;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private ActivityMainBinding mBinding;
    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private FloatingActionButton fab;
    private Toolbar toolbar;
    private FrameLayout llTitleMenu;
    private ViewPager vpContent;
    private ImageView llTitleGank;
    private ImageView llTitleDou;
    private ImageView llTitleOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initId();
        initRxBus();
        //StatusBarUtil 状态栏工具类（实现沉浸式状态栏/变色状态栏）
        StatusBarUtil.setColorNoTranslucentForDrawerLayout(MainActivity.this, drawerLayout
                , CommonUtils.getColor(R.color.colorTheme));
        initContentFragment();
        initDrawerLayout();
        initListener();
    }


    private void initListener() {
        llTitleMenu.setOnClickListener(this);
        llTitleGank.setOnClickListener(this);
        llTitleDou.setOnClickListener(this);
        llTitleOne.setOnClickListener(this);
        fab.setOnClickListener(this);
    }

    //添加窗口布局 inflateHeaderView进来的布局要宽一些
    private void initDrawerLayout() {
        navView.inflateHeaderView(R.layout.nav_header_main);
        View headerView = navView.getHeaderView(0);
        ImageView ivAvatar = (ImageView) headerView.findViewById(R.id.iv_avatar);
        ImgLoadUtil.displayCircle(ivAvatar, R.drawable.ic_avatar);
        LinearLayout llNavHomepage = (LinearLayout) headerView.findViewById(R.id.ll_nav_homepage);
        LinearLayout llNavAbout = (LinearLayout) headerView.findViewById(R.id.ll_nav_about);
        LinearLayout llNavScanDownload = (LinearLayout) headerView.findViewById(R.id.ll_nav_scan_download);
        LinearLayout llNavDeedback = (LinearLayout) headerView.findViewById(R.id.ll_nav_deedback);
        llNavHomepage.setOnClickListener(this);
        llNavAbout.setOnClickListener(this);
        llNavDeedback.setOnClickListener(this);
        llNavScanDownload.setOnClickListener(this);

    }

    private void initContentFragment() {
        ArrayList<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(new GankFragment());
        mFragmentList.add(new OneFragment());
        mFragmentList.add(new BookFragment());
        //注意的是：getSupportFragmentManager()
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), mFragmentList);
        vpContent.setAdapter(adapter);
        //设置viewpager最大缓存的页面个数(cpu消耗少)
        vpContent.setOffscreenPageLimit(2);

        vpContent.addOnPageChangeListener(this);
        llTitleGank.setSelected(true);
        vpContent.setCurrentItem(0);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //去除默认title显示
            actionBar.setDisplayShowTitleEnabled(false);
        }


    }

    /**
     * 每日推荐点击"新电影热映榜"跳转
     */
    private void initRxBus() {
        RxBus.getDefault().toObservable(RxCodeConstants.JUMP_TYPE_TO_ONE, RxBusBaseMessage.class)
                .subscribe(new Action1<RxBusBaseMessage>() {
                    @Override
                    public void call(RxBusBaseMessage message) {
                        vpContent.setCurrentItem(1);
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    private void initId() {
        drawerLayout = mBinding.drawerLayout;
        navView = mBinding.navView;
        fab = mBinding.include.fab;
        toolbar = mBinding.include.toolbar;
        llTitleMenu = mBinding.include.llTitleMenu;
        vpContent = mBinding.include.vpContent;

//        fab.setVisibility(View.GONE);

        llTitleGank = mBinding.include.ivTitleGank;
        llTitleDou = mBinding.include.ivTitleDou;
        llTitleOne = mBinding.include.ivTitleOne;
    }

    //menu搜索按钮
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //点击搜索按钮
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_title_menu://开启菜单
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.ll_nav_homepage://主页
                drawerLayout.closeDrawer(GravityCompat.START);
                drawerLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        NavHomePageActivity.start(MainActivity.this);
                    }
                }, 360);
                break;
            case R.id.ll_nav_scan_download://扫码下载
                drawerLayout.closeDrawer(GravityCompat.START);
                drawerLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        NavDownloadActivity.start(MainActivity.this);
                    }
                }, 360);
                break;
            case R.id.ll_nav_deedback://问题反馈
                drawerLayout.closeDrawer(GravityCompat.START);
                drawerLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        NavDeedBackActivity.start(MainActivity.this);
                    }
                }, 360);
                break;
            case R.id.ll_nav_about://关于项目
                drawerLayout.closeDrawer(GravityCompat.START);
                drawerLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        NavAboutActivity.start(MainActivity.this);
                    }
                }, 360);
                break;
            case R.id.iv_title_gank://干货栏
                if (vpContent.getCurrentItem() != 0) {//不然cpu会有损耗
                    llTitleGank.setSelected(true);
                    llTitleOne.setSelected(false);
                    llTitleDou.setSelected(false);
                    vpContent.setCurrentItem(0);
                }
                break;
            case R.id.iv_title_one://电影栏
                if (vpContent.getCurrentItem() != 1) {
                    llTitleOne.setSelected(true);
                    llTitleGank.setSelected(false);
                    llTitleDou.setSelected(false);
                    vpContent.setCurrentItem(1);
                }
                break;
            case R.id.iv_title_dou://书籍栏
                if (vpContent.getCurrentItem() != 2) {
                    llTitleDou.setSelected(true);
                    llTitleGank.setSelected(false);
                    llTitleOne.setSelected(false);
                    vpContent.setCurrentItem(2);
                }
                break;
        }
    }

    //退出键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                //不退出程序，进入后台
                moveTaskToBack(true);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //返回按键如果窗口开着关闭窗口
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    //    ViewPager.OnPageChangeListener需要实现的方法
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                llTitleGank.setSelected(true);
                llTitleOne.setSelected(false);
                llTitleDou.setSelected(false);
                break;
            case 1:
                llTitleOne.setSelected(true);
                llTitleGank.setSelected(false);
                llTitleDou.setSelected(false);
                break;
            case 2:
                llTitleDou.setSelected(true);
                llTitleGank.setSelected(false);
                llTitleOne.setSelected(false);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

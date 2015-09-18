package ruanyun.com.fragmenttabhost;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

/**
 *
 * @author zqy
 *
 */
public class MainActivity extends FragmentActivity {

    /**
     * FragmentTabhost
     */
    private FragmentTabHost mTabHost;

    /**
     * 布局填充器
     *
     */
    private LayoutInflater mLayoutInflater;

    /**
     * Fragment数组界面
     *
     */
    private Class mFragmentArray[] = { HomeFragment.class, MeassageFragment.class,
            SelfinfoFragment.class, SquareFragment.class, MoreFragment.class };

    /**
     * 存放图片数组
     *
     */
    private int mImageArray[] = { R.drawable.icon_home,
            R.drawable.icon_meassage, R.drawable.icon_selfinfo,
            R.drawable.icon_square, R.drawable.icon_more};

    /**
     * 选修卡文字
     *
     */
    private int mTextArray[] = { R.string.home, R.string.meassage,
            R.string.selfinfo, R.string.square, R.string.more};

    /**
     *
     *
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    /**
     * 初始化组件
     */
    private void initView() {
        mLayoutInflater = LayoutInflater.from(this);

        // 找到TabHost
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        // 得到fragment的个数
        int count = mFragmentArray.length;
        for (int i = 0; i < count; i++) {
            // 给每个Tab按钮设置图标、文字和内容
            TabSpec tabSpec = mTabHost.newTabSpec(getResources().getString(mTextArray[i]))
                    .setIndicator(getTabItemView(i));
            // 将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec, mFragmentArray[i], null);
            // 设置Tab按钮的背景
            mTabHost.getTabWidget().getChildAt(i)
                    .setBackgroundResource(R.drawable.home_btn_bg_selected);
        }
    }

    /**
     *
     * 给每个Tab按钮设置图标和文字
     */
    private View getTabItemView(int index) {
        View view = mLayoutInflater.inflate(R.layout.item_tab_view, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        imageView.setImageResource(mImageArray[index]);
        TextView textView = (TextView) view.findViewById(R.id.text);
        textView.setText(mTextArray[index]);
        //ColorStateList颜色状态改变列表，不同状态文字颜色不同
        ColorStateList csl = getResources().getColorStateList(R.color.text_color_selected);
        if (csl != null) {
            textView.setTextColor(csl);
        }
        return view;
    }

}

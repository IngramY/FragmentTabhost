package ruanyun.com.fragmenttabhost;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;


public class MainActivity extends FragmentActivity {

    FrameLayout tabs;
    FrameLayout tabcontent;
    FragmentTabHost tabhost;

    private LayoutInflater layoutInflater;


    private Class fragments[] = { HomeFragment.class, MeassageFragment.class,
    MoreFragment.class, SelfinfoFragment.class, SquareFragment.class};


    private String textviewArray[] = { "首页", "消息", "好友", "广场", "更多" };

    int[] icon ={R.drawable.icon_home, R.drawable.icon_meassage,
            R.drawable.icon_selfinfo, R.drawable.icon_square, R.drawable.icon_more};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TextView textView = (TextView) findViewById(R.id.text1);

        layoutInflater = LayoutInflater.from(this);
        initView();

    }

    private void initView() {
        tabhost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabs = (FrameLayout) findViewById(R.id.realtabcontent);
        tabcontent = (FrameLayout) findViewById(android.R.id.tabcontent);

        tabhost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        //添加tab视图
        for (int i = 0; i < fragments.length; i++ ) {
            TabHost.TabSpec tabSpec = tabhost.newTabSpec(textviewArray[i])
                    .setIndicator(getItemView(i));
            tabhost.addTab(tabSpec, fragments[i], null );
            tabhost.getTabWidget().getChildAt(i)
                    .setBackgroundResource(R.drawable.home_btn_bg);

        }
    }

    public View getItemView(int index) {
        View v = layoutInflater.inflate(R.layout.item_tab_view, null);

        ImageView image = (ImageView) v.findViewById(R.id.image);
        image.setImageResource(icon[index]);

        TextView text = (TextView) v.findViewById(R.id.text);
        text.setText(textviewArray[index]);

        return v;
    }
}

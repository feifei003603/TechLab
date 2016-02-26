package com.soulrelay.techlab.activity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.soulrelay.techlab.R;
import com.soulrelay.techlab.Utils.DisplayImageOptionsUtil;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) this.findViewById(R.id.imageView);
        DisplayImageOptions options = DisplayImageOptionsUtil.getOptions(R.mipmap.ic_launcher);
        ImageLoader.getInstance().displayImage("http://creatim.qtmojo.cn/imedia/csdn/20160223/17_33_12_8D4C3D7E.jpg",imageView,options);
        String channel = getAppMetaData("APP_CHANNEL");
        if(channel != null)
            Toast.makeText(this, channel, Toast.LENGTH_SHORT).show();
    }

    /**
     * 获取Application下面的metaData
     * @param meta_name
     * @return
     * @author SuS
     * @date   2016年2月25日
     */
    public String getAppMetaData(String meta_name){
        try {
            ApplicationInfo appInfo = this.getPackageManager()
                    .getApplicationInfo(getPackageName(),PackageManager.GET_META_DATA);
            return appInfo.metaData.getString(meta_name);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

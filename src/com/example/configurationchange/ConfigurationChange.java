package com.example.configurationchange;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

//动态的修改系统屏幕的方向
public class ConfigurationChange extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bn = (Button)findViewById(R.id.bn);
        bn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Configuration configuration = getResources().getConfiguration(); //获取系统的Configuration对象
				//如果当前是横屏
				if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
				{
					ConfigurationChange.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//设为竖屏
				}
				//如果当前是竖屏
				if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
				{
					ConfigurationChange.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//设为横屏
				}
				
			}
		});
        
   }
    
    //重写该方法，用于监听系统设置的更改，主要是监控屏幕方向的更改
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
    	// TODO Auto-generated method stub
    	super.onConfigurationChanged(newConfig);
    	
    	String screen = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE ? "横向屏幕":"竖向屏幕";
    	Toast.makeText(this, "系统的屏幕方向发生改变" + "\n修改后的屏幕方向为:" + screen, Toast.LENGTH_LONG).show();
    	
    }
    
}

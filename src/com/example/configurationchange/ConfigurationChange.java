package com.example.configurationchange;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

//��̬���޸�ϵͳ��Ļ�ķ���
public class ConfigurationChange extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bn = (Button)findViewById(R.id.bn);
        bn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Configuration configuration = getResources().getConfiguration(); //��ȡϵͳ��Configuration����
				//�����ǰ�Ǻ���
				if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
				{
					ConfigurationChange.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//��Ϊ����
				}
				//�����ǰ������
				if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
				{
					ConfigurationChange.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//��Ϊ����
				}
				
			}
		});
        
   }
    
    //��д�÷��������ڼ���ϵͳ���õĸ��ģ���Ҫ�Ǽ����Ļ����ĸ���
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
    	// TODO Auto-generated method stub
    	super.onConfigurationChanged(newConfig);
    	
    	String screen = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE ? "������Ļ":"������Ļ";
    	Toast.makeText(this, "ϵͳ����Ļ�������ı�" + "\n�޸ĺ����Ļ����Ϊ:" + screen, Toast.LENGTH_LONG).show();
    	
    }
    
}

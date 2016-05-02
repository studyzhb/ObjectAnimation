package com.cooshow.objectanamition;

import java.util.ArrayList;
import java.util.List;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

public class TestActivity extends Activity implements OnClickListener{
	private int[] res={R.id.imageView1,R.id.imageView2,R.id.imageView3,R.id.imageView4,R.id.imageView5,R.id.imageView6};
	private List<ImageView> list=new ArrayList<ImageView>();
	private boolean flag;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tests);
		for(int i=0;i<res.length;i++){
			ImageView iv=(ImageView) findViewById(res[i]);
			iv.setOnClickListener(this);
			list.add(iv);
		}
		
	}
/**
public void move(View view){
	ImageView iv=(ImageView) findViewById(R.id.imageView1);
	//属性动画
//	ObjectAnimator.ofFloat(iv, "translationX", 0,200f).setDuration(1000).start();//X轴移动 
	
	//第2种 优化
//	PropertyValuesHolder p1=PropertyValuesHolder.ofFloat("translationX", 0,200f);
//	PropertyValuesHolder p2=PropertyValuesHolder.ofFloat("translationY", 0,200f);
//	PropertyValuesHolder p3=PropertyValuesHolder.ofFloat("rotation", 0,360f);
//	ObjectAnimator.ofPropertyValuesHolder(iv, p1,p2,p3).setDuration(1000).start();
	
	//结合 
	AnimatorSet set=new AnimatorSet();
	ObjectAnimator oa1=ObjectAnimator.ofFloat(iv, "translationX", 0,200f);
	ObjectAnimator oa2=ObjectAnimator.ofFloat(iv, "translationY", 0,200f);
	ObjectAnimator oa3=ObjectAnimator.ofFloat(iv, "rotation", 0,360f);
//	set.playTogether(oa1,oa2,oa3);//一起
//	set.playSequentially(oa1,oa2,oa3);//顺序播放
	set.play(oa1).with(oa2);
	set.play(oa3).after(oa2);//平移在一起，最后在旋转
	set.setDuration(1000);
	set.start();
}
*/

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imageView1:
			if(flag){
			startAnimat();
			}else{
				closeAnimat();
			}
			break;

		default:
			Toast.makeText(this, "click"+v.getId(), Toast.LENGTH_SHORT).show();
			break;
		}
		
	}
private void closeAnimat() {
	for(int i=1;i<res.length;i++){
		AnimatorSet set=new AnimatorSet();
		ObjectAnimator oa1=ObjectAnimator.ofFloat(list.get(i), "translationX",(float)Math.sin(Math.toRadians((i-1)*90/(5-1)))*200 ,0);
		ObjectAnimator oa2=ObjectAnimator.ofFloat(list.get(i), "translationY",(float)Math.cos(Math.toRadians((i-1)*90/(5-1)))*200 ,0);
		set.playTogether(oa1,oa2);
		set.setDuration(3000);
		set.setInterpolator(new BounceInterpolator());
//		set.setStartDelay(i*300);
		set.start();
		flag=true;
		
	}
	
}
/**
 * 菜单展开
 */
private void startAnimat() {
	// TODO Auto-generated method stub
	for(int i=1;i<res.length;i++){
		AnimatorSet set=new AnimatorSet();
		ObjectAnimator oa1=ObjectAnimator.ofFloat(list.get(i), "translationX",0,(float)Math.sin(Math.toRadians((i-1)*90/(5-1)))*200 );
		ObjectAnimator oa2=ObjectAnimator.ofFloat(list.get(i), "translationY",0,(float)Math.cos(Math.toRadians((i-1)*90/(5-1)))*200 );
		set.playTogether(oa1,oa2);
		set.setDuration(3000);
//		set.setStartDelay(i*300);
		set.start();
		flag=false;
		
	}
}
	
	/**
	 * 监听事件
	 */
//	public void move(View view){
//		ObjectAnimator oa1=ObjectAnimator.ofFloat(view, "alpha", 0,1f);
//		oa1.setDuration(1000).start();
//		oa1.addListener(new AnimatorListenerAdapter() {
//			@Override
//			public void onAnimationEnd(Animator animation) {
//				Toast.makeText(TestActivity.this,"click", Toast.LENGTH_SHORT).show();
//			}
//		});
//	}
}

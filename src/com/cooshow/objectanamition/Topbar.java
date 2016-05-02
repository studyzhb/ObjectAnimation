package com.cooshow.objectanamition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
/*
 * 制定
 * 自定义View
 * 
 */
public class Topbar extends RelativeLayout {
	/*
	 * 自定义中控件
	 */
	private Button leftbtn,rightbtn;
	private TextView textView;
	/**
	 * 自定义控件的属性
	 */
	private int leftTextColor;
	private Drawable leftBackground;
	private String leftText;
	
	private int rightTextColor;
	private Drawable rightBackground;
	private String rightText;
	
	private float titleSize;
	private int textColor;
	private String titleText;
	
	private TopbarClickListener clickListener;
	
	//把控件放入布局中
	private LayoutParams leftParams,rightParams,titleParams;
	
	/**
	 * 没有自定义的属性所以不用调用3个参数的构造方法
	 * 
	 * @param context
	 */
	public Topbar(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public Topbar(Context context, AttributeSet attrs) {
		super(context, attrs);
		//获取自定义的属性集合
		TypedArray ta=context.obtainStyledAttributes(attrs,R.styleable.Topbar);
		//获取属性值
		leftTextColor=ta.getColor(R.styleable.Topbar_leftTextColor, 0);
		leftBackground=ta.getDrawable(R.styleable.Topbar_leftBackground);
		leftText=ta.getString(R.styleable.Topbar_leftText);
		
		rightTextColor=ta.getColor(R.styleable.Topbar_rightTextColor, 0);
		rightBackground=ta.getDrawable(R.styleable.Topbar_rightBackground);
		rightText=ta.getString(R.styleable.Topbar_rightText);
		
		titleSize=ta.getDimension(R.styleable.Topbar_titleTextSize, 0);
		textColor=ta.getColor(R.styleable.Topbar_titleTextColor, 0);
		titleText=ta.getString(R.styleable.Topbar_title);
		//释放资源
		ta.recycle();
		
		leftbtn=new Button(context);
		rightbtn=new Button(context);
		textView=new TextView(context);
		
		//把属性赋给控件
		leftbtn.setTextColor(leftTextColor);
		leftbtn.setBackgroundDrawable(leftBackground);
		leftbtn.setText(leftText);
		
		rightbtn.setTextColor(rightTextColor);
		rightbtn.setBackgroundDrawable(rightBackground);
		rightbtn.setText(rightText);
		
		textView.setTextSize(titleSize);
		textView.setTextColor(textColor);
		textView.setText(titleText);
		textView.setGravity(Gravity.CENTER);
		
		setBackgroundColor(0xFFF59563);
		
		leftParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		//为左边控件制定规则，左对齐
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
		//加入到ViewGroup
		addView(leftbtn, leftParams);
		rightParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
		addView(rightbtn, rightParams);
		
		titleParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
		titleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
		addView(textView, titleParams);
		
		leftbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				clickListener.leftClick();
			}
		});
		rightbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				clickListener.rightClick();
			}
		});
	}
	/**
	 * 监听回调接口
	 * @author Administrator
	 *
	 */
	public interface TopbarClickListener{
		public void leftClick();
		public void rightClick();
	}
	public void setOnTopbarClickListener(TopbarClickListener listener){
		this.clickListener=listener;
	}
	
	public void setLeftVisible(boolean flag){
		if(flag){
			leftbtn.setVisibility(View.VISIBLE);
		}else{
			leftbtn.setVisibility(View.GONE);
		}
	}
}

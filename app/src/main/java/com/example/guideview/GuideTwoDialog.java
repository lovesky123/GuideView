package com.example.guideview;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

/**
 * @author zhanghuibin
 * @desc 蒙层dialog
 */
public class GuideTwoDialog extends Dialog {
    TextView mTarget2, tv;
    Context context;

    public GuideTwoDialog(Context context, TextView target) {
        super(context, R.style.DailyCheckDialog);
        this.mTarget2 = target;
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_guide_two);
        //按空白处取消动画
        setCanceledOnTouchOutside(false);
        //初始化界面控件
        initView();
        initEvent();
        ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) tv.getLayoutParams();
        int[] pos = new int[2];
        mTarget2.getLocationInWindow(pos);
        lp.leftMargin = pos[0];
        lp.topMargin = pos[1] - getStatusBarHeight(context);
        Log.e("SSSSSS", pos[0] + "-------" + lp.topMargin);
        tv.setLayoutParams(lp);
    }

    /**
     * 初始化控件
     */
    private void initView() {
        tv = findViewById(R.id.tv);
    }

    private void initEvent() {
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    /**
     * 获取状态栏高度
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }

}

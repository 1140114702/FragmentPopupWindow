package com.example.bin.fragmentpopupwindow;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by bin on 2017/3/28.
 */

public class FragmentFriends extends Fragment {

    private PopupWindow window;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setGravity(Gravity.CENTER);
        final TextView textView = new TextView(getContext());
        textView.setText("朋友");
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2,-2));
        textView.setTextSize(16.0f);
        textView.setTextColor(Color.GRAY);
        textView.setGravity(Gravity.CENTER);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (window == null) {
                    View view = LayoutInflater.from(getContext()).inflate(R.layout.window_view,null);
                    window = new PopupWindow(view, -1, -2);
                    window.setBackgroundDrawable(new BitmapDrawable());

                    view.findViewById(R.id.item_view1).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(getContext(), "关闭", Toast.LENGTH_SHORT).show();
                            window.dismiss();
                        }
                    });
                }
                window.showAsDropDown(textView);
            }
        });
        linearLayout.addView(textView);
        return linearLayout;
    }
}

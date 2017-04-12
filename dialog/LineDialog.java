package com.kjdy.mobiledevfinalproject.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.kjdy.mobiledevfinalproject.R;
import com.kjdy.mobiledevfinalproject.drawing.RectangleDrawingView;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yunjo on 4/10/2017.
 */

public class LineDialog extends Dialog {



    String src_valueX, src_valueY, src_valueArea;

    @OnClick(R.id.custom_dialog_ok)
    public void okClick(){
        listener.onClickListener();
        dismiss();
    }
    private ICustomDialogEventListener listener;

    public interface ICustomDialogEventListener{
        public void onClickListener();
    }
    public LineDialog(@NonNull Context context, ICustomDialogEventListener listener) {
        super(context, R.style.dialog);
        this.listener = listener;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_custom_rectangle);
        ButterKnife.bind(this);

        //RectangleDrawingView rd = new RectangleDrawingView(this, );
        TextView valueX = (TextView) findViewById(R.id.rectangle_value_x);
        TextView valueY = (TextView) findViewById(R.id.rectangle_value_y);
        TextView valueArea = (TextView) findViewById(R.id.rectangle_value_area);

        src_valueX = RectangleDrawingView.getRectangleX();
        src_valueY = RectangleDrawingView.getRectangleY();
        src_valueArea = RectangleDrawingView.getRectangleArea();

        valueX.setText(src_valueX+" px(s)");
        valueY.setText(src_valueY+" px(s)");
        valueArea.setText(src_valueArea+" px * px");

    }

}

package com.kjdy.mobiledevfinalproject.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.kjdy.mobiledevfinalproject.R;
import com.kjdy.mobiledevfinalproject.drawing.CircleDrawingView;
import com.kjdy.mobiledevfinalproject.drawing.RectangleDrawingView;

import org.w3c.dom.Text;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yunjo on 4/10/2017.
 */

public class CircleDialog extends Dialog {

    String src_valueX, src_valueY, src_valueArea, src_valueDiameter,src_valueCircum;

    @OnClick(R.id.custom_dialog_ok)
    public void okClick(){
        listener.onClickListener();
        dismiss();
    }
    private ICustomDialogEventListener listener;

    public interface ICustomDialogEventListener{
        public void onClickListener();
    }
    public CircleDialog(@NonNull Context context, ICustomDialogEventListener listener) {
        super(context, R.style.dialog);
        this.listener = listener;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_custom_circle);
        ButterKnife.bind(this);

        //RectangleDrawingView rd = new RectangleDrawingView(this, );
        TextView valueX = (TextView) findViewById(R.id.circle_value_x);
        TextView valueY = (TextView) findViewById(R.id.circle_value_y);
        TextView valueArea = (TextView) findViewById(R.id.circle_value_area);
        TextView valueDiameter = (TextView) findViewById(R.id.circle_value_diameter);
        TextView valueCircum = (TextView) findViewById(R.id.circle_value_circum);


        src_valueX = CircleDrawingView.getCircleX();
        src_valueY = CircleDrawingView.getCircleY();
        src_valueArea = CircleDrawingView.getCircleArea();
        src_valueDiameter = CircleDrawingView.getCircleDiameter();
        src_valueCircum = CircleDrawingView.getCircleCircum();


        valueX.setText(src_valueX+" px(s)");
        valueY.setText(src_valueY+" px(s)");
        valueDiameter.setText(src_valueDiameter+" px(s)");
        valueCircum.setText(src_valueCircum+" px(s)");
        valueArea.setText(src_valueArea+" px * px");


    }

}
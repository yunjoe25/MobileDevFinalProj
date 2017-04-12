package com.kjdy.mobiledevfinalproject.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.kjdy.mobiledevfinalproject.R;
import com.kjdy.mobiledevfinalproject.drawing.CircleDrawingView;
import com.kjdy.mobiledevfinalproject.drawing.OvalDrawingView;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yunjo on 4/10/2017.
 */

public class OvalDialog extends Dialog {

    String src_valueX, src_valueY, src_valueMidPoint,src_valueRadiusX,src_valueRadiusY,src_valueArea;

    @OnClick(R.id.custom_dialog_ok)
    public void okClick(){
        listener.onClickListener();
        dismiss();
    }
    private ICustomDialogEventListener listener;

    public interface ICustomDialogEventListener{
        public void onClickListener();
    }
    public OvalDialog(@NonNull Context context, ICustomDialogEventListener listener) {
        super(context, R.style.dialog);
        this.listener = listener;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_custom_oval);
        ButterKnife.bind(this);

        //RectangleDrawingView rd = new RectangleDrawingView(this, );
        TextView valueX = (TextView) findViewById(R.id.oval_value_x);
        TextView valueY = (TextView) findViewById(R.id.oval_value_y);
        TextView valueRadiusX = (TextView) findViewById(R.id.oval_value_radiusX);
        TextView valueRadiusY = (TextView) findViewById(R.id.oval_value_radiusY);

        TextView valueArea = (TextView) findViewById(R.id.oval_value_area);
        TextView valueMidpoint = (TextView) findViewById(R.id.oval_value_midPoint);


        src_valueX = OvalDrawingView.getOvalX();
        src_valueY = OvalDrawingView.getOvalY();
        src_valueRadiusX = OvalDrawingView.getOvalRadiusX();
        src_valueRadiusY = OvalDrawingView.getOvalRadiusY();

        src_valueArea = OvalDrawingView.getOvalArea();
        src_valueMidPoint = OvalDrawingView.getOvalMidPoint();


        valueX.setText(src_valueX+" px(s)");
        valueY.setText(src_valueY+" px(s)");
        valueRadiusX.setText(src_valueRadiusX+" px(s)");
        valueRadiusY.setText(src_valueRadiusY+" px(s)");
        valueArea.setText(src_valueArea+" px * px");
        valueMidpoint.setText("("+src_valueMidPoint+") px(s)");


    }

}
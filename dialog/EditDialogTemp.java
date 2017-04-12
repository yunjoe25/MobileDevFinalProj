package com.kjdy.mobiledevfinalproject.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.widget.EditText;
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

public class EditDialogTemp extends Dialog {

    String src_valueX, src_valueY, src_valueArea, src_valueDiameter,src_valueCircum, src_valueMidPoint,src_valueRadius;

    @OnClick(R.id.custom_dialog_ok)
    public void okClick(){
        listener.onClickListener();
        dismiss();
    }
    private ICustomDialogEventListener listener;

    public interface ICustomDialogEventListener{
        public void onClickListener();
    }
    public EditDialogTemp(@NonNull Context context, ICustomDialogEventListener listener) {
        super(context, R.style.dialog);
        this.listener = listener;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_edit_custom_temp);
        ButterKnife.bind(this);


//        EditText valueX = (EditText) findViewById(R.id.edit_value_x);
//        EditText valueY = (EditText) findViewById(R.id.edit_value_y);

//        Editable tmp = valueX.getText();

    }

}
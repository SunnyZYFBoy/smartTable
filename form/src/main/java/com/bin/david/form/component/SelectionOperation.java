package com.bin.david.form.component;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.bin.david.form.core.TableConfig;
import com.bin.david.form.data.format.selected.ISelectFormat;

/**
 * Created by huang on 2018/1/12.
 * 选中操作
 * 这个类用于处理选中操作
 * 暂时只做比较简单点击效果
 */

public class SelectionOperation {
    /**
     * 选中区域
     */
    public static final int INVALID = -1; //无效坐标
    private Rect selectionRect;
    private ISelectFormat selectFormat;
    private int selectRow = INVALID;
    private int selectColumn = INVALID;
    private boolean isShow;

    void reset(){
        isShow = false;
    }

    SelectionOperation() {
        this.selectionRect = new Rect();
    }

    void setSelectionRect(int selectColumn,int selectRow, Rect rect){
        this.selectRow = selectRow;
        this.selectColumn = selectColumn;
        selectionRect.set(rect);
        isShow = true;
    }

    boolean isSelectedPoint( int selectColumn,int selectRow){

       return  selectRow == this.selectRow  && selectColumn == this.selectColumn;
    }

    void checkSelectedPoint(int selectColumn,int selectRow, Rect rect){

         if(isSelectedPoint(selectColumn,selectRow)){
             selectionRect.set(rect);
             isShow = true;
         }
    }





    public void draw(Canvas canvas, Rect showRect, TableConfig config){

        if(selectFormat !=null && isShow){
          selectFormat.draw(canvas,selectionRect,showRect,config);
        }
    }

    public ISelectFormat getSelectFormat() {
        return selectFormat;
    }

    void setSelectFormat(ISelectFormat selectFormat) {
        this.selectFormat = selectFormat;
    }
}

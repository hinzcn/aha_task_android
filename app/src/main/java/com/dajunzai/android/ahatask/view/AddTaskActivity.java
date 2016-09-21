package com.dajunzai.android.ahatask.view;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.dajunzai.android.ahatask.R;
import com.henry.calendarview.DatePickerController;
import com.henry.calendarview.DayPickerView;
import com.henry.calendarview.SimpleMonthAdapter;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;
import java.util.List;

public class AddTaskActivity extends Activity {
    DayPickerView  dpv_calendar;
    MaterialEditText et_addtask_content;
    AppCompatSpinner sp_addtask_select;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        et_addtask_content = (MaterialEditText) findViewById(R.id.et_addtask_content);
        sp_addtask_select = (AppCompatSpinner) findViewById(R.id.sp_addtask_select);
        List<String> list = new ArrayList<String>();
        list.add("简单任务");
        list.add("一般任务");
        list.add("微难任务");
        list.add("困难任务");
        sp_addtask_select.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice,list) );
        dpv_calendar = (DayPickerView) findViewById(R.id.dpv_calendar);
        init();
    }
    private void init() {
        DayPickerView.DataModel dataModel = new DayPickerView.DataModel();
        dataModel.yearStart = 2016;
        dataModel.monthStart = 8;
        dataModel.monthCount = 12;
        dataModel.defTag = "￥100";
        dataModel.leastDaysNum = 2;
        dataModel.mostDaysNum = 100;

        dpv_calendar.setParameter(dataModel, new DatePickerController() {
            @Override
            public void onDayOfMonthSelected(SimpleMonthAdapter.CalendarDay calendarDay) {
                Toast.makeText(AddTaskActivity.this, "onDayOfMonthSelected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDateRangeSelected(List<SimpleMonthAdapter.CalendarDay> selectedDays) {
                Toast.makeText(AddTaskActivity.this, "onDateRangeSelected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void alertSelectedFail(FailEven even) {
                Toast.makeText(AddTaskActivity.this, "alertSelectedFail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.anfube.simarro.examen_1trimestre_andreufuriobenavent.adapters;

import android.app.Activity;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.anfube.simarro.examen_1trimestre_andreufuriobenavent.R;
import com.anfube.simarro.examen_1trimestre_andreufuriobenavent.fragments.FragmentViewTask;
import com.anfube.simarro.examen_1trimestre_andreufuriobenavent.models.Task;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {
    private Activity context;
    private ArrayList<Task> data;
    private FragmentViewTask fragment;

    public TaskAdapter(FragmentViewTask context, ArrayList<Task> objects) {
        super(context.getActivity(), R.layout.task_list_item, objects);
        this.context = context.getActivity();
        this.data = objects;
        this.fragment = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.task_list_item, null);
        CheckBox chkItem = listItemView.findViewById(R.id.task_list_item);

        Task task = (Task) getItem(position);
        chkItem.setText(task.getNombre());
        if (task.isHecha()) {
            chkItem.setPaintFlags(chkItem.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            if (task.isEsImportante()) {
                chkItem.setTypeface(chkItem.getTypeface(), Typeface.BOLD);
            }
        }

        chkItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chkItem.isChecked()) {
                    task.setHecha(true);
                    fragment.changeLists(task);
                }
            }
        });
        return listItemView;
    }
}

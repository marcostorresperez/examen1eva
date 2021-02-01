package com.anfube.simarro.examen_1trimestre_andreufuriobenavent.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.anfube.simarro.examen_1trimestre_andreufuriobenavent.R;
import com.anfube.simarro.examen_1trimestre_andreufuriobenavent.fragments.AddTaskFragment;
import com.anfube.simarro.examen_1trimestre_andreufuriobenavent.fragments.AddTaskListener;
import com.anfube.simarro.examen_1trimestre_andreufuriobenavent.models.Task;

public class AddTaskActivity extends AppCompatActivity implements AddTaskListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        AddTaskFragment fragment = new AddTaskFragment();
        fragment.setOnAddTaskListener(this);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contenedorAddTask, fragment)
                .commit();
    }

    @Override
    public void onAddTask(Task task) {
        Intent intent = new Intent(AddTaskActivity.this, MainActivity.class);
        intent.putExtra("task", task);
        setResult(1, intent);
        finish();
    }
}
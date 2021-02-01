package com.anfube.simarro.examen_1trimestre_andreufuriobenavent.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.anfube.simarro.examen_1trimestre_andreufuriobenavent.R;
import com.anfube.simarro.examen_1trimestre_andreufuriobenavent.fragments.AddTaskFragment;
import com.anfube.simarro.examen_1trimestre_andreufuriobenavent.fragments.AddTaskListener;
import com.anfube.simarro.examen_1trimestre_andreufuriobenavent.fragments.FragmentViewTask;
import com.anfube.simarro.examen_1trimestre_andreufuriobenavent.models.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AddTaskListener {

    private FloatingActionButton btnAdd;
    private ArrayList<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            tasks = new ArrayList<>();
        tasks.add(new Task(1, "Estudiar PMM", "Estudiar PMM", true, false));
        tasks.add(new Task(2, "Hacer practica de AD", "Hacer practica de AD", true, false));
        tasks.add(new Task(3, "Ir a comprar", "Ir a comprar", false, false));
        tasks.add(new Task(4, "Reparar movil", "Reparar movil", false, false));
        tasks.add(new Task(5, "Ir al banco", "Ir al banco", false, true));


        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contenedorLista, FragmentViewTask.newInstance(tasks))
                .commit();

        if (findViewById(R.id.contenedorAdd) != null) {
            AddTaskFragment fragment = new AddTaskFragment();
            fragment.setOnAddTaskListener(this);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contenedorLista, fragment)
                    .commit();
        }

        btnAdd = findViewById(R.id.btnAdd);

        if (btnAdd != null) {
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
                    startActivityForResult(intent, 1);
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            Task task = (Task) data.getSerializableExtra("task");
            tasks.add(task);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contenedorLista, FragmentViewTask.newInstance(tasks))
                    .commit();
        }
    }

    @Override
    public void onAddTask(Task task) {
        tasks.add(task);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contenedorLista, FragmentViewTask.newInstance(tasks))
                .commit();
    }

//    public void addTask(Task task) {
//        tasks.add(task);
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.contenedorLista, FragmentViewTask.newInstance(tasks))
//                .commit();
//    }
}
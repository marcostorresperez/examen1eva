package com.anfube.simarro.examen_1trimestre_andreufuriobenavent.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.anfube.simarro.examen_1trimestre_andreufuriobenavent.R;
import com.anfube.simarro.examen_1trimestre_andreufuriobenavent.models.Task;

public class AddTaskFragment extends Fragment {
    private View view;
    private EditText name;
    private EditText desc;
    private CheckBox isImportant;
    private Button add;
    private AddTaskListener listener;

    public AddTaskFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_add_task, container, false);
        name = view.findViewById(R.id.name);
        desc = view.findViewById(R.id.desc);
        isImportant = view.findViewById(R.id.isImportant);
        add = view.findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!name.getText().toString().isEmpty()) {
                    if (!desc.getText().toString().isEmpty()) {
                        Task task = new Task(1, name.getText().toString(), desc.getText().toString(), isImportant.isChecked(), false);
                        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                        dialog.setMessage("Nombre: " + task.getNombre() + "\nDescripción: " + task.getDescripcion() + "\nEs importante: " + task.isEsImportante())
                                .setTitle("¿Guardar tarea?")
                                .setPositiveButton(getString(android.R.string.ok), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        listener.onAddTask(task);
                                    }
                                })
                                .setNegativeButton(getString(android.R.string.cancel), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        name.setText("");
                                        desc.setText("");
                                        isImportant.setChecked(false);
                                        dialog.cancel();
                                    }
                                }).create().show();
                    } else Toast.makeText(getContext(), "No has puesto descripción", Toast.LENGTH_LONG).show();
                } else Toast.makeText(getContext(), "No has puesto un nombre", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    public void setOnAddTaskListener(AddTaskListener listener) {
        this.listener = listener;
    }
}
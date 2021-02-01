package com.anfube.simarro.examen_1trimestre_andreufuriobenavent.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

import com.anfube.simarro.examen_1trimestre_andreufuriobenavent.R;
import com.anfube.simarro.examen_1trimestre_andreufuriobenavent.adapters.TaskAdapter;
import com.anfube.simarro.examen_1trimestre_andreufuriobenavent.models.Task;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentViewTask#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentViewTask extends Fragment {
    private View view;
    private ListView listaTareas;
    private ListView listaCompletadas;
    private ArrayList<Task> tasks;
    private ArrayList<Task> tareasCompletadas;
    private ArrayList<Task> tareasSinCompletar;
    private TaskAdapter adapter1;
    private TaskAdapter adapter2;

    public FragmentViewTask() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentViewTask newInstance(ArrayList<Task> tasks) {
        FragmentViewTask fragment = new FragmentViewTask();
        Bundle args = new Bundle();
        args.putSerializable("tasks", tasks);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.tasks = (ArrayList<Task>) getArguments().getSerializable("tasks");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_view_task, container, false);
        listaTareas = view.findViewById(R.id.listaTareas);
        listaCompletadas = view.findViewById(R.id.completedtasksList);
        tareasCompletadas = new ArrayList<>();
        tareasSinCompletar = new ArrayList<>();
        for (Task task :
                tasks) {
            if (task.isHecha()) tareasCompletadas.add(task);
            else tareasSinCompletar.add(task);
        }
        adapter1 = new TaskAdapter(this, tareasSinCompletar);
        listaTareas.setAdapter(adapter1);
        adapter2 = new TaskAdapter(this, tareasCompletadas);
        listaCompletadas.setAdapter(adapter2);

        return view;
    }

    public void changeLists(Task task) {
        tareasCompletadas.add(task);
        tareasSinCompletar.remove(task);
        adapter1.notifyDataSetChanged();
        adapter2.notifyDataSetChanged();
//        listaTareas.setAdapter(new TaskAdapter(this, tareasSinCompletar));
//        listaCompletadas.setAdapter(new TaskAdapter(this, tareasCompletadas));
    }

}
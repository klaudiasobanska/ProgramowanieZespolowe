package com.example.programowaniezespolowe;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class KanbanActivity extends AppCompatActivity {

    private static final String SPRINT_TASK = "com.ciastkaipiwo.android.scrummajster.sprinTask";
    private static final String SPRINT_TASK_POSITION = "com.ciastkaipiwo.android.scrummajster.sprinTaskPosition";

    private Task mSprintTask;
    private int mTaskPosition;
    private EditText mEnterTask;
    private Button mOkButton;
    private ToDoAdapter mAdapterToDo;
    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanban);

        mSprintTask = getIntent().getParcelableExtra(SPRINT_TASK);

        mOkButton = (Button) findViewById(R.id.to_do_ok_button);
        mEnterTask = (EditText) findViewById(R.id.to_do_edit_text);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_to_do);




        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSprintTask.getToDo().add(mEnterTask.getText().toString());
                mEnterTask.getText().clear();
                mRecyclerView.setAdapter(mAdapterToDo);

            }
        });

        mAdapterToDo = new ToDoAdapter(mSprintTask.getToDo());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapterToDo);


    }

    public static Intent newIntent(Context packageContext, Task task){
        Intent intent = new Intent(packageContext, KanbanActivity.class);
        intent.putExtra(SPRINT_TASK, task);
        return intent;
    }

}

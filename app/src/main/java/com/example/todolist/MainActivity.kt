package com.example.todolist

import TaskAdapter
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var taskAdapter: TaskAdapter
    private var taskList = mutableListOf<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the RecyclerView and Adapter
        taskAdapter = TaskAdapter(taskList)
        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = taskAdapter
    }

    // Method to add a task when the button is clicked
    fun addTask(view: View) {
        val editTextTask= findViewById<EditText>(R.id.editTextTask)
        val taskName = editTextTask.text.toString()

        if (taskName.isNotEmpty()) {
            // Add new task to the list
            taskList.add(Task(taskName))

            // Notify adapter about the new item
            taskAdapter.notifyItemInserted(taskList.size - 1)

            // Clear the input field
            editTextTask.text.clear()
        }
    }
}

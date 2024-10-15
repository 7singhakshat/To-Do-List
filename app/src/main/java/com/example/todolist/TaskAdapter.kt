import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.Task

class TaskAdapter(private val tasks: List<Task>) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    class TaskViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val taskName: TextView = view.findViewById(R.id.taskName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.taskName.text = tasks[position].name
    }

    override fun getItemCount(): Int = tasks.size
}

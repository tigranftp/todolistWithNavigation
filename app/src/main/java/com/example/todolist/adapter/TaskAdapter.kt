package com.example.todolist.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.MAIN
import com.example.todolist.POS
import com.example.todolist.R
import com.example.todolist.databinding.TaskLayoutBinding
import com.example.todolist.model.TaskModel


class TaskAdapter: RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {


    class TaskViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = TaskLayoutBinding.bind(view)
    }



    private var taskList = ArrayList<TaskModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.task_layout, parent, false )
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.binding.card.setOnClickListener{
            POS = position
            MAIN.navController.navigate(R.id.action_mainFragment_to_changeFragment)
        }
        holder.binding.todoCheckBox.text = taskList[position].textOfTask
        holder.binding.todoCheckBox.isChecked = taskList[position].isChecked
        holder.binding.todoCheckBox.setOnClickListener{
            taskList[position].isChecked = holder.binding.todoCheckBox.isChecked
        }
        holder.binding.btnDel.setOnClickListener {
            taskList.removeAt(position)
            notifyDataSetChanged()
        }



    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<TaskModel>){
        taskList = list
        notifyDataSetChanged()
    }
}
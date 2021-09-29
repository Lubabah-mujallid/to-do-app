package com.example.todoapp

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.to_do_layout.view.*

class Recycler (val context: Context, val messages: ArrayList<Todo>):
    RecyclerView.Adapter<Recycler.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.to_do_layout,parent,false))
    }

    // #C6ABFD
    // If the Check Box is checked, the text should be a light color,
    // otherwise, it should be black

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = messages[position]
        holder.itemView.apply {
            tvTodo.text = message.task
            checkBox.isChecked = message.isDone
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                if(isChecked) tvTodo.setTextColor(Color.GRAY)
                else tvTodo.setTextColor(Color.BLACK)
                message.isDone = !message.isDone
            }
        }
    }

    override fun getItemCount(): Int = messages.size

    fun deleteItems(){
        messages.removeAll{ message -> message.isDone }
        notifyDataSetChanged()
    }

}
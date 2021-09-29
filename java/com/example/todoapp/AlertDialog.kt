package com.example.todoapp

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.widget.EditText
import android.widget.LinearLayout

class AlertDialog (context: Context,  list : ArrayList<Todo> ,recycler: Recycler) {
    init {
        val dialogBuilder = AlertDialog.Builder(context)
        val newLayout = LinearLayout(context)
        newLayout.orientation = LinearLayout.VERTICAL

        val newTask = EditText(context)
        newTask.hint = "Enter a new task: "
        newLayout.addView(newTask)

        dialogBuilder
            .setPositiveButton("Add", DialogInterface.OnClickListener { dialog, id -> list.add(Todo(newTask.text.toString())!!)
                recycler.notifyDataSetChanged()})
            .setNegativeButton("Cancel",DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })


        val alert = dialogBuilder.create()
        alert.setTitle("New Task")
        alert.setView(newLayout)
        alert.show()
    }

}
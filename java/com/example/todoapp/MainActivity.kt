package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var myList : ArrayList<Todo>
    lateinit var floatingButton : FloatingActionButton
    lateinit var adapter : Recycler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "TO DO APP"
        floatingButton = findViewById(R.id.button)
        myList = ArrayList()
        adapter = Recycler(this, myList)
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)

        floatingButton.setOnClickListener {
            AlertDialog(this, myList, adapter)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.delete_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemsDeleted = 0
        for(i in myList){
            if(i.isDone) itemsDeleted++
        }

        if(itemsDeleted > 0){
            Toast.makeText(this, "$itemsDeleted items deleted", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "No items selected", Toast.LENGTH_LONG).show()
        }
        adapter.deleteItems()
        return super.onOptionsItemSelected(item)
    }
}

package com.example.appl1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.findNavController
import com.example.appl1.fragments.create.Create
import com.example.appl1.fragments.read.Read
import com.google.android.material.floatingactionbutton.FloatingActionButton


class CrudActivity : AppCompatActivity() {

    private lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.crudlayout)

        fab = findViewById(R.id.fab)
        fab.setOnClickListener {
            findNavController(R.id.nav_host_fragment).navigate(R.id.createFragment)
        }

        val navController = findNavController(R.id.nav_host_fragment)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.createFragment) {
                fab.hide()
            } else {
                fab.show()
            }
        }

    }
}
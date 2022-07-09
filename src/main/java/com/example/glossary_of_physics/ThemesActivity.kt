package com.example.glossary_of_physics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ThemesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_themes)
        var listView = findViewById<ListView>(R.id.sectionListView)
        var i = intent.getSerializableExtra("physic") as ArrayList<String>

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, i)
        listView.adapter = adapter

          listView.setOnItemClickListener { parent, view, position, id ->

              val intent = Intent(this, FormulasActivity::class.java)
                    when (id) {
                        0L -> intent.apply { putExtra("formulas", 0) }
                        1L -> intent.apply { putExtra("formulas", 1) }
                        2L -> intent.apply { putExtra("formulas", 2) }
                    }
              startActivity(intent)
        }

    }
}

//var idz = intent.clipData
//Log.d("some", "$idz")

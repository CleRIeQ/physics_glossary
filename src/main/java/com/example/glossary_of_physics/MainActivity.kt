package com.example.glossary_of_physics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.sectionListView)
        val sections = ArrayList<String>()
        val mechanic_sections = ArrayList<String>()
        val molecul_sections = ArrayList<String>()

        sections.add("Механика")
        sections.add("Молекулярная физика и термодинамика")
        sections.add("Электричество и электромагнетизм")
        sections.add("Колебания и волны")
        sections.add("Оптика")
        sections.add("Физика атома и атомного ядра")

        mechanic_sections.add("Кинематика")
        mechanic_sections.add("Динамика")
        mechanic_sections.add("Статика")

        molecul_sections.add("Молекулярно кинетическая теория")
        molecul_sections.add("Статистическая физка")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, sections)
        listView.adapter = adapter

        listView.setOnItemClickListener{parent, view, position, id ->
            val intent = Intent(this, ThemesActivity::class.java)

            when (id) {
                0L -> intent.apply { putExtra("physic", mechanic_sections)} // механика
                1L -> intent.apply { putExtra("physic", molecul_sections)} // Молекулярно кинет.
            }
            startActivity(intent)
        }

    }



    }

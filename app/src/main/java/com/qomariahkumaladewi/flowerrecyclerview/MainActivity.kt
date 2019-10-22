package com.qomariahkumaladewi.flowerrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//      Tambah kedua
//      Pada method onCreate, panggil fungsi initData() yang telah kita buat dan deklarasikan RecyclerView beserta adapter-nya.
        val list = findViewById<RecyclerView>(R.id.flower_list)
        initData()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = RecyclerViewAdapter(this, items)
    }

//    Tambah pertama
//    fungsi atau method untuk memasukkan array yang sudah kita buat ke dalam data class.
    private fun initData(){
        val name = resources.getStringArray(R.array.flower_name)
        val image = resources.obtainTypedArray(R.array.flower_image)
        items.clear()

        for (i in name.indices) {
            items.add(Item(name[i],
                image.getResourceId(i, 0)))
        }

//        Recycle the typed array
        image.recycle()
    }
}

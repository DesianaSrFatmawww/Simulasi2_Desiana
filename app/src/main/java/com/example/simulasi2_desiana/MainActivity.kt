package com.example.simulasi2_desiana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var Nama : EditText
    private lateinit var TB : EditText
    private lateinit var Lk : RadioButton
    private lateinit var PR : RadioButton
    private lateinit var Hasil : TextView
    private lateinit var reset : Button
    private lateinit var simpan : Button
    private lateinit var cek : Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private var tbadan : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Nama = findViewById(R.id.etNama)
        TB = findViewById(R.id.etTB)
        Lk = findViewById(R.id.rbLk)
        PR = findViewById(R.id.rbPR)
        Hasil = findViewById(R.id.tvHasil)
        reset = findViewById(R.id.btHps)
        simpan = findViewById(R.id.btSimpan)
        cek = findViewById(R.id.btCek)
        recyclerView = findViewById(R.id.listData)

        val data = mutableListOf<DataBBI>()
        viewManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerAdapter = adapterBBI(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager

        simpan.setOnClickListener {
            val namaa = Nama.text.toString()
            val tBadan = TB.text.toString()
            val hasill = Hasil.text.toString()

            val dataBbi = DataBBI(namaa,tBadan,hasill)
            data.add(dataBbi)
            recyclerAdapter.notifyDataSetChanged()
        }
        cek.setOnClickListener {
          val TinggiBadan = TB.text.toString().toInt()

            if (Lk.isChecked){
                tbadan = (TinggiBadan - 100) - ((TinggiBadan - 100) * 10 / 100)
                Hasil.setText(tbadan.toString() + "Kg")
            } else{
                tbadan = (TinggiBadan - 100) - ((TinggiBadan - 100) * 15 / 100)
                Hasil.setText(tbadan.toString() + "Kg")
            }
        }
        reset.setOnClickListener {
            Hasil.text = 0.toString()
            Nama.text.clear()
            TB.text.clear()
        }
    }
}
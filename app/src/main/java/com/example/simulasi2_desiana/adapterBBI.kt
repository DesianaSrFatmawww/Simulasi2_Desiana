package com.example.simulasi2_desiana

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class adapterBBI (private val DataSet: MutableList<DataBBI>):
    RecyclerView.Adapter<adapterBBI.BBIViewHolder>(){
    class BBIViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val nama = view.findViewById<TextView>(R.id.tvNama)
        val tbadan = view.findViewById<TextView>(R.id.tvTB)
        val hasil = view.findViewById<TextView>(R.id.tvHasil)
        val hapus = view.findViewById<TextView>(R.id.btHapus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BBIViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.activity_adapter_bbi,parent,false
        )
        return BBIViewHolder(view)
    }

    override fun onBindViewHolder(holder: BBIViewHolder, position: Int) {
        val data = DataSet[position]
        holder.nama.text = data.nama
        holder.tbadan.text = data.tb
        holder.hasil.text = data.hasil
        holder.hapus.setOnClickListener {
            DataSet.removeAt(position)
            notifyItemRangeRemoved(position,DataSet.size)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return DataSet.size
    }
}
package com.example.testrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testrecycler.databinding.AvtoItemBinding

class AvtoAdapter: RecyclerView.Adapter<AvtoAdapter.AvtoHolder>() {
    var avtoList = ArrayList<Avto>()
    class AvtoHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = AvtoItemBinding.bind(item)
        fun bind (avto: Avto) = with(binding) {
            imView.setImageResource(avto.imageId)
            tvText.text = avto.title
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvtoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.avto_item, parent, false)
        return AvtoHolder(view)
    }

    override fun onBindViewHolder(holder: AvtoHolder, position: Int) {
        holder.bind(avtoList[position])
    }

    override fun getItemCount(): Int {
        return avtoList.size
    }
    fun avtoAdd (avto: Avto) {
        avtoList.add(avto)
        notifyDataSetChanged()
    }

}
package com.ozanyazici.artbookfragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ozanyazici.artbookfragment.databinding.RecyclerRowBinding
import com.ozanyazici.artbookfragment.model.Art
import com.ozanyazici.artbookfragment.view.ArtListFragmentDirections

class ArtAdapter(val artList: List<Art>) : RecyclerView.Adapter<ArtAdapter.ArtHolder>() {

    class ArtHolder(val binding: RecyclerRowBinding) : ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ArtHolder(binding)
    }

    override fun getItemCount(): Int {
        return artList.size
    }

    override fun onBindViewHolder(holder: ArtHolder, position: Int) {
        holder.binding.recyclerTextView.setText(artList.get(position).artName)
        holder.itemView.setOnClickListener {
            val action = ArtListFragmentDirections.actionArtListFragmentToDetailsFragment("old",artList.get(position).id)
            Navigation.findNavController(it).navigate(action)
        }
    }
}
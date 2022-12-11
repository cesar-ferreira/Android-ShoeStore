package com.example.shoestore.home.business

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.shoestore.R
import com.example.shoestore.home.HomeFragmentDirections
import com.example.shoestore.home.model.Shoe

class ShoeAdapter(private val shoeList : ArrayList<Shoe>): RecyclerView.Adapter<ShoeAdapter.ShoeViewHolder>(){

    class ShoeViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val title : TextView = itemView.findViewById(R.id.shoeTitle)
        val description : TextView = itemView.findViewById(R.id.showDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val viewLayout = LayoutInflater.from(parent.context).inflate(
            R.layout.shoe_item,
            parent,false)
        return ShoeViewHolder(viewLayout)
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        val shoe = shoeList[position]
        holder.title.text = shoe.name
        holder.description.text = shoe.description

        holder.itemView.setOnClickListener {
            Navigation.findNavController(it).navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(shoe))
        }

    }

    override fun getItemCount() = shoeList.size


}
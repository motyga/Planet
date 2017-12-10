package com.example.android.planet

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item.view.*

class PlanetAdapter(var dataPlanet: Array<Planet>) : RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder>() {

    class PlanetViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var planetImage: ImageView = view.item_image
        var planetNameText: TextView = view.item_planet_name
        var distanceText: TextView  = view.item_distance
        var isLifeImage:  ImageView = view.item_image_life
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            PlanetViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        holder.planetImage.setImageBitmap(dataPlanet[position].imagePlanet)
        holder.planetNameText.text = "Planet: " + dataPlanet[position].namePlanet
        holder.distanceText.text = "Distanse: " + dataPlanet[position].distanceToSun
        holder.isLifeImage.setImageBitmap(dataPlanet[position].imageLife)

        holder.view.setOnClickListener({
            var intent = Intent(holder.view.context, WebActivity::class.java)
            intent.putExtra(Intent.ACTION_VIEW, dataPlanet[position].Url)
            holder.view.context.startActivity(intent)
        })
    }

    override fun getItemCount() = dataPlanet.size
}
package com.example.android.planet

import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var data = Array<Planet>(countPlanets, {i -> getPlanet(i)})

        var list = list
        list.layoutManager = GridLayoutManager(applicationContext, spanCount)
        list.adapter = PlanetAdapter(data)
    }

    private fun getPlanet(position: Int): Planet {
        var idBtm = if (dataLife[position]) R.drawable.yes else R.drawable.no

        return Planet(dataPlanet[position],
                BitmapFactory.decodeResource(resources, dataImage[position]),
                dataDistanceToSun[position],
                BitmapFactory.decodeResource(resources, idBtm),
                String.format(dataURL, dataPlanet[position]))
    }

    private val countPlanets = 8
    private val spanCount = 2
    private var dataPlanet = arrayOf("Mercury", "Venera", "Earth",
                                     "Mars", "Jupiter", "Saturn",
                                     "Neptune", "Uranus")

    private var dataDistanceToSun = arrayOf("57,91E6", "108,2E6", "149,6E6",
                                            "227,9E6", "778,5E6", "1,429E9",
                                            "4,498E9", "2,871E9")

    private var dataLife = arrayOf(false, false, true,
                                   false, false, false,
                                   false, false)

    private var dataImage = arrayOf(R.drawable.mercury, R.drawable.venus, R.drawable.earth,
                                    R.drawable.mars, R.drawable.jupiter, R.drawable.saturn,
                                    R.drawable.neptune, R.drawable.uran)

    private var dataURL = "https://en.wikipedia.org/wiki/%s"

}
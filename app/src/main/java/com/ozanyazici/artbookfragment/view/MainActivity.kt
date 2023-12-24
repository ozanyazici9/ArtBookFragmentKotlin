package com.ozanyazici.artbookfragment.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.ozanyazici.artbookfragment.R
import com.ozanyazici.artbookfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

         return when(item.itemId) {
            R.id.addArt -> {

                val action = ArtListFragmentDirections.actionArtListFragmentToDetailsFragment("new")
                Navigation.findNavController(this, R.id.fragmentContainerView).navigate(action)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
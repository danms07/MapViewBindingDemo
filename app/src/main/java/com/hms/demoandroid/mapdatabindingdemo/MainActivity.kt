package com.hms.demoandroid.mapdatabindingdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.hms.demoandroid.mapdatabindingdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.fullScreen)
            launchFullScreenMap()
        return super.onOptionsItemSelected(item)
    }

    private fun launchFullScreenMap() {
        val intent= Intent(this,MapActivity::class.java).apply {
            flags=Intent.FLAG_ACTIVITY_SINGLE_TOP
        }
        startActivity(intent)
    }
}
package com.example.navigationda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.internal.NavigationMenuView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fm : FragmentManager = supportFragmentManager
        val ft : FragmentTransaction = fm.beginTransaction()
        var fragment = RedFragment()
        when(item.itemId)
        {
            R.id.walk -> {
                fragment = RedFragment()
            }
            R.id.edit -> {

            }
        }
        ft.replace(R.id.contentspace,fragment)
        ft.commit()
        dl.closeDrawer(GravityCompat.START)
        return true
    }

    lateinit var toolbar:Toolbar
    lateinit var nv:NavigationView
    lateinit var dl:DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar=findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        nv=findViewById(R.id.navigation_view)
        dl=findViewById(R.id.dlayout)
        val toggle=ActionBarDrawerToggle(this,dl,toolbar,0,0)
        dl.addDrawerListener(toggle)
        toggle.syncState()

    }
}

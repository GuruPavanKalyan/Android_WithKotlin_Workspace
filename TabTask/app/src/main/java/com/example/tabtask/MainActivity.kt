package com.example.tabtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    lateinit var vp: ViewPager
    lateinit var tl:TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vp = findViewById(R.id.viewPager)
        tl = findViewById(R.id.tabLayout)
        val vpa: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager, 5)
        vp.adapter = vpa
        tl.setupWithViewPager(vp)
    }

    class ViewPagerAdapter(fm: FragmentManager, v: Int) : FragmentStatePagerAdapter(fm, v) {
        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> return FirstFragment()
                1 -> return SecondFragment()
                2 -> return ThirdFragment()
                3 -> return FourthFragment()
                4 -> return FifthFragment()
            }
            return null!!
        }

        override fun getCount(): Int {
            return 5
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return "First"
                1 -> return "Second"
                2 -> return "Third"
                3 -> return "Fourth"
                4 -> return "Fifth"
            }

            return super.getPageTitle(position)
        }


    }
}

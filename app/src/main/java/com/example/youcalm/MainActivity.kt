package com.example.youcalm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.youcalm.ui.breathe.BreatheFragment
import com.example.youcalm.ui.education.EducationFragment
import com.example.youcalm.ui.home.HomeFragment
import com.example.youcalm.ui.logs.LogsFragment
import com.example.youcalm.ui.scheme.SchemeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : FragmentActivity() {

    lateinit var toolbar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigation: BottomNavigationView = findViewById(R.id.nav_view)
        bottomNavigation.selectedItemId = R.id.navigation_home
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_scheme -> {
                val schemeFragment = SchemeFragment.newInstance()
                openFragment(schemeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_education -> {
                val educationFragment = EducationFragment.newInstance()
                openFragment(educationFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_home -> {
                val homeFragment = HomeFragment.newInstance()
                openFragment(homeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_breathe -> {
                val breatheFragment = BreatheFragment.newInstance()
                openFragment(breatheFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_logs -> {
                val logsFragment = LogsFragment.newInstance()
                openFragment(logsFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}

package com.facomobile.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.viewpager.widget.ViewPager
import com.facomobile.R
import com.facomobile.databinding.FragmentHomeBinding
import com.facomobile.ui.main.home.AlertsFragment
import com.facomobile.ui.main.home.ArticlesFragment
import com.facomobile.ui.main.home.CovidInfoFragment
import com.facomobile.ui.main.home.HomePagerAdapter

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar: Toolbar = view.findViewById(R.id.home_tool_bar)!!
        val appBarConfiguration = AppBarConfiguration(
                setOf(
                        R.id.homeFragment,
                        R.id.messagesFragment,
                        R.id.resultsFragment,
                        R.id.profileFragment
                )
        )

        val navHostFragment = NavHostFragment.findNavController(this)
        NavigationUI.setupWithNavController(toolbar, navHostFragment, appBarConfiguration)

        setHasOptionsMenu(true)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        setupViewPager(binding.homePager)
        binding.homeTabLayout.setupWithViewPager(binding.homePager)
    }


    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = HomePagerAdapter(childFragmentManager)
        adapter.addFragment(AlertsFragment(), "My Alert")
        adapter.addFragment(CovidInfoFragment(), "COVID Info")
        adapter.addFragment(ArticlesFragment(), "Articles")
        viewPager.adapter = adapter
    }

}

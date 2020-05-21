package com.facomobile.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
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

    // When requested, this adapter returns a DemoObjectFragment,
    // representing an object in the collection.
    private lateinit var homePagerAdapter: HomePagerAdapter
    private lateinit var viewPager: ViewPager2
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

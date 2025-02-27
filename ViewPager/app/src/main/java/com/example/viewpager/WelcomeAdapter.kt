package com.example.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class WelcomeAdapter(fa: FragmentActivity, private val contents: List<Welcome>) : FragmentStateAdapter(fa) {

  override fun getItemCount(): Int {
    return contents.size
  }

  override fun createFragment(position: Int): Fragment {
    return WelcomeFragment.newInstance(contents[position])
  }

}
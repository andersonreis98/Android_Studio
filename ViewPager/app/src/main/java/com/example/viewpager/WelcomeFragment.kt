package com.example.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.viewpager.R

class WelcomeFragment : Fragment() {

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val view = inflater.inflate(R.layout.fragment_welcome, container, false)

    val title: TextView = view.findViewById(R.id.txt_title)
    val desc: TextView = view.findViewById(R.id.txt_desc)
    val image: ImageView = view.findViewById(R.id.img)

    arguments?.let {
      title.text = it.getString(KEY_TITLE)
      desc.text = it.getString(KEY_DESC)
      image.setImageResource(it.getInt(KEY_IMAGE))
    }

    return view
  }

  companion object {

    fun newInstance(welcome: Welcome) : WelcomeFragment {
      val args = Bundle().apply {
        putString(KEY_TITLE, welcome.title)
        putString(KEY_DESC, welcome.desc)
        putInt(KEY_IMAGE, welcome.drawableId)
      }
      val frag = WelcomeFragment()
      frag.arguments = args
      return frag
    }

    const val KEY_TITLE = "title"
    const val KEY_DESC = "desc"
    const val KEY_IMAGE = "img"
  }

}
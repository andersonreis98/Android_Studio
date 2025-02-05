package com.example.viewpager

import androidx.annotation.DrawableRes

data class Welcome(
  val title: String,
  @DrawableRes val drawableId: Int,
  val desc: String
)

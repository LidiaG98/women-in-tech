package com.applaudostudios.womenintech.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.applaudostudios.womenintech.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

private const val IMAGES_BASE_URL = "https://raw.githubusercontent.com/LidiaG98/pictures-women-in-tech/main/Pictures"

@BindingAdapter("loadImage")
fun loadImage(showImg: ImageView, imageUrl: String?) {
    imageUrl?.let {
        val fullImgUrl = IMAGES_BASE_URL + imageUrl
        Glide.with(showImg.context)
            .load(fullImgUrl)
            .placeholder(R.drawable.loading_animation)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .error(R.drawable.ic_flower)
            .into(showImg)
    }
}
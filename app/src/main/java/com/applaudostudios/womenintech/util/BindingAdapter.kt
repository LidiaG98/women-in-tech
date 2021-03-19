package com.applaudostudios.womenintech.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.airbnb.lottie.LottieAnimationView
import com.applaudostudios.womenintech.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

private const val IMAGES_BASE_URL =
    "https://raw.githubusercontent.com/LidiaG98/pictures-women-in-tech/main/Pictures"

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

@BindingAdapter("flag")
fun setFlag(flagImage: ImageView, country: String?) {
    country?.let {
        when (country) {
            "USA" -> flagImage.setImageResource(R.drawable.ic_usa)
            "Austria" -> flagImage.setImageResource(R.drawable.ic_austria)
            "England" -> flagImage.setImageResource(R.drawable.ic_united_kingdom)
        }
    }
}
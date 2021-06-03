package com.example.jetpackpractice.adapters

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean?) {
    view.visibility = if (isGone == null || isGone == false) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, url: String?) {
    if (url != null && url.isNotBlank()) {
        Glide.with(view.context)
            .load(url)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}

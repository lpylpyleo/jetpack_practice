package com.example.jetpackpractice.adapters

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.jetpackpractice.data.Card
import com.example.jetpackpractice.databinding.ListItemCardBinding

class CardListAdapter : PagingDataAdapter<Card, CardListAdapter.CardViewHolder>(
    CardDiffCallback()
) {

    class CardViewHolder(val binding: ListItemCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Card) {
            binding.apply {
                card = item
                executePendingBindings()
            }
        }
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {

        val card = getItem(position)
        holder.bind(checkNotNull(card))
        Glide.with(holder.binding.root)
            .load(card.imageUrl)
            .listener(illustratorLoadListener(holder.binding.progressCircular))
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(holder.binding.illustration)
        holder.binding.setClickListener {
            card.noFrame = !card.noFrame
            notifyItemChanged(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            ListItemCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}

class CardDiffCallback : DiffUtil.ItemCallback<Card>() {
    override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem.name == newItem.name
    }
}

fun illustratorLoadListener(progressBar: ProgressBar) : RequestListener<Drawable> = object : RequestListener<Drawable> {
    override fun onLoadFailed(
        e: GlideException?,
        model: Any?,
        target: Target<Drawable>?,
        isFirstResource: Boolean
    ): Boolean {
        progressBar.visibility = View.GONE
        return false
    }

    override fun onResourceReady(
        resource: Drawable?,
        model: Any?,
        target: Target<Drawable>?,
        dataSource: DataSource?,
        isFirstResource: Boolean
    ): Boolean {
        progressBar.visibility = View.GONE
        return false
    }

}
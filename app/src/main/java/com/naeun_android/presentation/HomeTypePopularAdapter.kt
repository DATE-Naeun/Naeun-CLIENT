package com.naeun_android.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.naeun_android.databinding.ItemTypePopularBinding
import com.naeun_android.domain.entity.Product
import com.naeun_android.util.setOnSingleClickListener

class HomeTypePopularAdapter(private val itemClick: (Product) -> (Unit)) :
    ListAdapter<Product, HomeTypePopularAdapter.TypePopularViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypePopularViewHolder {
        val binding =
            ItemTypePopularBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TypePopularViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: TypePopularViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    class TypePopularViewHolder(
        private val binding: ItemTypePopularBinding,
        private val itemClick: (Product) -> (Unit)
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Product) {
            with(binding) {
                root.setOnSingleClickListener {
                    itemClick(data)
                }
            }
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem.productId == newItem.productId
            }

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem == newItem
            }

        }
    }
}
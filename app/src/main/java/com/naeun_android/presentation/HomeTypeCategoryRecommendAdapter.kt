package com.naeun_android.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.naeun_android.databinding.ItemTypeCategoryBinding
import com.naeun_android.domain.entity.Product
import com.naeun_android.util.setOnSingleClickListener

class HomeTypeCategoryRecommendAdapter(private val itemClick: (Product) -> (Unit)) :
    ListAdapter<Product, HomeTypeCategoryRecommendAdapter.TypeCategoryRecommendViewHolder>(diffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TypeCategoryRecommendViewHolder {
        val binding =
            ItemTypeCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TypeCategoryRecommendViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: TypeCategoryRecommendViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class TypeCategoryRecommendViewHolder(
        private val binding: ItemTypeCategoryBinding,
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
        private val diffUtil = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem.productId == newItem.productId
            }

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem == newItem
            }

        }
    }
}
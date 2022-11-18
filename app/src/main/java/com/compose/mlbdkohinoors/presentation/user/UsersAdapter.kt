package com.compose.mlbdkohinoors.presentation.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.request.RequestOptions
import com.compose.mlbdkohinoors.R
import com.compose.mlbdkohinoors.databinding.ItemUsersBinding
import com.compose.mlbdkohinoors.domain.model.TeamMember

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.MyViewHolder>() {

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TeamMember>() {
        override fun areItemsTheSame(oldItem: TeamMember, newItem: TeamMember): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: TeamMember,
            newItem: TeamMember
        ): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            ItemUsersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) =
        holder.bind(differ.currentList[position])

    override fun getItemCount(): Int = differ.currentList.size

    fun submitList(list: List<TeamMember>) = differ.submitList(list)

    inner class MyViewHolder(binding: ItemUsersBinding) : RecyclerView.ViewHolder(binding.root) {
        private val _binding: ItemUsersBinding = binding

        fun bind(user: TeamMember) {
            _binding.apply {
                textUserName.text = user.name ?: ""

                val options: RequestOptions = RequestOptions()
                    .transform(FitCenter())
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .priority(Priority.HIGH)

                Glide.with(imgUser)
                    .load(user.avatar)
                    .apply(options)
                    .into(imgUser)
            }
        }
    }
}

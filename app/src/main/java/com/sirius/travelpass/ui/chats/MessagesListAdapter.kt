package com.sirius.travelpass.ui.chats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sirius.travelpass.R
import com.sirius.travelpass.base.ui.BaseMultiRecyclerViewAdapter

import com.sirius.travelpass.databinding.ItemMessageConnectBinding
import com.sirius.travelpass.databinding.ItemMessageOfferBinding
import com.sirius.travelpass.databinding.ItemMessageTextBinding
import com.sirius.travelpass.ui.chats.holder.MessageViewHolder
import com.sirius.travelpass.ui.chats.message.BaseItemMessage
import com.sirius.travelpass.ui.chats.message.OfferItemMessage
import com.sirius.travelpass.ui.credentials.CredentialsDetailAdapter


class MessagesListAdapter :
    BaseMultiRecyclerViewAdapter<BaseItemMessage>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutRes = MessageViewHolder.getLayoutResFromType(viewType)
        val view =
            LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)
        return MessageViewHolder.getHolderFromType(viewType, view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as? MessageViewHolder)?.bind(item)
    }


    override fun getItemViewType(position: Int): Int {
        return getItem(position).getType().ordinal
    }

}
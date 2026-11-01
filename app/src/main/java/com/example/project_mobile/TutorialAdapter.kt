package com.example.project_mobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TutorialAdapter(private val steps: List<TutorialStep>) :
    RecyclerView.Adapter<TutorialAdapter.TutorialViewHolder>() {

    class TutorialViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvStepLabel: TextView = view.findViewById(R.id.tvStepLabel)
        val imgStepIcon: ImageView = view.findViewById(R.id.imgStepIcon)
        val tvStepTitle: TextView = view.findViewById(R.id.tvStepTitle)
        val tvStepDesc: TextView = view.findViewById(R.id.tvStepDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TutorialViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tutorial_page, parent, false)
        return TutorialViewHolder(view)
    }

    override fun onBindViewHolder(holder: TutorialViewHolder, position: Int) {
        val item = steps[position]
        holder.tvStepLabel.text = item.stepLabel
        holder.tvStepTitle.text = item.stepTitle
        holder.tvStepDesc.text = item.description
        holder.imgStepIcon.setImageResource(item.iconResId)
    }

    override fun getItemCount(): Int = steps.size
}

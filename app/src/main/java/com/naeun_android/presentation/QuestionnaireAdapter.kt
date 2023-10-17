package com.naeun_android.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.naeun_android.R
import com.naeun_android.data.model.Question

class QuestionnaireAdapter(private var questions: List<Question>) :
    RecyclerView.Adapter<QuestionnaireAdapter.QuestionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_questionnaire_selection, parent, false)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val question = questions[position]
        holder.bind(question)
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    fun updateQuestionsSubset(subset: List<Question>) {
        questions = subset
        notifyDataSetChanged()
    }

    inner class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.tv_question)
        private val radioGroup: RadioGroup = itemView.findViewById(R.id.radio_group_options)

        fun bind(question: Question) {
            titleTextView.text = question.title
            addOptionsToRadioGroup(question.options)
        }

        private fun addOptionsToRadioGroup(options: List<String>) {
            radioGroup.removeAllViews()

            options.forEach { option ->
                val radioButton = RadioButton(itemView.context)
                radioButton.text = option
                radioGroup.addView(radioButton)
            }
        }
    }
}

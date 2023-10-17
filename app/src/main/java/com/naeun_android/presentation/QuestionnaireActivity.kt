package com.naeun_android.presentation

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.naeun_android.R
import com.naeun_android.data.model.Question
import com.naeun_android.databinding.ActivityQuestionnaireBinding
import com.naeun_android.util.BindingActivity
import java.lang.Integer.min

class QuestionnaireActivity :
    BindingActivity<ActivityQuestionnaireBinding>(R.layout.activity_questionnaire) {
    private var currentQuestionIndex = 0
    private lateinit var questionAdapter: QuestionnaireAdapter
    private lateinit var questions: List<Question>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        questions = generateSampleQuestions()
        questionAdapter = QuestionnaireAdapter(
            questions.subList(currentQuestionIndex, getNextQuestionIndex()),
        )

        binding.rvQuestions.layoutManager = LinearLayoutManager(this)
        binding.rvQuestions.adapter = questionAdapter

        binding.btnNext.setOnClickListener {
            currentQuestionIndex = getNextQuestionIndex()
            questionAdapter.updateQuestionsSubset(
                questions.subList(currentQuestionIndex, getNextQuestionIndex()),
            )
        }
    }

    private fun generateSampleQuestions(): List<Question> {
        val questions = mutableListOf<Question>()
        questions.add(
            Question(
                "Q1. 세안 후, 아무 것도 바르지 않고 2-3시간 지나면 내 이마와 볼은",
                listOf(
                    "1매우 거칠고, 버석거리며 각질이 들떠 보인다.",
                    "1당긴다.",
                    "1당기지 않고 건조해 보이지 않으며 번들거리지 않는다.",
                    "1밝은 빛에 반사되는 것처럼 번들거린다.",
                ),
            ),
        )
        questions.add(
            Question(
                "Q2. 세안 후, 아무 것도 바르지 않고 2-3시간 지나면 내 이마와 볼은",
                listOf(
                    "2매우 거칠고, 버석거리며 각질이 들떠 보인다.",
                    "2당긴다.",
                    "2당기지 않고 건조해 보이지 않으며 번들거리지 않는다.",
                    "2밝은 빛에 반사되는 것처럼 번들거린다.",
                ),
            ),
        )
        questions.add(
            Question(
                "Q3. 파우더를 바르지 않은 상태에서, 파운데이션을 바른 지 2-3시간 후 메이크업의 상태가 어떻습니까?",
                listOf(
                    "약간 들떠 보이고 주름에 낀다.",
                    "부드러워 보인다.",
                    "번들거린다..",
                    "고정이 안 되고 번들거린다.",
                    "애초에 파운데이션을 바르지 않는다.",
                ),
            ),
        )
        questions.add(
            Question(
                "Q4. 세안 후, 아무 것도 바르지 않고 2-3시간 지나면 내 이마와 볼은",
                listOf(
                    "건조하고 갈라질 것 같다.",
                    "당긴다.",
                    "정상적이다.",
                    "번들거리며, 로션과 크림이 필요 없다.",
                    "잘 모르겠다.",
                ),
            ),
        )
        questions.add(
            Question(
                "Q5. 모공이 많고 사이즈가 큽니까?",
                listOf(
                    "아니다.",
                    "이마와 코에 두드러져 보인다.",
                    "많다.",
                    "매우 많다.",
                    "잘 모르겠다.",
                ),
            ),
        )
        questions.add(
            Question(
                "Q6. 평소 내 피부 타입이 뭐라고 생각합니까?",
                listOf(
                    "건성",
                    "중성",
                    "복합",
                    "지성",
                ),
            ),
        )
        questions.add(
            Question(
                "Q7. 화이트헤드나 블랙헤드가 있습니까?",
                listOf(
                    "없다",
                    "거의 없다",
                    "조금 있다",
                    "많다",
                ),
            ),
        )
        questions.add(
            Question(
                "Q8. 이마와 코 부위가 번들거리는 느낌이 듭니까?",
                listOf(
                    "전혀 그렇지 않다.",
                    "가끔 그렇다",
                    "자주 그렇다.",
                    "항상 그렇다.",
                ),
            ),
        )
        questions.add(
            Question(
                "Q9. 수분용 로션이나 크림을 바르고 2-3시간 후 볼의 피부 상태는",
                listOf(
                    "매우 거칠고, 각질이 일어나거나 각질이 떨어진다.",
                    "부드럽다.",
                    "조금 번들거린다.",
                    "번들거리고 기름진다.",
                ),
            ),
        )
        return questions
    }

    private fun getNextQuestionIndex(): Int {
        // TODO : 모든 질문 추가 후, 각 페이지별 인덱스 증가
        return min(currentQuestionIndex + 2, questions.size)
    }
}

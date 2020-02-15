package work.nbcc.quiz

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_main.*
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

class MainFragment : Fragment() {


    private val questionBank = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, false),
        Question(R.string.question_6, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8, true),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, false),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, true),
        Question(R.string.question_15, false),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, false),
        Question(R.string.question_19, false),
        Question(R.string.question_20, true))



    private var questionIndex = 0
    private lateinit var questionView: TextView
    private  lateinit var nextButton: ImageButton
    private lateinit var previusButton : ImageButton
    private lateinit var navController: NavController
    private lateinit var binding: MainFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()
        questionIndex = savedInstanceState?.getInt("qIndex", 0) ?: questionIndex

        binding.apply{

            questionView.setText(questionBank[questionIndex].textResId)

            true_button.setOnClickListener{
                var answer = if (questionBank[questionIndex].answer) "You are right!"
                else "You are wrong!"
                Toast.makeText(context, answer, Toast.LENGTH_SHORT).show()
            }

            false_button.setOnClickListener{
                var answer = if (!questionBank[questionIndex].answer) "You are right!"
                else "You are wrong!"
                Toast.makeText(context, answer, Toast.LENGTH_SHORT).show()
            }

            next_button.setOnClickListener {
                questionIndex = (questionIndex + 1) % 20
                questionView.setText(questionBank[questionIndex].textResId)
            }


            p_button.setOnClickListener {
                questionIndex = (questionIndex + 19) % 20
                questionView.setText(questionBank[questionIndex].textResId)
            }

            cheat_button.setOnClickListener {
                val question = questionBank[questionIndex].textResId
                val asnwer = questionBank[questionIndex].answer
                navController.navigate(MainFragment.actionMainFragmentToCheatFragment(question, asnwer))

            }
        }
    }


}

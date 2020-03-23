package learn.nbcc.quizapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import learn.nbcc.quizapp.databinding.FragmentMainBinding
import learn.nbcc.therickandmortyquizapp.Question

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var navigation: NavController

    private var questionIndex = 0


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
        Question(R.string.question_20, true)
    )



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
           inflater, R.layout.fragment_main, container, false
        )
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigation = view.findNavController()
        questionIndex = savedInstanceState?.getInt("qIndex", 0) ?: questionIndex

        binding.apply{

            questionText.setText(questionBank[questionIndex].textResId)

            truebutton.setOnClickListener{
                var answer = if (questionBank[questionIndex].answer) "You are right"
                else "You are wrong"
                Toast.makeText(context, answer, Toast.LENGTH_SHORT).show()
            }

            falsebutton.setOnClickListener{
                var answer = if (!questionBank[questionIndex].answer) "You are right"
                else "You are wrong"
                Toast.makeText(context, answer, Toast.LENGTH_SHORT).show()
            }

            prevbutton.setOnClickListener {
                questionIndex = (questionIndex + 19) % 20

                questionText.setText(questionBank[questionIndex].textResId)
            }

            nextbutton.setOnClickListener {
                questionIndex = (questionIndex + 1) % 20

                questionText.setText(questionBank[questionIndex].textResId)
            }

            cheatBtn.setOnClickListener {
                val ans = questionBank[questionIndex].answer
                navigation.navigate(MainFragmentDirections.actionMainFragmentToCheatFragment(questionIndex, ans))
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("qIndex", questionIndex)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, view!!.findNavController()) || super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.info_menu, menu)
    }
}

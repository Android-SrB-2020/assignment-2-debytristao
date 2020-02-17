package work.nbcc.quiz


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_cheat_.*

/**
 * A simple [Fragment] subclass.
 */
class cheat_Fragment : Fragment() {


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

    private lateinit var binding: cheat_Fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var args : cheat_Fragment = cheat_Fragment().fromBundle(arguments!!)


        binding.apply{

            cheatLabel.setText(questionBank[args.question].textResId)

            val answ: String = if (args.answer == true) "TRUE" else "FALSE"

            answerLabel.visibility = View.INVISIBLE

            yesButton.setOnClickListener{
                answerLabel.visibility = View.VISIBLE
            }

            noButton.setOnClickListener{
                activity!!.onBackPressed()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_cheat_, container, false)
        binding = DataBindingUtil.inflate( inflater, R.layout.fragment_cheat_, container, false)

        return  binding.root
    }


}

package halla.icsw.lovetest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import halla.icsw.lovetest.R
import halla.icsw.lovetest.databinding.FragmentQuestionBinding
import halla.icsw.lovetest.databinding.FragmentResultBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var binding: FragmentResultBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_result,container,false)
        return binding.root
    }

    var option = -1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        option = arguments?.getInt("index") ?: -1
        navController = Navigation.findNavController(view)
        setResult(option)
        binding.homeButton.setOnClickListener {
            navController.navigate(R.id.action_resultFragment_to_mainFragment)
        }
    }

    fun setResult(option :Int){
        when (option){
            1-> {binding.resultMessage.setText("You are a QURTTER")
                binding.resultMessage2.setText("You can let the person easily.")
            }
            2-> {binding.resultMessage.setText("You should focus on yourself")
                binding.resultMessage2.setText("You become really clingy to your ex.")
            }
            3-> {binding.resultMessage.setText("You should take it easy")
                binding.resultMessage2.setText("You cna to crazy things no matter what it takes.")
            }
            4-> {binding.resultMessage.setText("You are pretty mature")
                binding.resultMessage2.setText("You can easily accept the break-up.")
            }
            else-> {binding.resultMessage.setText("ERROR")
                binding.resultMessage2.setText("SORRY.")
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ResultFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
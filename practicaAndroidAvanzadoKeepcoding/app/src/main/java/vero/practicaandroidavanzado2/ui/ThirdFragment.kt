package vero.practicaandroidavanzado2.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import vero.practicaandroidavanzado2.R
import vero.practicaandroidavanzado2.databinding.FragmentSecondBinding
import vero.practicaandroidavanzado2.databinding.FragmentThirdBinding


class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonToFirst.setOnClickListener {
            findNavController().navigate(R.id.action_Third_to_FirstFragment)
            Log.d("DEL Tercero FRAGMENT AL PRIMERO", toString())
        }
        binding.buttonToSecond.setOnClickListener {
            findNavController().navigate(R.id.action_Third_to_SecondFragment)
            Log.d("DEL Tercero FRAGMENT AL SEGUNDO", toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

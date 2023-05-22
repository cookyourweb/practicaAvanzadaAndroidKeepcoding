package com.example.practicaandroidavanzadokeepcoding.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.practicaandroidavanzadokeepcoding.databinding.FragmentFirstBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel = SuperHeroViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.superheroList.adapter = SuperHeroAdapter()
       binding.fab.setOnClickListener{
            viewModel.getHeroes()
        }
        viewModel.heroes.observe(viewLifecycleOwner){
            Log.d("superheroes", it.toString())

        }
        lifecycleScope.launchWhenResumed {
            var  counter = 0
            launch(Dispatchers.IO){
                while (isActive){
                    launch(Dispatchers.IO) {
                        Thread.sleep(1000)
                        counter++
                    }
                    launch (Dispatchers.Main){
                     binding.textViewCounter.text = counter.toString()
                    }

                }
            }
        }
        }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

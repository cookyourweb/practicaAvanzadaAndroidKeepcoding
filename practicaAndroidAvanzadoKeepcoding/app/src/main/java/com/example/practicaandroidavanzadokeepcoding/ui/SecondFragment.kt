package com.example.practicaandroidavanzadokeepcoding

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.practicaandroidavanzadokeepcoding.R
import androidx.navigation.fragment.findNavController
import com.example.practicaandroidavanzadokeepcoding.databinding.FragmentSecondBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val viewModel = SuperHeroViewModel()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = SuperHeroAdapter()



        binding.superheroList2.adapter = SuperHeroAdapter()
        binding.fab.setOnClickListener {
            viewModel.getHeroes()
        }
        viewModel.heroes.observe(viewLifecycleOwner) {

            Log.d("SUPERHEROES", it.toString())
           /* val superheroNames = heroes.map { hero -> (hero.name) }
            Log.d("Adapter1", adapter.superheroes.size.toString())
            adapter.superheroes.clear()
            Log.d("Adapter2", adapter.superheroes.size.toString())
            adapter.superheroes.addAll(superheroNames)
            Log.d("Adapter3", adapter.superheroes.size.toString())
            adapter.notifyDataSetChanged()//hay muchos tipos ,este es el*/
        }
        lifecycleScope.launchWhenResumed {
            var counter = 0
            launch(Dispatchers.IO) {
                while (isActive) {
                    launch(Dispatchers.IO) {
                        Thread.sleep(1000)
                        counter++
                    }
                    launch(Dispatchers.Main) {
                        binding.textViewCounter.text = counter.toString()
                    }

                }


            }
        } //FIN LIFECYCLE

        /*  binding.buttonSecond.setOnClickListener {
          findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
      }
      binding.buttonThird.setOnClickListener {
          findNavController().navigate(R.id.action_SecondFragment_to_ThirdFragment)
      }
            }*/
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

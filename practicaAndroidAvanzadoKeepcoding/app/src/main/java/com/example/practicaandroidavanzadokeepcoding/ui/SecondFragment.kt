package com.example.practicaandroidavanzadokeepcoding

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.practicaandroidavanzadokeepcoding.databinding.FragmentSecondBinding
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
        binding.superherolist2.adapter = SuperHeroAdapter()
        binding.fab.setOnClickListener {
            viewModel.getHeroes()
            Log.d("DENTRODESETONCLIC", it.toString())

        //En la parte de stateflow seria .collect en lugar de .observe con livedata



            viewModel.heroes.observe(viewLifecycleOwner) { heroes ->

            Log.d("SUPERHEROES", heroes.toString())
                val superHeroName =heroes.map { hero ->
                    hero.name
                }
                adapter.superheroes.clear()
                adapter.superheroes.addAll(superHeroName)



           /* val superheroNames = heroes.map { hero -> (hero.name) }*/
            Log.d("Adapter1", adapter.superheroes.size.toString())
            adapter.superheroes.clear()
            Log.d("Adapter2", adapter.superheroes.size.toString())
            adapter.superheroes.addAll(superHeroName)
            Log.d("Adapter3", adapter.superheroes.size.toString())
            adapter.notifyDataSetChanged()//hay muchos tipos ,este es el
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

                }}


            }
        } //FIN LIFECYCLE

         binding.buttonSecond.setOnClickListener {
          findNavController().navigate(R.id.action_SecondFragment_to_ThirdFragment)
             Log.d("DEL SEGUNDOO FRAGMENT AL TERCERO", it.toString())
      }
            }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

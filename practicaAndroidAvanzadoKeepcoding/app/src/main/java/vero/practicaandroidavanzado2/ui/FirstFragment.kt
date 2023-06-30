package vero.practicaandroidavanzado2.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import vero.practicaandroidavanzado2.R
import vero.practicaandroidavanzado2.databinding.FragmentFirstBinding



@AndroidEntryPoint
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: SuperheroViewModel by viewModels()


    //private lateinit var   viewModel:  SuperHeroViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        //aqui hacemos la navegacion de un fragment a otro
        val adapter = SuperheroAdapter() {
            findNavController().
                navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment())
                        Log.d("DEL PRIMERO  AL SEGUNDO", it.toString())
        }



        binding.superheroList.adapter = adapter


        binding.fab.setOnClickListener {
            Log.d("LLamo API", it.toString())
            viewModel.getHeroes()
        }
        viewModel.heroes.observe(viewLifecycleOwner) { heroes ->
            adapter.submitList(heroes)
        }
        lifecycleScope.launchWhenResumed {
            var counter = 0
            launch(Dispatchers.IO) {
                while (isActive) {
                    launch(Dispatchers.IO) {
                        {
                            Thread.sleep(1000)
                            counter++
                        }
                        launch(Dispatchers.Main) {
                            binding.textViewCounter.text = counter.toString()
                        }

                    }
                }


            }
            //FIN LIFECYCLE
            binding.buttonFirst.setOnClickListener {
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                Log.d("DEL PRIMERO  AL SEGUNDO", it.toString())


            }
        }


        fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }
}
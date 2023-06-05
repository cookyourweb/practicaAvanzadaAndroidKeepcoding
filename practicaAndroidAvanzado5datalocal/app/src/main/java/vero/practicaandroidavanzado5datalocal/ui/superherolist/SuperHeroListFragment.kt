package vero.practicaandroidavanzado5datalocal.ui.superherolist

import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import dagger.hilt.android.AndroidEntryPoint

import vero.practicaandroidavanzado5datalocal.databinding.FragmentSuperHeroListBinding
import vero.practicaandroidavanzado5datalocal.ui.utils.SuperHeroListAdapter


@AndroidEntryPoint
class SuperHeroListFragment : Fragment() {

    private var _binding: FragmentSuperHeroListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
private val adapter = SuperHeroListAdapter{
    Log.d("Adapter click", it.toString())
    findNavController().navigate(
    SuperHeroListFragmentDirections.actionSuperHeroListFragmentToDetailFragment(it, it.name))}

    private val viewModel: SuperHeroListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSuperHeroListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            superheroList.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            superheroList.adapter = adapter

            viewModel.heros.observe(viewLifecycleOwner) { superheroList ->
                adapter.submitList(superheroList)
            }

            viewModel.error.observe(viewLifecycleOwner) { error ->
                Toast.makeText(requireContext(), error, Toast.LENGTH_LONG).show()
            }

            viewModel.state.observe(viewLifecycleOwner) { state ->
                when (state) {
                    is SuperHeroListState.Failure -> {
                        Toast.makeText(requireContext(), state.error, Toast.LENGTH_LONG).show()
                    }
                    is SuperHeroListState.Success -> {
                        adapter.submitList(state.heros)
                    }
                    is SuperHeroListState.NetworkFailure -> {
                    }
                }
            }

            viewModel.getSuperheros()
        }
    }

    /*
    override fun onAttach(context: Context) {
        super.onAttach(context)

        val myInterface = context as? MyInterface
        myInterface?.hola()
    }


    // DEPRECATED
    override fun onAttach(activity: Activity) {
        super.onAttach(activity)

        try {
            val myInterface = context as MyInterface
            myInterface.hola()
        } catch (e: Exception){

        }
    }
    */

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

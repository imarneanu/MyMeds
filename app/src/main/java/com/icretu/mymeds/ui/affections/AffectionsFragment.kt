package com.icretu.mymeds.ui.affections

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.icretu.mymeds.R
import com.icretu.mymeds.databinding.FragmentAffectionsBinding

class AffectionsFragment : Fragment() {

    private var _binding: FragmentAffectionsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val affectionsViewModel =
            ViewModelProvider(this)[AffectionsViewModel::class.java]

        _binding = FragmentAffectionsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textAffections
        affectionsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_affections_to_treatment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

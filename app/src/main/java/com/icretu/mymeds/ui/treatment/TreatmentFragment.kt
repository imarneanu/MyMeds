package com.icretu.mymeds.ui.treatment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.icretu.mymeds.R
import com.icretu.mymeds.databinding.FragmentTreatmentBinding

class TreatmentFragment : Fragment() {

    private var _binding: FragmentTreatmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val treatmentViewModel =
            ViewModelProvider(this)[TreatmentViewModel::class.java]

        _binding = FragmentTreatmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textTreatment
        treatmentViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_treatment_to_meds)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

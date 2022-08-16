package com.icretu.mymeds.ui.meds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.icretu.mymeds.R
import com.icretu.mymeds.databinding.FragmentMedsBinding

class MedsFragment : Fragment() {

    private var _binding: FragmentMedsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val medsViewModel =
            ViewModelProvider(this)[MedsViewModel::class.java]

        _binding = FragmentMedsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textMeds
        medsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_meds_to_affections)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

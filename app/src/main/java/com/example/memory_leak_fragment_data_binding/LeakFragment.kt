package com.example.memory_leak_fragment_data_binding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.memory_leak_fragment_data_binding.databinding.FragmentLeakBinding

class LeakFragment : Fragment() {

    private lateinit var binding: FragmentLeakBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        DataBindingUtil.inflate<FragmentLeakBinding>(
            inflater,
            R.layout.fragment_leak,
            container,
            false,
        ).also {
            binding = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
    }

    companion object {
        fun newInstance(): LeakFragment {
            return LeakFragment()
        }
    }
}
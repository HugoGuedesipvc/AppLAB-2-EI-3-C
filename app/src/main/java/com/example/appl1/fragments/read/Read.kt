package com.example.appl1.fragments.read

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appl1.R
import com.example.appl1.data.vm.NoteViewModel

class Read : Fragment() {

    private val noteViewModel: NoteViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NoteListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_read, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView(view)
        observeData()
    }

    private fun setupRecyclerView(view: View) {
        recyclerView = view.findViewById(R.id.recyclerview)
        adapter = NoteListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

    }


    private fun observeData() {
        noteViewModel.allNotes.observe(viewLifecycleOwner, { notes ->
            notes?.let { adapter.setNotes(it) }
        })
    }

}
package com.example.appl1.fragments.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.appl1.R
import com.example.appl1.data.entities.Note
import com.example.appl1.data.vm.NoteViewModel

class Create : Fragment() {

    private val noteViewModel: NoteViewModel by viewModels()
    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var saveButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView(view)
        setupButton()
    }

    private fun setupView(view: View) {
        titleEditText = view.findViewById(R.id.titleEditText)
        descriptionEditText = view.findViewById(R.id.descriptionEditText)
        saveButton = view.findViewById(R.id.saveButton)
    }

    private fun setupButton() {
        saveButton.setOnClickListener {
            val note = Note().apply {
                title = titleEditText.text.toString()
                description = descriptionEditText.text.toString()
            }
            noteViewModel.insert(note)

            Toast.makeText(requireContext(), "Gravado com sucesso!", Toast.LENGTH_LONG).show()
            findNavController().navigateUp()
        }
    }
}
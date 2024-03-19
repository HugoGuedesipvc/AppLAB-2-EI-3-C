package com.example.appl1.fragments.update

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.appl1.R
import com.example.appl1.data.entities.Note
import com.example.appl1.data.vm.NoteViewModel

class UpdateFragment : Fragment() {

    private val noteViewModel: NoteViewModel by viewModels()
    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var updateButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_update, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView(view)
        setupButton()
    }

    private fun setupView(view: View) {
        titleEditText = view.findViewById(R.id.titleEditText)
        descriptionEditText = view.findViewById(R.id.descriptionEditText)
        updateButton = view.findViewById(R.id.updateButton)
    }

    private fun setupButton() {
        updateButton.setOnClickListener {
            val note = Note().apply {
                title = titleEditText.text.toString()
                description = descriptionEditText.text.toString()
            }
            noteViewModel.update(note)

            Toast.makeText(requireContext(), "Atualizado com sucesso!", Toast.LENGTH_LONG).show()
        }
    }
}
package org.d3if2084.asesmen2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import org.d3if2084.asesmen2.databinding.ActivityMainBinding
import org.d3if2084.asesmen2.db.NoteDatabase
import org.d3if2084.asesmen2.repository.NoteRepository
import org.d3if2084.asesmen2.viewmodel.NoteViewModel
import org.d3if2084.asesmen2.viewmodel.NoteViewModelProviderFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        setUpViewModel()
    }

    private fun setUpViewModel() {
        val noteRepository = NoteRepository(
            NoteDatabase(this)
        )

        val viewModelProviderFactory =
            NoteViewModelProviderFactory(
                application, noteRepository
            )

        noteViewModel = ViewModelProvider(
            this,
            viewModelProviderFactory
        ).get(NoteViewModel::class.java)
    }

}
package org.d3if2084.asesmen2.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if2084.asesmen2.repository.NoteRepository

class NoteViewModelProviderFactory(
    val app: Application,
    private val noteRepository: NoteRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NoteViewModel(app, noteRepository) as T
    }
}
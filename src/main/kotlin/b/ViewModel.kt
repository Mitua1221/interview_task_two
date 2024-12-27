package b

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

// User inserting name / surname in text fields, we calling 'nameInput' methods.

// After user inserts value, we have to make formatting (it may takes long time, emulated with delays).

// Do we have any concurrency-problems here? Try to find it (if we have some) and solve it (if needed).

class ViewModel {

    private val repository = Repository()

    private val scope = CoroutineScope(Dispatchers.IO)

    private val state = MutableStateFlow(State())

    private data class State(
        val name: String = "",
    )

    fun nameInput(name: String) {
        state.value = state.value.copy(name = name)
        nameFormat()
    }

    private fun nameFormat() {
        scope.launch {
            val name = state.value.name
            val formattedName = repository.nameFormat(name)
            state.value = state.value.copy(name)
        }
    }
}

// This repository is stable, dont edit it please. Its just an emulation of long formatting on backend.
class Repository() {

    suspend fun nameFormat(name: String): String {
        delay(1000) // Emulate long api call with formatting
        return name.uppercase() // Emulate formatting on backend
    }

}
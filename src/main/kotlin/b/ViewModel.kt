package b

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

// User inserting name / surname in text fields, we calling 'nameInput' and 'surnameInput' methods.

// After user inserts value, we have to make formatting (it may takes long time, emulated with delays).

// Do we have any problems here? Try to find it (if we have some) and solve it (if needed).

class ViewModel {

    private val repository = Repository()

    private val scope = CoroutineScope(Dispatchers.IO)

    private val state = MutableStateFlow(State())

    private data class State(
        val name: String = "",
        val surname: String = "",
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

    fun surnameInput(surname: String) {
        state.value = state.value.copy(surname = surname)
        surnameFormat()
    }

    private fun surnameFormat() {
        scope.launch {
            val surname = state.value.surname
            val formattedSurname = repository.nameFormat(surname)
            state.value = state.value.copy(surname)
        }
    }
}

// This repository is stable, dont edit it please. Its just an emulation of long formatting on backend.
class Repository() {

    suspend fun nameFormat(name: String): String {
        delay(1000) // Emulate long api call with formatting
        return name.uppercase() // Emulate formatting on backend
    }

    suspend fun surnameFormat(surname: String): String {
        delay(1000) // Emulate long api call with formatting
        return surname.lowercase() // Emulate formatting on backend
    }

}
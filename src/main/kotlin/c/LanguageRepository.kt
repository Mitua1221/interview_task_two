package c_third


// In this task, we need to write tests to validate the functionality of the `detectLanguage` method.

// The method determines the language of a given input string by checking its script
// and matches it to one of the supported languages:
// - Arabic
// - Spanish
// - Chinese
// - Unknown

// We should focus on creating tests for `detectLanguage` method.

// Lets try to avoid any frameworks for testing, we have only Kotlin and corouties in this project. 

// Examples of input strings for local languages:
// - Arabic: "مرحبا", "السلام عليكم"
// - Spanish: "Hola", "¿Cómo estás?"
// - Chinese: "你好", "早上好"
// - Unknown: "1234", "!@#$"

fun main() {
    val test = LanguageRepositoryTest()

}


// Enum to represent supported languages
enum class Language {
    ARABIC,
    SPANISH,
    CHINESE,
    UNKNOWN
}

// Repository class to detect language based on input
class LanguageRepository {

    fun detectLanguage(input: String): Language {
        if (input.matches(Regex("[\u0600-\u06FF]+"))) {
            return Language.ARABIC // Arabic script range
        } else {
            if (input.matches(Regex("[\u4E00-\u9FFF]+"))) {
                return Language.CHINESE // Chinese characters range
            } else {
                if (input.matches(Regex("[\u0400-\u04FF]+"))) {
                    return Language.SPANISH // Spanish characters range
                } else {
                    return Language.UNKNOWN
                }
            }
        }
    }
}

// Test class to verify detection logic
class LanguageRepositoryTest {

}

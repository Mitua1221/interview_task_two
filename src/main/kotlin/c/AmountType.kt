package c

/**
 * ## Task Description
 *
 * We need to retrieve a sum from our backend for a certain cryptocurrency.
 *
 * 1. We need to choose the data type that we will use in our application to receive this sum and work with it.
 *    We can choose absolutely any data type for this purpose—`Double`, `Integer`, `Long`, `Float`, `String`, or any other.
 *
 * 2. After receiving the sum, we need to divide it by 13 and then multiply it by 5.
 *
 * 3. The resulting value must be rounded to 4 decimal places.
 */

class CurrencyQuestion {

    fun processCurrencySum(amount: SET_TYPE): SET_TYPE {
        val result = (amount / 13) * 5 // count
        val roundedResult = result // round
        return roundedResult
    }
}

class Api {

    fun getCurrency(): SET_TYPE {
        return "133223500.7235235"  // Example value
    }
}

fun main() {
    val api = Api()
    val currencyQuestion = CurrencyQuestion()

    val currencySum = api.getCurrency()
    val processedSum = currencyQuestion.processCurrencySum(currencySum)

    println("Original Sum: $currencySum")
    println("Processed Sum (rounded to 4 decimal places): $processedSum")
}

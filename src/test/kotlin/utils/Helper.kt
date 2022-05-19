package utils

import com.google.gson.JsonObject
import com.google.gson.JsonParser
import java.io.FileReader
import java.lang.System.currentTimeMillis
import java.sql.Timestamp
import java.util.Random

/**
 * Helper class which contains all the functions to generate random data for user creation
 * it is also used to instantiate the singleton TestContext
 */
open class Helper {
    companion object {
        val testContext: TestContext = TestContext

        fun readFile(fileName: String, objectName: String? = null): JsonObject {
            FileReader("src/test/resources/support/testdata/$fileName").use { reader ->
                val obj = JsonParser.parseReader(reader).asJsonObject
                objectName?.let { return obj.getAsJsonObject(objectName) } ?: return obj
            }
        }

        fun generateEmail() = "jose+${Timestamp(currentTimeMillis()).time}@share-now.com"

        fun generatePhoneNumber(legalEntity: LegalEntity): String {
            val currentTimeInTimesTamp = (Timestamp(currentTimeMillis()).time / 100).toString()
            return "${legalEntity.phoneCountryCode}$currentTimeInTimesTamp"
        }

        fun generateRandomNumber(length: Int): String {
            var randomNumber = Math.pow(10.0, (length - 1).toDouble()).toInt()
            randomNumber += Random().nextInt(9 * randomNumber)
            return randomNumber.toString()
        }
    }
}

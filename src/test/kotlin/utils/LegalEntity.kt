package utils

import utils.Helper.Companion.generateRandomNumber
/**
Legal entity represents every Country where the car sharing service exist
this class contains also information that only are required for a specific country
 */
sealed class LegalEntity(
    val id: String,
    val userFile: String,
    val phoneCountryCode: String,
    val name: String,
    val driversLicenseNumber: String = generateRandomNumber(6)
) {
    object DE : LegalEntity("10", "DEUser.json", "+49", "DE")
    object NL : LegalEntity("1", "NLUser.json", "+31", "NL", generateRandomNumber(10))

    companion object {
        fun fromString(legalEntity: String): LegalEntity {
            return when (legalEntity) {
                "DE" -> DE
                "NL" -> NL
                else -> throw java.lang.IllegalArgumentException("LE not found")
            }
        }
    }
}


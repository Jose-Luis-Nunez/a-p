package utils

import utils.Helper.Companion.generateRandomNumber

/**
 * Like the sealed class LegalEntity but with an Enum
 *
 * Legal Entity represents every Country where the car sharing service exist
 * this class contains also information that only are required for a specific country
 */
enum class LegalEntityNew(
    val id: String,
    val userFile: String,
    val phoneCountryCode: String,
    val legalEntityName: String,
    val driversLicenseNumber: String = Helper.generateRandomNumber(6)
) {
    DE("10", "DEUser.json", "+49", "DE"),
    NL("1", "NLUser.json", "+31", "NL", generateRandomNumber(10))
}
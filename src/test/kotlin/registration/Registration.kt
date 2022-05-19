package registration

import utils.RequestFunctions.Companion.postRequest
import io.restassured.RestAssured
import io.restassured.http.ContentType
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification
import utils.Helper.Companion.generateEmail
import utils.Helper.Companion.generatePhoneNumber
import utils.Helper.Companion.generateRandomNumber
import utils.Helper.Companion.readFile
import utils.Helper.Companion.testContext
import utils.LegalEntity
import utils.REGISTRATION_URL
/**
 * This class represents the domain registration
 * here the calls are made to do a registration
 */
class Registration {

    fun postNewCustomerRequest(legalEntity: LegalEntity): Response {
        val requestSpecification = createCustomerRequestSpecification(legalEntity)
        val response = postRequest(requestSpecification, "$REGISTRATION_URL${legalEntity.id}")

        testContext.customerId = "extract customer id from response and store in singleton for Deletion in a different step"

        return response
    }

    private fun createCustomerRequestSpecification(legalEntity: LegalEntity): RequestSpecification {
        val userRequestParams = readFile(legalEntity.userFile).apply {
            addProperty("email", generateEmail())
            addProperty("mobilePhone", generatePhoneNumber(legalEntity))
            addProperty("drivingLocation", generateRandomNumber(7))
        }

        return RestAssured.given()
            .contentType(ContentType.JSON)
            .body(userRequestParams.toString())
            .log().body()
    }
}

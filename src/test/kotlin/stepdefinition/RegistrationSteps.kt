package stepdefinition

import io.cucumber.java.en.Given
import registration.Registration
import utils.LegalEntity
import utils.Retry.Companion.waitFor

/**
 * Step class for Cucumber
 * here we call the functions from the domain class like Registration
 */
class RegistrationSteps {

    @Given("new {string} customer is registered")
    @Throws(InterruptedException::class)
    fun registerAndValidateCustomer(le: String) {
        val legalEntity = LegalEntity.fromString(le)

        waitFor({ Registration().postNewCustomerRequest(legalEntity) }, statusCode = 200)
    }
}

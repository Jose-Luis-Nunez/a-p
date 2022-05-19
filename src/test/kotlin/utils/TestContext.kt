package utils

/**
 * this class is a singleton
 * it will store all the information that are important for a test run
 *
 * e.g. the class Registration will save a customerID which will be used later to delete the same customer
 * with the stored customerID provided by the TestContext class
 */
object TestContext {
    var customerId = ""
}

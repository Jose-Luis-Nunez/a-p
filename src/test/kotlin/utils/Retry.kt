package utils

import io.restassured.response.Response
import java.lang.Thread.sleep
import java.util.function.BooleanSupplier
/**
 * This class is for retrying a request
 *
 * in the RegistrationSteps all the request for a test are made
 * and because a request could fail it will be executed maximum 3 times
 */
class Retry {
    companion object {
        private const val RETRIES = 3
        private const val SLEEP_TIME_IN_SECONDS = 1

        fun waitFor(request: () -> Response, statusCode: Int) {

            for (i in 1..RETRIES) {

                if (request().statusCode == statusCode) return
                sleep(SLEEP_TIME_IN_SECONDS * 1000L)

                println("#try: $i - request result: ${request().statusCode} not $statusCode")
            }
            throw RuntimeException("$RETRIES Failed retries")
        }

        fun waitFor(fn: BooleanSupplier) {
            for (i in 1..RETRIES) {

                val result = fn.asBoolean
                println("#try: $i - request result: $result")

                if (result) return
                sleep(SLEEP_TIME_IN_SECONDS * 1000L)
            }
            throw RuntimeException("$RETRIES Failed retries")
        }
    }
}

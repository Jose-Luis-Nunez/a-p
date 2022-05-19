package utils

import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification
/**
 * In this class the rest assured request will be stored to reused it every time
 */
class RequestFunctions {
    companion object {
        fun postRequest(requestSpecification: RequestSpecification, requestPath: String): Response {
            return Given {
                spec(requestSpecification)
            } When {
                log().all()
                post(requestPath)
            } Then {
                log().body()
            } Extract {
                response()
            }
        }
    }
}

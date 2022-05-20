package utils

import io.restassured.RestAssured
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import io.restassured.parsing.Parser
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

        fun getRequest(requestSpecification: RequestSpecification, requestPath: String): Response {
            return Given {
                spec(requestSpecification)
            } When {
                get(requestPath)
            } Then {
                log().body()
            } Extract {
                response()
            }
        }

        fun putRequest(requestSpecification: RequestSpecification, requestPath: String): Response {
            RestAssured.defaultParser = Parser.JSON
            return Given {
                spec(requestSpecification)
            } When {
                log().all()
                put(requestPath)
            } Then {
                log().body()
            } Extract {
                response()
            }
        }
    }
}

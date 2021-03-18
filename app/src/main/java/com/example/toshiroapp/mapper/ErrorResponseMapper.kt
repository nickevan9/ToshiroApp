package com.example.toshiroapp.mapper

import com.example.toshiroapp.model.WeatherErrorResponse

import com.skydoves.sandwich.ApiErrorModelMapper
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message

/**
 * A mapper for mapping [ApiResponse.Failure.Error] response as custom [WeatherErrorResponse] instance.
 *
 * @see [ApiErrorModelMapper](https://github.com/skydoves/sandwich#apierrormodelmapper)
 */
object ErrorResponseMapper : ApiErrorModelMapper<WeatherErrorResponse> {

  /**
   * maps the [ApiResponse.Failure.Error] to the [WeatherErrorResponse] using the mapper.
   *
   * @param apiErrorResponse The [ApiResponse.Failure.Error] error response from the network request.
   * @return A customized [WeatherErrorResponse] error response.
   */
  override fun map(apiErrorResponse: ApiResponse.Failure.Error<*>): WeatherErrorResponse {
    return WeatherErrorResponse(apiErrorResponse.statusCode.code, apiErrorResponse.message())
  }
}

package com.fletchmckee.composeplayground.common.util

import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.withContext

suspend fun <T> suspendRunCatching(block: suspend () -> T): Result<T> = try {
  Result.success(block())
} catch (cancellationException: CancellationException) {
  throw cancellationException
} catch (exception: Exception) {
  Result.failure(exception)
}

suspend fun <T> suspendRunCatching(
  context: CoroutineContext,
  block: suspend () -> T,
): Result<T> = withContext(context) {
  try {
    Result.success(block())
  } catch (cancellationException: CancellationException) {
    throw cancellationException
  } catch (exception: Exception) {
    Result.failure(exception)
  }
}

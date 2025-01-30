package com.fletchmckee.composeplayground.data.repository

import com.fletchmckee.composeplayground.common.util.suspendRunCatching

interface CatalogRepository {
  suspend fun getCatalog(): Result<Unit>
}

class CatalogRepositoryImpl : CatalogRepository {
  override suspend fun getCatalog(): Result<Unit> = suspendRunCatching {
    // TODO: Testing out the todo.yml action.
  }
}

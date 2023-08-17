package com.example.fleetiocore.webService

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.fleetiocore.model.VehicleItem
import com.example.fleetiocore.model.VehicleItemTrim
import com.example.fleetiocore.util.EitherResult

class VehiclePagingSource(private val webService: WebService) : PagingSource<Int, VehicleItemTrim>() {

    override fun getRefreshKey(state: PagingState<Int, VehicleItemTrim>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, VehicleItemTrim> {
        return try {
            val page = params.key ?: 1
            when (val response = webService.getVehicles(page = page)) {
                is EitherResult.Failure -> LoadResult.Error(Exception(response.error.message ?: ""))
                is EitherResult.Success -> {
                    LoadResult.Page(
                        data = response.value,
                        prevKey = if (page == 1) null else page.minus(1),
                        nextKey = if (response.value.isEmpty()) null else page.plus(1),
                    )
                }
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}
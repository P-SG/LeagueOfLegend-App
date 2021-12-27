package com.psg.leagueoflegend_app.data.repository

import androidx.lifecycle.LiveData
import com.psg.leagueoflegend_app.data.api.LeagueOfLegendAPI
import com.psg.leagueoflegend_app.data.db.dao.LoLDao
import com.psg.leagueoflegend_app.data.model.LeagueEntryDTO
import com.psg.leagueoflegend_app.data.model.SearchEntity
import com.psg.leagueoflegend_app.data.model.Summoner
import com.psg.leagueoflegend_app.data.model.SummonerEntity
import com.psg.leagueoflegend_app.utils.Constants
import retrofit2.Response

class AppRepository constructor(private val dao: LoLDao, private val api: LeagueOfLegendAPI) {

    suspend fun searchSummoner(name: String, apiKey: String): Response<Summoner> = api.getSummoner(name,apiKey)

    suspend fun searchLeague(summonerId:String?, apiKey: String): Response<Set<LeagueEntryDTO>> = api.getLeague(summonerId,apiKey)


    // Room Main
    fun getSummoner() = dao.getSummoner()

    suspend fun insertSummoner(summonerEntity: SummonerEntity){
        dao.insertSummoner(summonerEntity)
    }

    suspend fun updateSummoner(summonerEntity: SummonerEntity){
        dao.updateSummoner(summonerEntity)
    }

    suspend fun deleteSummoner(summonerEntity: SummonerEntity){
        dao.deleteSummoner(summonerEntity)
    }

    suspend fun deleteSummonerAll(){
        dao.deleteSummonerAll()
    }

    // Search

    fun getSearch() = dao.getSearch()

    suspend fun insertSearch(searchEntity: SearchEntity){
        dao.insertSearch(searchEntity)
    }

    suspend fun deleteSearch(searchEntity: SearchEntity){
        dao.deleteSearch(searchEntity)
    }

    suspend fun deleteSearchAll(){
        dao.deleteSearchAll()
    }

}
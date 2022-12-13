package com.example.shoestore.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.shoestore.home.model.Shoe

class ShoeViewModel: ViewModel() {

    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>>
        get() = _shoes


    fun getShoes() {
        _shoes.value = createShoeList()
    }

    private fun createShoeList(shoe: Shoe? = null) : MutableList<Shoe> {
        val shoes: MutableList<Shoe> = ArrayList()
        shoes.add(Shoe(name = "Sapato 1", description = "Descrição 2", size = "1.0", company = "Empresa 2"))
        shoes.add(Shoe(name = "Sapato 2", description = "Descrição 2", size = "1.0", company = "Empresa 2"))
        shoes.add(Shoe(name = "Sapato 3", description = "Descrição 3", size = "1.0", company = "Empresa 3"))
        shoes.add(Shoe(name = "Sapato 4", description = "Descrição 4", size = "1.0", company = "Empresa 4"))
        shoes.add(Shoe(name = "Sapato 5", description = "Descrição 5", size = "1.0", company = "Empresa 5"))
        shoes.add(Shoe(name = "Sapato 6", description = "Descrição 6", size = "1.0", company = "Empresa 6"))
        shoes.add(Shoe(name = "Sapato 7", description = "Descrição 7", size = "1.0", company = "Empresa 7"))
        shoes.add(Shoe(name = "Sapato 8", description = "Descrição 8", size = "1.0", company = "Empresa 8"))
        shoes.add(Shoe(name = "Sapato 9", description = "Descrição 9", size = "1.0", company = "Empresa 9"))
        shoes.add(Shoe(name = "Sapato 10", description = "Descrição 10", size = "1.0", company = "Empresa 10"))
        shoes.add(Shoe(name = "Sapato 11", description = "Descrição 11", size = "1.0", company = "Empresa 11"))
        shoes.add(Shoe(name = "Sapato 12", description = "Descrição 12", size = "1.0", company = "Empresa 12"))
        shoes.add(Shoe(name = "Sapato 13", description = "Descrição 13", size = "1.0", company = "Empresa 13"))
        shoe?.let { shoes.add(it) }
        return shoes
    }

    fun addShoe(shoe: Shoe) {
        _shoes.value = createShoeList(shoe)
    }
}
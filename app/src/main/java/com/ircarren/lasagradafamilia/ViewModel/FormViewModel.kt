package com.ircarren.lasagradafamilia.ViewModel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FormViewModel : ViewModel() {
    // Clase que se encarga de la lógica de la vista

    // Variables que se encargan de guardar los datos de la vista
    private val _live_data_localizador = MutableLiveData<String>()
    val localizador: LiveData<String> = _live_data_localizador

    private val _live_data_email = MutableLiveData<String>()
    val email: LiveData<String> = _live_data_email

    private val _live_data_fecha = MutableLiveData<String>()
    val fecha: LiveData<String> = _live_data_fecha

    private val _live_data_check = MutableLiveData<Boolean>()
    val check: LiveData<Boolean> = _live_data_check

    fun onLoginChange(localizador: String, email: String, fecha: String) {
        _live_data_email.value = email
        _live_data_localizador.value = localizador
        _live_data_fecha.value = fecha
        _live_data_check.value = checkEmail(email) && checkLocalizador(localizador) && checkFecha(fecha)
    }

    // Función que comprueba que el email sea correcto

    fun checkEmail(email:String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    // Función que comprueba que el localizador sea correcto

    fun checkLocalizador(localizador:String): Boolean {
        return localizador.length > 6
    }
    // Función que comprueba que la fecha sea correcta

    fun checkFecha(fecha:String): Boolean {
        return fecha.length > 6
    }

    // Función que comprueba que descarga la entrada del cliente
    fun genEntrada() {
        // TODO

    }

}
package com.ircarren.lasagradafamilia.View

import android.app.DatePickerDialog
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.ircarren.lasagradafamilia.ViewModel.FormViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*

class FormView {


    // funcion para el main
    @Composable
    fun MainScrrenForm() {
        FormScreen(viewModel = FormViewModel())
    }
    // funcion para el formulario
    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun FormScreen( modifier: Modifier = Modifier, viewModel: FormViewModel){



        val email:String by viewModel.email.observeAsState(initial = "")
        val localizador:String by viewModel.localizador.observeAsState(initial = "")
        val fecha:String by viewModel.fecha.observeAsState(initial = "")
        val check:Boolean by viewModel.check.observeAsState(initial = false)
        var showDialog by remember { mutableStateOf(false) }


        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            headerForm()
            Spacer(modifier = Modifier.height(16.dp))
            EmailPlace(modifier = Modifier.height(16.dp), email = email){
                viewModel.onLoginChange(localizador, it, fecha)
            }
            Spacer(modifier = Modifier.height(16.dp))
            LocalizadorPlace(modifier = Modifier.height(16.dp), localizador = localizador){
                viewModel.onLoginChange(it, email, fecha)
            }
            Spacer(modifier = Modifier.height(16.dp))
            FechaPlace(modifier = Modifier.height(16.dp), fecha = fecha){
                viewModel.onLoginChange(localizador, email, it)
            }
            Spacer(modifier = Modifier.height(16.dp))
            DescargaEntrada(check = check, modifier = Modifier.height(16.dp)){
                viewModel.genEntrada()
                showDialog = true
            }
            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text("Entradas descargadas") },
                    text = { Text("Las entradas se han descargado correctamente") },
                    confirmButton = {
                        Button(onClick = { showDialog = false }) {
                            Text("Aceptar")
                        }
                    }
                )
            }
        }
    }
    // funcion para el header
    @Composable
    fun headerForm(modifier: Modifier = Modifier){
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Column {
                Text(text = "Descarga tus entradas", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Introduce tu email y localizador para descargar tus entradas", fontSize = 16.sp)

            }
        }
    }

    // funcion para el campo de email
    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun EmailPlace(modifier: Modifier, email: String, onEmailChange: (String) -> Unit) {
        val keyboardController = LocalSoftwareKeyboardController.current

        OutlinedTextField(
            leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "Email") },
            value = email,
            onValueChange = { onEmailChange(it) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
            maxLines = 1,
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
    }
    // funcion para el campo de localizador
    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun LocalizadorPlace(modifier: Modifier, localizador: String, onLocalizadorChange: (String) -> Unit) {
        val keyboardController = LocalSoftwareKeyboardController.current
        OutlinedTextField(
            leadingIcon = { Icon(Icons.Filled.AccountCircle, contentDescription = "Localizador") },
            value = localizador,
            onValueChange = { onLocalizadorChange(it) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
            maxLines = 1,
            label = { Text("Localizador") },
            modifier = Modifier.fillMaxWidth()
        )
    }
    // funcion para el campo de fecha
    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun FechaPlace(modifier: Modifier, fecha: String, onFechaChange: (String) -> Unit) {
        val keyboardController = LocalSoftwareKeyboardController.current


        val mYear: Int
        val mMonth: Int
        val mDay: Int
        val mContext = LocalContext.current
        val mCalendar = Calendar.getInstance()

        mYear = mCalendar.get(Calendar.YEAR)
        mMonth = mCalendar.get(Calendar.MONTH)
        mDay = mCalendar.get(Calendar.DAY_OF_MONTH)
        mCalendar.time = Date()
        val mDate = remember { mutableStateOf("") }

        val mDatePickerDialog = DatePickerDialog(
            mContext,
            { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
                mDate.value = "$mDayOfMonth/${mMonth+1}/$mYear"

            }, mYear, mMonth, mDay
        )

        OutlinedTextField(
            leadingIcon = { Icon(Icons.Filled.Favorite, contentDescription = "Fecha") },
            value = mDate.value,
            onValueChange = { onFechaChange(it) },
            keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
            singleLine = true,
            maxLines = 1,
            label = { Text("Fecha") },
            modifier = Modifier.fillMaxWidth().clickable { mDatePickerDialog.show() },
        )
    }

    @Composable
    fun DescargaEntrada(check: Boolean, modifier: Modifier, onClick: (Boolean) -> Unit ) {
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                onClick(true)
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = check
        ) {
            Text("Descarga tus entradas")
        }
    }


}
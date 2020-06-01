package cursoandroid.kotlin.com.br

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcularPreco(view: View) {

        //recuperar valores digitados
        //val precoAlcool = findViewById<EditText>(R.id.editTextAlcool)
        val precoAlcool = editTextAlcool.text.toString(); //outra alternativa de captura viewbinding usando kotlin extensions;
        val precoGasolina = editTextGasolina.text.toString();

        val validarCampos = validarCampos(precoAlcool,precoGasolina)

        if (validarCampos) {
            calculaMelhorPreco(precoAlcool,precoGasolina)
        }else{
            textResultado.text= "Preencha os preços primeiros"
        }

    }

    fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean{

        var camposValidados: Boolean = true

        if (precoAlcool == null || precoAlcool.equals("")) {
            camposValidados = false
        }else if (precoGasolina == null || precoGasolina.equals("")){
            camposValidados = false
        }

        return camposValidados

    }

    fun calculaMelhorPreco(precoAlcool: String, precoGasolina: String){

            val precoAlcool = precoAlcool.toDouble()
            val precoGasolina = precoGasolina.toDouble()

            val resultadoPreco = precoAlcool / precoGasolina

            if (resultadoPreco >= 0.7) {
                textResultado.text = "Melhor utilizar gasolina!"
            } else {
                textResultado.text = "Mulher utilizar alcool!"
            }

    }



}
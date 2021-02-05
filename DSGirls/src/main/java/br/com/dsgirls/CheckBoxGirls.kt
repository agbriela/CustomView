package br.com.dsgirls

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.TypedValue
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.core.content.ContextCompat

enum class CheckTypes {
    PURPLE,
    BLUE
}

class CheckBoxGirls @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatCheckBox(context, attrs, defStyleAttr) {

    private lateinit var checkBoxType: CheckTypes

    init {
        setPadding(
            16,
            paddingTop,
            paddingRight,
            paddingBottom
        )// seta programaticamente a margem na esquerda e deixa a margem dos outros lados estao sendo o padrao do android
        setTextSize(TypedValue.COMPLEX_UNIT_PX, 54F)
        isClickable = true
        attrs?.let {
            updateCheckBox(it) // verifica se teve mudanca ou n no botao
        }
    }
    // enum class = a gente consegue colocar todos os tipos de componentes que vao existir no projeto. CONJUNTO DE VALORES CONSTANTES PRÉ DEFINIDOS

    private fun updateCheckBox(attributeSet: AttributeSet) {
        val attributes: TypedArray = context.obtainStyledAttributes(
            attributeSet,
            R.styleable.CheckBoxDesign,
            0,
            0
        )
        val enumCheckBoxIndex = attributes.getInt(R.styleable.CheckBoxDesign_checkBoxTypes, 0)
        checkBoxType = CheckTypes.values()[enumCheckBoxIndex]
        attributes.recycle()
        updateCheckBoxColor(checkBoxType)
    }

    private fun updateCheckBoxColor(status: CheckTypes) {
        when (status) {
            CheckTypes.PURPLE -> {
                setButtonDrawable(R.drawable.checkbox_violet)
                setTextColor(ContextCompat.getColor(context, R.color.color_violet))
            }
            CheckTypes.BLUE -> {
                setButtonDrawable(R.drawable.checkbox_blue)
                setTextColor(ContextCompat.getColor(context, R.color.color_blue))
            }
        }
    }
}
package br.com.dsgirls

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.TypedValue
import androidx.appcompat.widget.AppCompatCheckBox

class CheckBoxGirls @JvmOverloads constructor(
    context: Context, attrs: AttributeSet?=null, defStyleAttr: Int = 0
): AppCompatCheckBox(context, attrs, defStyleAttr){

    init {
        setPadding(16, paddingTop, paddingRight, paddingBottom)// seta programaticamente a margem na esquerda e deixa a margem dos outros lados estao sendo o padrao do android
        setTextSize(TypedValue.COMPLEX_UNIT_PX, 54F)
        isClickable = true
        attrs.let {
            updateCheckBox(it) // verifica se teve mudanca ou n no botao
        }
    }

    private fun updateCheckBox(attributeSet: AttributeSet?) {
        val attributes: TypedArray = context.obtainStyledAttributes(
            attributeSet,
            R.styleable.CheckBoxDesign,
            0,
            0
        )

    }
}
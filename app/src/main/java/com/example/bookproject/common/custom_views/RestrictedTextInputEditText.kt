package com.example.bookproject.common.custom_views

import android.content.Context
import android.text.InputFilter
import android.util.AttributeSet
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.textfield.TextInputEditText

// this will works only when input type is number and not decimal
class RestrictedTextInputEditText : TextInputEditText {

    // Constructor for creating the view programmatically
    constructor(context: Context) : super(context) {
        setupRestriction()
    }

    // Constructor for inflating the view from XML with attributes
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        setupRestriction()
    }

    // Constructor for inflating the view with a style attribute
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        setupRestriction()
    }

    private fun setupRestriction() {
        // 🔥 Add Emoji Filter
        val emojiFilter = InputFilter { source, start, end, _, _, _ ->
            source?.filter { ch ->
                val type = Character.getType(ch)
                !(type == Character.SURROGATE.toInt() || type == Character.OTHER_SYMBOL.toInt())
            }
        }

        // Apply emoji filter without removing existing filters
        filters = filters.toMutableList().apply { add(emojiFilter) }.toTypedArray()


        this.doAfterTextChanged { text ->
            text?.let {
                // Apply restriction: Remove '.' or '0' unless it's "0."
                if (it.isNotEmpty()) {
                    //if (it.startsWith(".") || (it.startsWith("0") && it.length > 1 && it[1] != '.')) {
                    if (it.startsWith(".")) {
                        it.delete(0, 1)
                    }
                }
            }
        }
    }
}

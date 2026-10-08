package com.example.bookproject.common.custom_views

import android.content.Context
import android.util.AttributeSet
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.view.autofill.AutofillValue
import androidx.appcompat.widget.AppCompatAutoCompleteTextView

/**
 * Created by rahi.jain on 20-03-2024.
 */
class CustomAutoCompleteTextView : AppCompatAutoCompleteTextView {
    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    override fun autofill(value: AutofillValue?) {
        return
        super.autofill(value)
    }


    private fun init() {
        // Disable copy/paste actions
        isLongClickable = false

        //Disable selection
        //setTextIsSelectable(false)
        customSelectionActionModeCallback = object : ActionMode.Callback {
            override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
                return false
            }

            override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
                return false
            }

            override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
                return false
            }

            override fun onDestroyActionMode(mode: ActionMode) {}
        }
    }
}
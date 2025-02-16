package breon.telematics.loneworkersafetyapp.android.utils

import android.app.AlertDialog
import android.content.Context

fun createAlertDialog(
    context: Context,
    title: String,
    message: String,
    positiveBtnText: String = "Yes",
    negativeBtnText: String = "No",
    onPositiveBtnClick: () -> Unit = {},
    onNegativeBtnClick: () -> Unit = {}
) {
    val builder = AlertDialog.Builder(context)
    builder.setTitle(title)
    builder.setMessage(message)

    builder.setPositiveButton(positiveBtnText) { dialogInterface, _ ->
        dialogInterface.dismiss()
        onPositiveBtnClick.invoke()
    }

    builder.setNegativeButton(negativeBtnText) { dialogInterface, _ ->
        dialogInterface.dismiss()
        onNegativeBtnClick.invoke()
    }
    val alertDialog: AlertDialog = builder.create()
    alertDialog.setCancelable(true)
    alertDialog.show()
}

fun createOptionDialog(
    context: Context,
    options: Array<String>,
    title: String,
    onOptionSelected: (String, Int) -> Unit
) {
    val builder = AlertDialog.Builder(context)
    builder.setTitle(title)
        .setItems(options) { _, pos ->
            // Handle option selection
            when (pos) {
                0 -> onOptionSelected(options[pos], pos)
                1 -> onOptionSelected(options[pos], pos)
                2 -> onOptionSelected(options[pos], pos)
                3 -> onOptionSelected(options[pos], pos)
            }
        }
        .setCancelable(true)

    val dialog = builder.create()
    dialog.show()
}

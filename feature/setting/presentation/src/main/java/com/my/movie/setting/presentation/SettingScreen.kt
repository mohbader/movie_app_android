package com.my.movie.setting.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties


@Composable
fun SettingDialog(
    onDismiss: () -> Unit,
) {
    SettingDialog(
        onDismiss,
        onChaneTheme = {}
    )
}

@Composable
fun SettingDialog(
    onDismiss: () -> Unit,
    onChaneTheme: () -> Unit
) {
    AlertDialog(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false
        ),
        onDismissRequest = { onDismiss() },

        title = {
            Text(text = "Setting")
        },

        text = {
            ThemeChoices()
        },
        confirmButton = {
            Button(
                onClick = { onDismiss() }
            ) {
                Text(text = "Done")
            }
        },
    )
}

@Composable
fun ThemeChoices(

) {

    Column(modifier = Modifier.selectableGroup()) {
        ChoicerRow(text = "Light", isSelected = true, onClick = {})
        ChoicerRow(text = "dark", isSelected = true, onClick = {})
        ChoicerRow(text = "default", isSelected = true, onClick = {})
    }
}

@Composable
fun ChoicerRow(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
            .selectable(
                selected = isSelected,
                onClick = onClick,
                role = Role.RadioButton
            )
    ) {
        RadioButton(
            selected = isSelected,
            onClick = onClick
        )
        Spacer(Modifier.width(8.dp))
        Text(text = text)
    }
}
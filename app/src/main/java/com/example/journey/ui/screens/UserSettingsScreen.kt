package com.example.journey.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.journey.model.Task
import com.example.journey.model.UserSettings
import com.example.journey.ui.viewmodel.TaskViewModel
import com.example.journey.ui.viewmodel.UserSettingsViewModel

@Composable
fun UserSettingsScreen() {

    val viewModel: UserSettingsViewModel = viewModel()

    val userSettings = viewModel.userSettings.collectAsState().value

//     UI to display tasks
//    LazyColumn {
//        items(userSettings) { userSetting ->
//            UserSettingItem(userSetting, onUserSettingClicked = { /* Handle task click */ })
//        }
//    }
}

@Composable
fun UserSettingItem(userSetting: UserSettings, onUserSettingClicked: (UserSettings) -> Unit) {
    // Layout for each task item
    Text(text = userSetting.darkModeEnabled.toString(), modifier = Modifier.clickable { onUserSettingClicked(userSetting) })
    // Add more details as needed
}

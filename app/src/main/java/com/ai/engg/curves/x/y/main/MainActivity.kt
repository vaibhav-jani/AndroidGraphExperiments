package com.ai.engg.curves.x.y.main

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ai.engg.curves.x.y.main.models.Example

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    val context = LocalContext.current
    val examples = remember { getAllActivities(context) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Activities List") })
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(examples) { example ->
                ActivityItem(example, context)
            }
        }
    }
}

@Composable
fun ActivityItem(example: Example, context: Context) {
    Text(
        text = example.name,
        fontSize = 22.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                try {
                    val clazz = Class.forName(example.fullName)
                    val intent = Intent(context, clazz)
                    context.startActivity(intent)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
    )
}

fun getAllActivities(context: Context): List<Example> {
    val manager = context.packageManager
    val activitiesList = mutableListOf<Example>()
    val packageName = context.packageName

    val examplesPackage = "com.ai.engg.curves.x.y.examples."
    val packageInfo = manager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
    packageInfo.activities?.forEach { activityInfo ->
        if (activityInfo.name.startsWith(examplesPackage)) {
            val activityName = activityInfo.name.replace(examplesPackage, "")
            val example = Example(
                name = activityName,
                fullName = activityInfo.name
            )
            activitiesList.add(
                example
            )
        }
    }

    return activitiesList
}

@Preview(showBackground = true)
@Composable
fun PreviewMyApp() {
    MyApp()
}

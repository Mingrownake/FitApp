package com.nvozhegov.optimalworkout.presentation.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.nvozhegov.optimalworkout.presentation.bars.TopBar
import com.nvozhegov.optimalworkout.presentation.components.sharedViewModel
import com.nvozhegov.optimalworkout.presentation.screen.exercise.ExerciseCardScreen
import com.nvozhegov.optimalworkout.presentation.screen.group.GroupScreen
import com.nvozhegov.optimalworkout.presentation.screen.template.newTemplate.NewTemplateScreen
import com.nvozhegov.optimalworkout.presentation.screen.template.newTemplate.NewTemplateViewModel

@Composable
fun TemplateNavScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val templateNavController = rememberNavController()
    val scaffoldState = remember {
        mutableStateOf(BarScaffoldViewState())
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopBar(
                title = scaffoldState.value.title,
                navigationIcon = scaffoldState.value.navigationIcon,
                actionButton = scaffoldState.value.actionButton
            )
        },
        floatingActionButton = scaffoldState.value.floatingButton


    ) { innerPadding ->
        NavHost(
            navController = templateNavController,
            modifier = Modifier
                .padding(innerPadding)
                .background(color = MaterialTheme.colorScheme.background),
            startDestination = TemplateNavRoute.Template.title,
            enterTransition = {
                slideInHorizontally {
                    it
                }
            },
            exitTransition = {
                slideOutHorizontally {
                    it
                }
            }
        ) {
            navigation(
                route = TemplateNavRoute.Template.title,
                startDestination = TemplateNavRoute.NewTemplate.title
            ) {
                composable(
                    route = TemplateNavRoute.NewTemplate.title
                ) { entry ->
                    val newTemplateViewModel = entry.sharedViewModel<NewTemplateViewModel>(
                        templateNavController
                    )
                    NewTemplateScreen(
                        scaffoldViewState = scaffoldState,
                        actionBack = {
                            navController.navigateUp()
                        },
                        navigateTo = {
                            templateNavController.navigate(TemplateNavRoute.Groups.title) {
                                launchSingleTop = true
                            }
                        },
                        templateViewModel = newTemplateViewModel
                    )
                }

                composable(
                    route = TemplateNavRoute.Groups.title
                ) {
                    GroupScreen(
                        scaffoldViewState = scaffoldState,
                        actionBack = { templateNavController.popBackStack() },
                        navigateTo = {
                            templateNavController.navigate(
                                "${TemplateNavRoute.Exercise.title}/$it"
                            ) {
                                launchSingleTop = true
                            }
                        }
                    )
                }

                composable(
                    route = "${TemplateNavRoute.Exercise.title}/{groupId}",
                    arguments = listOf(navArgument("groupId") {
                        type = NavType.IntType
                        nullable = false
                    })
                ) { entry ->
                    val newTemplateViewModel = entry.sharedViewModel<NewTemplateViewModel>(
                        templateNavController
                    )
                    val groupId = entry.arguments?.getInt("groupId")
                    ExerciseCardScreen(
                        scaffoldViewState = scaffoldState,
                        groupId = groupId!!,
                        actionBack = {
                            templateNavController.popBackStack()
                        },
                        action = { exercise ->
                            //newTemplateViewModel.addExercise(exercise)
                        }
                    )
                }
            }
        }
    }
}
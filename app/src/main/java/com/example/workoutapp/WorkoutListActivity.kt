package com.example.workoutapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WorkoutListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_list)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewWorkouts)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val workoutCategories = listOf(
            ExerciseCategory(
                name = "Yoga",
                description = "Yoga exercises & meditation",
                imageResId = R.drawable.yoga
            ),
            ExerciseCategory(
                name = "Chest",
                description = "Push movement exercises",
                imageResId = R.drawable.shoulderpress
            ),
            ExerciseCategory(
                name = "Back",
                description = "Pull movement exercises",
                imageResId = R.drawable.cable
            ),
            ExerciseCategory(
                name = "Arms",
                description = "Arm movement exercises",
                imageResId = R.drawable.straightarm
            ),
            ExerciseCategory(
                name = "Cardio",
                description = "Cardio exercises",
                imageResId = R.drawable.cardio
            ),
            ExerciseCategory(
                name = "Legs",
                description = "Legs workout",
                imageResId = R.drawable.legsworkout
            )
        )

        val adapter = WorkoutCategoryAdapter(workoutCategories) { category ->
            val intent = Intent(this, ExerciseCategoryActivity::class.java)
            intent.putExtra("CATEGORY_NAME", category.name ?: "Default Category")
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}

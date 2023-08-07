package com.yanshin.todoapp.models

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import com.yanshin.todoapp.ui.theme.HighPriorityColor
import com.yanshin.todoapp.ui.theme.LowPriorityColor
import com.yanshin.todoapp.ui.theme.MediumPriorityColor
import com.yanshin.todoapp.ui.theme.NoPriorityColor

@Entity
enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NoPriorityColor)
}

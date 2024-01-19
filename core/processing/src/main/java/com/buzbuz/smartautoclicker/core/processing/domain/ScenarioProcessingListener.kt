/*
 * Copyright (C) 2024 Kevin Buzeau
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.buzbuz.smartautoclicker.core.processing.domain

import android.content.Context

import com.buzbuz.smartautoclicker.core.domain.model.condition.ImageCondition
import com.buzbuz.smartautoclicker.core.domain.model.event.ImageEvent
import com.buzbuz.smartautoclicker.core.domain.model.event.TriggerEvent
import com.buzbuz.smartautoclicker.core.domain.model.scenario.Scenario

interface ScenarioProcessingListener {

    suspend fun onSessionStarted(
        context: Context,
        scenario: Scenario,
        imageEvents: List<ImageEvent>,
        triggerEvents: List<TriggerEvent>,
    )

    suspend fun onImageEventsProcessingStarted()

    suspend fun onImageEventProcessingStarted(event: ImageEvent)

    suspend fun onImageConditionProcessingStarted(condition: ImageCondition)
    suspend fun onImageConditionProcessingCompleted(result: ConditionResult)
    suspend fun onImageConditionProcessingCancelled()

    suspend fun onImageEventProcessingCompleted(event: ImageEvent, results: IConditionsResult)
    suspend fun onImageEventProcessingCancelled()

    suspend fun onImageEventsProcessingCompleted()

    suspend fun onSessionEnded()
}
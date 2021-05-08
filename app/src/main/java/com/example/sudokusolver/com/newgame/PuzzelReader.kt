package com.example.sudokusolver.com.newgame

import CheckOutcome
import Coordinate
import GameBoard
import android.content.res.Resources
import validateGame


fun readerPuzzel(res:Resources, id:Int):GameBoard = res.openRawResource(id).reader().readLines()
        .withIndex()
        .flatMap { indexedValue ->
            val xCoordinate = indexedValue.index
            indexedValue.value.toCharArray().withIndex()
                .filter { indexedChar -> indexedChar.value != '.' }
                .map { indexedChar ->
                    val yCoordinate = indexedChar.index
                    val coordinate = Coordinate(x = xCoordinate, y = yCoordinate)
                    val number = Character.getNumericValue(indexedChar.value)
                    coordinate to number
                }
        }
        .toMap()
fun validatePuzzel(resources: Resources): CheckOutcome {
    val input = readerPuzzel(resources, R.raw.input)
    val solution = readerPuzzel(resources, R.raw.solution)
    return validateGame(input, solution)
}
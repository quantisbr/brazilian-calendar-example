/**
 * Copyright 2021 Quantis All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.quantis.libraries

import br.com.quantis.libraries.dates.DateRange
import br.com.quantis.libraries.dates.holidays.brazil.*
import java.time.LocalDate

fun main(args: Array<String>) {
    example()
}

private fun example() {
    dateOfMobileReligiouseEventFromTheYear()
    println("")
    checkIfTheDateIsHoliday()
    println("")
    checkIfTheDateIsBankHolidayDay()
    println("")
    checkIfTheDateIsBusinessDay()
    println("")
    checkIfTheDateIsBankBusinessDay()
    println("")
    countTheNumberOfBusinessDaysInTheDateRange()
    println("")
    countTheNumberOfBankBusinessDaysInTheDateRange()
}

private fun dateOfMobileReligiouseEventFromTheYear() {
    val year = 2021
    println("Carnival: " + year.toCarnivalDate())
    println("Good Friday: " + year.toGoodFridayDate())
    println("Easter: " + year.toEasterDate())
    println("Corpus Christi: " + year.toCorpusChristiDate())
}

private fun checkIfTheDateIsHoliday() {
    val date = LocalDate.now()
    if (date.isNationalHoliday())
        println("The '$date' is a holiday")
    else
        println("The '$date' is not a holiday")
}

private fun checkIfTheDateIsBankHolidayDay() {
    val date = LocalDate.now()
    if (date.isBankHoliday())
        println("The '$date' is a bank holiday")
    else
        println("The '$date' is not a bank holiday")
}

private fun checkIfTheDateIsBusinessDay() {
    val date = LocalDate.now()
    if (date.isBusinessDay(false))
        println("The '$date' is a business day")
    else
        println("The '$date' is not a business day")
}

private fun checkIfTheDateIsBankBusinessDay() {
    val date = LocalDate.now()
    if (date.isBankBusinessDay())
        println("The '$date' is a bank business day")
    else
        println("The '$date' is not a bank business day")
}

private fun countTheNumberOfBusinessDaysInTheDateRange() {
    val start = LocalDate.of(2019, 3, 12)
    val end = LocalDate.of(2021, 11, 15)
    val range = DateRange(start, end)
    println("Number of business day: " + range.countBusinessDays())
}

private fun countTheNumberOfBankBusinessDaysInTheDateRange() {
    val start = LocalDate.of(2019, 3, 12)
    val end = LocalDate.of(2021, 11, 15)
    val range = DateRange(start, end)
    println("Number of bank business day: " + range.countBankBusinessDays())
}
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
package br.com.quantis.libraries;

import br.com.quantis.libraries.dates.DateRange;
import br.com.quantis.libraries.dates.holidays.brazil.BrazilianHolidays;

import java.time.LocalDate;

public class JavaExample {

    public static void main(String[] args) {
        new JavaExample().example();
    }

    private void example() {
        getDateOfMobileReligiouseEventFromTheYear();

        System.out.println();

        checkIfTheDateIsHoliday();

        System.out.println();

        checkIfTheDateIsBankHolidayDay();

        System.out.println();

        checkIfTheDateIsBusinessDay();

        System.out.println();

        checkIfTheDateIsBankBusinessDay();

        System.out.println();

        countTheNumberOfBusinessDaysInTheDateRange();

        System.out.println("");

        countTheNumberOfBankBusinessDaysInTheDateRange();
    }

    private void getDateOfMobileReligiouseEventFromTheYear() {
        final int year = 2021;
        System.out.println("Carnival: " + BrazilianHolidays.toCarnivalDate(year));
        System.out.println("Good Friday: " + BrazilianHolidays.toGoodFridayDate(year));
        System.out.println("Easter: " + BrazilianHolidays.toEasterDate(year));
        System.out.println("Corpus Christi: " + BrazilianHolidays.toCorpusChristiDate(year));
    }

    private void checkIfTheDateIsHoliday() {
        final LocalDate date = LocalDate.now();
        if (BrazilianHolidays.isNationalHoliday(date))
            System.out.printf("The '%s' is a holiday%n", date);
        else
            System.out.printf("The '%s' is not a holiday%n", date);
    }

    private void checkIfTheDateIsBankHolidayDay() {
        final LocalDate date = LocalDate.now();
        if (BrazilianHolidays.isBankHoliday(date))
            System.out.printf("The '%s' is a bank holiday%n", date);
        else
            System.out.printf("The '%s' is not a bank holiday%n", date);
    }

    private void checkIfTheDateIsBusinessDay() {
        final LocalDate date = LocalDate.now();
        if (BrazilianHolidays.isBusinessDay(date, false))
            System.out.printf("The '%s' is a business day%n", date);
        else
            System.out.printf("The '%s' is not a business day%n", date);
    }

    private void checkIfTheDateIsBankBusinessDay() {
        final LocalDate date = LocalDate.now();
        if (BrazilianHolidays.isBankBusinessDay(date))
            System.out.printf("The '%s' is a bank business day%n", date);
        else
            System.out.printf("The '%s' is not a bank business day%n", date);
    }

    private void countTheNumberOfBusinessDaysInTheDateRange() {
        final LocalDate start = LocalDate.of(2019, 3, 12);
        final LocalDate end = LocalDate.of(2021, 11, 15);
        final DateRange range = new DateRange(start, end);

        System.out.println("Number of business day: " + BrazilianHolidays.countBankBusinessDays(range));
    }

    private void countTheNumberOfBankBusinessDaysInTheDateRange() {
        final LocalDate start = LocalDate.of(2019, 3, 12);
        final LocalDate end = LocalDate.of(2021, 11, 15);
        final DateRange range = new DateRange(start, end);

        System.out.println("Number of bank business day: " + BrazilianHolidays.countBankBusinessDays(range));
    }
}
